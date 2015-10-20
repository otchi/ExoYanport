package fr.yanport.test.utils;

/**
 * 
 * @author amine
 * état de direction de l'aspirateur comme suggéré dans l'écércice 
 * ici en plus de definir l'état avec une lettre , on definie l'état gauche et l'état droite 
 * pour que le traitement de chagement de diréction soit plus facile 
 */
public enum NEWS_Direction {
	
	NORTH("N","W","E"),EAST("E","N","S"),WEAST("W","N","S"),SOUTH("S","W","E");
	
	private String item;
	private String gauche;
	private String droite;
	
	private NEWS_Direction(String item ,String gauche,String droite){
		this.item=item;
		this.gauche=gauche;
		this.droite=droite;
	}
	
	public static NEWS_Direction getDirection(String item){
		if(item.equals(NORTH.item)) return NEWS_Direction.NORTH;
		if(item.equals(EAST.item)) return NEWS_Direction.EAST;
		if(item.equals(WEAST.item)) return NEWS_Direction.WEAST;
		if(item.equals(SOUTH.item)) return NEWS_Direction.SOUTH;
		return null;
		
	}
	
	/**
	 * 
	 * @param commande la commande indique l'acction a faire , si c'est gauche ou droite 
	 * elle est executé pour changé la direction de l'aspirateur sinon on retourne un null
	 * @return
	 */
	public NEWS_Direction changeDirection(GDA_Commande commande){
		if(commande.equals(GDA_Commande.DROITE)) return NEWS_Direction.getDirection(this.droite);
		if(commande.equals(GDA_Commande.GAUCHE)) return NEWS_Direction.getDirection(this.gauche);
		return null;
		
	}

	public String getItem() {
		return item;
	}
	
}
