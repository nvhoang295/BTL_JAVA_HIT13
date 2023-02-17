package control;

import java.util.ArrayList;
import java.util.Scanner;

import objects.Books;

public class BooksFindingServices {
	private static ShowBooksServices showBooksServices = new ShowBooksServices();
	private static AddBooksServices  addBooksServices = new AddBooksServices();
	
	private static Scanner scanner = new Scanner(System.in);
	
	
	void showFoundBookInfor(Books book) {
		System.out.printf("%03d | %-25s | %-20s | %-10s | %-10s | %3d | %,7dđ\n", book.getBookID(), book.getBookName(),
				book.getBookAuthor(), book.getBookGenre(), book.getBookStatus(), book.getBookAvail(),
				book.getBookPrice());
	}

	void showBooksFoundByBookName(ArrayList<Books> books, String targetBookName) {
		int count = 0;
		for (int i = 0; i < books.size(); ++i) {
			if (books.get(i).getBookName().equalsIgnoreCase(targetBookName)) {
				++count;
				if (count == 1) {
					showBooksServices.showBookHeading();
				}
				showFoundBookInfor(books.get(i));
			}
		}
		if (count == 0) {
			System.out.println("Không tìm thấy sách có tên tương ứng!");
		} else {
			int tableLength = 97;
			for (int i = 0; i < tableLength; ++i) {
				System.out.print('-');
			}
			System.out.println();
		}
	}

	void showBooksFoundByBookAuthor(ArrayList<Books> books, String targetBookAuthor) {
		int cnt = 0;
		for (int i = 0; i < books.size(); ++i) {
			if (books.get(i).getBookAuthor().equalsIgnoreCase(targetBookAuthor)) {
				++cnt;
				if (cnt == 1) {
					showBooksServices.showBookHeading();
				} else {

				}
				showFoundBookInfor(books.get(i));
			}
		}
		if (cnt == 0) {
			System.out.println("Không tìm thấy sách có tên tương ứng!");
		} else {
			int tableLength = 97;
			for (int i = 0; i < tableLength; ++i) {
				System.out.print('-');
			}
			System.out.println();
		}
	}

	void showBooksFoundByBookGenre(ArrayList<Books> books) {
		int choice;
		System.out.println("Các thể loại sách: ");
		addBooksServices.displayBookGenre();
		System.out.print("Nhập thể loại sách muốn tìm kiếm: ");
		do {
			choice = scanner.nextInt();
			if (choice < 1 || choice > 9) {
				System.out.println("Vui lòng nhập đúng số!");
			}
		} while (choice < 1 || choice > 9);
		String targetBookGenre = addBooksServices.chooseBookGenre(choice);
		int cnt = 0;
		for (Books book : books) {
			if (book.getBookGenre().equalsIgnoreCase(targetBookGenre)) {
				++cnt;
				if (cnt == 1) {
					showBooksServices.showBookHeading();
				}
				showFoundBookInfor(book);
			}
		}
		if (cnt == 0) {
			System.out.println("Không tìm thấy loại sách với thể loại tương ứng!");
		} else {
			int tableLength = 97;
			for (int i = 0; i < tableLength; ++i) {
				System.out.print('-');
			}
			System.out.println();
		}
	}
}
