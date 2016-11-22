package de.proglabor.aufgabe2;

public class Koenig extends Figur{
	private boolean koenigInGefahr = false;
	/**
	 * Der Konstruktor f�r den L�ufer
	 * @ Param zielZeile  die x Koordinate eines Bauers
	 * @ Param zielSpalte die y Koordinate eines Bauers
	 * @ Param farbe die Farbe des Bauers
	 */
	public Koenig(String farbe) {
		super(farbe);
		//super.f_type = this.type; // Aus Super Klasse
	}

}
