import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class PopUpWarnung {

    // Attribute festlegen.
    private JFrame frame;
    private String warnung = "";

    // Der Konstruktor.
    public PopUpWarnung(final String warnung) {

        this.warnung = warnung;

    }

    /**
     * Das ist die go methode sie wickelt das ganze Geschehen ab.
     */
    public void go() {

        // Die innere Klasse erzeugen.
        final HörerOk okl = new HörerOk();

        // frame inizialisieren.
        this.frame = new JFrame("Info");

        // ok Button erzeugen und den ActionListener der inneren klasse hinzufügen.
        final JButton ok = new JButton("ok");
        ok.addActionListener(okl);

        // zur verkleinerung des ok Buttons
        final JPanel buttonPanel = new JPanel();
        final BorderLayout bl = new BorderLayout();
        buttonPanel.setLayout(bl);

        // zur verkleinerung des ok Buttons
        final JPanel buttonUnterPanel = new JPanel();
        final BorderLayout bl2 = new BorderLayout();
        buttonPanel.setLayout(bl2);

        final StyleContext.NamedStyle centerStyle = StyleContext.getDefaultStyleContext().new NamedStyle();
        StyleConstants.setAlignment(centerStyle, StyleConstants.ALIGN_CENTER);

        // Label erzeugen und den warnungsstring einfügen.
        final JTextPane text = new JTextPane();

        text.setLogicalStyle(centerStyle);
        text.setEditable(false);
        text.setText("\n" + this.warnung);

        // zur verkleinerung des ok Buttons
        buttonUnterPanel.add(BorderLayout.WEST, ok);
        buttonPanel.add(BorderLayout.SOUTH, buttonUnterPanel);

        // Alle Elemente dem Frame hinzufügen.
        this.frame.add(BorderLayout.SOUTH, buttonPanel);
        this.frame.add(BorderLayout.CENTER, text);

        // Standardwerte des Frames festsetzen.
        this.frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        this.frame.pack();
        this.frame.setResizable(false);
        this.frame.setVisible(true);

    }

    /**
     * Das ist die innere Klasse HörerOk sie sorgt dafür das wenn der user Ok drückt die die Warnung verschwindet.
     * 
     * @author Maximilian
     * 
     */
    private class HörerOk implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent e) {
            PopUpWarnung.this.frame.dispose();

        }

    }

}
