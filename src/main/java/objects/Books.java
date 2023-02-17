package objects;

public class Books {
	private static int tmp = 0;
	
	


	private int bookID;
	private String bookName;
	private String bookAuthor;
	private String bookGenre;
	private String bookStatus;
	private int bookAvail = 0;
	private int bookPrice;
	
	
	
	public Books(int bookID) {
		super();
		this.bookID = bookID;
	}


	public Books(String bookName, String bookAuthor, String bookGenre, String bookStatus, int bookAvail) {
//		super();
		this.bookID = ++tmp;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookGenre = bookGenre;
		this.bookStatus = bookStatus;
		this.bookAvail += bookAvail;
	}
	
	
	public Books(int bookID, String bookName, String bookAuthor, String bookGenre, String bookStatus, int bookAvail) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookGenre = bookGenre;
		this.bookStatus = bookStatus;
		this.bookAvail = bookAvail;
	}
	
	
	
	
	public Books(String bookName, String bookAuthor, String bookGenre, String bookStatus, int bookAvail,
			int bookPrice) {
		super();
		this.bookID = ++tmp;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookGenre = bookGenre;
		this.bookStatus = bookStatus;
		this.bookAvail = bookAvail;
		this.bookPrice = bookPrice;
	}


	public Books(int bookID, String bookName, String bookAuthor, String bookGenre, String bookStatus, int bookAvail,
			int bookPrice) {
		super();
		this.bookID = bookID;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookGenre = bookGenre;
		this.bookStatus = bookStatus;
		this.bookAvail = bookAvail;
		this.bookPrice = bookPrice;
	}


	public int getBookID() {
		return bookID;
	}


	public String getBookName() {
		return bookName;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public String getBookGenre() {
		return bookGenre;
	}


	public String getBookStatus() {
		return bookStatus;
	}


	public int getBookAvail() {
		return bookAvail;
	}


	public void setBookID(int bookID) {
		this.bookID = ++tmp;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}


	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}


	public void setBookAvail(int bookAvail) {
		this.bookAvail += bookAvail;
	}


	public int getBookPrice() {
		return bookPrice;
	}


	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}



	
	
	


	

}
