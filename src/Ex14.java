import sun.swing.icon.SortArrowIcon;

/**
 * Binary search example.
 * 
 * @author (Raskanskyz)
 * @version (1.0)
 */

public class Ex14 {
	private static int startFlag;
	private static int endFlag;

	public static int count(int[] a, int x) {
		int lowerBound = 0;
		int upperBound = a.length - 1;
		int middle;

		while (lowerBound <= upperBound) {

			middle = ((lowerBound + upperBound) / 2);
			if (x > a[middle]) {
				lowerBound = middle + 1;
			}// if
			else {
				upperBound = middle - 1;
			}// else

		}// while
		startFlag = lowerBound;// <-----found Lower Bound
		upperBound = a.length - 1;

		while (lowerBound <= upperBound) {

			middle = ((lowerBound + upperBound) / 2);
			if (x == a[middle]) {
				lowerBound = middle + 1;
			}// if
			else {
				upperBound = middle - 1;
			}// else

		}
		endFlag = lowerBound;

		return endFlag - startFlag;
	}// count method

	public static int f(int[] a, int[] b, int[] c) {
		int t = 0;
		int k = 0;

		quickSort(b);// <-----------implement quickSort

		for (int i = 0; i < a.length; i++) {
			if (binarySearch(b, a[i]) == -1) {
				c[t] = a[i];
				if (c[t] > k) {
					k = c[t];

				}// inner if
				t++;
			}// outer if
		}// for
		return k;
	}// static int f

	// my private methods
	private static void sortArray(int[] arrayToSort) {
		int newest, current, newItem;
		boolean seeking;
		for (newest = 1; newest < arrayToSort.length; newest++) {
			seeking = true;
			current = newest;
			newItem = arrayToSort[newest];
			while (seeking) {
				if (arrayToSort[current - 1] < newItem) {
					arrayToSort[current] = arrayToSort[current - 1];
					current--;
					seeking = (current > 0);
				}// if
				else {
					seeking = false;
				}// else
			}// while seeking
			arrayToSort[current] = newItem;
		}// forloop
	}// sortArray

	private static int binarySearch(int[] data, int num) {
		// int index = 0, lower = 0, upper = (arrayToSearch.length - 1);
		// while (lower <= upper && arrayToSearch[index] != key) {
		// index = ((lower + upper) / 2);
		// if (key < arrayToSearch[index]) {
		// upper = index - 1;
		// }// if
		// else {
		// lower = index + 1;
		// }// else
		// }// while
		// if (arrayToSearch[index] == key) {
		// return 0;
		// } else {
		// return arrayToSearch[index];
		//

		int middle, lower = 0, upper = (data.length - 1);
		do {
			middle = ((lower + upper) / 2);
			if (num < data[middle])
				upper = middle - 1;
			else
				lower = middle + 1;
		} while ((data[middle] != num) && (lower <= upper));
		if (data[middle] == num)
			return num;
		else
			return -1;

	}// binarySearch

	private static void quickSort(int array[])
	// pre: array is full, all elements are non-null integers
	// post: the array is sorted in ascending order
	{
		quickSort(array, 0, array.length - 1); // quicksort all the elements in
												// the array
	}

	private static void quickSort(int array[], int start, int end) {
		int i = start; // index of left-to-right scan
		int k = end; // index of right-to-left scan

		if (end - start >= 1) // check that there are at least two elements to
								// sort
		{
			int pivot = array[start]; // set the pivot as the first element in
										// the partition

			while (k > i) // while the scan indices from left and right have not
							// met,
			{
				while (array[i] <= pivot && i <= end && k > i)
					// from the left, look for the first
					i++; // element greater than the pivot
				while (array[k] > pivot && k >= start && k >= i)
					// from the right, look for the first
					k--; // element not greater than the pivot
				if (k > i) // if the left seekindex is still smaller than
					swap(array, i, k); // the right index, swap the
										// corresponding elements
			}
			swap(array, start, k); // after the indices have crossed, swap the
									// last element in
									// the left partition with the pivot
			quickSort(array, start, k - 1); // quicksort the left partition
			quickSort(array, k + 1, end); // quicksort the right partition
		} else // if there is only one element in the partition, do not do any
				// sorting
		{
			return; // the array is sorted, so exit
		}
	}

	private static void swap(int array[], int index1, int index2)
	// pre: array is full and index1, index2 < array.length
	// post: the values at indices 1 and 2 have been swapped
	{
		int temp = array[index1]; // store the first value in a temp
		array[index1] = array[index2]; // copy the value of the second into the
										// first
		array[index2] = temp; // copy the value of the temp into the second
	}



	
	
	
	
	
	public static void main(String[] args) {
		
		int[] a = { 1, 2, 8, 3, 4, 5 };
		int[] b = { 2, 6, 7, 2, 55, 4 };
		int[] c = new int[a.length];

		f(a, b, c);

		System.out
				.println("highest value in a that is not in b: " + f(a, b, c));
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);

		}
		System.out.println("**************");
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);

		}

	}
}// class
