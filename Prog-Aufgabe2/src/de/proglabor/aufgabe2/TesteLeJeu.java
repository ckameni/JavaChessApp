package de.proglabor.aufgabe2;

import java.util.*;

public class TesteLeJeu {

	public static void main(String[] args){

		// Erzeugung eines neuen Stack-Objektes
		//Stack <String> stack = new Stack();
		// Hinzufügen von zwei Punkt-Objekten
		//stack.push("z");
		//stack.push("f");
		// Entferne jeweils ein Objekt solange der Stack noch Objekte enthält
		Spiel newSpiel = new Spiel();
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Welcher Spieler ist jetzt am Zug? 'W' für Weiss und 'S' für schwarz");
		String farbe = scanner.nextLine();
		
		boolean istZugErfolgereich;
		newSpiel.setAmzug(farbe);
		
		do{
			System.out.println("Geben sie bite die Startposition ein: z.B. 'B3'");
			String startpos = scanner.nextLine();
			System.out.println("Geben sie nun die Zielposition ein: z.B. 'B4'");
			String zielpos = scanner.nextLine();
			istZugErfolgereich=newSpiel.ziehe(startpos, zielpos);
		}while(istZugErfolgereich == false);
		
		//newSpiel.ziehe("F3BW", "F4BW");		
//		newSpiel.setAmzug("W");
//		newSpiel.ziehe("C2BW", "C3BW");
//		newSpiel.ziehe("B2BW", "B4BW");
//		newSpiel.ziehe("C3BW", "B4BW");
//		newSpiel.ziehe("C1LW", "A3LW");
//
//		newSpiel.printChessTabelle();
//		
		for (String zug:newSpiel.zugListe)
		{
		    // Entfernt das oberste Objekt vom Stack
		    System.out.println(zug);
		}
		
//		
		
		//System.out.println(startpos + zielpos + farbe);
//		int startZeile = 1;
//		int zielZeile =7;
//		int  startSpalte =0;
//		int zielSpalte=6; int j=0;
//		for(int i = startZeile; i < zielZeile; i++){
//			//for( int j =startSpalte ; j < zielSpalte; j++){
//				System.out.println((i+1) + " " + (++j));
//			//}	
//			}
		}
	

}
