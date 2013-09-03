import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Das ist die Klasse, die eine File mit einer Zeile voller Zufallszahlen füllt.
 * @author Maximilian Scholz
 *
 */
public class ZufaelligerBefueller {
/**
 * Das ist die Methode, die genau das umsetzt, was in der Klassenbeschreibung steht.
 * Mit dem PfadString wird eine File erstellt und die Anzahl der Zufallszahlen wird über den anderen Parameter hierher übergeben.
 * Die File wird erstellt die Zufallszahlen in ihr mit dem lokal erstellten BufferedWriter reingeschrieben.
 * Der Trenner zwischen den einzelnen Zahlen ist ein Semikolon.
 * Returnt wird dann ein ObjektArray, welches am ersten Platz die File und am zweiten Platz den damit verketteten BufferedWriter enthält.
 * Da in die File noch mehr herein muss, dafür aber diese Klasse nicht zuständig ist.
 * @param pfad
 * @param anzahlDerZahlen
 * @return
 * @throws IOException
 */
	public Object[] go(String pfad, int anzahlDerZahlen) throws IOException{
		
		// Variablen erstellen
		File file = new File(pfad);
		BufferedWriter bfw = new BufferedWriter(new FileWriter(file));
		int zufallszahl = 0;
		
		// Überschrift in der File
		bfw.write("Ungeordnet:");
		bfw.newLine();
		
		// Zeile mit Zufallszahlen befüllen und Semikolon als Trenner einsetzen
		for(int i = 0 ; i < anzahlDerZahlen ; ++i){
			
			zufallszahl = (int) (Math.random()*1000);
			bfw.write(zufallszahl+";");
		}
		
		bfw.newLine();
		bfw.flush();

		// Returncontainer zusammenstellen
		Object[] objectArray = new Object[2];
		
		objectArray[0] = file;
		objectArray[1] = bfw;
		
		return objectArray;
	}	
}
