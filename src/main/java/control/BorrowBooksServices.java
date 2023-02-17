package control;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import objects.Books;
import objects.Borrows;

public class BorrowBooksServices {
	private static String booksFileName = "Books.txt";
	private static String borrowsFileName = "Borrows.txt";
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static ShowBooksServices showBooksManagement = new ShowBooksServices();
	private static FilesManagement filesManagement = new FilesManagement();

	private static int choice;
	
	int checkExist(ArrayList<Books> books, int targetBookID) {
		for (int i = 0; i < books.size(); ++i) {
			if (books.get(i).getBookID() == targetBookID && books.get(i).getBookAvail() > 0)
				return i;
		}
		return -1;
	}
	
	void borrowBooks(ArrayList<Borrows> borrows, ArrayList<Books> books) {
		filesManagement.readBooksFile(books, booksFileName);
		int lastID = filesManagement.readBorrowsFile(borrows, borrowsFileName);
		int bookID = 0;
		int bookQuantity = 0;
		System.out.println("Chức năng tìm mượn sách theo ID, nhấn 0 để quay lại menu trước");
		do {
			showBooksManagement.showBooks(books);
			System.out.print("Nhập mã sách muốn mượn: ");
			bookID = scanner.nextInt();
			if (bookID == 0)
				return;
			int borrowIndex = checkExist(books, bookID);
			if (borrowIndex != -1) {
				System.out.println("Nhập số lượng sách muốn mượn: ");
				bookQuantity = scanner.nextInt();
				if (bookQuantity == 0)
					return;
			} else {
				System.out.println("Trong kho đã hết sách này!");
			}
			if (bookID != 0 && bookQuantity != 0) {
				System.out.println(books.get(borrowIndex).getBookAvail() - bookQuantity);
				books.get(borrowIndex).setBookAvail(-bookQuantity);
				LocalDate currentDate = LocalDate.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String borrowDate = currentDate.format(formatter);
				int borrowDeposite = (int) (books.get(borrowIndex).getBookPrice() * bookQuantity);
				borrows.add(new Borrows(++lastID, bookID, bookQuantity, borrowDate, borrowDeposite));
			}
			System.out.println("Mượn sách thành công!");
			System.out.println("0. Quay lại menu\n" + "1. Mượn tiếp");

			filesManagement.writeBooksFile(books, booksFileName);
			filesManagement.writeBorrowsFile(borrows, borrowsFileName);
			choice = scanner.nextInt();
			if (choice == 0) {
				filesManagement.writeBooksFile(books, booksFileName);
				filesManagement.writeBorrowsFile(borrows, borrowsFileName);
				borrows.clear();
				books.clear();
				return;
			}
		} while (true);

	}
}
