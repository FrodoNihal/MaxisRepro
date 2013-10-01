import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Schiff {

    // Attribute festlegen (Da die Methoden darunter öfter aufgerufen werden, brauchen wir manche Attribute hier, die man sonst
    // eigentlich als lokale Parameter hätte, da sie sonst überschrieben werden und das mit der Simulationsanzeige nicht klappen würde)
    private Punkt aktuellerP = null;
    private Punkt startP = null;
    private SchiffsImage img;
    private final String schiffsname;
    private double geschw;
    private double aktuellZeiteinheit = 0;
    private double zeit;

    // Beiden Höhrer für die Geschwindigkeitserhöung oder Verminderung
    private final PlusHörer ph = new PlusHörer();
    private final MinusHörer mh = new MinusHörer();

    /**
     * Ein Schiff braucht eine Geschwindigkeit eine aktuelle Position, sowie einen Namen
     * 
     * @param punktX
     * @param punktY
     * @param geschw
     * @param name
     */
    public Schiff(final int punktX, final int punktY, final double geschw, final String name) {

        this.aktuellerP = new Punkt(punktX, punktY);
        this.startP = new Punkt(punktX, punktY);
        this.geschw = geschw;
        this.schiffsname = name;
    }

    public Punkt getAktuellerP() {
        return this.aktuellerP;
    }

    public double getGeschw() {
        return this.geschw;
    }

    public PlusHörer getPh() {
        return this.ph;
    }

    public MinusHörer getMh() {
        return this.mh;
    }

    public String getSchiffsname() {
        return this.schiffsname;
    }

    /**
     * Das ist die Methode, die ein Schiff zum Fahren bringt. (Mathematisch gesagt, die die den nächsten Punkt pro Zeiteinheit
     * berechnet) und dann auch zeichnet. Dafür brauchen wir in diesem Fall die richtung (osten) die Zeiteinheit und das objekt zum
     * Zeichnen
     * 
     * @param zeiteinheit
     * @param osten
     * @param g
     * @return
     */
    public Schiff fahren(final double zeiteinheit, final boolean osten, final Graphics2D g) {

        this.zeit = zeiteinheit;

        if (osten) {

            // Formel zur neuen Punktberechnung (gerundet weil sonst der Cast gleich alles abschneidet) Formel wird pro Knopfdruck
            // (egal ob plus oder minus) ungenauer. Die geschwindigkeit muss durch 6 geteilt werden um das verhältnis beizubehalten 1
            // sm = 10 pix
            this.aktuellerP.setX(Math.round(this.startP.getX() + 1 * (this.geschw / 6) * (zeiteinheit - this.aktuellZeiteinheit)));
            this.aktuellerP.setY(Math.round(this.startP.getY() + 0 * (this.geschw / 6) * (zeiteinheit - this.aktuellZeiteinheit)));

        } else {

            this.aktuellerP.setX(Math.round(this.startP.getX() + 0 * (this.geschw / 6) * (zeiteinheit - this.aktuellZeiteinheit)));
            this.aktuellerP.setY(Math.round(this.startP.getY() + 1 * (this.geschw / 6) * (zeiteinheit - this.aktuellZeiteinheit)));
        }

        // Zeichne das Schiff im neu berechneten Punkt
        this.img = new SchiffsImage(this.aktuellerP);
        this.img.go(this.aktuellerP, g);

        return this;
    }

    private class PlusHörer implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent e) {

            // Wenn plus gedrückt wurde erhöhe die Geschwindikeit, nehme die aktuellezeit und rechne die gegen die später reinkommenden
            // Zeiten und setze den aktuellen punkt als startpunkt (das die formel richtig bleibt) beim aktuellen punkt als neuen
            // Startpunkt setzen treten die Rundungsfehler auf und in massen angewedet führt das zu fehlerhaften ergebnissen
            Schiff.this.geschw += +1;
            Schiff.this.aktuellZeiteinheit = Schiff.this.zeit;
            Schiff.this.startP = Schiff.this.aktuellerP.clone();
        }
    }

    private class MinusHörer implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent e) {

            // Wenn plus gedrückt wurde vermindere die Geschwindikeit, nehme die aktuellezeit und rechne die gegen die später
            // reinkommenden
            // Zeiten und setze den aktuellen punkt als startpunkt (das die formel richtig bleibt) beim aktuellen punkt als neuen
            // Startpunkt setzen treten die Rundungsfehler auf und in massen angewedet führt das zu fehlerhaften ergebnissen
            Schiff.this.geschw -= +1;
            Schiff.this.aktuellZeiteinheit = Schiff.this.zeit;
            Schiff.this.startP = Schiff.this.aktuellerP.clone();
        }
    }
}
