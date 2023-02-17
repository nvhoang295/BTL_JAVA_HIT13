package control;

import java.util.ArrayList;
import java.util.Scanner;

import objects.Books;

public class BookFindingManagement {
	private static BookFindingManagement bookFindingManagement = new BookFindingManagement();
	private static BooksFindingServices booksFindingServices = new BooksFindingServices();
	private static FilesManagement filesManagement = new FilesManagement();

	private ArrayList<Books> books = new ArrayList<Books>();
	static String booksFileName = "Books.txt";
	private static Scanner scanner = new Scanner(System.in);
	private static int choice;

	public void showBookFindingManageMenu() {
		filesManagement.readBooksFile(books, booksFileName);
		do {
			System.out.println("Chức năng tìm kiếm sách");
			System.out.println("1. Tìm sách theo tên sách\n" + "2. Tìm sách theo tên tác giả\n"
					+ "3. Tìm sách theo tên thể loại\n" + "0. Quay lại");
			do {
				System.out.print(">>> Nhập lựa chọn: ");
				choice = scanner.nextInt();
				if (choice == 0)
					return;
				else if (choice < 1 || choice > 3) {
					System.out.println("Vui lòng nhập đúng số!");
				}
				switch (choice) {
				case 1:
					System.out.print("Nhập vào tên sách muốn tìm kiếm: ");
					scanner.nextLine();
					String targetBookFindName = scanner.nextLine();
					booksFindingServices.showBooksFoundByBookName(books, targetBookFindName);
					break;
				case 2:
					System.out.print("Nhập vào tên tác giả muốn tìm kiếm: ");
					scanner.nextLine();
					String targetBookAuthorName = scanner.nextLine();
					booksFindingServices.showBooksFoundByBookAuthor(books, targetBookAuthorName);
					break;
				case 3:
					booksFindingServices.showBooksFoundByBookGenre(books);
				default:
					break;
				}
			} while (choice < 1 || choice > 3);
			if (choice == 0) {
				filesManagement.writeBooksFile(books, booksFileName);
				books.clear();
				return;
			}
		} while (true);
	}

	public static void main(String[] args) {
		bookFindingManagement.showBookFindingManageMenu();
	}
}
