/**
 * 
 * @author Maximilian
 *
 */
public class Probant {

    public String ziffernfolge(final int n) {
    	
        if (n == 0) {
            return " ";
        }
        
        return this.ziffernfolge(n - 1) + " " + n + " " + this.ziffernfolge(n - 1);
    }
}
