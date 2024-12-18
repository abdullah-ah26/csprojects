package lab1;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Color color;
	
	public Shape(int x, int y, int width, int height, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	
	abstract public void paint(Graphics g);
	
	public void move() {
		x++;
		y+=2;
	}
	
//	public void jazz() {
//		x++;
//		y+=2;
//	}
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setWidth(int w) {
		this.width = w;
	}
	
	public void setHeight(int h) {
		this.height = h;
	}
	
	

}
