class MergeSorting{
	public static void main(String[] args){
		int[] arr = {4, 3, 5, 1, 0, 6, 88, 1};
		
		mergeSort(arr, 0, arr.length-1);
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		
	}
	
	public static void mergeSort(int[] arrA, int low, int high){
		//break down arrays into left and right by dividing array into 2
		if (low < high){
			int mid = (low + high) / 2;
			
			//first goes start to mid/2, second does mid+1 to end of array
			mergeSort(arrA, low, mid);
			mergeSort(arrA, mid+1, high);
			merge(arrA, low, mid, high);
		}
	}

	public static void merge(int[] arrA, int low, int mid, int high){
		//sort a sublist and merge back into arrA
		int[] arrB = new int[high+1];
		
		int h= low;
		int i = low;
		int j = mid + 1;
		
		//build array B in sorted fassion  
		while ( (h <= mid) && (j <= high) ){				
			//initial test checks if arrA @ low is less than mid
			if (arrA[h] <= arrA[j])				
				arrB[i++] = arrA[h++];
			else
				arrB[i++] = arrA[j++];
		}
		
		//add in any remianing elements to arrB:
		if (h > mid){
			for (int k = j; k <= high; k++)
				arrB[i++] = arrA[k];
		}else{		
			for(int k = h; k <= mid; k++)
				arrB[i++] = arrA[k];
		}
						
		//coppy B into A (for subarrays only that half of A will be copied)
		for(int k = low; k <= high; k++){
			arrA[k] = arrB[k];
		} 	
	}
}








