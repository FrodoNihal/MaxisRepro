import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Das ist die Laager Klasse. Es gibt davon nur ein Objekt, welches durch alle Klassen geleitet wird, um für alle wichtigen Dinge einen
 * zentralen Anlaufpunkt zu haben. In diesem Laager ist das wichtigste Objekt, was überall erreichbar sein soll die abstandsListe.
 * 
 * @author Maximilian
 * 
 */
public class Laager {

    // Attribute festlegen (Da die Methoden darunter öfter aufgerufen werden, brauchen wir manche Attribute hier, die man sonst
    // eigentlich als lokale Parameter hätte, da sie sonst überschrieben werden und das mit der Simulationsanzeige nicht klappen würde)
    private final ArrayList<Object[]> abstandsListe = new ArrayList<Object[]>();
    private boolean einmal = true;
    private Punkt fixPunktPrincessJane;
    private Punkt fixPunktCantona;
    private SchiffsImage princessJane;
    private SchiffsImage cantona;

    public ArrayList<Object[]> getAbstandsListe() {
        return this.abstandsListe;
    }

    /**
     * Das ist die abstrakte .add() Methode für die abstandsListe. Wir brauchen die beiden Punkte und berechnen dann dazwischen den
     * Abstand und die Zeiteinheit ist wichtig, dass wir wissen, wann die Punkte so in diesem speziellen Abstand zueinander standen.
     * Das Graphics2D Objekt wird gebraucht, um den Abstand, wenn es dann der kürzeste ist gleich zu zeichnen.
     * 
     * @param p1
     * @param p2
     * @param g
     * @param zeiteinheit
     */
    public void abstandHinzufügen(final Punkt p1, final Punkt p2, final Graphics2D g, final int zeiteinheit) {

        // Haben wir den kürzesten Abstand noch nicht?
        if (this.einmal) {

            final Object[] o = new Object[4];
            // Wir speichern uns den ungerundeten Abstand weg (ist für die Vergleiche des Sortieralgorithmusses besser)
            final double abstand = Punkt.abstandsBerechnung(p1, p2);
            double kleinsterAbstand = 0;
            // Die abstandsListe ist eine Liste aus ObjektArrays, hier sieht man den Aufbau der Objektarrays.
            o[0] = abstand;
            o[1] = p1;
            o[2] = p2;
            o[3] = zeiteinheit;
            this.abstandsListe.add(o);

            // Hier werden die Objekte nach ihrem Abstand sortiert. Warum Insertionsort? Weil wir durch das sequentielle Sortieren (pro
            // Durchgang einmal) eine Vorsortierte Liste haben, mit nur einem fehlsortierten Element (also fast best case) ->
            // Insertionsort ist performanter
            Insertionsort.insertionSort(this.abstandsListe);
            // Durch das Sortieren ist der kleinste Abstand an vorderster Stelle
            kleinsterAbstand = (double)this.abstandsListe.get(0)[0];

            // Wenn wir den kleinsten Abstand in der Liste mit dem momentanen Abstand vergleichen und dieser -1 immernoch kleiner ist,
            // dann haben wir den kleinsten Abstand gefunden. Warum das -1? Weil es bei der Annäherung an den minimalsten Abstand durch
            // PC Rundungen zu Ungenauigkeiten kommen kann, die wir ab der einen Einheit vernachlässigen können.
            if (kleinsterAbstand < abstand - 1) {

                // Wir haben den kleinsten Abstand festgeschrieben und merken uns die Punkte, an denen dieser Abstand herrscht.
                this.einmal = false;
                this.fixPunktPrincessJane = (Punkt)this.abstandsListe.get(0)[1];
                this.fixPunktCantona = (Punkt)this.abstandsListe.get(0)[2];
            }

        } else {

            // Wenn der kleinste Abstand gefunden wurde, dann kann er eingezeichnet werden.
            g.setColor(Color.RED);
            this.princessJane = new SchiffsImage(this.fixPunktPrincessJane);
            this.princessJane.go(this.fixPunktPrincessJane, g);

            g.setColor(Color.BLUE);
            this.cantona = new SchiffsImage(this.fixPunktCantona);
            this.cantona.go(this.fixPunktCantona, g);

            // Die Abstandslinie
            g.setColor(Color.BLACK);
            g.drawLine(
                    this.fixPunktPrincessJane.getX(),
                    this.fixPunktPrincessJane.getY(),
                    this.fixPunktCantona.getX(),
                    this.fixPunktCantona.getY());

        }
    }
}
