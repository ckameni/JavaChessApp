package de.proglabor.aufgabe2;

/**
 * @author GuilaineLaure
 *
 */
public interface ISpiel extends IRSpiel {
	String getFigur(String string);
	boolean ziehe (String startpos , String zielpos);
	public void setAmzug(String amzug);
}
