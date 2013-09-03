/**
 * 
 * @author Maximilian Scholz (umgeschrieben)
 *
 */
public class SelectionSort {

	public static int[] selectionSort(int[] nAr)
	{
		
		for(int i=0; i < nAr.length;i++)
		{
			int nIndex = i;
			int nValue = nAr[i];
			for(int j = i+1; j< nAr.length;j++)
			{
				if(nAr[j] < nValue)
				{
					nValue = nAr[j];
					nIndex = j;					
				}
				else{//not smaller					
				}				
			}
			
			if(nIndex!=i){
									
				int nValue1 = nAr[i];
				nAr[i] = nAr[nIndex];
				nAr[nIndex] = nValue1;
			}						
		}		
		return nAr;
	}
	
}
