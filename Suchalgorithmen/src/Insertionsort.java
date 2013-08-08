
public class Insertionsort {

	
	public static int[] insertionSort(int[] unsortiertesArray){
		
		int zwischenvariable = 0;
		int dreieckselement = 0;
		
		for(int i = 1 ; i < unsortiertesArray.length ; ++i){
			
			int index2 = 1;			
			zwischenvariable = unsortiertesArray[i];						
			
			if(zwischenvariable<unsortiertesArray[i-1]){
				
				while(i>=index2 && zwischenvariable<unsortiertesArray[i-index2] ){
							
					dreieckselement = unsortiertesArray[i-index2];
					unsortiertesArray[i-index2]= zwischenvariable ;
					unsortiertesArray[i-index2+1]=dreieckselement;
					++index2;
				}			
			}
		}
		
		return unsortiertesArray;
	}	
}
