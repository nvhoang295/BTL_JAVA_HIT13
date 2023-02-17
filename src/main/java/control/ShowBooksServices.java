package control;

import java.util.ArrayList;
import java.util.Scanner;

import objects.Books;

public class ShowBooksServices {

	private static FilesManagement filesManagement = new FilesManagement();

	private static String booksFileName = "Books.txt";
	
	
	void showBookHeading() {
		int tableLength = 97;
		for (int i = 0; i < tableLength; ++i) {
			System.out.print('-');
		}
		System.out.println();
		System.out.printf("%3s | %-25s | %-20s | %-10s | %-10s | %3s | %-7s\n", "ID", "Tên sách", "Tác giả", "Thể loại",
				"Tình trạng", "SL", "Giá sách");
		for (int i = 0; i < tableLength; ++i) {
			System.out.print('-');
		}
		System.out.println();
	}
	
	
	public void showBooks(ArrayList<Books> books) {
		int tableLength = 97;
		showBookHeading();
		for (int i = 0; i < books.size(); ++i) {
			System.out.printf("%03d | %-25s | %-20s | %-10s | %-10s | %3d | %,7dđ\n", books.get(i).getBookID(),
					books.get(i).getBookName(), books.get(i).getBookAuthor(), books.get(i).getBookGenre(),
					books.get(i).getBookStatus(), books.get(i).getBookAvail(), books.get(i).getBookPrice());
		}
		for (int i = 0; i < tableLength; ++i) {
			System.out.print('-');
		}
		System.out.println();
	}
}
