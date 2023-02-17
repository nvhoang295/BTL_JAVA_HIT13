package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import objects.Books;
import objects.Borrows;

public class BooksBorrowingManagement {
	private static FilesManagement filesManagement = new FilesManagement();
	private static BooksManagement booksManagement = new BooksManagement();
	private static BooksBorrowingManagement booksBorrowingManagement = new BooksBorrowingManagement();
	private static BorrowBooksServices borrowBooksManagement = new BorrowBooksServices();
	private static ShowBorrowBooksServices showBorrowBooksManagement = new ShowBorrowBooksServices();
	private static ReturnBooksServices returnBooksManagement = new ReturnBooksServices();
	
	
	static Scanner scanner = new Scanner(System.in);
	private ArrayList<Borrows> borrows = new ArrayList<Borrows>();
	private ArrayList<Books> books = new ArrayList<Books>();
	static int input;
	private static String borrowsFilename = "Borrows.txt";
	private static String booksFilename = "Books.txt";
	
	private static int choice;



	void revokeBooksData(ArrayList<Books> books) {
		filesManagement.readBooksFile(books, booksFilename);
	}

	public void showBookBorrowingManageMenu() {
		do {
			System.out.println("__________________________________________");
			System.out.println("Chức năng mượn - trả sách");
			System.out.println("1. Mượn sách\n" + "2. Thống kê sách mượn\n" + "3. Trả sách\n"
					+ "0. Quay lại");
			System.out.print("Chọn một lựa chọn: ");
			do {
				choice = scanner.nextInt();
				if (choice == 0)
					return;
				if (choice < 1 || choice > 3) {
					System.out.println("Vui lòng nhập đúng số!");
				}
			} while (choice < 1 || choice > 3);
			scanner.nextLine();
			switch (choice) {
			case 1:
				borrowBooksManagement.borrowBooks(borrows, books);
				break;
			case 2:
				showBorrowBooksManagement.showBorrowBooks(borrows);
				break;
			case 3:
				returnBooksManagement.returnBooks(borrows, books);
				break;
			default:
				break;
			}
			
			
//			if (choice == 1) {
//				borrowBooks(borrows, books);
//				booksBorrowingManagement.writeFile(borrows, borrowsFilename);
//			} else if (choice == 2) {
//				showBorrowBooks(borrows);
//				booksBorrowingManagement.writeFile(borrows, borrowsFilename);
//				borrows.clear();
//			} else {
//				returnBooks(borrows, books);
//			}
//			System.out.println();

		} while (true);
	}

	public static void main(String[] args) {
		booksBorrowingManagement.showBookBorrowingManageMenu();
	}
}
