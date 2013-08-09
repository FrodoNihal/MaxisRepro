/**
 * 
 * @author Maximilian Scholz
 *
 */
public class Test {

	public static void main(String[] args) {		
				
		for (int i = 1 ; i <100 ; ++i){
			
		System.out.println(Quadrieren.iterativ(i));
		}
	System.out.println("---------------------------------------------------------------------------");
		for (int i = 1 ; i <100 ; ++i){
			
		System.out.println(Quadrieren.rekursiv(i));
		}

	}
}
