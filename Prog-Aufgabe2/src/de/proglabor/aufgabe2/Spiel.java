package de.proglabor.aufgabe2;

import java.util.Arrays;
import java.util.*;

/**
 * @author GuilaineLaure
 *
 */
public class Spiel implements ISpiel{
	
//	String stellung = "A7BS,B7BS,C7BS,D7BS,E7BS,F7BS,G7BS,H7BS,"
//			+ "A2BW,B2BW,C2BW,D2BW,E2BW,F2BW,G2BW,H2BW";
//	
	private Figur[][]feld;
	private String amZug;
	private int s_startZeile;
	private int s_startSpalte;
	private int s_Zielzeile,s_Zielspalte;
	private boolean istZugGueltig;
	
	public ArrayList <String> zugListe = new ArrayList<String>();
	
	public void setAmzug(String amzug){
		this.amZug= amzug;
	}
	
	@Override
	public Figur[][] getSpielfeld() {
		return feld;
	}
	
	/** Die Funktion 
	 * 
	 */
	public void zugFolge(){
		if (amZug == "W")
			amZug="S";
		if (amZug == "")
			amZug="W";
	}
	
	/**
	 * 
	 * @param position
	 * @return
	 */
	public String getFigur(String stellung){
		Figur f = getFeldFigur(stellung);
		return (f != null) ? f.toString() : "";
	}
	
	/**
	 * 
	 * @param stellung
	 * @return
	 */
	private Figur getFeldFigur(String stellung){
		startPositionen(stellung);
		return feld[s_startZeile][s_startSpalte];
	}	

	/**
	 * 
	 * @param stellung
	 */
	public void startPositionen(String stellung){
		Feld koordinate = new Feld(stellung);
		s_startZeile = koordinate.getX();
		s_startSpalte = koordinate.getY();
		
		
	}
	
	
	public void zielPositionen(String stellung){
		Feld koordinate = new Feld(stellung);
		s_Zielzeile = koordinate.getX();
		s_Zielspalte = koordinate.getY();
	}

	public Spiel() {

		feld = new Figur [8][8];
		for( int i = 0; i < feld.length;i++){
			feld[1][i] = new Bauern("S");
			feld[6][i] = new Bauern("W");
			if (i==0 || i ==7){
				feld[0][i]= new Turm("S");
				feld[7][i]= new Turm("W");
			}else if (i==1 || i ==6){
				feld[0][i]= new Springer("S");
				feld[7][i]= new Springer("W");
			}else if (i==2 || i ==5){
				feld[0][i]= new Laeufer("S");
				feld[7][i]= new Laeufer("W");
			}else if (i==3){
				feld[0][i]= new Dame("S");
				feld[7][i]= new Dame("W");
			}else if ( i ==4){
				feld[0][i]= new Koenig("S");
				feld[7][i]= new Koenig("W");
			}
		}
		
		// Zu Beginn des Spiels ist der Spieler Weiss am Zug
		setAmzug("W");

	}	
	
