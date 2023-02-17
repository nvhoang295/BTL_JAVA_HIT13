package control;

import java.util.ArrayList;

import objects.Borrows;

public class ShowBorrowBooksServices {
	private static FilesManagement filesManagement = new FilesManagement();
	
	private static String borrowsFileName = "Borrows.txt";
	
	void showBorrowBooks(ArrayList<Borrows> borrows) {
		filesManagement.readBorrowsFile(borrows, borrowsFileName);
		System.out.println();
		int tableLength = 97;
		for (int i = 0; i < tableLength; ++i) {
			System.out.print('-');
		}
		System.out.println();
		System.out.printf("%7s | %7s | %-8s | %-10s | %-13s\n", "Mã mượn", "Mã sách", "Số lượng", "Ngày mượn",
				"Tổng tiền cọc");
		for (int i = 0; i < tableLength; ++i) {
			System.out.print('-');
		}
		System.out.println();
		for (int i = 0; i < borrows.size(); ++i) {
			System.out.printf("%07d | %07d | %8d | %-10s | %12dđ\n", borrows.get(i).getBorrowID(),
					borrows.get(i).getBorrowBookID(), borrows.get(i).getBorrowBookQuantity(),
					borrows.get(i).getBorrowDate(), borrows.get(i).getBorrowDeposite());
		}
		for (int i = 0; i < tableLength; ++i) {
			System.out.print('-');
		}
		System.out.println();
		filesManagement.writeBorrowsFile(borrows, borrowsFileName);
		borrows.clear();
	}
}
