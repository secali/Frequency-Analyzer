
public class Occurrence {
	private char character;
	private int times;
	
	public Occurrence() {
		character = '¿';
		times = 0;
	}
	
	public Occurrence(char c) {
		character = c;
		times = 0;
	}
	
	public char getCharacter() {
		return character;
	};
	
	public int getTimes() {
		return times;
	}
	
	public void setCharacter(char c) {
		character = c;
	}
	
	public void increase() {
		++times;
	}
	
	public String toString() {
		return (character)+"->"+times+"\n";
		
	}
	
}
