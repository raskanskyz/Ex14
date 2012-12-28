/**
 * Write a description of class Ex14 here.
 * 
 * @author (your name)
 * @version (a version number or a date)
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

}
