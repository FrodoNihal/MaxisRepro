import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
/**
 * Das ist die Klasse Probant, sie simuliert immer genau einen Durchlauf aller Sortieralgorithmen und gibt diesen in der logfile an.
 * @author Maximilian
 *
 */
public class Probant {
	
	/**
	 * Das ist der Konstruktor von Probant, eine richtige Begründung, warum ich das alles in den Konstruktor gepackt habe, gibt es nicht.
	 * Die kontrollZahl gibt an, wie viele Zufallszahlen in diesem Durchlauf sortiert werden sollen.
	 * Der graphDatenSchreiber ist der globale BufferedWriter für die graphDaten Datei
	 * 
	 * @param kontrollZahl
	 * @param graphDatenSchreiber
	 */
	public Probant(int kontrollZahl, BufferedWriter graphDatenSchreiber) {
		
		// Festlegen der lokalen Variablen.
		int anzahlDerZufallsZahlen = kontrollZahl;
		
		ZufaelligerBefueller zufälligerBefüller = new ZufaelligerBefueller();
		Schreiber schreiber = new Schreiber();
		Leser leser = new Leser();
		ContainerSortieralgorithmus[] suchalgorithmenUndInformationen;
		Object[] objectArray = null;
		BufferedWriter bfw = null;
		int[] zielArray = null;	
		File file = null;
		
		try{
			
			// Versuche das logfile mit der Menge der Zufallszahlen zu befüllen, die die Variable "anzahlDerZufallsZahlen" vorgibt.
			objectArray = zufälligerBefüller.go("E:\\Schule\\LF3\\Suchalgorithmen\\target\\logfile.txt", anzahlDerZufallsZahlen);	
		}catch(IOException e){
			
			System.out.println("Beim zufälligen Befüllen trat ein Fehler auf.");			
			e.printStackTrace();
		}
		
		// Das objektArray ist ein Container an der ersten Stelle steht immer das logfile und an zweiter Stelle immer der dazugehörige BufferedWriter.
		file = (File) objectArray[0];
		bfw = (BufferedWriter) objectArray[1];
		
		try {
			
			// Versuche die Zufallszahlen aus der logfile zu lesen und in ein Array zu schreiben.
			zielArray = leser.go(file);			
		} catch (IOException e) {
			
			System.out.println("Es konnte nicht alles vorschriftsmäßig gelesen werden.");
			e.printStackTrace();
		}
		
		// Sortiere das Array mit allen gängigen Sortieralgorithmen und speichere mir dazu ihre zeiten,
		// sowie ihren Namen in eine ContainerKlasse und diese wiederum in ein Array.
		suchalgorithmenUndInformationen = SortierungsTester.go(zielArray);
		
		// Gehe das Array "suchalgorithmenUndInformationen" durch und versuche die darin enthaltenen Informationen in die logfile zu schreiben.
		for(int i = 0 ; i < suchalgorithmenUndInformationen.length ; ++i){
			
			try {
				
				schreiber.go(suchalgorithmenUndInformationen[i], bfw);
			} catch (IOException e) {
				
				System.out.println("Beim schreiben trat ein Fehler auf.");
				e.printStackTrace();
			}			
		}
		
		try {
			
			// Versuche die Zeiten der einzelnen Sortieralgorithmen mit dem globalen BufferedReader zu protokollieren.
			schreiber.graphDatenSchreiber(anzahlDerZufallsZahlen, suchalgorithmenUndInformationen, graphDatenSchreiber);
		} catch (IOException e1) {
			
			System.out.println("Beim schreiben der graphDaten Datei ist ein Fehler aufgetreten.");
			e1.printStackTrace();
		}
		
		try {
			
			// Gib die Ressource für den lokalen BufferedWriter (steht auf der logfile) wieder frei.
			bfw.close();
		} catch (IOException e) {
			
			System.out.println("Beim schließen des BufferedWriters ist ein Fehler aufgetreten.");
			e.printStackTrace();
		}
	}
}
