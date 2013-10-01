import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Das ist die Klasse informationsPanel jedes Schiff hat eine anzeige später auf dem Frame, mit seinen wichtigsten Daten. Diese Anzeige
 * der wichtigsten Daten übernimmt das InformationsPanel
 * 
 * @author Maximilian
 * 
 */
public class InformationsPanel extends JPanel {

    // Attribute festlegen (Da die Methoden darunter öfter aufgerufen werden, brauchen wir manche Attribute hier, die man sonst
    // eigentlich als lokale Parameter hätte, da sie sonst überschrieben werden und das mit der Simulationsanzeige nicht klappen würde)
    private Schiff schiff;
    private final BorderLayout bl = new BorderLayout();
    private final GridLayout grl = new GridLayout(1, 2);
    private final Box labelBox = new Box(BoxLayout.Y_AXIS);

    private final JTextField schiffsName = new JTextField();
    private final JTextField koordinaten = new JTextField();
    private final JTextField abstandsLabel = new JTextField();
    private final JTextField geschwindigkeit = new JTextField();
    private final JPanel buttonPanel = new JPanel();
    private boolean einmal = true;

    private final JButton plus = new JButton("+");
    private final JButton minus = new JButton("-");

    /**
     * Das ist die go methode des Informationspanels. Pro Schiff werden hier die wichtigsten Daten in einer Übersicht erst inhaltlich
     * formatiert und dann an die oberfläche zum User gegeben.
     * 
     * @param s
     * @param abstand
     */
    public void go(final Schiff s, final double abstand) {

        this.schiff = s;

        if (this.schiff.getSchiffsname().equals("Cantona")) {

            this.schiffsName.setForeground(Color.BLUE);

        } else {

            this.schiffsName.setForeground(Color.RED);
        }

        if (this.einmal) {
            // beim Ersten mal ausführen, werden die Listener gesetzt.
            this.plus.addActionListener(this.schiff.getPh());
            this.minus.addActionListener(this.schiff.getMh());
            this.einmal = false;
        }

        // Anzeigetext formatieren
        this.schiffsName.setText(this.schiff.getSchiffsname());
        this.koordinaten.setText("( " + s.getAktuellerP().getX() + " | " + s.getAktuellerP().getY() + " )");
        this.abstandsLabel.setText(abstand + " sm");
        this.geschwindigkeit.setText(Math.round(this.schiff.getGeschw() * 100) / 100.0 + " sm/h");

        // button formatieren
        this.buttonPanel.setLayout(this.grl);
        this.buttonPanel.add(this.plus);
        this.buttonPanel.add(this.minus);

        // label formatieren
        this.labelBox.add(this.schiffsName);
        this.labelBox.add(this.koordinaten);
        this.labelBox.add(this.abstandsLabel);
        this.labelBox.add(this.geschwindigkeit);
        this.labelBox.add(this.buttonPanel);

        // Manipulation durch den User vermeiden
        this.schiffsName.setEditable(false);
        this.koordinaten.setEditable(false);
        this.abstandsLabel.setEditable(false);
        this.geschwindigkeit.setEditable(false);
        this.schiffsName.setFocusable(false);
        this.koordinaten.setFocusable(false);
        this.abstandsLabel.setFocusable(false);
        this.geschwindigkeit.setFocusable(false);

        this.setLayout(this.bl);

        this.add(BorderLayout.CENTER, this.labelBox);

        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
    }
}
