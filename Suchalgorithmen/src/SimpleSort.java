/**
* @author Chris-L. Junge
*/
public class SimpleSort {
  public static void process(double[] vValues)
  {
    for (int i = 0; i < vValues.length; i++) {
      for (int j = i + 1; j < vValues.length; j++) {
        if(vValues[i] > vValues[j])
        {
          swap(vValues, i, j);
        }
        else { }
      }
    }
  }
  
  private static void swap(double[] vValues, int i, int j)
  {
    double dblTemp = vValues[i];
    vValues[i] =  vValues[j];
    vValues[j] =  dblTemp;
  }
}
