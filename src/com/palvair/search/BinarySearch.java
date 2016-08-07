package com.palvair.search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] tab = { 20, 30, 47, 63, 101, 115 };
		int result = binarySearch(tab, 0, tab.length, 30);
		System.out.println("result = " + result);
	}

	public static int binarySearch(int[] tab, int p, int r, int el) {
		// on a dépassé la capacité du tableau => tableau vide
		if (p > r) {
			return -1;
		}
		int middle = (p + r) / 2;
		if (tab[middle] == el)
			return middle;
		else {
			if (tab[middle] < el)
				return binarySearch(tab, middle + 1, r, el);
			if (tab[middle] > el)
				return binarySearch(tab, p, middle - 1, el);
		}

		return -1;
	}
}
