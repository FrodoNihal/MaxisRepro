
public class SelectionSort {

	public static int[] SelectionSort(int[] nAr)
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
			
			nAr = nIndex!=i? Switch(nAr,i,nIndex):nAr;
		}
		
		return nAr;
	}

	private static int[] Switch(int[] nAr, int i, int j) {
		//System.out.println(i+" <-> "+j);
		int nValue1 = nAr[i];
		nAr[i] = nAr[j];
		nAr[j] = nValue1;		
		return nAr;
	}
	
}
