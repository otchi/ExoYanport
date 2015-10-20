package fr.yanport.test.shapes;
/**
 * 
 * @author amine
 * cette interface est commune a toute les formes de piece a parcourir 
 * par l'aspirateur qu'on pourrais est  definire
 */
public interface Shape {
	public static String DEFINITION_SEPARATOR=" ";
	/**
	 * une sorte de factory (implementationdans une interface noueau JAVA8)
	 * @param shapeDefinition les valeurs qui définissent la forme dune piéce
	 * @param shapeClass  la forme a definir (class de la forme)
	 * @return  une instance de type shape respectant les contrainte
	 */
	public static Shape createShape(String shapeDefinition,Class<? extends Shape> shapeClass) {
			if(shapeClass.equals(Rectangle.class)){
				String[] def=shapeDefinition.split(DEFINITION_SEPARATOR);
				return new Rectangle(Integer.parseInt(def[0]), Integer.parseInt(def[1]));
			}
			return null;
	}

}
