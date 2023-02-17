package control;

import java.util.ArrayList;
import java.util.Scanner;

import objects.Books;

public class RemoveBooksServices {
	
	private static ShowBooksServices showBooksManagement = new ShowBooksServices();
	private static FilesManagement filesManagement = new FilesManagement();
	
	private static String booksFileName = "Books.txt";
	
	private static Scanner scanner = new Scanner(System.in);
	
	int inputRemoveID(ArrayList<Books> books) {
		int lineLength = 90;
		for (int i = 0; i < lineLength; ++i) {
			System.out.print("-");
		}
		System.out.println();
		System.out.println("Bạn đang xoá bản ghi sách! Nếu muốn quay lại menu chính, vui lòng nhập 0.");
		showBooksManagement.showBooks(books);
		System.out.print("Nhập ID bản ghi sách muốn xoá: ");
		int removeID = -1;
		removeID = scanner.nextInt();
		if (removeID == 0) {
			return -2;
		}
		return removeID;
	}
	
	/**
	 * Phương thức xoá bản ghi Books <br>
	 * Phương thức đã có sẵn các phương thức đọc, ghi và clear mảng đối tượng Books
	 * @param books
	 */
	void removeBookRecord(ArrayList<Books> books) {
		filesManagement.readBooksFile(books, booksFileName);
		do {
			int removeID = inputRemoveID(books);
			if (removeID == -2)
				return;
			for (int i = 0; i < books.size(); ++i) {
				if (removeID == books.get(i).getBookID()) {
					books.remove(i);
					System.out.println("Xoá bản ghi thành công!");
					return;
				}
			}
			System.out.println("Không tìm thấy bản ghi có ID = " + removeID);
			int choice = new java.util.Scanner(System.in).nextInt();
			if(choice == 0) {
				filesManagement.writeBooksFile(books, booksFileName);
				books.clear();
			}
		}while(true);
	}
}
