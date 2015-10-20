package fr.yanport.test.coordonates;

/**
 * 
 * @author amine
 * type de coordonnées demandées dans l'exercice 
 *  x y entier 
 */
public class GridCoordonate implements Coordinate{
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "GridCoordonate [x=" + x + ", y=" + y + "]";
	}
	
	
	
}
