/**
 * This file contains the SimpleList class.
 * 
 * @author Carter Pote
 * @class_id 135
 * @assignment 1
 * 
 */

package cse360Assign2;

/**
 * Class that creates an integer array of ARRAY_SIZE entries, and performs basic
 * list operations.
 * 
 * @author Carter Pote
 * @version 1.0
 */
public class SimpleList {

	// Variables
	private int[] list;
	private int count;

	final int ARRAY_SIZE = 10;

	// Methods
	/**
	 * Constructor. Initializes array of 10 integers and count to 0.
	 * 
	 */
	public SimpleList() {
		list = new int[ARRAY_SIZE];
		count = 0;
	}

	/**
	 * Adds an integer to index 0 of the list, shifts all other elements to the left
	 * by one. Element in index 9 is overwritten.
	 * 
	 * @param x the integer to be added to the list.
	 */
	public void add(int x) {

		for (int i = ARRAY_SIZE - 2; i >= 0; i--) {
			list[i + 1] = list[i];
		}

		list[0] = x;

		// Adjust count with operations instead of recalculating.
		if (count < ARRAY_SIZE) {
			count++;
		}
	}

	/**
	 * Removes all instances of integer x from the list, shifting all following
	 * elements to the left to fill in the void.
	 * 
	 * @param x the number to be removed from the list.
	 */
	public void remove(int x) {
		for (int i = 0; i < ARRAY_SIZE; i++) {

			if (list[i] == x) {

				for (int j = i; j < ARRAY_SIZE - 1; j++) {

					list[j] = list[j + 1];

				}

				// Set last value in array to 0 to clear data.
				list[ARRAY_SIZE - 1] = 0;

				// Adjust count during operations instead of recalculating.
				count--;

				// Step back to check new value in this index.
				i = i - 1;

			}
		}
	}

	/**
	 * Returns the amount of elements in the list.
	 * 
	 * @return number of elements in list.
	 */
	public int count() {
		return count;
	}

	/**
	 * Returns string representation of elements in the list, seperated by spaces.
	 * 
	 * @return String representing elements.
	 */
	public String toString() {
		String outString = "";

		// String constructor
		for (int i = 0; i <= count - 1; i++) {
			if (i < count - 1) {
				outString += list[i];
				outString += " ";
			} else {
				// No space after last element
				outString += list[i];
			}
		}

		return outString;
	}

	/**
	 * Searches for the first appearance of input integer in the list, and returns
	 * its index. If not found, returns -1.
	 * 
	 * @param x the integer being searched for.
	 * @return the index of the sought value in the array.
	 */
	public int search(int x) {
		int index = -1;

		// Counts backwards from list.count to find first element efficiently.
		for (int i = count - 1; i >= 0; i--) {
			if (list[i] == x) {
				index = i;
			}
		}

		return index;
	}

}
