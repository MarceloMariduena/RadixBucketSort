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
	    boolean maxLength = false;
	    int temp = -1, placement = 1;
	    
	    /* declare and initialize bucket[]: an array of arrayLists */
	    ArrayList<Integer>[] bucket = new ArrayList[RADIX]; // generic array
	    
	    for (int i = 0; i < bucket.length; i++) {
	    	/* each key holds an arrayList of integers */
	    	bucket[i] = new ArrayList<Integer>();
	    }

	    /* radix sorting */
	    while (!maxLength) {
	    	maxLength = true;
	      
	    	/* split myList into buckets sorting each column of digits */
	    	for (Integer i : myList) {
	    		temp = i / placement; 
	    		bucket[temp % RADIX].add(i); 
	    		if (maxLength && temp > 0) {
	    			maxLength = false;
	    		}
	    	}
	      
	    	/* empty the buckets into myList */
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
