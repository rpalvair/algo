package com.palvair.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] tab = {101,115,30,63,47,20};
		for(int i = tab.length;i > 1; i--) {
			for(int j=0;j < (i-1);j++) {
				if(tab[j+1] < tab[j]) {
					int temp = tab[j+1];
					tab[j+1] = tab[j];
					tab[j] = temp;
				}
			}
			System.out.println("tab = "+Arrays.toString(tab));
		}
	}
}