	public Spiel(String stellung, String amZug) {
		this.amZug = amZug;
		feld = new Figur [8][8];
		spielAufbau(stellung);
	}

	
	/**
	 * 
	 * @param stellung
	 */
	private void spielAufbau (String stellung) {
		String [] stellungArray = stellung.split(",");
		int Laenge = stellungArray.length;


		for (int i = 0; i < Laenge;i++){
				String MyStellung = stellungArray[i];
			    //Figur bauer = new Bauern(amZug);
			    startPositionen(MyStellung);
			    if (MyStellung.charAt(3)=='W'){
			    	if (MyStellung.charAt(2)=='B')
			    		feld[s_startZeile][s_startSpalte] = new Bauern("W");
			    	if (MyStellung.charAt(2)=='T')
			    		feld[s_startZeile][s_startSpalte] = new Turm("W");
			    	if (MyStellung.charAt(2)=='S')
			    		feld[s_startZeile][s_startSpalte] = new Springer("W");
			    	if (MyStellung.charAt(2)=='L')
			    		feld[s_startZeile][s_startSpalte] = new Laeufer("W");
			    	if (MyStellung.charAt(2)=='D')
			    		feld[s_startZeile][s_startSpalte] = new Dame("W");
			    	if (MyStellung.charAt(2)=='K')
			    		feld[s_startZeile][s_startSpalte] = new Koenig("W");
			    		
			    }else if(MyStellung.charAt(3)=='S'){
			    	if (MyStellung.charAt(2)=='B')
			    		feld[s_startZeile][s_startSpalte] = new Bauern("S");
			    	if (MyStellung.charAt(2)=='T')
			    		feld[s_startZeile][s_startSpalte] = new Turm("S");
			    	if (MyStellung.charAt(2)=='S')
			    		feld[s_startZeile][s_startSpalte] = new Springer("S");
			    	if (MyStellung.charAt(2)=='L')
			    		feld[s_startZeile][s_startSpalte] = new Laeufer("S");
			    	if (MyStellung.charAt(2)=='D')
			    		feld[s_startZeile][s_startSpalte] = new Dame("S");
			    	if (MyStellung.charAt(2)=='K')
			    		feld[s_startZeile][s_startSpalte] = new Koenig("S");
			    }
			}
	}
	


	/**
	* Methode , die versucht die Figur auf start pos nach zielpos
	 *zu setzen . Ist das moeglich , wird der Zug ausgefuehrt
	* und true zurueckgegeben , andernfalls false und der Zug
	* wird nicht ausgefuehrt .
	* @param start pos Start position des Zugs
	* @param ziel posZiel positiondes Zugs
	* @return true, falls der Zug moeglich ist , false sonst .
	*/
	public boolean ziehe ( String startpos,String zielpos){
//		do
//		{
			//######################################################################   // Entfernt das oberste Objekt vom Stack
		
		Feld koordinate = new Feld(startpos);
		s_startZeile = koordinate.getX();
		s_startSpalte = koordinate.getY();
		
		koordinate = new Feld(zielpos);
		s_Zielzeile = koordinate.getX();
		s_Zielspalte = koordinate.getY();
		
		
		
		//printChessTabelle();
		if (getFigur(startpos)== ""){
			System.out.println(" keine Figur auf dieser Position");
			istZugGueltig = false; // return
		}else{
			Figur newFigur = getFeldFigur(startpos);	
			
			boolean kannziehen =newFigur.kannZiehen(startpos,zielpos,amZug,this);
			boolean kannschlagen =newFigur.kannSchlagen(startpos,zielpos,amZug,this);


			/**
			 * Bevor der König auf die zielPosition gesetzt wird,
			 * muss man prüfen, ob er dann auf der ZielPosition vom Gegner 
			 * geschlagen werden kann
			 * 
			 * Wenn Ja, darf der König nicht auf diese Position gesetzt werden
			 * d.h. kannziehen und kannschlagen werden auf false gesetzt
			 */
			 boolean koenigInfGefahr= false;
			if (newFigur instanceof Koenig ){
				//s_Zielzeile,s_Zielspalte des Königs
				koenigInfGefahr =istDerKoenigGefaehrdet(s_Zielzeile,s_Zielspalte);
				if (koenigInfGefahr == true){
					kannziehen= false;
					kannschlagen=false;
				}
			}
			
			
			/**
			 * Die Figure darf dann nur bewegt werden, wenn man entweder
			 * 1. eine leere Stelle im Felm besetzen 
			 *  oder
			 * 2. einen Gegner schlagen möchte
			 */
			Figur tmpFigur = null;
			if ((kannziehen ) || (kannschlagen)){
				tmpFigur=feld[s_Zielzeile][s_Zielspalte];
				feld[s_Zielzeile][s_Zielspalte] = newFigur;
				feld[s_startZeile][s_startSpalte] = null;
				
				istZugGueltig= true;
				//printChessTabelle();
	
				//Immer, wenn ich eine Figur bewege, prüfen, ob mein Koenig
				// dadurch geschlagen werden kann.
				// wenn ja, muss der Zug rückgängig gemacht werden
				if (kannMeinKoenigGeschlagenWerden() == true){
					feldSituationZueruckSetzen(tmpFigur);
					//printChessTabelle();
					istZugGueltig = false; // return
				}
				printChessTabelle();
				
			}else{
				//printChessTabelle();
				System.out.print("Zug nicht erlaubt:");
				System.out.print(" von" + "[" + s_startZeile+ "," + s_startSpalte +"]");
				System.out.println(" nach" + "[" + s_Zielzeile+ "," + s_Zielspalte +"]");

				istZugGueltig = false; // return
			}
		}
		
		//######################################################################
	    
//	 }while (istZugGueltig == false);
		
		if(istZugGueltig == true){
			String start=startpos.substring(0, 2);
			String ziel =zielpos.substring(0, 2);
			
			zugListe.add(start + ziel + amZug);
		}
		
		printChessTabelle();
		 return istZugGueltig; 
	}
	
