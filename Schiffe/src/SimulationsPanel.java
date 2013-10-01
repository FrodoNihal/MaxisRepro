import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JPanel;

/**
 * Das ist die SimulationsPanel Klasse auf diesem Panel fahren später die Schiffe umher.
 * 
 * @author Maximilian
 * 
 */
public class SimulationsPanel extends JPanel {

    // Attribute festlegen (Da die Methoden darunter öfter aufgerufen werden, brauchen wir manche Attribute hier, die man sonst
    // eigentlich als lokale Parameter hätte, da sie sonst überschrieben werden und das mit der Simulationsanzeige nicht klappen würde)
    private int zeiteinheit;
    private Schiff cantona = new Schiff(470, 120, 10, "Cantona");
    private Schiff princessJane = new Schiff(70, 120, 15, "Princess Jane");
    private final Laager laager;

    public SimulationsPanel(final Laager laager) {
        this.laager = laager;
    }

    public Schiff getCartona() {
        return this.cantona;
    }

    public Schiff getPrincessJane() {
        return this.princessJane;
    }

    public void setZeiteinheit(final int zeiteinheit) {
        this.zeiteinheit = zeiteinheit;
    }

    /**
     * Das ist die Methode, die uns das Graphics Objekt zum sequentiellen Zeichnen gibt. In ihr werden pro Durchgang die Schiffe und
     * ihr Abstand zueinander gezeichnet.
     */
    @Override
    protected void paintComponent(final Graphics g) {

        super.paintComponent(g);

        final Graphics2D g2 = (Graphics2D)g;
        // SEHR wichtiger Befehl dadurch wird für dieses Graphics Objekt der Ursprung von oben links nach unten links gesetzt (ist für
        // Mathe gut)
        g2.setTransform(new AffineTransform(1, 0, 0, -1, 0, this.getHeight()));

        // male das Koordinatensystem
        this.koordinatenSystem(g2);

        // male Princess Jane rot
        g2.setColor(Color.RED);
        this.princessJane = this.princessJane.fahren(this.zeiteinheit, true, g2);

        // male Cantona blau
        g2.setColor(Color.BLUE);
        this.cantona = this.cantona.fahren(this.zeiteinheit, false, g2);

        // male den Abstand zwischen den beiden
        g.setColor(Color.BLACK);
        g.drawLine(
                this.princessJane.getAktuellerP().getX(),
                this.princessJane.getAktuellerP().getY(),
                this.cantona.getAktuellerP().getX(),
                this.cantona.getAktuellerP().getY());

        // Werfe die aktuellen Punkte (geclont wegen referentieller Integrität) in das laager mit der momentanen Zeiteinheit
        this.laager.abstandHinzufügen(this.princessJane.getAktuellerP().clone(), this.cantona.getAktuellerP().clone(), g2, this.zeiteinheit);
    }

    /**
     * Hier wird das Koordinatenystem gezeichnet (um das Koordinatensystem sichtbar zu machen wurde es in das eigentliche am rand
     * stehende Koordinatensystem gezeichnet) also ist das Sichtbare koordinatensystem NICHT das richtige KoordinatenSystem, sondern
     * nur eine visuelle Stütze (natürlich brauch man dazu ein zeichen Objekt)
     * 
     * @param g
     */
    private void koordinatenSystem(final Graphics2D g) {

        // Grenzenbestimmung
        final int rechteGrenze = this.getBounds().width - 10;
        final int obereGrenze = this.getBounds().height - 10;

        // malt die x achse ohne orientierungsstriche
        g.drawLine(10, 10, rechteGrenze, 10);
        // malt die y achse ohne orientierungsstriche
        g.drawLine(10, 10, 10, obereGrenze);

        // Die Orientierungsstriche sind die kurzen senkrechten (x achse) und waagerechten (y achse) Striche im Koordinatensystem.
        // Zwischen ihnen sind 10 pixel (simulationstechnisch also 1 seemeile)
        this.xOrientierungsStriche(g, rechteGrenze);
        this.yOrientierungsStriche(g, obereGrenze);
    }

    /**
     * Malt die orientierungsstriche bis zur rechtenGrenze in die xAchse
     * 
     * @param g
     * @param rechteGrenze
     */
    private void xOrientierungsStriche(final Graphics2D g, final int rechteGrenze) {

        for (int i = 20; i <= rechteGrenze; i += 10) {

            g.drawLine(i, 15, i, 5);
        }
    }

    /**
     * Malt die orientierungsstriche bis zur oberenGrenze in die yAchse
     * 
     * @param g
     * @param obereGrenze
     */
    private void yOrientierungsStriche(final Graphics2D g, final int obereGrenze) {

        for (int i = 20; i <= obereGrenze; i += 10) {

            g.drawLine(5, i, 15, i);
        }
    }
}
