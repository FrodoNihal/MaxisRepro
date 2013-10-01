import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Das ist die Klasse SchiffsImage, sie erstellt mithilfe eines Punktes und eines graphics objektes ein visuelles Schiff (sieht ähnlich
 * wie ein Papierboot aus)
 * 
 * @author Maximilian
 * 
 */
public class SchiffsImage extends BufferedImage {

    /**
     * Konstruktor, hier wird die Größe des Images an die Superklasse weitergeleitet.
     * 
     * @param p
     */
    public SchiffsImage(final Punkt p) {
        super(p.getX() + 16 - (p.getX() - 16), p.getY() + 15 - (p.getY() - 3), BufferedImage.TYPE_INT_ARGB);
    }

    /**
     * Die go methode zeichnet das Schiff nach den hier stehenden Vorgaben. Mithilfe eines Punktes und eines graphics objektes.
     * 
     * @param p
     * @param g
     */
    public void go(final Punkt p, final Graphics2D g) {

        final int x = p.getX();
        final int y = p.getY();

        final Punkt p1 = new Punkt(x - 10, y - 3);
        final Punkt p2 = new Punkt(p1.getX() + 20, p1.getY());
        final Punkt p3 = new Punkt(p2.getX() + 6, p2.getY() + 6);
        final Punkt p4 = new Punkt(p3.getX() - 32, p3.getY());
        final Punkt p5 = new Punkt(x, y + 3);
        final Punkt p6 = new Punkt(p5.getX() - 4, p5.getY());
        final Punkt p7 = new Punkt(p5.getX() + 4, p5.getY());
        final Punkt p8 = new Punkt(x, y + 15);

        g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        g.drawLine(p1.getX(), p1.getY(), p4.getX(), p4.getY());
        g.drawLine(p2.getX(), p2.getY(), p3.getX(), p3.getY());
        g.drawLine(p4.getX(), p4.getY(), p3.getX(), p3.getY());
        g.drawLine(p8.getX(), p8.getY(), p5.getX(), p5.getY());
        g.drawLine(p8.getX(), p8.getY(), p6.getX(), p6.getY());
        g.drawLine(p8.getX(), p8.getY(), p7.getX(), p7.getY());
    }
}