	/**
	 * Figur auf vohreriger Position zurücksetzen, weil sonst der König geschlagen
	 * werden kann
	 */
	private void feldSituationZueruckSetzen(Figur f){
		feld[s_startZeile][s_startSpalte]= feld[s_Zielzeile][s_Zielspalte];
		feld[s_Zielzeile][s_Zielspalte] = f;
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean kannMeinKoenigGeschlagenWerden(){
		int [] koenigkordinate= new int[2];
		/*
		 * finde erstmal die koordinaten des eigenen Königs auf dem Feld
		 */
		for (int i = 0; i < feld.length;i++){
			for ( int j = 0; j < feld.length;j++){
				if (feld[i][j]!=null )
					if (feld[i][j].getFarbe().equals(amZug))
						if(feld[i][j] instanceof Koenig){
							koenigkordinate[0]=i;
							koenigkordinate[1]=j;
							break;
						}
			}
		}
		return istDerKoenigGefaehrdet(koenigkordinate[0], koenigkordinate[1]);
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
	
	public boolean istDerKoenigGefaehrdet(int zielX, int zielY){
		String gegnerAmZug;
		
		/*
		 * Um zu prüfen, ob der Gegner den König schlagen kann,
		 * muss man diese FUnktion so ausführen, als ob der Gegner
		 * am Zug wäre.
		 * 	
		 */
		if (amZug == "W"){
			gegnerAmZug ="S";
		}else{  //(amZug == "W")
			gegnerAmZug="W";
		}

		for ( int i = 0; i < feld.length;i++){
			for ( int j = 0; j < feld.length;j++){
				if (feld[i][j]!=null )// && !(feld[i][j] instanceof Koenig) )
					if ((feld[i][j].getFarbe().equals(gegnerAmZug)))
						if(feld[i][j].gegenSchlagen(i,j,zielX,zielY,gegnerAmZug,this))
							return  true;
			}
		}
		return  false;
	}
	
	/**
	 *  Tabelle für Stellung des Typs "B2", "A1" usw...
	 */
	public void printChessTabelle(){
		// Buchstabe...
		System.out.print(" | ");
		for(char alphabet = 'A'; alphabet <= 'H'; alphabet++) {
		    System.out.print(alphabet+"  | ");
		}
		
		int indexWeiss=8;
		System.out.println("");
		// Feld
		//char buchstabe = 'A';
		for(int i = 0; i < 8; i++){
			System.out.println("  --------------------------------"
					+ "--------");
			System.out.print(i+1);
			for (int j = 0; j < 8 ; j++){
				if (feld[i][j] == null){ 
					System.out.print("| " + "  " + " ");
				}else{ 
					System.out.print("| " + feld[i][j] + " ");
				}
			}
			System.out.println("|" + indexWeiss--);
		}
		System.out.println("  --------------------------------"
				+ "--------");
	}	
	
	

	@Override
	public String toString() {
		return "Spiel [feld=" + Arrays.toString(feld) + ", amZug=" + amZug + 
				 ", startZeile= " + s_startZeile + ", startSpalte= " + s_startSpalte + "]";
	}
	

	
}
