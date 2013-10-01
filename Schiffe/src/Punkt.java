/**
 * Das ist die klasse Punkt, sie dient hauptsächlich zum besseren verständnis und nimmt auch elementare methoden auf
 * (abstandsberechnung) die attribute MÜSSEN int sein, da Java nur mit int Werten zeichnet (ist da wir die Pixel ansteuern und die
 * nicht aufteilbar sind auch klar)
 * 
 * @author Maximilian
 * 
 */
public class Punkt {

    // Attribute
    private int x = 0;
    private int y = 0;

    /**
     * Konstruktor (ein Punkt braucht im 2 dimensionalen raum 2 Werte um überhaupt ein Punkt zu sein)
     * 
     * @param x
     * @param y
     */
    public Punkt(final int x, final int y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public Punkt clone() {

        return new Punkt(this.x, this.y);
    }

    public void setX(final double x) {
        // gerundet das durch den cast nicht so viel verloren gehen kann
        this.x = (int)Math.round(x);
    }

    public void setY(final double y) {
        // gerundet das durch den cast nicht so viel verloren gehen kann
        this.y = (int)Math.round(y);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * Das ist die statische methode, die zwischen 2 Punkten den abstand bestimmt.
     * 
     * @param p1
     * @param p2
     * @return
     */
    public static double abstandsBerechnung(final Punkt p1, final Punkt p2) {

        final int x = p2.getX() - p1.getX();
        final int y = p2.getY() - p1.getY();

        final double ergebnis = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

        return ergebnis;
    }

    public String punktAusgeben() {

        final String ausgabeString = "(" + this.x + "|" + this.y + ")";

        return ausgabeString;
    }
}
