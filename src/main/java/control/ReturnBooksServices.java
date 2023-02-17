package control;

import java.util.ArrayList;
import java.util.Scanner;

import objects.Books;
import objects.Borrows;

public class ReturnBooksServices {
	private static FilesManagement filesManagement = new FilesManagement();
	private static ShowBorrowBooksServices showBorrowBooksManagement = new ShowBorrowBooksServices();
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static String booksFileName = "Books.txt";
	private static String borrowsFileName = "Borrows.txt";
	
	int inputRemoveIndex(ArrayList<Borrows> borrows, int input) {
		for (int i = 0; i < borrows.size(); ++i) {
			if (borrows.get(i).getBorrowID() == input) {
				return i;
			}
		}
		return -1;
	}
	
	void returnBookQuantity(ArrayList<Books> books, int returnBookID, int returnBookQuanity) {
		for (Books book : books) {
			if (book.getBookID() == returnBookID) {
				book.setBookAvail(returnBookQuanity);
			}
		}
	}
	
	void returnBooks(ArrayList<Borrows> borrows, ArrayList<Books> books) {
		int input;
		borrows.clear();
		books.clear();
		do {
			filesManagement.readBorrowsFile(borrows, borrowsFileName);
			filesManagement.readBooksFile(books, booksFileName);
			System.out.println("Chức năng trả lại sách mượn theo mã mượn sách, nhấn 0 để quay lại menu");
			showBorrowBooksManagement.showBorrowBooks(borrows);
			System.out.print("Nhập vào mã mượn cần trả: ");
			input = scanner.nextInt();
			if (input == 0)
				return;
			int removeIdx = inputRemoveIndex(borrows, input);
			if (removeIdx != -1) {
				int returnBookID = borrows.get(removeIdx).getBorrowBookID();
				int returnBookQuantity = borrows.get(returnBookID).getBorrowBookQuantity();
				returnBookQuantity(books, returnBookID, returnBookQuantity);
				borrows.remove(removeIdx);
			} else {
				System.out.println("Không tồn tại mã mượn trên hệ thống!");
			}
			filesManagement.writeBooksFile(books, booksFileName);
			filesManagement.writeBorrowsFile(borrows, borrowsFileName);
			borrows.clear();
			books.clear();
		} while (true);
	}

}
