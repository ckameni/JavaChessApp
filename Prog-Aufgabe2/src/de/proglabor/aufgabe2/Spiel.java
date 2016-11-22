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
	
	
}
