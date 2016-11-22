package de.proglabor.aufgabe2;

public class Koenig extends Figur{
	private boolean koenigInGefahr = false;
	/**
	 * Der Konstruktor für den Läufer
	 * @ Param zielZeile  die x Koordinate eines Bauers
	 * @ Param zielSpalte die y Koordinate eines Bauers
	 * @ Param farbe die Farbe des Bauers
	 */
	public Koenig(String farbe) {
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
		
		
		Feld koordinate = new Feld(startpos);
		int startZeile = koordinate.getX();
		int startSpalte = koordinate.getY();
	
		koordinate = new Feld(zielpos);
		int zielZeile = koordinate.getX();
		int zielSpalte = koordinate.getY();
		/**
		 * Bevor der König auf die zielPosition gesetzt wird,
		 * muss man prüfen, ob er dann auf der ZielPosition vom Gegner 
		 * geschlagen werden kann
		 * 
		 * Wenn Ja, darf der König nicht auf diese Position gesetzt werden
		 * d.h. kannziehen und kannschlagen werden auf false gesetzt
		 */

		 //istDerKoenigGefaehrdert(int zielX, int zielY, String amZug,IRSpiel spiel)
		
			//s_Zielzeile,s_Zielspalte des Königs
//		koenigInGefahr =istDerKoenigGefaehrdet(zielZeile, zielSpalte,  amZug, spiel);
//			if (koenigInGefahr == true){
//				return false;
//			}
		
		
		Figur [][] feld= spiel.getSpielfeld();
		int zielPositionVomGegnerBelegt = istZielPositionVomGegnerBelegt(feld,
				zielZeile,zielSpalte, amZug);
		
		int zeilenDifferenz = Math.abs(zielZeile - startZeile);
		int spaltenDifferenz = Math.abs(zielSpalte - startSpalte);

		String FarbeDerFigur =getFarbe();
		
		if (FarbeDerFigur.equals(amZug) && !startpos.equals(zielpos) && zielPositionVomGegnerBelegt==3){
			return spaltenDifferenz == 1 && zeilenDifferenz == 0 || 
				   spaltenDifferenz == 0 && zeilenDifferenz == 1 || 
				   spaltenDifferenz == 1 && zeilenDifferenz == 1 ;
			
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
//		if (koenigInGefahr == true){
//			return false;
//		}
		
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
		if (FarbeDerFigur.equals(amZug) && !startpos.equals(zielpos) && zielPositionVomGegnerBelegt==2){
			return spaltenDifferenz == 1 && zeilenDifferenz == 0 || 
				   spaltenDifferenz == 0 && zeilenDifferenz == 1 || 
				   spaltenDifferenz == 1 && zeilenDifferenz == 1 ;
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
		 * funktion durchläuft das Feld und Prüft, ob jede durchlaufene Figur
		 * die zielPosition erreichen kann bzw. schlagen kann.
		 *
		 *Diese Funktion ist  wichtig, um den König zu bewegen.
		 *Bevor der König bewegt wird, wird geprüft ,ob die Zielposition auch vom Gegner 
		 *erreicht werden kann. Wenn eine Figur des Gegners die Zielposition des Königs erreichen kann,
		 *dann kann der Gegener den König auch schlagen.
		 *wenn der König bewget werden soll, bekommen ZielX und ZielY die Zielkoordinaten
		 *des zu bewegenden Königs
		 *@ param  zielX = s_Zielzeile;
		 *@ param  zielY = s_Zielspalte;
		 * wenn eine andere Figur bewegt werden soll, bekommen ZielX und ZielY
		 * die Startkoordinaten des Gegnerischen Königs
		 */
		
		public boolean istDerKoenigGefaehrdet(int zielX, int zielY, String amZug,IRSpiel spiel){
			String wennGegnerAmZug;
			Figur [][] feld= spiel.getSpielfeld();
			/*
			 * Um zu prüfen, ob der Gegner den König schlagen kann,
			 * muss man diese FUnktion so ausführen, als ob der Gegner
			 * am Zug wäre.
			 * 	
			 */
			if (amZug == "W"){
				wennGegnerAmZug ="S";
			}else{  //(amZug == "W")
				wennGegnerAmZug="W";
			}
			
			
			for ( int i = 0; i < feld.length;i++){
				for ( int j = 0; j < feld.length;j++){
					if (feld[i][j]!=null )// && !(feld[i][j] instanceof Koenig) )
						if ((feld[i][j].getFarbe().equals(wennGegnerAmZug)))
							if(feld[i][j].gegenSchlagen(i,j,zielX,zielY,wennGegnerAmZug,spiel))
								return  true;
				}
			}
			return  false;
		}
	/**
	 * 
	 */
	@Override
	public String toString(){
		return "K" + super.toString();
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
			return spaltenDifferenz == 1 && zeilenDifferenz == 0 || 
				   spaltenDifferenz == 0 && zeilenDifferenz == 1 || 
				   spaltenDifferenz == 1 && zeilenDifferenz == 1 ;
		}else{ // Farbe der Figur und 
			return false;
		}
	}
	
	
}
