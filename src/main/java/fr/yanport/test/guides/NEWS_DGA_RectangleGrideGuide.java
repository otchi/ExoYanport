package fr.yanport.test.guides;

import java.util.Arrays;

import fr.yanport.test.coordonates.Coordinate;
import fr.yanport.test.coordonates.GridCoordonate;
import fr.yanport.test.shapes.Rectangle;
import fr.yanport.test.shapes.Shape;
import fr.yanport.test.utils.GDA_Commande;
import fr.yanport.test.utils.NEWS_Direction;

/**
 * 
 * @author amine
 * le guide qui implemente le system suggéré dans l'éxercice
 */
public class NEWS_DGA_RectangleGrideGuide extends Guide {
	// separateur de la chaine de caractére qui indication de position initiale
	public static final String POSITION_SEPARATOR = " ";
	// separateur de la chaine de caractére qui indique les instruction a suivre
	public static final String COMMANDE_SEPARATOR = "";
	// direction de l'aspirateur
	private NEWS_Direction direction;

	// constructeur
	public NEWS_DGA_RectangleGrideGuide(Shape shape, Coordinate coordinate, String position) throws Exception {
		super(shape, coordinate);

		if (!shape.getClass().equals(Rectangle.class) || !coordinate.getClass().equals(GridCoordonate.class)) {
			throw new Exception("incorect parameter in construction NEWS_DGA_RectangleGrideGuide ");
		}
		String[] pos = position.split(POSITION_SEPARATOR);
		GridCoordonate gridCoordonate = (GridCoordonate) coordinate;
		gridCoordonate.setX(Integer.parseInt(pos[0]));
		gridCoordonate.setX(Integer.parseInt(pos[1]));
		direction = NEWS_Direction.getDirection(pos[2]);
	}

	
	@Override
	/**
	 * execute les instructions comme indiqué dans l'éxércice
	 * s' il y a changement de direction, on l'applique
	 * sinon il y a avancement donc, regarder la direction et selon sa valeur
	 *  on change les valeur des coordonnée 
	 */
	public void executeInstruction(String instruction) {
		Arrays	.asList(instruction.split(COMMANDE_SEPARATOR))
				.forEach(
			(String x) -> {
					NEWS_Direction direction = this.direction.changeDirection(GDA_Commande.getMove(x));
					
					if (direction != null) {
						this.direction = direction;
						return;
					}
			
					GridCoordonate gridCoord = (GridCoordonate) super.getCoordinate();
					Rectangle Rect = (Rectangle) super.getShape();
			
					if (this.direction.equals(NEWS_Direction.NORTH) && gridCoord.getY() < Rect.getHeight()) {
						gridCoord.setY(gridCoord.getY() + 1);
						return;
					}
			
					if (this.direction.equals(NEWS_Direction.EAST) && gridCoord.getX() < Rect.getWidth()) {
						gridCoord.setX(gridCoord.getX() + 1);
						return;
					}
			
					if (this.direction.equals(NEWS_Direction.WEAST) && gridCoord.getX() > 0) {
						gridCoord.setX(gridCoord.getX() - 1);
						return;
					}
			
					if (this.direction.equals(NEWS_Direction.SOUTH) && gridCoord.getY() > 0) {
						gridCoord.setY(gridCoord.getY() - 1);
						return;
					}
		});
	}

	@Override
	public String toString() {
		return "NEWS_DGA_RectangleGrideGuide [direction=" + direction + ", getShape()=" + getShape()
				+ ", getCoordinate()=" + getCoordinate() + "]";
	}

	public NEWS_Direction getDirection() {
		return direction;
	}
	
	

}
