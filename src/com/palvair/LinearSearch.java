package com.palvair;

public class LinearSearch {

	public static void main(String[] args) {
		int[] tab = { 101, 115, 30, 63, 47, 20 };
		int el = 20;
		boolean isPresent = isPresent(tab, el);
		System.out.println("isPresent = " + isPresent);
		
		boolean isPresentRecursive = isPresentRecursive(tab, el);
		System.out.println("isPresentRecursive = " + isPresentRecursive);
	}

	public static int getIndice(int[] tab, int el) {
		for (int i = 0; i < tab.length; i++) {
			//invariant de boucle : si el est présent dans tab, il est forcément présent dans tab[i+1]
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
	
	public static int getIndiceRecursive(int[] tab , int i, int el) {
		//cas de base
		if(i >= tab.length) {
			return -1;
		} else {
			if(tab[i] == el) {
				return i;
			} else {
				return getIndiceRecursive(tab, i+1, el);
			}
		}
	}
	
	public static boolean isPresentRecursive(int[] tab, int el) {
		int start = 0;
		if(getIndiceRecursive(tab, start, el) != -1) {
			return true;
		}
		return false;
	}
	

}
