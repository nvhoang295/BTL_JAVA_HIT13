package control;

import java.util.ArrayList;
import java.util.Scanner;

import objects.Books;

public class ChangeBooksInfoServices {

	private static AddBooksServices addBooksManagement = new AddBooksServices();
	private static ShowBooksServices showBooksManagement = new ShowBooksServices();
	private static FilesManagement filesManagement = new FilesManagement();
	private static String booksFileName = "Books.txt";

	private static int choice;
		
	private static Scanner scanner = new Scanner(System.in);

	void showMenuChangeInfor() {
		System.out.println("1. Tên sách\n" + "2. Tác giả\n" + "3. Thể loại\n" + "4. Tình trạng\n" + "5. Số lượng");
	}

	/**
	 * Phương thức nhập vào ID sách muốn thay đổi <br>
	 * Với ID sách ràng buộc bắt đầu từ 1
	 * 
	 * @param books
	 * @return changeID
	 */
	int inputChangeBookID(ArrayList<Books> books) {
		int lineLength = 90;
		for (int i = 0; i < lineLength; ++i) {
			System.out.print("-");
		}
		System.out.println();
		System.out.print("Bạn đang thay đổi thông tin sách! Nếu muốn quay lại menu chính, vui lòng nhập 0");
		showBooksManagement.showBooks(books);
		System.out.print(">>> Nhập ID sách muốn thay đổi thông tin: ");
		int changeID = -1;
		do {
			changeID = scanner.nextInt();
			if (changeID == 0)
				return -1;
			else if (changeID < 1 || changeID >= books.get(books.size() - 1).getBookID()) {
				System.out.println("Vui lòng nhập đúng ID sách!");
			}
		} while (changeID < 1 || changeID >= books.size() + 1);
		return changeID;
	}

	void changeBookInfor(ArrayList<Books> books) {
		filesManagement.readBooksFile(books, booksFileName);
		int changeField;
		int changeID = inputChangeBookID(books);
		if (changeID == -1)
			return;
		System.out.println("Danh sách các trường có thể thay đổi" + "\n0. Huỷ bỏ");
		showMenuChangeInfor();
		do {
			System.out.print(">>> Nhập vào trường muốn thay đổi thông tin: ");
			changeField = scanner.nextInt();
			if (changeField == 0)
				return;
			if (changeField < 1 || changeField > 5) {
				System.out.println("Vui lòng nhập đúng số!");
			}
		} while (changeField < 1 || changeField > 5);
		scanner.nextLine();
		System.out.printf("%s %03d %s", "Đang thay đổi thông tin cho sách có ID =", changeID,
				"\nNhấn 0 nếu muốn huỷ bỏ\n");
		--changeID;
		switch (changeField) {
		case 1: 
			System.out.print(">>> Nhập tên sách muốn thay đổi: ");
			String alterBookName = scanner.nextLine();
			if (alterBookName.equalsIgnoreCase("0"))
				return;
			else
				books.get(changeID).setBookName(alterBookName);
			break;		
		case 2: 
			System.out.print(">>> Nhập tên tác giả muốn thay đổi: ");
			String alterBookAuthor = scanner.nextLine(); 
			if (alterBookAuthor.equalsIgnoreCase("0"))
				return;
			else
				books.get(changeID).setBookAuthor(alterBookAuthor);
			break;		
		case 3: 
			System.out.println(">>> Chọn thể loại muốn thay đổi: ");
			addBooksManagement.displayBookGenre();
			choice = scanner.nextInt();
			if (choice == 0)
				return;
			else {
				books.get(changeID).setBookGenre(addBooksManagement.chooseBookGenre(choice));
			}
			break;	
		case 4: 
			System.out.println(">>> Chọn tình trạng sách muốn thay đổi: ");
			addBooksManagement.displayBookStatus();
			choice = scanner.nextInt();
			if (choice == 0)
				return;
			else {
				books.get(changeID).setBookStatus(addBooksManagement.chooseBookStatus(choice));
			}
			break;
		case 5:
			System.out.print(">>> Nhập số lượng sách muốn bổ sung: ");
			int additionalNumber = scanner.nextInt();
			books.get(changeID).setBookAvail(additionalNumber);
			break;
		default:
			break;
		}
		System.out.println("Cập nhật thành công!");
	}
}
