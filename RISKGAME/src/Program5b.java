import java.util.Scanner;

public class Program5b {
	
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the attacker strength");
		int attackstr = scan.nextInt();
		
		/*
		 *  While the strength is less
		 *  or equal to 1 you will be 
		 *  trapped in this loop
		 */
		while(attackstr <= 1) {
			System.out.println("Enter the attacker strength");
			System.out.println("Remember it is a integer greater than 1");
			attackstr = scan.nextInt();
		}
		System.out.println("Enter the defender strength");
		int defendstr = scan.nextInt();
		
		/*
		 * While the strength is less 
		 * or equal to 1 you will be 
		 * trapped in this loop
		 */
		while(defendstr <= 1) {
			System.out.println("Enter the defender strength");
			System.out.println("Remember it is a integer greater than 1");
			defendstr = scan.nextInt();
		}
		/*
		 * Let's play now! We build start the game by
		 * building a constructor and calling
		 * the member method match()		 */
		Risk risk = new Risk(attackstr,defendstr);
		risk.match();
	}
}
