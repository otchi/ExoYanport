package fr.yanport.test.utils;

/**
 * 
 * @author amine
 * instructions qui peuvent étre executées selon l'exercice 
 */
public enum GDA_Commande {
	
	GAUCHE("G"),DROITE("D"),AVANCE("A");
	private String item;
	
	private GDA_Commande(String item){
		this.item=item;
	}
	
	public static GDA_Commande getMove(String item){
		if(GAUCHE.item.equals(item)) return GDA_Commande.GAUCHE;
		if(DROITE.item.equals(item)) return GDA_Commande.DROITE;
		if(AVANCE.item.equals(item)) return GDA_Commande.AVANCE;
		return null;
	}

	public String getItem() {
		return item;
	}
	

}
