package control;

import java.util.ArrayList;
import java.util.Scanner;

import objects.Books;

public class AddBooksServices {
	private static BooksManagement booksManagement = new BooksManagement();
	private static Scanner scanner = new Scanner(System.in);
	private static BeautifierServices beautifier = new BeautifierServices();
	private static FilesManagement filesManagement = new FilesManagement();
	
	private static String booksFileName = "Books.txt";
	
	
	private ArrayList<Books> books = new ArrayList<Books>();
	
	static String chooseBookGenre(int choice) {
		switch (choice) {
		case 1:
			return "Tình cảm";
		case 2:
			return "Hài hước";
		case 3:
			return "Viễn tưởng";
		case 4:
			return "Khoa học";
		case 5:
			return "Kinh dị";
		case 6:
			return "Lịch sử";
		case 7:
			return "Trinh thám";
		case 8: 
			return "Phiêu lưu";
		case 9:
			return "Kịch";
		default:
			return "";
		}
	}
	
	static String chooseBookStatus(int choice) {
		switch (choice) {
		case 1: 
			return "Tốt";
		case 2:
			return "Nhàu nát";
		case 3:
			return "Hư hỏng";
		default:
			return "";
		}
	}
	
	static void displayBookGenre() {
		System.out.println("\t1. Tình cảm\n" + "\t2. Hài hước\n" + "\t3. Viễn tưởng\n" + "\t4. Khoa học\n"
				+ "\t5. Kinh dị\n" + "\t6. Lịch sử\n" + "\t7. Trinh thám\n" + "\t8. Phiêu lưu\n" + "\t9. Kịch");
	}

	static void displayBookStatus() {
		System.out.println("\t1. Tốt\n" + "\t2. Nhàu nát\n" + "\t3. Hư hỏng");
	}
	
	void addBook(ArrayList<Books> books, int lastID) {
		int lineLength = 42;
		int choice;
		beautifier.drawLine(lineLength);
		System.out.println();
		System.out.printf("|%-40s|\n|%-40s|\n"," Chức năng quản lý sách > Thêm đầu sách "," 0. Huỷ bỏ và quay lại");
		beautifier.drawLine(lineLength);

		System.out.print("\n>>> Nhập vào tên sách: ");
		String bookName = scanner.nextLine();
		if(bookName.equals("0")) return;
		System.out.print("\n>>> Nhập vào tên tác giả: ");
		String bookAuthor = scanner.nextLine();
		if(bookAuthor.equals("0")) return;
		System.out.println("Thể loại sách: ");
		displayBookGenre();
		do {
			System.out.print(">>> Nhập lựa chọn: ");
			choice = scanner.nextInt();
			if (choice < 1 || choice > 9) {
				System.out.println("Vui lòng nhập đúng chữ số");
			}
		} while (choice < 1 || choice > 9);
		String bookGenre = chooseBookGenre(choice);

		System.out.println("Tình trạng sách: ");
		displayBookStatus();
		do {
			System.out.print("Lựa chọn của bạn: ");
			choice = scanner.nextInt();
			if (choice < 1 || choice > 3) {
				System.out.println("Vui lòng nhập đúng chữ số");
			}
		} while (choice < 1 || choice > 3);
		String bookStatus = chooseBookStatus(choice);

		System.out.print("Nhập vào số lượng sách: ");
		int bookQuantity = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Nhập vào giá sách: ");
		int bookPrice = scanner.nextInt();

		books.add(new Books(++lastID, bookName, bookAuthor, bookGenre, bookStatus, bookQuantity, bookPrice));
	}
	
	void showMenuAddBook(ArrayList<Books> books) {
		int lastID = filesManagement.readBooksFile(books, booksFileName);
		int choice;
		do {
			addBook(books, lastID);
			System.out.println("1. Nhập tiếp\n"
			+ "0. Quay lại");
			choice = scanner.nextInt();
			if (choice == 0)
				break;
		} while (true);
		filesManagement.writeBooksFile(books, booksFileName);
		books.clear();
	}
}
