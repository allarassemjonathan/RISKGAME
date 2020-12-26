import java.util.*;
public class Risk {

	private int attackerStrength;   
	private int defenderStrength;
	
	/**
	 * 
	 * @param aStrength the strength of the attacker
	 * @param dStrength the strength of the defender
	 * Basically it just initializes these two fields
	 * 
	 */
	public Risk(int aStrength, int dStrength) {
		attackerStrength = aStrength;
		defenderStrength = dStrength;
	}
	
	/**
	 * 
	 * @return a number between 1 and 6
	 */
	public int roll() {
		Random rand = new Random();
		return rand.nextInt(6)+1;
	}
	
	/**
	 * 
	 * @param array the array to order
	 * Basically it takes your array and 
	 * put it in descending order if its 
	 * length is 3 or 2.
	 */
	
	public void sortRolls(int[] array) {
		
		if(array.length == 2 || array.length == 3) {
			
			 for (int i = 0; i < array.length; i++) {
				 
				 for ( int j = i; j < array.length; j++) {
					 
					 /*The goal here is to take the maximum of the series 
					  * and to move it on the left side increasing each time 
					  * i by 1 index. So we will compare successively i
					  * to all the elements of the array through j and 
					  * putting the lower one at the top of the array
					  * after each iteration
					  */
					 
					 if ( array[i] < array [j] ) {
						 
						 int temp = array[i];
						 array[i] = array[j];
						 array[j] = temp;
					 }
				 } } } }

	/**
	 * 
	 * @param attackRoll one roll of the attacker
	 * @param defendRoll one roll of the defender
	 * @return true if the attacker loses and false otherwise
	 */
	
	public boolean attackerLoses(int attackRoll, int defendRoll) {
		return (attackRoll <= defendRoll);
	}
	 /**
	  * this method uses pretty much all the other methods
	  * it rolls, create two arrays to record players rolls
	  * sort it, find who lose and then modify the strengths
	  */
	public void RiskRoll() {
		
		/*we give sizes to the two arrays that will
		 *store the rolls and the counters that will 
		 *count the strength lose. 
		*/
		
		int size = 0, size1 = 0, size2 = 0, comp1 = 0, comp2 = 0;		
		
		if(this.attackerStrength >= 4) {
			size1 = 3;
		}
		else if (this.attackerStrength ==3) {
			size1 = 2;
		}
		else if (this.attackerStrength ==2) {
			size1 = 1;
		}
		if (this.defenderStrength >=2) {
			size2 = 2;
		}
		else if( this.defenderStrength ==1) {
			size2 = 1;
		}
		
		// we create these two arrays
		
		int aarr[] = new int [size1];
		int darr[] = new int [size2];
				
		// we filled these two arrays
		
		for (int i = 0; i < size1; i++) {
			aarr[i] = this.roll();
		}
		
		for (int i = 0; i < size2; i++) {
			darr[i] = this.roll();
		}
		
		// we sort these two arrays and print them
		
		this.sortRolls(aarr);
		this.sortRolls(darr);
		
		System.out.print("attacker rolled...");
        for (int i = 0; i < aarr.length; i ++) {
			System.out.print(aarr[i] + " ");
		}System.out.println();
        
        System.out.print("defender rolled...");
        for (int i = 0; i < darr.length; i ++) {
			System.out.print(darr[i] + " ");
		}System.out.println(); 

		size = (size1 > size2 )?size2:size1;
		
		// we find who lose and who won
		
		for (int i = 0; i < size; i++) {
			
			if (this.attackerLoses(aarr[i], darr[i])) {
				this.attackerStrength-=1;
				comp1+=1;
			}
			else {
				this.defenderStrength-=1;
				comp2+=1;
			}
		}
		System.out.print("the attacker lost " + comp1 + " strenghts\n");
		System.out.print("and the defender lost " + comp2 + " strengths\n");
		
	}
	
	/**
	 * Here we do the match. Basically, 
	 * this method calls the {@link #RiskRoll()} 
	 * until someone wins!
	 */
	
	public void match() {
		
		/*
		 * This loop will stop if one of
		 * the two strength is less or 
		 * equal to 1. THen it will print 
		 * who of the two won the game.
		 */
		
		while(true) {
			this .RiskRoll();
			if(this.attackerStrength <=1 || this.defenderStrength <= 1) {
				break;
			}	
		}
		if(this.attackerStrength <=1) {
			System.out.print("Defender wins!");
		}
		else if(this.defenderStrength <=1) {
			System.out.print("Attacker wins!");
		}
	}
}
