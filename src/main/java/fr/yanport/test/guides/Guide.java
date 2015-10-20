package fr.yanport.test.guides;

import fr.yanport.test.coordonates.Coordinate;
import fr.yanport.test.coordonates.GridCoordonate;
import fr.yanport.test.shapes.Rectangle;
import fr.yanport.test.shapes.Shape;

/**
 * 
 * @author amine
 * cette class et le modele des classes qui suppervisent les actions de l'aspirateur et gardent sont état 
 */
public abstract class Guide {
	/**
	 * nom du systéme d'instruction et de rotation (direction) suggérer dans l'exercice
	 */
	public static final String NEWS_GDA_System="NEWS/GDA";
	/**
	 *  la forme de la piece
	 */
	private Shape shape; 
	/**
	 *  coordoonnées au sein de la piece
	 */
	private Coordinate coordinate; 
	
	public Guide(Shape shape , Coordinate coordinate){
		this.shape=shape;
		this.coordinate=coordinate;
	}
	
	
	
	public Shape getShape() {
		return shape;
	}



	public Coordinate getCoordinate() {
		return coordinate;
	}


	/**
	 *  execution des instruction est abstracte car le system d'instruction peut varier grandement
	 * @param instruction les instruction sous forme de chaine de caractaire
	 */
	public abstract void  executeInstruction(String instruction);

	/**
	 *  création d'un guide (une factory) qui sappuis sur les difirente caractéristique du system
	 */
	public static Guide getGuide(Shape shape,Coordinate coordinate,String moveSystem ,String initialPosition) throws Exception{
		
		if(shape.getClass().equals(Rectangle.class) && 
				coordinate.getClass().equals(GridCoordonate.class) && 
				    moveSystem.equals(NEWS_GDA_System)){
			return new NEWS_DGA_RectangleGrideGuide(shape, coordinate,initialPosition);
		}
		
		return null;
	}
	
	
	
}
