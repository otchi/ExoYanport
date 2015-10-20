package fr.yanport.test.shapes;
/**
 * 
 * @author amine
 * un rectangle defini par sa hauteur et sa largeur
 */
public class Rectangle implements Shape{
	private int height;
	private int width;
	
	
	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Rectangle(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}


	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}


	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width + "]";
	}
	
}
