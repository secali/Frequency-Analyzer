import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Debug {
	public static void prueba(String args []) {
		Text textReference = new Text ();
		Text textEncrypted = new Text ();
		
		System.out.println("Reading reference and encrypted file...\n");
		textReference.readTextFromFile("reference_file.txt");
		textEncrypted.readTextFromFile("encrypted_file.txt");
		
		
		System.out.println("################################################################################");
		System.out.println("########################## REFERENCE TEXT ######################################");
		System.out.println("################################################################################");
		System.out.println(textReference.getText());
		
		System.out.println("################################################################################");
		System.out.println("########################## ENCRYPTED TEXT ######################################");
		System.out.println("################################################################################");
		System.out.println(textEncrypted.getText());

		
		System.out.println("################################################################################");
		System.out.println("############ OCURRENCES ON REFERENCE TEXT ######################################");
		System.out.println("################################################################################");
		textReference.printOccurrences();
		
		System.out.println("################################################################################");
		System.out.println("############ OCURRENCES ON ENCRYPTED TEXT ######################################");
		System.out.println("################################################################################");
		textEncrypted.printOccurrences();
		
		
		System.out.println("################################################################################");
		System.out.println("############ DICTIONARY ########################################################");
		System.out.println("################################################################################");
		Map<Character, Character> d = new HashMap<Character, Character> ();
		d = textEncrypted.generateDictionary(textReference.getOccurrences());
		System.out.println(d+"\n\n");
		
		
		System.out.println("################################################################################");
		System.out.println("############ TEXT PARTIALLY DECRYPTED ##########################################");
		System.out.println("################################################################################");
		String encrypted = textEncrypted.getText();
		String textoParcialmenteDesencriptado = "";
		for(int i=0; i<encrypted.length(); i++) {
			if(d.containsKey(encrypted.charAt(i))) {
				//System.out.println("Cambiando del texo: "+encrypted.charAt(i)+ " por "+ d.get(encrypted.charAt(i)));
				textoParcialmenteDesencriptado+=d.get(encrypted.charAt(i));
				
			}else textoParcialmenteDesencriptado+=encrypted.charAt(i);
		}
		
		System.out.println(textoParcialmenteDesencriptado);
		
		//textEncrypted.setText(s);
		//--------------------------------------------
		
		boolean end = false;
		Scanner sc = new Scanner (System.in);
		
		/*
		do {
			System.out.println("################################################################################");
			System.out.println("############ DECRYPTING OPTIONS ################################################");
			System.out.println("################################################################################");
			System.out.print("Would you like change any character? (y/n): ");
			if(sc.next().toString().compareTo("n")==0)  end=true;
			else {
				System.out.print("Character you want to change on text: ");
				char a = sc.next().charAt(0);
				System.out.print("Change for with character: ");
				char b = sc.next().charAt(0);
				System.out.println("\n\n");
				textEncrypted.changeCharacter(a, b, textoParcialmenteDesencriptado);
					//textoParcialmenteDesencriptado se va modificando
					// pero el String del objeto textEncrypted permanece original
				System.out.println(textoParcialmenteDesencriptado);
			}
			
		}while(!end);*/
		
		System.out.println("END");
		
		textEncrypted.createTextFile();
	
	}

}
