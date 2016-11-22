package de.proglabor.aufgabe2;

public abstract class Figur {
private String f_farbe;

/**
	 * 
	 * @param farbe wird instanziert
	 */
	public Figur(String farbe){
		f_farbe = farbe;		
	}
	
	/**
	 * 
	 * @return farbe
	 */
	public String getFarbe(){
		return f_farbe;
	}
	

	
	@Override
	public String toString() {
		//return f_type.toString() + f_farbe.toString();
		return  f_farbe ;
	}

	/**
	 * @ Param zielZeile  die x Koordinate der Figur, die man bewegen möchte
	 * @ Param zielSpalte die y Koordinate der Figur, die man bewegen möchte
	 * @return ein boolean mit dem Hinweis, ob der Weg für die Figur erlaubt ist
	 */
	/**
	 * 
	 * @param startpos die (x,y) Koordinate der Figur, die man bewegen möchte
	 * @param zielpos die(x,y) Koordinate der Figur, die man bewegen möchte
	 * @param spiel
	 * @return ein boolean mit dem Hinweis, ob der Weg für die Figur erlaubt ist
	 */
	public abstract boolean kannZiehen(String startpos , String zielpos,
			String amZug, IRSpiel spiel);
	
	/**
	 * 
	 * @ Param startZeile  die x Koordinate der Figur, bevor sie bewegt wird
	 * @ Param startSpalte die y Koordinate der Figur, bevor sie bewegt wird
	 * @ Param zielZeile die x Koordinate der Figur, nachdem sie bewegt wurde
	 * @ Param zielSpalte die y Koordinate der Figur, nachdem sie bewegt wurde
	 * @return false wenn Das Schlagen nicht möglich ist 
	 * oder true wenn geschlagen werden kann 
	 */
	public abstract boolean kannSchlagen(String startpos , String zielpos,
			String amZug, IRSpiel spiel);
	
	
	/**
	 *  Funktion ist wichtig um zu prüfen, ob eine Figur den gegnerischen König 
	 *  direkt schlagen kann, wenn der König auf einer bestimmten Stelle
	 *  gesetzt wird
	 *  
	 *  
	 * @param startZeile
	 * @param startSpalte
	 * @param zielZeile
	 * @param zielSpalte
	 * @param amZug
	 * @param spiel
	 * @return
	 */
	public  abstract boolean gegenSchlagen(int startZeile, int startSpalte,
			int zielZeile, int zielSpalte,String amZug,IRSpiel spiel);

	/**
	 * 
	 * @param i
	 * @return
	 */
	public static String wandleZahlenIndBuchstaben(int i) {
	    char[] alphabet = "ABCDEFGH".toCharArray();
	    if (i > 7) {
	        return null;
	    }
	    return Character.toString(alphabet[i]);
	}
	
	/**
	 * 
	 * @param zeile
	 * @param spalte
	 * @return
	 */
	public String stringPositionenNachbilden(int zeile, int spalte){
		return wandleZahlenIndBuchstaben(spalte) + (zeilenAnpassen(zeile)+1);
	}
	
	/**
	 * 
	 * @param zeile
	 * @return
	 */
	public int zeilenAnpassen( int zeile){
		if(zeile ==7)
			zeile =0;
		else if(zeile ==6)
			zeile =1;
		else if(zeile ==5)
			zeile =2;
		else if(zeile ==4)
			zeile =3;
		else if(zeile ==3)
			zeile =4;
		else if(zeile == 2)
			zeile =5;
		else if(zeile ==1)
			zeile =6;
		else if(zeile ==0)
		zeile =7;
		return zeile ;
	}

}
