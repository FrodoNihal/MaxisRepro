import java.util.Arrays;
/**
 * Das ist die Klasse SortierungsTester sie macht nichts anderes als die Array Sortieren zu lassen
 * und dabei die Zeit zu nehmen sowie gegen zu pr�fen, ob richtig sortiert wurde. 
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
			
			System.out.println("Das zu pr�fende Array ist null.");
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
				int[] pr�fArray = array.clone();
				Arrays.sort(pr�fArray);
				
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
				
				// Die Pr�fungs Booleans festlegen
				boolean BubbleSortPr�fung = false;
				boolean InsertionSortPr�fung= false;
				boolean MergeSortPr�fung = false;
				boolean QuickSortPr�fung = false;
				boolean SelectionSortPr�fung = false;
				boolean SimpleSortPr�fung = false;					
				
				// Alle sortierten Arrays mit einem durch Java sortierten abgleichen
				BubbleSortPr�fung = sortierungsPr�fer(pr�fArray, geordnetesArrayBubbleSort);
				InsertionSortPr�fung = sortierungsPr�fer(pr�fArray, geordnetesArrayInsertionSort);
				MergeSortPr�fung = sortierungsPr�fer(pr�fArray, geordnetesArrayMergeSort);
				QuickSortPr�fung = sortierungsPr�fer(pr�fArray, geordnetesArrayQuickSort);
				SelectionSortPr�fung = sortierungsPr�fer(pr�fArray, geordnetesArraySelectionSort);
				SimpleSortPr�fung = sortierungsPr�fer(pr�fArray, geordnetesArraySimpleSort);
				
				// War die Pr�fung erfolgreich? Dann speicher das Array in eine ContainerKlasse und dann in das zugeh�rige Container Array 
				if(BubbleSortPr�fung){
					
					sortieralgorithmenDaten[0] = new ContainerSortieralgorithmus(gesamtZeitBubbleSort, geordnetesArrayBubbleSort, "Bubblesort");
				}else{
					
					System.out.println("Die Bubblesort Pr�fung schlug fehl.");
				}
				
				if(InsertionSortPr�fung){
					
					sortieralgorithmenDaten[1] = new ContainerSortieralgorithmus(gesamtZeitInsertionSort, geordnetesArrayInsertionSort, "Insertionsort");
				}else{
					
					System.out.println("Die Insertionsort Pr�fung schlug fehl.");
				}
				
				if(MergeSortPr�fung){
					
					sortieralgorithmenDaten[2] = new ContainerSortieralgorithmus(gesamtZeitMergeSort, geordnetesArrayMergeSort, "Mergesort");
				}else{
					
					System.out.println("Die Mergesort Pr�fung schlug fehl.");
				}
				
				if(QuickSortPr�fung){
					
					sortieralgorithmenDaten[3] = new ContainerSortieralgorithmus(gesamtZeitQuickSort, geordnetesArrayQuickSort, "Quicksort");
				}else{
					
					System.out.println("Die Quicksort Pr�fung schlug fehl.");
				}
				
				if(SelectionSortPr�fung){
					
					sortieralgorithmenDaten[4] = new ContainerSortieralgorithmus(gesamtZeitSelectionSort, geordnetesArraySelectionSort, "Selectionsort");
				}else{
					
					System.out.println("Die Selectionsort Pr�fung schlug fehl.");
				}
				
				if(SimpleSortPr�fung){
					
					sortieralgorithmenDaten[5] = new ContainerSortieralgorithmus(gesamtZeitSimpleSort, geordnetesArraySimpleSort, "Simplesort");
				}else{
					
					System.out.println("Die Simplesort Pr�fung schlug fehl.");
				}
				
				return sortieralgorithmenDaten;
			}
	}
	/**
	 * Das ist die SortierungsPr�fer Methode, sie ist privat, da nur die go() Methode sie verwendet und sie pr�ft ein Array, von dem vorher sichergestellt werden muss,
	 * dass es geordnet ist mit einem Array ab, von dem man sich noch nicht sicher sein kann ob es richtig geordnet ist. 
	 * Es �berpr�ft ob beide die gleiche L�nge haben und wenn beide den gleichen Inhalt haben, m�ssen die gleichen Werte auf den gleichen Indizies stehen.
	 * Zur�ck gegeben word ein Boolean ob das zu pr�fende Array mit dem gegenpr�f Array, was die Werte angeht �bereinstimmt (true) oder eben nicht (false) 
	 * @param gegenpr�fArray
	 * @param zuPr�fendesArray
	 * @return
	 */
	private static boolean sortierungsPr�fer(int[] gegenpr�fArray, int[] zuPr�fendesArray){
		
		// Wenn die L�nge nicht gleich ist dann kann der Inhalt auch nicht gleich sein, dann sind sie nicht vergleichbar.
		if(gegenpr�fArray.length != zuPr�fendesArray.length){
			
			return false;
		}else{
			
			int count = 0;
			
			// Gehe beide Arrays durch steht an jedem Index der gleiche Wert jeweils im einen so wie im anderen Array dann z�hle Count hoch.
			for(int i = 0 ; i < gegenpr�fArray.length ; ++i){
				
				if(gegenpr�fArray[i] == zuPr�fendesArray[i]){
					
					count++;
				}
			}
			
			// Stand in jedem Index der gleiche Wert, wie im gegenpr�fArray dann sind beide Identisch 
			// und count ist genauso gro� wie das zu pr�fende Array lang ist und genau dann ist alles nach Plan gelaufen. 
			if(count == zuPr�fendesArray.length){
				
				return true;
			}else{
				
				return false;
			}
		}
	}
}
