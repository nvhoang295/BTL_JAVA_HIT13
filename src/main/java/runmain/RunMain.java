package runmain;

import java.util.Scanner;

import control.*;

public class RunMain {
	private static BooksManagement booksManagement = new BooksManagement();
	private static BooksBorrowingManagement booksBorrowingManagement = new BooksBorrowingManagement();
	private static BookFindingManagement bookFindingManagement = new BookFindingManagement();
	private static BeautifierServices beautifierServices = new BeautifierServices();
	private static Scanner scanner = new Scanner(System.in);
	private static int choice;

	public static void main(String[] args) {
		int lineLength = 33;
		do {
			beautifierServices.drawLine(lineLength);
			System.out.println();
			System.out.printf("|%-31s|\n", " Chương trình quản lý thư viện ");
			beautifierServices.drawLine(lineLength);
			System.out.printf("\n|%-31s|\n|%-31s|\n|%-31s|\n|%-31s|\n", " 1. Chức năng quản lý sách",
					" 2. Chức năng mượn trả sách", " 3. Chức năng tìm kiếm sách", " 0. Thoát chương trình");
			beautifierServices.drawLine(lineLength);
			do {
				System.out.print("\n>>> Nhập lựa chọn: ");
				choice = scanner.nextInt();
				if (choice == 0) {
					beautifierServices.drawLine(lineLength);
					System.out.printf("\n|%-31s|\n|%-31s|\n|%-31s|\n", "", "         Hẹn gặp lại!", "");
					beautifierServices.drawLine(lineLength);
					return;
				}
				if (choice < 1 || choice > 3) {
					System.out.print("Vui lòng nhập lại!");
				} else {
					if (choice == 1) {
						booksManagement.showBookManageMenu();
					} else if (choice == 2) {
						booksBorrowingManagement.showBookBorrowingManageMenu();
					} else {
						bookFindingManagement.showBookFindingManageMenu();
					}
				}
			} while (choice < 1 || choice > 3);
		} while (true);

	}
}
