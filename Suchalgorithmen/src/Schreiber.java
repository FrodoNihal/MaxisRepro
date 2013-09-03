import java.io.BufferedWriter;
import java.io.IOException;
/**
 * Das ist die Schreiber Klasse sie schreibt in eine file mit dem dazugehörigen BufferedWriter die Informationen.
 * @author Maximilian Scholz
 *
 */
public class Schreiber {
/**
 * Das ist die Metjode, welche in das logfile immer genau einen Sortieralgorithmus schreibt,
 * dieser muss in der ContainerKlasse: ContainerSortieralgorithmus dafür vorliegen. Der lokale BufferedWriter des logfiles wird außerdem benötigt.
 * @param container
 * @param bfw
 * @throws IOException
 */
	public void go(ContainerSortieralgorithmus container, BufferedWriter bfw) throws IOException{
		
		// Sind die Parameter null? Dann kann damit nicht gearbeitet werden.
		if(container == null && bfw == null){
			
			System.out.println("Der Buffered Writer oder der übergebene Container ist null.");
			}else{ 
				
				//Überschrift des Sortieralgorithmusses
				bfw.newLine();
				bfw.newLine();
				bfw.write(container.getName()+":");
				bfw.newLine();
				
				// Schreib das Array in die Datei
				for(int i = 0 ; i < container.getArray().length ; ++i){
					
					bfw.write("[ "+container.getArray()[i]+" ]");			
				}
				
				// Hinterlege die gesamt Sortierzeit
				bfw.newLine();
				bfw.write("Zeit: ");
				bfw.write(container.getGesamtZeit()+" ms");
				bfw.newLine();
				bfw.flush();
		}
	}
	
	/**
	 * Das ist die Methode, welche ein Dokument mit dem globalen BufferedWriter schreibt in einer Semokola separierten,
	 * für exel lesbaren Datei, dass nachher aus den Zeitwerten ein Diagramm erstellt werden kann.
	 * Es wird der Durchgang Protokolliert sowie alle in diesem Durchgang exorzierten Zeiten der Suchalgorithmen.
	 * Am Ende werden die Punkte der Zeiten (Double verwendet Punkte bei Dezimalzahlen in Kommatas umgewandelt, dass Excel die Werte auch als Zahlen erkennt)
	 * @param Durchgang
	 * @param containerArray
	 * @param bfw
	 * @throws IOException
	 */
	public void graphDatenSchreiber(int Durchgang, ContainerSortieralgorithmus[] containerArray, BufferedWriter bfw) throws IOException{
	
		String tmpString = ""+Durchgang+";"+containerArray[0].getGesamtZeit()+";"+containerArray[1].getGesamtZeit()+";"+containerArray[2].getGesamtZeit()+";"+containerArray[3].getGesamtZeit()+";"+containerArray[4].getGesamtZeit()+";"+containerArray[5].getGesamtZeit()+";";
		tmpString = tmpString.replace(".", ",");
		bfw.write(tmpString);
		bfw.newLine();
		bfw.flush();
	}
}
