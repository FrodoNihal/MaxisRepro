/**
 * Das ist die Test Klasse sie enthält die Mainmethode und stößt die ganze Simulation an.
 * 
 * @author Maximilian
 * 
 */
public class Test {

    public static void main(final String[] args) {

        // Erstelle ein neues Laager, erzeuge einen Simulationsframe und lasse diesen laufen
        final Laager laager = new Laager();
        final SimulationsFrame sim = new SimulationsFrame(laager);
        sim.go();
    }
}
