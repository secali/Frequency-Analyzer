import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Text {
	private static final int sizeAlphabet = 26;
	private String text;
	private Occurrence alphabet [];

	
	
	public Text() {
		text = "";
		alphabet = new Occurrence[sizeAlphabet];
		for(int i=0; i<sizeAlphabet; i++) {
			alphabet[i] = new Occurrence ((char)('a'+i));
		}
	}
	
	public String getText() {
		return text;
	}
	public void setText(String s) {
		text = s;
	}
	
	
	public Occurrence[] getOccurrences() {
		return alphabet;
	}
	
	public void printOccurrences() {
		System.out.println(Arrays.toString(alphabet)); 
	}
	
	
	public void readTextFromFile(String file) {
		try(BufferedReader bf = new BufferedReader(new FileReader("files/"+file))){
			char character = Character.toLowerCase((char) bf.read());
			
			while (bf.ready()) {
				//System.out.print(character);	
				if(character >= 'a' & character <= 'z') 
					alphabet[character-'a'].increase();
				
				text+= Character.toString(character);
				character = Character.toLowerCase((char) bf.read());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Map <Character, Character> generateDictionary (Occurrence [] oc, Map <Character, Character> repetidas) {
		Map <Character, Character> diccionario = new HashMap <Character, Character>();
		
		for(int i=0; i<sizeAlphabet; i++) {
			for(int j=0; j<sizeAlphabet; j++) {
				//System.out.println("Comparing "+this.alphabet[i].toString()+" with     "+ oc[j].toString());
				
				if(this.alphabet[i].getTimes() == oc[j].getTimes()) {
					//System.out.println("-------MATCH! "+this.alphabet[i].getCharacter()+" with "+ oc[j].getCharacter()+"\n");
					if(diccionario.containsKey((char)(i+'a')))repetidas.put((char)(i+'a'), oc[j].getCharacter());
					else diccionario.put((char)(i+'a'), oc[j].getCharacter());
					
				}
			}
		}
		return diccionario;
	}
	
	public void changeCharacter (char o, char n, String nuevo) {
		StringBuilder s = new StringBuilder(text);
		StringBuilder nuev = new StringBuilder(nuevo);
		
		for(int i=0; i<s.length();i++) {
			if(text.charAt(i)==o) {
				nuev.deleteCharAt(i);
				nuev.insert(i, n);
			}
		}
		nuevo = nuev.toString();
	}
	
	public void createTextFile () {
		 try {
			PrintWriter writer = new PrintWriter("generatedFile.txt");
			writer.println(text);
			
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
