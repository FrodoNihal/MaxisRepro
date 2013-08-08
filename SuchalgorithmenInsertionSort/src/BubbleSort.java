
/**
* @author Chris-L. Junge
*/
public class BubbleSort {
  public static void bubbleSort(double[] vValues)
  {
    for(int i = vValues.length; i > 1; i = i - 1)
    {
      for(int j = 0; j < i - 1; j = j + 1)
      {
        if(vValues[j] > vValues[j + 1])
        {
          swap(vValues, j, j + 1);
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
