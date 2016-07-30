package com.palvair;

public class LinearSearch {

	public static void main(String[] args) {
		int[] tab = { 101, 115, 30, 63, 47, 20 };
		boolean isPresent = isPresent(tab, 47);
		System.out.println("isPresent = " + isPresent);
	}

	public static int getIndice(int[] tab, int el) {
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == el) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean isPresent(int[] tab, int el) {
		if(getIndice(tab, el) != -1) {
			return true;
		}
		return false;
	}
}
