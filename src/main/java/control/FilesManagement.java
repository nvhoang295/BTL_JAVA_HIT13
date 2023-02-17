package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import objects.Books;
import objects.Borrows;


public class FilesManagement {
	
	/**
	 * Used to read books record from file
	 * @author Hoang Nguyen
	 * @param books
	 * @param filename
	 * @return baseID
	 */
	int readBooksFile(ArrayList<Books> books, String filename) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] datas = line.split("\\|");
				books.add(new Books(Integer.parseInt(datas[0]), datas[1], datas[2], datas[3], datas[4],
						Integer.parseInt(datas[5]), Integer.parseInt(datas[6])));
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int lastID = books.get(books.size() - 1).getBookID();
		return lastID;
	}
	
	int readBorrowsFile(ArrayList<Borrows> borrows, String filename) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] datas = line.split("\\|");
				borrows.add(new Borrows(Integer.parseInt(datas[0]), Integer.parseInt(datas[1]),
						Integer.parseInt(datas[2]), datas[3], Integer.parseInt(datas[4])));
			}
			bufferedReader.close();
		} catch (Exception e) {
//			e.printStackTrace();
		}
		int lastID = borrows.get(borrows.size() - 1).getBorrowID();
		return lastID;
	}
	
	
	
	void writeBooksFile(ArrayList<Books> books, String filename) {
		try {
			FileWriter fileWriter = new FileWriter(filename);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			for (Books book : books) {
				String line = book.getBookID() + "|" + book.getBookName() + "|" + book.getBookAuthor() + "|"
						+ book.getBookGenre() + "|" + book.getBookStatus() + "|" + book.getBookAvail() + "|"
						+ book.getBookPrice();
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}

			bufferedWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void writeBorrowsFile(ArrayList<Borrows> borrows, String filename) {
		try {
			FileWriter fileWriter = new FileWriter(filename);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			for (Borrows borrow : borrows) {
				String line = borrow.getBorrowID() + "|" + borrow.getBorrowBookID() + "|"
						+ borrow.getBorrowBookQuantity() + "|" + borrow.getBorrowDate() + "|"
						+ borrow.getBorrowDeposite();
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}

			bufferedWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
