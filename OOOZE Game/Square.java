package lab1;
import java.awt.Color;

public class Square extends Rectangle {

	public Square(int x, int y, int sideLength, Color color) {
		super(x, y, sideLength, sideLength, color);
	}
	
	public void setWidth(int w) {
		this.width = w;
		this.height = w;
	}
	
	public void setHeight(int h) {
		this.width = h;
		this.height = h;
	}

}
