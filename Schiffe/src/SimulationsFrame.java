import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Das ist der SimulationsFrame, in ihm findet die Simulation sichtbar statt.
 * 
 * @author Maximilian
 * 
 */
public class SimulationsFrame extends JFrame {

    // Attribute festlegen (Da die Methoden darunter �fter aufgerufen werden, brauchen wir manche Attribute hier, die man sonst
    // eigentlich als lokale Parameter h�tte, da sie sonst �berschrieben werden und das mit der Simulationsanzeige nicht klappen w�rde)
    private final Laager laager;
    private final JLabel zeitAnzeigeLabel = new JLabel();
    private final InformationsPanel informationsPanel1 = new InformationsPanel();
    private final InformationsPanel informationsPanel2 = new InformationsPanel();
    private final SimulationsPanel simulationsPanel;

    /**
     * Konstruktor (Laager wird durchgeleitet)
     * 
     * @param laager
     */
    public SimulationsFrame(final Laager laager) {

        super("Simulation");
        this.laager = laager;
        // schon hier muss das SimulationsPanel erzeugt werden, um Nullpointer(vom Laager) zu vermeiden.
        this.simulationsPanel = new SimulationsPanel(this.laager);
    }

    /**
     * Das ist die go() Methode, sie wickelt das Geschehen im SimulationsFrame ab und l�sst die Zeit vergehen. (Dadurch kommt erst die
     * Simulation ins rollen)
     */
    public void go() {

        // bereite den Frame f�r die Simulation vor
        this.setDefaultFrameSettings();

        // lasse die Zeit vergehen 1 Einheit = eine Minute Simulationszeit 10 Einheiten = 1 reale Sekunde (diese Methode bef�llt im
        // Hintergrund das Laager mit den ben�tigten Informationen)
        this.zeitVergehenLassen(0, 180);

        // Es werden nun, da das Laager gef�llt ist die wichtigsten Informationen aus diesem extrahiert und in die richtigen Variablen
        // �berf�hrt.
        final double k�rzesterAbstand = Math.round((double)this.laager.getAbstandsListe().get(0)[0] * 100) / 1000.0;
        final int zeitPunktInt = (int)this.laager.getAbstandsListe().get(0)[3];
        final String zeitpunkt = this.zeitBerechnen(zeitPunktInt, "9:00");
        final Punkt k�rzesterAbstandPrincessJanePunkt = (Punkt)this.laager.getAbstandsListe().get(0)[1];
        final Punkt k�rzesterAbstandCantona = (Punkt)this.laager.getAbstandsListe().get(0)[2];

        // jetzt werden diese Informationen an die Oberfl�che geleitet und f�r den User sichtbar gemacht
        final PopUpWarnung pop =
                new PopUpWarnung("Der k�rzeste Abstand zwischen den beiden Schiffen" + "\n" + "Cartona und Prinzess Jane betr�gt: "
                        + k�rzesterAbstand + " sm (" + zeitpunkt + " Uhr)." + "\n" + "Position Princess Jane: "
                        + k�rzesterAbstandPrincessJanePunkt.punktAusgeben() + "\n" + "Position Cartona: "
                        + k�rzesterAbstandCantona.punktAusgeben());
        // erst durch die Go methode wird wirklich angezeigt
        pop.go();
    }

    /**
     * Mit dieser Methode wird die Simulationszeit berechnet und als String f�r die Anzeige bereit gestellt. Daf�r ben�tigt man die
     * Zeiteinheit und die Startzeit als String. WICHTIG diese Methode kann nicht �ber einen Tag hinaus anzeigen.
     * 
     * @param zeitEinheit
     * @param digitalZeit
     * @return
     */
    private String zeitBerechnen(final int zeitEinheit, final String digitalZeit) {

        final String[] stundeMinute = digitalZeit.split(":");
        int stunde = Integer.parseInt(stundeMinute[0]);
        int minute = Integer.parseInt(stundeMinute[1]);
        double tmp = 0;
        int dazuWertStunde = 0;

        if (zeitEinheit >= 60) {

            tmp = zeitEinheit / 60;
            dazuWertStunde = (int)tmp;
            stunde += dazuWertStunde;
            minute += zeitEinheit - dazuWertStunde * 60;

        } else {

            minute += zeitEinheit;
        }

        if (minute <= 9) {

            return stunde + ":0" + minute;
        }

        return stunde + ":" + minute;
    }

    /**
     * Das ist die Methode, die alle immer gleichen Settings des Frames voreinstellt. (Damit wird der Code �bersichtlicher und man kann
     * sich separat darum k�mmern, wenn Ver�nderungen gew�nscht sind) (Ist speziell auf diesen SimulationsFrame zugeschnitten)
     */
    private void setDefaultFrameSettings() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 800);
        this.setResizable(false);
        this.setVisible(true);

        this.zeitAnzeigeLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        final Box infobox = new Box(BoxLayout.Y_AXIS);

        infobox.add(this.informationsPanel1);
        infobox.add(this.informationsPanel2);
        infobox.add(this.zeitAnzeigeLabel);

        final JPanel zwischenPanel = new JPanel();
        final BorderLayout bl = new BorderLayout();
        zwischenPanel.setLayout(bl);
        zwischenPanel.add(BorderLayout.NORTH, infobox);

        this.add(BorderLayout.EAST, zwischenPanel);

        this.add(this.simulationsPanel);
    }

    /**
     * Das ist die wichtige Zeitvergehenlassen Methode, sie l�sst minutenweise die Simulationsszeit vergehen. Bef�llt damit im
     * hintergrund das laager und l�sst dadurch alle sequenziell zu berechnenden Objekte berechnen. Nat�rlich braucht sie daf�r die
     * anfangs und endzeit.
     * 
     * @param anfangszeitInMin
     * @param endZeitInMin
     */
    private void zeitVergehenLassen(final int anfangszeitInMin, final int endZeitInMin) {

        // Die Schleife die das realisiert
        for (int i = anfangszeitInMin; i <= endZeitInMin; ++i) {

            // leite die Zeit an das simulationsPanel weiter
            this.simulationsPanel.setZeiteinheit(i);
            // berechne die momentane Simulationszeit und zeige diese an
            final String momentanZeit = this.zeitBerechnen(i, "9:00");
            this.zeitAnzeigeLabel.setText("T: " + momentanZeit);

            // berechne den momentanen Abstand der Schiffe und formatiere ihn f�r die Anzeige
            double abstand =
                    Punkt.abstandsBerechnung(
                            this.simulationsPanel.getPrincessJane().getAktuellerP(),
                            this.simulationsPanel.getCartona().getAktuellerP());
            abstand = abstand / 10;
            abstand = Math.round(abstand * 1000) / 1000.0;

            // lasse die Informationspanels (mit den neusten Informationen aus dem Laager) laufen
            this.informationsPanel1.go(this.simulationsPanel.getPrincessJane(), abstand);
            this.informationsPanel2.go(this.simulationsPanel.getCartona(), abstand);

            // male dich neu und zeige diese Infos an
            this.repaint();

            // hier unten wrd kurz gewartet, um die Simulation besser sichtbar zu machen. �ber diesen Wartewert kann man die Simulation
            // auch in Echtzeit abwickeln. 1 min (simZeit) = 1 sec(real) -> 1000 | 1 min(simZeit) = 1 min(real) -> 60000
            try {
                Thread.sleep(100);
            } catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
