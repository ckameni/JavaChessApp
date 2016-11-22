package de.proglabor.aufgabe2;


public class Bauern extends Figur{
	//private String type = "B";
	
	/**
	 * Der Konstruktor für Bauern
	 * @ Param zielZeile  die x Koordinate eines Bauers
	 * @ Param zielSpalte die y Koordinate eines Bauers
	 * @ Param farbe die Farbe des Bauers
	 */
	public Bauern(String farbe) {
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
		
	
				
		int zeilenDifferenz = zielZeile - startZeile;
		int spaltenDifferenz = Math.abs(zielSpalte - startSpalte);
		String FarbeDerFigur =getFarbe();
		

		
		Figur [][] feld= spiel.getSpielfeld();
		
		boolean wegFrei = istDerWegBisZumZielFrei(startZeile,startSpalte,
					 zielZeile, zielSpalte, feld);
		
		int zielPositionVomGegnerBelegt = istZielPositionVomGegnerBelegt(feld,
				zielZeile,zielSpalte, amZug);
		
		if (FarbeDerFigur.equals(amZug) && !startpos.equals(zielpos) 
				&& wegFrei && zielPositionVomGegnerBelegt==3){
		/////
			if (FarbeDerFigur.equals("W")){	// DER GEHT HIER NICHT REIN!!!!
				if (startZeile == 6){
					return spaltenDifferenz == 0 && (zeilenDifferenz == -1 || zeilenDifferenz == -2);
				}else{
					
					return spaltenDifferenz == 0 && zeilenDifferenz == -1;
				}
				
			}else{// if (getFarbe() == Farbe.S){
				if (startZeile == 1){
					return spaltenDifferenz == 0 && (zeilenDifferenz == +1 || zeilenDifferenz == +2);
				}else{
					return spaltenDifferenz == 0 && zeilenDifferenz == +1;				
				}
	
			}
		/////
		}else{ 
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
		 
		int zeilenDifferenz = zielZeile - startZeile;
		int spaltenDifferenz = zielSpalte - startSpalte;
		
		Figur [][] feld= spiel.getSpielfeld();
		int zielPositionVomGegnerBelegt = istZielPositionVomGegnerBelegt(feld,
				zielZeile,zielSpalte, amZug);
		
		String FarbeDerFigur =getFarbe();

		/**
		 *  Schlagen nur wenn:
		 *  1 - Der Spieler, der am Zug ist, seine eigene Figuren bewegt und nicht die des gegners
		 *  2 - start und ziel nicht gleich sind
		 */	
		if (FarbeDerFigur.equals(amZug) && !startpos.equals(zielpos) && zielPositionVomGegnerBelegt ==2){
			if (FarbeDerFigur == "W"){
				return (zeilenDifferenz == -1 && (spaltenDifferenz == 1|| spaltenDifferenz == -1 ));
			}else{  //(f_farbe=="S"){
				return (zeilenDifferenz == 1 && (spaltenDifferenz == 1|| spaltenDifferenz == -1 ));
			}
		}else{
			return false;
		}
	}
	

	/**
	 * Diese Funktion ist wichtig , wenn der Bauer mehrere Stellen überspringen möchte
	 * Dann wird geprüft, ob es nicht ein Hindernis gibt
	 * @param startZeile
	 * @param startSpalte
	 * @param zielZeile
	 * @param zielSpalte
	 * @param feld
	 * @return
	 */
	private boolean istDerWegBisZumZielFrei(int startZeile, int startSpalte,
			int zielZeile, int zielSpalte,Figur[][] feld){
		
		boolean wegFrei = true;
		/*
		 * Der Weg ist Eigentlich immer frei,wenn sich der Bauer um eine Stelle
		 * bewegen möchte.
		 * will der Bauer aber mehrere Stellen überspringen
		 */
		if (Math.abs(startZeile-zielZeile)>1){
			
			Figur f=feld[startZeile][startSpalte];
			if (f.getFarbe()=="S"){
				for(int i = startZeile; i < zielZeile; i++){
					if (feld[i+1][zielSpalte]!=null){
						wegFrei= false;
					
					}
				}
			}else{
				for(int i = startZeile; i > zielZeile; i--){
					if (feld[i-1][zielSpalte]!=null){
						wegFrei= false;
					}
				}
			}
		}		
		return wegFrei;
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
		return "B" + super.toString();
	}
	
	/**
	 *  Funktion ist wichtig um zuprüfen, ob ein Bauer den gegnerische König 
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
	public  boolean gegenSchlagen(int startZeile, int startSpalte,
			int zielZeile, int zielSpalte,String amZug,IRSpiel spiel){
		 
		int zeilenDifferenz = zielZeile - startZeile;
		int spaltenDifferenz = zielSpalte - startSpalte;
		
		String FarbeDerFigur =getFarbe();
		String startpos =stringPositionenNachbilden(startZeile,startSpalte);
		String zielpos =stringPositionenNachbilden(zielZeile,zielSpalte);
		
		/**
		 *  Schlagen nur wenn:
		 *  1 - Der Spieler, der am Zug ist, seine eigene Figuren bewegt und nicht die des gegners
		 *  2 - start und ziel nicht gleich sind
		 */	
		if (FarbeDerFigur.equals(amZug) && !startpos.equals(zielpos)){
			if (FarbeDerFigur == "W"){
				return (zeilenDifferenz == -1 && (spaltenDifferenz == 1|| spaltenDifferenz == -1 ));
			}else{  //(f_farbe=="S"){
				return (zeilenDifferenz == 1 && (spaltenDifferenz == 1|| spaltenDifferenz == -1 ));
			}
		}else{
			return false;
		}
	}
	
	
}
 	