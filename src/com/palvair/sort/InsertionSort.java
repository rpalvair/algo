package com.palvair.sort;

import java.util.Arrays;

public class InsertionSort {
	
	public static void main(String[] args) {
		int[] tab = {101,115,30,63,47,20};
		for(int i =0;i<tab.length; i++) {
			int min = i;
			//search min
			for(int j = i+1;j < tab.length;j++) {
				if(tab[j] < tab[min]) {
					min = j;
				}
			}
			if(min != i) {
				int temp = tab[i];
				tab[i] = tab[min];
				tab[min] = temp;
			}
			System.out.println("tab = "+Arrays.toString(tab));
		}
	}

}
