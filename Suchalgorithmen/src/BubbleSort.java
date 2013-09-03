
/**
* @author Chris-L. Junge
* 
* Maximilian Scholz hats umgeschrieben.
*/
public class BubbleSort {
	
  public static int[] bubbleSort(int[] vValues){
	  
    for(int i = vValues.length; i > 1; i = i - 1)
    {
      for(int j = 0; j < i - 1; j = j + 1)
      {
        if(vValues[j] > vValues[j + 1])
        {
          
          int dblTemp = vValues[j];
          vValues[j] =  vValues[j+1];
          vValues[j+1] =  dblTemp; 
        }
        else { }
      }
    }
    return vValues;
  }
}
