/*Michael Blackburn
  CSCI 221
  Exercise04_25.java*/
  
/*This program returns approximations for pi at 10000, 20000, 30000, 40000, 50000, 60000, 
  70000, 80000, 90000, and 100000.*/
  
public class Exercise04_25{
	public static void main(String[] args){
	double pi = 0.0;
	double piApprox = 0.0;
	for (int j = 0; j < 10; j++){
		for (int k = 10000; k < 100000; k += 10000){
			for (int i = 1; i < k; i += 2){
				piApprox = piApprox + ((1.0 / (2 * i - 1)) - (1.0 / (2.0 * i + 1)));
				pi = 4 * piApprox;
				System.out.println(pi);
				pi = 0;
				piApprox = 0;
			}
			}
		}
	}
}
