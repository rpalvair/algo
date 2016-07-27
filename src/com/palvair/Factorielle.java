package com.palvair;

public class Factorielle {

	public static void main(String[] args) {
		int result = factorielle(8);
		System.out.println("result = " + result);
	}

	public static int factorielle(int n) {
		if (n > 1) {
			return n * factorielle(n - 1);
		}
		return 1;
	}
}
