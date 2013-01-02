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

		quickSort(b);

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

	private static int binarySearch(int[] data, int num) {

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

	private static void quickSort(int array[]) {
		quickSort(array, 0, array.length - 1);
	}

	private static void quickSort(int array[], int start, int end) {
		int median;
		if (end > start + 1) {
			median = partition(array, start, end);
			quickSort(array, start, median - 1);
			quickSort(array, median + 1, end);
		}// base case
		else {
			if (end == start + 1 && array[start] > array[end]) {
				swap(array, start, end);
			}
		}
	}// quickSort

	private static int partition(int[] array, int start, int end) {
		swap(array, start,
				medianLocation(array, start + 2, end, (start + end) / 2));
		int median = partition(array, start + 1, end, array[start]);
		swap(array, start, median);
		return median;
	}// partition

	private static int partition(int[] array, int start, int end, int pivot) {
		if (start == end) {
			if (array[start] < pivot) {
				return start;
			} else {
				return start - 1;
			}
		} else if (array[start] <= pivot) {
			return partition(array, start + 1, end, pivot);
		} else {
			swap(array, start, end);
			return partition(array, start, end - 1, pivot);
		}
	}

	private static void swap(int array[], int index1, int index2) {
		int temp = array[index1]; // store the first value in a temp
		array[index1] = array[index2]; // copy the value of the second into the
		// first
		array[index2] = temp; // copy the value of the temp into the second
	}

	private static int medianLocation(int[] array, int i, int j, int k) {
		if (array[i] <= array[j]) {
			if (array[j] <= array[k]) {
				return j;
			} else if (array[i] <= array[k]) {
				return k;
			} else {
				return i;
			}
		} else {
			if (array[i] <= array[k]) {
				return i;
			} else if (array[j] <= array[k]) {
				return k;
			} else {
				return j;
			}
		}
	}// medianLocation
}// class
