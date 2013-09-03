import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * Das ist die Leser Klasse sie lie�t die Zeile,
 * die die ZufaelligerBefueller Klasse vorher mit Zufallszahlen bef�llt hat und macht daraus ein int Array.
 * @author Maximilian Scholz
 *
 */
public class Leser {
/**
 * Das ist die go Methode, welche genau den Zweck erf�llt, was der Leser in seiner Klassenbeschreibung machen soll.
 * Sie Brauch die file aus der sie lesen soll und gibt ein Array zur�ck, welches die Zufallszahlen die in der file stehen enth�lt.
 * @param file
 * @return
 * @throws IOException
 */
	public int[] go(File file) throws IOException{
		
		// Ist die file wegen einem vorangegangenen Fehler null? Dann gibt das in der Konsole aus.
		if(file == null){
			
			System.out.println("Die zu lesende File ist null.");
			
			return null;			
				}else{
				
				// Variablen festlegen
				BufferedReader bfr = new BufferedReader(new FileReader(file));
				String informationsLine = "";
				String[] getrennteInformationsLine;
				
				// Die Zufallszahlenzeile lesen und in ein String Array Splitten (jeder Eintrag eine Zahl) Trenner war das Semikolon.
				bfr.readLine();
				informationsLine = bfr.readLine();
				getrennteInformationsLine = informationsLine.split(";");
				bfr.close();
				int[] zielArray = new int[getrennteInformationsLine.length];
				
				// Gehe das String Array durch und parse die Strings in int Zahlen und speichere diese dann in ein int Array.
				for(int i = 0 ; i < getrennteInformationsLine.length ; ++i){
					
					try{
						
					zielArray[i] = Integer.parseInt(getrennteInformationsLine[i]);			
					}catch(NumberFormatException e){
						
						System.out.println("Es konnten nicht alle Zahlen in einen Int Wert �berf�hrt werden.");
						e.printStackTrace();
					}
				}
				
				return zielArray;
			}
	}
}
