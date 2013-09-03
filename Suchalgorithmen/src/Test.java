import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Das ist die Test Klasse, sie testet, wie der Name schon sagt alle implementierten Funktionen, 
 * sie erstellt einmal eine logfile (ein Snapshot des letzten Probanten Durchlaufs) und eine datenFile == graphDaten,
 * die die Zeiten aller Durchl�ufe von allen Sortieralgorithmen protokolliert.
 * @author Maximilian Scholz
 *
 */
public abstract class Test {

	//main
	public static void main(String[] args) {
		
		//Erzeuge eine Referenz, dass wir auf die exsistierende Datei zugreifen k�nnen
		//und erstelle eine H�lle f�r den BufferedWriter.
		File datenFile = new File("E:\\Schule\\LF3\\Suchalgorithmen\\target\\graphDaten.txt");
		BufferedWriter bfwDF = null;
		
		try {
		
			// Versuche den BufferedWriter zu instanziieren und ihn via FileWriter mit der graphDaten Datei zu verkn�pfen und
			// lege in der graphDaten Datei den Spaltenkopf fest.
			bfwDF = new BufferedWriter(new FileWriter(datenFile));
			bfwDF.write("Durchgang;Bubblesort Zeit;Insertionsort Zeit;Mergesort Zeit;Quicksort Zeit;Selectionsort Zeit;Simplesort Zeit;");
			bfwDF.newLine();		
		} catch (IOException e) {
			
			System.out.println("Der BufferedWriter f�r die graphDatei konnte nicht erzeugt werden.");
			e.printStackTrace();
		}
		
		// Sortiere immer gr��ere Arrays, dass man nachher eine gute Datengrundlage f�r das Diagramm hat.
		for(int i = 1 ; i < 1000 ; ++i){
			
			Probant probant = new Probant(i,bfwDF);
		}
		
		try {
			
			bfwDF.close();			
		} catch (IOException e) {
			
			System.out.println("Der BufferedWriter f�r die graphDatei konnte nicht geschlossen werden.");
			e.printStackTrace();
		}
		
		System.out.println("Fertig");
	}

}
