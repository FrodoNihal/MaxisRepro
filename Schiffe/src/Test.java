/**
 * Das ist die Test Klasse sie enth�lt die Mainmethode und st��t die ganze Simulation an.
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
