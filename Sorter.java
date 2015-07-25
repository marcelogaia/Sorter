public class Sorter {

	// Heap Sort
    private static int[] a;
    private static int n;
    private static int left;
    private static int right;
    private static int largest;
	
	// Merge Sort
	private static int[] numbers;
	private static int[] helper;
	private static int number;
	
	//Counters
	private static int moves;
	private static long comparisons;
  
	public static void main(String args[]){
		int[] list = new int[50000];
		
		for(int i = 0; i < list.length; i++) list[i] = (int) (Math.random() * 100000.0);
		bubbleSort(list);
		System.out.println();
		
		for(int i = 0; i < list.length; i++) list[i] = (int) (Math.random() * 100000.0);
		heapSort(list);
		System.out.println();
		
		for(int i = 0; i < list.length; i++) list[i] = (int) (Math.random() * 100000.0);
		insertionSort(list);
		System.out.println();
		
		for(int i = 0; i < list.length; i++) list[i] = (int) (Math.random() * 100000.0);
		mergeSort(list);
		System.out.println();
		
		for(int i = 0; i < list.length; i++) list[i] = (int) (Math.random() * 100000.0);
		quickSort(list);
		System.out.println();
		
		for(int i = 0; i < list.length; i++) list[i] = (int) (Math.random() * 100000.0);
		selectionSort(list);
		System.out.println();
		
	}

	public static int[] bubbleSort(int[] list){
	    long startTime = System.currentTimeMillis();
		boolean swapped_items = true;
		moves = 0;
		comparisons = 0;
		
		while (swapped_items == true){
			swapped_items = false;
			for(int n = 0; n < list.length - 1; n++){
				comparisons++;
				if ( list[n] > list[n+1]){ 
					int temp = list[n];
					list[n] = list[n+1];
					list[n+1] = temp;
					swapped_items = true;
					moves++;
				}
			}
		}

		System.out.println("Bubble Sorting...");
		System.out.println("\tComparisons: \t" + comparisons);
		System.out.println("\tMoves: \t\t" + moves);
	    long elapsedTime = System.currentTimeMillis() - startTime;
	    System.out.println("\tElapsed Time: \t" + elapsedTime + "ms");
		
		return list;
	}
	
	public static int[] insertionSort(int[] list){
	    long startTime = System.currentTimeMillis();
		moves = 0;
		comparisons = 0;

		for(int i = 0; i < list.length - 1; i++){
			int temp = list[i];
			int j;
			
			for(j = i-1; j >= 0 && temp < list[j]; j++){
				list[j+1] = temp;
				moves++;
			}
			
			temp = list[j+1];
			comparisons += j;
		}
		
		System.out.println("Insertion Sorting...");
		System.out.println("\tComparisons: \t" + comparisons);
		System.out.println("\tMoves: \t\t" + moves);
	    long elapsedTime = System.currentTimeMillis() - startTime;
	    System.out.println("\tElapsed Time: \t" + elapsedTime + "ms");
		return list;
	}
	
	public static int[] selectionSort(int[] list){
	    long startTime = System.currentTimeMillis();
		moves = 0;
		comparisons = 0;
		
		int i,j;
		int iMin;

		for (j = 0; j < list.length-1; j++) {
		    iMin = j;
		    
		    for ( i = j+1; i < list.length; i++) {
		    	comparisons++;
		        if (list[i] < list[iMin]) iMin = i;
		    }
		   
		    if(iMin != j) {
		    	moves++;
		    	int temp = list[j];
		    	list[j] = list[iMin];
		    	list[iMin] = temp;
		    }
		}
		
		System.out.println("Selection Sorting...");
		System.out.println("\tComparisons: \t" + comparisons);
		System.out.println("\tMoves: \t\t" + moves);
	    long elapsedTime = System.currentTimeMillis() - startTime;
	    System.out.println("\tElapsed Time: \t" + elapsedTime + "ms");
		return list;
	}
	
	public static int[] mergeSort(int[] list){
	    long startTime = System.currentTimeMillis();
		moves = 0;
		comparisons = 0;

		numbers = list;
	    number = list.length;
	    helper = new int[number];
	    mergesort(0, number - 1);
		
		System.out.println("Merge Sorting...");
		System.out.println("\tComparisons: \t" + comparisons);
		System.out.println("\tMoves: \t\t" + moves);
	    long elapsedTime = System.currentTimeMillis() - startTime;
	    System.out.println("\tElapsed Time: \t" + elapsedTime + "ms");
		return list;
	}

	private static void mergesort(int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			mergesort(low, middle);
			mergesort(middle + 1, high);
			merge(low, middle, high);
		}
	}

	private static void merge(int low, int middle, int high) {

		for (int i = low; i <= high; i++) helper[i] = numbers[i];

	    int i = low;
	    int j = middle + 1;
	    int k = low;

	    while (i <= middle && j <= high) {
	    	comparisons++;
	    	moves++;
	    	if (helper[i] <= helper[j]) {
	    		numbers[k] = helper[i];
	    		i++;
	    	} else {
	    		numbers[k] = helper[j];
	    		j++;
	    	}
	    	k++;
	    }
	    
	    while (i <= middle) {
	    	moves++;
	    	numbers[k] = helper[i];
	    	k++;
	    	i++;
	    }
	}

	public static int[] heapSort(int[] list){
	    long startTime = System.currentTimeMillis();
		moves = 0;
		comparisons = 0;

        a=list;
        buildheap(a);
        
        for(int i=n;i>0;i--){
            exchange(0, i);
            n=n-1;
            maxheap(a, 0);
        }
		
		System.out.println("Heap Sorting...");
		System.out.println("\tComparisons: \t" + comparisons);
		System.out.println("\tMoves: \t\t" + moves);
	    long elapsedTime = System.currentTimeMillis() - startTime;
	    System.out.println("\tElapsed Time: \t" + elapsedTime + "ms");
		return list;
	}
	
	private static void buildheap(int []a){
        n=a.length-1;
        for(int i=n/2;i>=0;i--){
            maxheap(a,i);
        }
    }
    
    private static void maxheap(int[] a, int i){ 
        left=2*i;
        right=2*i+1;
        comparisons++;
        if(left <= n && a[left] > a[i]){
            largest=left;
        }
        else{
            largest=i;
        }

        comparisons++;
        if(right <= n && a[right] > a[largest]){
            largest=right;
        }
        if(largest!=i){
            exchange(i,largest);
            maxheap(a, largest);
        }
    }
    
    private static void exchange(int i, int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t; 
        moves++;
    }

	public static int[] quickSort(int[] list){
	    long startTime = System.currentTimeMillis();
		moves = 0;
		comparisons = 0;
		
		list = quicksort(list, 0, list.length-1);

		System.out.println("Quick Sorting...");
		System.out.println("\tComparisons: \t" + comparisons);
		System.out.println("\tMoves: \t\t" + moves);
	    long elapsedTime = System.currentTimeMillis() - startTime;
	    System.out.println("\tElapsed Time: \t" + elapsedTime + "ms");
		return list;
	}
	
	private static int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            comparisons++;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  moves++;
	                  i++;
	                  j--;
	            }
	      };
	     
	      return i;
	}
	 
	private static int[] quicksort(int list[], int left, int right) {
	    int index = partition(list, left, right);
	    comparisons++;
	    if (left < index - 1)
	          quicksort(list, left, index - 1);
	    
	    comparisons++;
	    if (index < right)
	          quicksort(list, index, right);
	    
	    return list;  
	}
}
