package de.proglabor.aufgabe2;

public class Springer extends Figur{
	/**
	 * Der Konstruktor für den Läufer
	 * @ Param zielZeile  die x Koordinate eines Bauers
	 * @ Param zielSpalte die y Koordinate eines Bauers
	 * @ Param farbe die Farbe des Bauers
	 */
	public Springer(String farbe) {
		super(farbe);
		//super.f_type = this.type; // Aus Super Klasse
	}
	

	/**
	 * @ Param zielZeile  die x Koordinate der Figur, die man bewegen möchte
	 * @ Param zielSpalte die y Koordinate der Figur, die man bewegen möchte
	 * @return ein boolean mit dem Hinweis, ob der Weg für die Figur erlaubt ist
	 */
	@Override
	public boolean kannZiehen(String startpos , String zielpos,
			String amZug, IRSpiel spiel){
		
		
	//  Getter Methoden aus dem Interface hole
		Feld koordinate = new Feld(startpos);
		int startZeile = koordinate.getX();
		int startSpalte = koordinate.getY();
	
		koordinate = new Feld(zielpos);
		int zielZeile = koordinate.getX();
		int zielSpalte = koordinate.getY();
		
		Figur [][] feld= spiel.getSpielfeld();
		int zielPositionVomGegnerBelegt = istZielPositionVomGegnerBelegt(feld,
				zielZeile,zielSpalte, amZug);
		
		int zeilenDifferenz = Math.abs(zielZeile - startZeile);
		int spaltenDifferenz = Math.abs(zielSpalte - startSpalte);
		String FarbeDerFigur =getFarbe();
		
		if (FarbeDerFigur.equals(amZug) && !startpos.equals(zielpos)&& zielPositionVomGegnerBelegt==3){
			return (spaltenDifferenz == 1 && zeilenDifferenz == 2) ||
					(spaltenDifferenz == 2 && zeilenDifferenz == 1);
		}else{ // Farbe der Figur und 
			return false;
		}
	}
	

	/**
	 * 
	 */
	public  boolean kannSchlagen(String startpos , String zielpos,
			String amZug, IRSpiel spiel){
		
		Feld koordinate = new Feld(startpos);
		int startZeile = koordinate.getX();
		int startSpalte = koordinate.getY();
	
		koordinate = new Feld(zielpos);
		int zielZeile = koordinate.getX();
		int zielSpalte = koordinate.getY();
		
		int zeilenDifferenz = Math.abs(zielZeile - startZeile);
		int spaltenDifferenz = Math.abs(zielSpalte - startSpalte);
		
		Figur [][] feld= spiel.getSpielfeld();
		int zielPositionVomGegnerBelegt = istZielPositionVomGegnerBelegt(feld,
				zielZeile,zielSpalte, amZug);
		
		String FarbeDerFigur =getFarbe();
		
		/**
		 *  Schlagen nur wenn:
		 *  1 - Der Spieler, der am Zug ist, seine eigene Figuren bewegt und nicht die des gegners
		 *  2 - start und ziel nicht gleich sind
		 */
		if (FarbeDerFigur.equals(amZug) && !startpos.equals(zielpos)&& zielPositionVomGegnerBelegt==2){
			return(spaltenDifferenz == 1 && zeilenDifferenz == 2) ||
			(spaltenDifferenz == 2 && zeilenDifferenz == 1);
		}else{ // Farbe der Figur und 
			return false;
		}
	}
	/**
	 * Funktion prüft, ob Zielposition belegt ist und gibt folgende int Werte zurück:
	 *  1 ,wenn Zielposition von einer Figur derselben Farbe beleget ist
	 *  2 ,wenn ZielPosition von einer Figur der gegnerischen Farbe 
	 *  3 , wenn Zielposition leer bzw. nicht belegt ist
	 */
	 private int istZielPositionVomGegnerBelegt(Figur [][] feld, int zielX,int zielY, String amZug ){
		 if (feld[zielX][zielY]!=null){
			 String FarbeDerFigurAufZielPosition=feld[zielX][zielY].getFarbe();
			 if (amZug.equals(FarbeDerFigurAufZielPosition)){
				 return 1; //Zielpos hat selbe Farbe
			 }else{
				 return 2; // ZielPos hat gegnerische Farbe
			 }
		 }
		 return 3;	// Zielpos ist leer
	 }

	/**
	 * 
	 */
	@Override
	public String toString(){
		return "S" + super.toString();
	}
	
	public  boolean gegenSchlagen(int startZeile, int startSpalte,
			int zielZeile, int zielSpalte,String amZug,IRSpiel spiel){
		 
		int zeilenDifferenz = Math.abs(zielZeile - startZeile);
		int spaltenDifferenz = Math.abs(zielSpalte - startSpalte);
				
		String FarbeDerFigur =getFarbe();
		String startpos =stringPositionenNachbilden(startZeile,startSpalte);
		String zielpos =stringPositionenNachbilden(zielZeile,zielSpalte);
		
		/**
		 *  Schlagen nur wenn:
		 *  1 - Der Spieler, der am Zug ist, seine eigene Figuren bewegt und nicht die des gegners
		 *  2 - start und ziel nicht gleich sind
		 */
		if (FarbeDerFigur.equals(amZug) && !startpos.equals(zielpos)){
			return(spaltenDifferenz == 1 && zeilenDifferenz == 2) ||
			(spaltenDifferenz == 2 && zeilenDifferenz == 1);
		}else{ // Farbe der Figur und 
			return false;
		}
	}
}
