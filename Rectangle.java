package lab1;
import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	public Rectangle(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
		
	}
	public void paint(Graphics g) {
        g.setColor(this.color);
        g.fillRect(x,y,width,height);	
	}

}
