import java.util.ArrayList;

/**
 * Das ist die Klasse Insertionsort, sie sortiert (in diesem Fall spezielle objektlisten) nach dem insertionsort verfahren (Maxis
 * insertionsort art)
 * 
 * @author Maximilian Scholz
 * 
 */
public class Insertionsort {

    public static ArrayList<Object[]> insertionSort(final ArrayList<Object[]> unsortierteOListe) {

        double zwischenvariable = 0;
        Object[] dreieckselement = null;
        Object[] zwischenElement = null;

        for (int i = 0; i < unsortierteOListe.size(); ++i) {

            int index2 = 1;
            zwischenvariable = (double)unsortierteOListe.get(i)[0];
            zwischenElement = unsortierteOListe.get(i);

            if (i > 0 && zwischenvariable < (double)unsortierteOListe.get(i - index2)[0]) {

                while (i >= index2 && zwischenvariable < (double)unsortierteOListe.get(i - index2)[0]) {

                    dreieckselement = unsortierteOListe.get(i - index2);
                    unsortierteOListe.remove(i - index2);
                    unsortierteOListe.add(i - index2, zwischenElement);
                    unsortierteOListe.remove(i);
                    unsortierteOListe.add(i, dreieckselement);
                    ++index2;
                }
            }
        }

        return unsortierteOListe;
    }
}
