package de.proglabor.aufgabe2;
/**
 * @author GuilaineLaure
 *
 */
public class Feld {

	private int x;
	private int y;
	
	
	public Feld(int x, int y) {
		this.x = x;
		this.y = y;
	}


	public Feld(String pos) {
		y = pos.charAt(0) - 'A';
		x = '8' - pos.charAt(1);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	@Override
	public String toString() {
		return Character.toString((char) ('A' + x)) +
			   Character.toString((char) ('8' - y));
	}
	
	public static void main(String[] args) {
		Feld f = new Feld("B7");
		System.out.println(f.getX());
		System.out.println(f.getY());
		System.out.println(f);
	}
}
