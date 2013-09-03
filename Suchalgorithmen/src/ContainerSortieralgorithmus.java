/**
 * Das ist die Container Klasse für einen Sortieralgorithmus und seinen wichtigsten Testdaten.
 * @author Maximilian Scholz
 *
 */
public class ContainerSortieralgorithmus {

	private double gesamtZeit;
	private int[] array;
	private String name;
	
	public ContainerSortieralgorithmus(double zeit, int[] sortiertesArray, String name){
		
		this.gesamtZeit = zeit;
		this.array = sortiertesArray;
		this.name = name;
	}
	
	public double getGesamtZeit() {
		return gesamtZeit;
	}

	public int[] getArray() {
		return array;
	}

	public String getName() {
		return name;
	}
}
