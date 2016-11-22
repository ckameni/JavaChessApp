package de.proglabor.aufgabe2;

public class Spielfeld {
	

	public static void main(String[] args){
		
	
//		String stellung = "A3BS,B3BS,C3BS,A2BS,B2BW,C2BS,A1BS,B1BS,C1BS," +
//		          "F3BW,G3BW,H3BW,F2BW,G2BS,H2BW,F1BW,G1BW,H1BW";
		String stellung = "A7BS,B7BS,C7BS,D7BS,E7BS,F7BS,G7BS,H7BS," +
		          "A2BW,B2BW,C2BW,D2BW,E2BW,F2BW,G2BW,H2BW,B6TW";
		Spiel newSpiel = new Spiel(stellung,"W");
//		newSpiel.ziehe("F3BW", "F4BW");
//		newSpiel.printChessTabelle();
		
		//Spiel newSpiel = new Spiel();
		

		System.out.println("");
		newSpiel.ziehe("C2BW", "C3BW");
//		newSpiel.ziehe("B2BW", "B4BW");
//		newSpiel.ziehe("C3BW", "B4BW");
		newSpiel.ziehe("B6TW", "H6TW");
		newSpiel.setAmzug("S");
//		newSpiel.ziehe("C7BS", "C6BS");
//		newSpiel.ziehe("C6BS", "C5BS");
//		newSpiel.setAmzug("W");
//		newSpiel.ziehe("B4", "C5");
//		newSpiel.ziehe("D2", "D4");
//		newSpiel.ziehe("H2BW", "H3BW");

		//
//		System.out.println("");System.out.println("");		
//		newSpiel.ziehe("D2BW", "D3BW");
//		newSpiel.ziehe("H7", "H6");
//		newSpiel.ziehe("B2", "B3");
//		newSpiel.ziehe("B3", "B4");
//		newSpiel.ziehe("B4", "B5");
//		newSpiel.ziehe("B5", "B6");
//		System.out.println(newSpiel.getFigur("B"));
//		newSpiel.ziehe("B6", "C7");
//		//System.out.println(newSpiel.showFigur());
//		System.out.println(newSpiel.showType("A2"));
//		System.out.println(newSpiel.showFigur("A2"));
//		System.out.println(newSpiel.showFigur("A7"));
//		System.out.println(newSpiel.getFigur("A2").getZeile());
//		System.out.println(newSpiel.showFigur("A7").getZeile());
		
		newSpiel.printChessTabelle();
		//System.out.println(newSpiel.getFigur("B3BS"));
		
//		System.out.println(bauer.getZeile());			
//		
		
		
		
		//System.out.println(" spalte:" + newSpiel.spalteExtrahieren("A2BW"));
		//System.out.println(" zeile:" + newSpiel.zeileExtrahieren("A2BW"));
		
		
		
		
//		System.out.println(" type:" + "B");
//		Type t = null, a;
//		 newSpiel.typeExtrahieren("A2BW");
//			
		
	
		//System.out.println(newSpiel.getFigur("A3"));

		//System.out.println(spalte.toString().charAt(2));
			
		

	}
	
	
}
