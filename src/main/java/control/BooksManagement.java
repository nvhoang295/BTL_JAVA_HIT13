package control;

import java.util.ArrayList;
import java.util.Scanner;

import objects.Books;

public class BooksManagement {
	private static Scanner scanner = new Scanner(System.in);

	private static FilesManagement filesManagement = new FilesManagement();
	private static BeautifierServices beautifier = new BeautifierServices();

	private static AddBooksServices addBooksManagement = new AddBooksServices();
	private static ChangeBooksInfoServices changeBooksInfoManagement = new ChangeBooksInfoServices();
	private static RemoveBooksServices removeBooksManagement = new RemoveBooksServices();
	private static ShowBooksServices showBooksManagement = new ShowBooksServices();

	private static String booksFileName = "Books.txt";

	private ArrayList<Books> books = new ArrayList<>();

	public void showBookManageMenu() {
		int choice = 0;
		int lineLength = 25;
		do {
			beautifier.drawLine(lineLength);
			System.out.printf("\n|%-23s|\n", "Chức năng quản lý sách");
			beautifier.drawLine(lineLength);
			System.out.printf("\n|%-23s|\n|%-23s|\n|%-23s|\n|%-23s|\n|%-23s|\n", "1. Thêm đầu sách", "2. Sửa đầu sách",
					"3. Xoá đầu sách", "4. Liệt kê sách", "0. Quay lại");
			beautifier.drawLine(lineLength);
			do {
				System.out.print("\n>>> Nhập lựa chọn: ");
				choice = scanner.nextInt();
				if (choice == 0) {
					return;
				}
				if (choice < 1 || choice > 5) {
					System.out.print("Vui lòng nhập đúng số!");
				}
			} while (choice < 1 || choice > 5);
			scanner.nextLine();
			switch (choice) {
			case 1:
				addBooksManagement.showMenuAddBook(books);
				break;
			case 2:
				changeBooksInfoManagement.changeBookInfor(books);
				filesManagement.writeBooksFile(books, booksFileName);
				books.clear();
				break;
			case 3:
				removeBooksManagement.removeBookRecord(books);
				break;
			case 4:
				filesManagement.readBooksFile(books, booksFileName);
				showBooksManagement.showBooks(books);
				filesManagement.writeBooksFile(books, booksFileName);
				books.clear();
				break;
			}
			
			System.out.println();
		} while (true);
	}

	public static void main(String[] args) {
		BooksManagement booksManagement = new BooksManagement();
		booksManagement.showBookManageMenu();
	}
}
