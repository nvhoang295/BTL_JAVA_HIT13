package control;

public class BeautifierServices {
	public void drawLine(int lineHeight) {
		for(int i=0;i<lineHeight;++i) {
			System.out.print("-");
		}
	}
	public void jumpLines() {
		for(int i=0;i<50;++i) {
			System.out.println();
		}
	}
}
