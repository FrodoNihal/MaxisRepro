import java.util.Arrays;
/**
 * Das ist die Klasse SortierungsTester sie macht nichts anderes als die Array Sortieren zu lassen
 * und dabei die Zeit zu nehmen sowie gegen zu prüfen, ob richtig sortiert wurde. 
 * @author Maximilian Scholz
 *
 */
public class SortierungsTester {
/**
 * 
 * @param array
 * @return
 */
	public static ContainerSortieralgorithmus[] go(int[] array){
		
		// Ist das Array aus vorangegangenen Fehlern null? Dann gib das in der Konsole aus. 
		if(array == null){
			
			System.out.println("Das zu prüfende Array ist null.");
			return null;
				}else{
				
				// Variablen festlegen 
				int[] geordnetesArrayBubbleSort;
				int[] geordnetesArrayInsertionSort;
				int[] geordnetesArrayMergeSort;
				int[] geordnetesArrayQuickSort;
				int[] geordnetesArraySelectionSort;
				int[] geordnetesArraySimpleSort;
				ContainerSortieralgorithmus[] sortieralgorithmenDaten = new ContainerSortieralgorithmus[6];
				int[] prüfArray = array.clone();
				Arrays.sort(prüfArray);
				
				// Jeden Sortieralgorithmus durchlaufen lassen, die Zeit stoppen und das alles mit einem geklonten Array
				//(das keine Referenzen Verdreht werden)
				long zeit1BubbleSort = System.nanoTime();
				geordnetesArrayBubbleSort = BubbleSort.bubbleSort(array.clone());
				long zeit2BubbleSort = System.nanoTime();
				
				long zeit1InsertionSort = System.nanoTime();
				geordnetesArrayInsertionSort = Insertionsort.insertionSort(array.clone());
				long zeit2InsertionSort = System.nanoTime();
				
				long zeit1MergeSort = System.nanoTime();
				geordnetesArrayMergeSort = MergeSort.sort(array.clone());
				long zeit2MergeSort = System.nanoTime();
				
				long zeit1QuickSort = System.nanoTime();
				geordnetesArrayQuickSort = Quicksort.sort(array.clone());
				long zeit2QuickSort = System.nanoTime();
				
				long zeit1SelectionSort = System.nanoTime();
				geordnetesArraySelectionSort = SelectionSort.selectionSort(array.clone());
				long zeit2SelectionSort = System.nanoTime();
				
				long zeit1SimpleSort = System.nanoTime();
				geordnetesArraySimpleSort = SimpleSort.simpleSort(array.clone());
				long zeit2SimpleSort = System.nanoTime();

				// Die Gesamtzeit der einzelnen Algorithmen ermitteln
				double gesamtZeitBubbleSort = zeit2BubbleSort-zeit1BubbleSort;
				double gesamtZeitInsertionSort = zeit2InsertionSort-zeit1InsertionSort;
				double gesamtZeitMergeSort = zeit2MergeSort-zeit1MergeSort;
				double gesamtZeitQuickSort = zeit2QuickSort-zeit1QuickSort;
				double gesamtZeitSelectionSort = zeit2SelectionSort-zeit1SelectionSort;
				double gesamtZeitSimpleSort = zeit2SimpleSort-zeit1SimpleSort;
				
				// Von Nanosekunden auf Millisekunden umrechnen
				gesamtZeitBubbleSort /= 1000000;
				gesamtZeitInsertionSort /= 1000000;
				gesamtZeitMergeSort /= 1000000;
				gesamtZeitQuickSort /= 1000000;
				gesamtZeitSelectionSort /= 1000000;
				gesamtZeitSimpleSort /= 1000000;
				
				// Die Prüfungs Booleans festlegen
				boolean BubbleSortPrüfung = false;
				boolean InsertionSortPrüfung= false;
				boolean MergeSortPrüfung = false;
				boolean QuickSortPrüfung = false;
				boolean SelectionSortPrüfung = false;
				boolean SimpleSortPrüfung = false;					
				
				// Alle sortierten Arrays mit einem durch Java sortierten abgleichen
				BubbleSortPrüfung = sortierungsPrüfer(prüfArray, geordnetesArrayBubbleSort);
				InsertionSortPrüfung = sortierungsPrüfer(prüfArray, geordnetesArrayInsertionSort);
				MergeSortPrüfung = sortierungsPrüfer(prüfArray, geordnetesArrayMergeSort);
				QuickSortPrüfung = sortierungsPrüfer(prüfArray, geordnetesArrayQuickSort);
				SelectionSortPrüfung = sortierungsPrüfer(prüfArray, geordnetesArraySelectionSort);
				SimpleSortPrüfung = sortierungsPrüfer(prüfArray, geordnetesArraySimpleSort);
				
				// War die Prüfung erfolgreich? Dann speicher das Array in eine ContainerKlasse und dann in das zugehörige Container Array 
				if(BubbleSortPrüfung){
					
					sortieralgorithmenDaten[0] = new ContainerSortieralgorithmus(gesamtZeitBubbleSort, geordnetesArrayBubbleSort, "Bubblesort");
				}else{
					
					System.out.println("Die Bubblesort Prüfung schlug fehl.");
				}
				
				if(InsertionSortPrüfung){
					
					sortieralgorithmenDaten[1] = new ContainerSortieralgorithmus(gesamtZeitInsertionSort, geordnetesArrayInsertionSort, "Insertionsort");
				}else{
					
					System.out.println("Die Insertionsort Prüfung schlug fehl.");
				}
				
				if(MergeSortPrüfung){
					
					sortieralgorithmenDaten[2] = new ContainerSortieralgorithmus(gesamtZeitMergeSort, geordnetesArrayMergeSort, "Mergesort");
				}else{
					
					System.out.println("Die Mergesort Prüfung schlug fehl.");
				}
				
				if(QuickSortPrüfung){
					
					sortieralgorithmenDaten[3] = new ContainerSortieralgorithmus(gesamtZeitQuickSort, geordnetesArrayQuickSort, "Quicksort");
				}else{
					
					System.out.println("Die Quicksort Prüfung schlug fehl.");
				}
				
				if(SelectionSortPrüfung){
					
					sortieralgorithmenDaten[4] = new ContainerSortieralgorithmus(gesamtZeitSelectionSort, geordnetesArraySelectionSort, "Selectionsort");
				}else{
					
					System.out.println("Die Selectionsort Prüfung schlug fehl.");
				}
				
				if(SimpleSortPrüfung){
					
					sortieralgorithmenDaten[5] = new ContainerSortieralgorithmus(gesamtZeitSimpleSort, geordnetesArraySimpleSort, "Simplesort");
				}else{
					
					System.out.println("Die Simplesort Prüfung schlug fehl.");
				}
				
				return sortieralgorithmenDaten;
			}
	}
	/**
	 * Das ist die SortierungsPrüfer Methode, sie ist privat, da nur die go() Methode sie verwendet und sie prüft ein Array, von dem vorher sichergestellt werden muss,
	 * dass es geordnet ist mit einem Array ab, von dem man sich noch nicht sicher sein kann ob es richtig geordnet ist. 
	 * Es überprüft ob beide die gleiche Länge haben und wenn beide den gleichen Inhalt haben, müssen die gleichen Werte auf den gleichen Indizies stehen.
	 * Zurück gegeben word ein Boolean ob das zu prüfende Array mit dem gegenprüf Array, was die Werte angeht übereinstimmt (true) oder eben nicht (false) 
	 * @param gegenprüfArray
	 * @param zuPrüfendesArray
	 * @return
	 */
	private static boolean sortierungsPrüfer(int[] gegenprüfArray, int[] zuPrüfendesArray){
		
		// Wenn die Länge nicht gleich ist dann kann der Inhalt auch nicht gleich sein, dann sind sie nicht vergleichbar.
		if(gegenprüfArray.length != zuPrüfendesArray.length){
			
			return false;
		}else{
			
			int count = 0;
			
			// Gehe beide Arrays durch steht an jedem Index der gleiche Wert jeweils im einen so wie im anderen Array dann zähle Count hoch.
			for(int i = 0 ; i < gegenprüfArray.length ; ++i){
				
				if(gegenprüfArray[i] == zuPrüfendesArray[i]){
					
					count++;
				}
			}
			
			// Stand in jedem Index der gleiche Wert, wie im gegenprüfArray dann sind beide Identisch 
			// und count ist genauso groß wie das zu prüfende Array lang ist und genau dann ist alles nach Plan gelaufen. 
			if(count == zuPrüfendesArray.length){
				
				return true;
			}else{
				
				return false;
			}
		}
	}
}
