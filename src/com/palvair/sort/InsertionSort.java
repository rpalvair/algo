package com.palvair.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] tab = { 101, 115, 30, 63, 47, 20 };
		sort(tab);
		System.out.println(Arrays.toString(tab));
	}

	public static void sort(int[] tab) {
		for (int i = 1; i < tab.length ; i++) {
			int clé = tab[i];
			int j = i;
			while (j > 0 && tab[j - 1] > clé) {
				tab[j] = tab[j - 1];
				j--;
			}
			tab[j] = clé;
		}
	}
}
