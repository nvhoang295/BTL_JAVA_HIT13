package objects;

public class Borrows {
	private static int tmp = 0;
	private int borrowID;
	private int borrowBookID;
	private int borrowBookQuantity;
	private String borrowDate;
	private int borrowDeposite;

	public Borrows(int borrowBookID, int borrowBookQuantity, String borrowDate, int borrowDeposite) {
		super();
		this.borrowID = ++tmp;
		this.borrowBookID = borrowBookID;
		this.borrowBookQuantity = borrowBookQuantity;
		this.borrowDate = borrowDate;
		this.borrowDeposite = borrowDeposite;
	}
	
	
	



	public Borrows(int borrowID) {
		super();
		this.borrowID = borrowID;
	}






	public Borrows(int borrowID, int borrowBookID, int borrowBookQuantity, String borrowDate, int borrowDeposite) {
//		super();
		this.borrowID = borrowID;
		this.borrowBookID = borrowBookID;
		this.borrowBookQuantity = borrowBookQuantity;
		this.borrowDate = borrowDate;
		this.borrowDeposite = borrowDeposite;
	}





	public int getBorrowID() {
		return borrowID;
	}

	public int getBorrowBookID() {
		return borrowBookID;
	}

	public int getBorrowBookQuantity() {
		return borrowBookQuantity;
	}

	public String getBorrowDate() {
		return borrowDate;
	}
	
	

	public int getBorrowDeposite() {
		return borrowDeposite;
	}



	public void setBorrowDeposite(int borrowDeposite) {
		this.borrowDeposite = borrowDeposite;
	}



	public void setBorrowID(int borrowID) {
		this.borrowID = borrowID;
	}

	public void setBorrowBookID(int borrowBookID) {
		this.borrowBookID = borrowBookID;
	}

	public void setBorrowBookQuantity(int borrowBookQuantity) {
		this.borrowBookQuantity = borrowBookQuantity;
	}

	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}
	
	

}
