/**
 * 
 * @author Maximilian Scholz
 *
 */
public class Test {
  
  public static void arrayAusgeben(int[] array){
    
    for(int i = 0 ; i < array.length ; ++i){
      
      System.out.print("[ "+array[i]+" ] ");      
    }   
    System.out.println();
  }
  
  public static void zuf�lligesBef�llen(int [] array){
    
    for(int i = 0 ; i<array.length ; ++i){
      
      array[i] = (int) Math.round((Math.random()*100));
    }
  }
  
  
  public static void main(String[] args) {
    
    int[] array = new int[10];
    
    zuf�lligesBef�llen(array);
    arrayAusgeben(array);
    Insertionsort.insertionSort(array);
    arrayAusgeben(array);
  }
  
}
