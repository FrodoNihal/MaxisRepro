/**
* @author Chris-L. Junge
* Umgeschrieben: Maximilian Scholz
*/
public class SimpleSort {
	
  public static int[] simpleSort(int[] vValues){
	  
    for (int i = 0; i < vValues.length; i++) {    	
      for (int j = i + 1; j < vValues.length; j++) {
    	  
        if(vValues[i] > vValues[j]){
        	          
          int dblTemp = vValues[i];
          vValues[i] =  vValues[j];
          vValues[j] =  dblTemp;          
        }
      }
    }
    
    return vValues;
  }
}
