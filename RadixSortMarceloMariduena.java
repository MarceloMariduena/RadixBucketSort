import java.util.*;

public class RadixSortMarceloMariduena {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, max;
		Integer[] list;
		
		System.out.print("Enter n and max value: ");
		n = input.nextInt(); //number of positive integers
		max = input.nextInt(); //highest integer that can be generated
		
		/* Fill an array with n integers of numbers between [0, max) */
		list = new Integer[n]; 
		fillWithRandom(list, 0, max);
		
		/* Display original array */
		System.out.println("Original");
		System.out.println(Arrays.toString(list));
		
		/* Sort array using Radix Bucket Sort algorithm */
	    radixSort(list);
		
		/* Display sorted array */
		System.out.println("After Radix Sort");
		System.out.println(Arrays.toString(list));
		
		input.close();
	}
	
	/** Fills Integer array with random n integers **/
	public static void fillWithRandom(Integer[] myList, int min, int max) {
		int range = max - min;
		    
		for(int i = 0; i < myList.length; i++)
			myList[i] = (int)(Math.random() * range) + min;
	}
	
	/** Radix bucket sort method **/
	public static void radixSort(Integer[] myList) {
		final int RADIX = 10;
	    
	    // declare and initialize bucket[]
	    ArrayList<Integer>[] bucket = new ArrayList[RADIX];
	    
	    for (int i = 0; i < bucket.length; i++) {
	    	bucket[i] = new ArrayList<Integer>();
	    }

	    /* sort */
	    boolean maxLength = false;
	    int tmp = -1, placement = 1;
	    while (!maxLength) {
	    	maxLength = true;
	      
	    	/* split myList between lists */
	    	for (Integer i : myList) {
	    		tmp = i / placement;
	    		bucket[tmp % RADIX].add(i);
	    		if (maxLength && tmp > 0) {
	    			maxLength = false;
	    		}
	    	}
	      
	    	/* empty the lists into myList */
	    	int a = 0;
	    	for (int b = 0; b < RADIX; b++) {
	    		for (Integer i : bucket[b]) {
	    			myList[a++] = i;
	    		}
	    		bucket[b].clear();
	    	}
	      
	    	placement *= RADIX; // move to the next digit
	    }
	}
}
