package com.palvair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Symbol {
	PIERRE(0), FEUILLE(1), CISEAUX(2);

	public static List<String> names = new ArrayList<>();

	private int strength;

	public static Map<BiGram, Symbol> map;

	Symbol(int strength) {
		this.strength = strength;
	}

	static {
		map = new HashMap<>();
		map.put(new BiGram(Symbol.PIERRE, Symbol.FEUILLE), Symbol.FEUILLE);
		map.put(new BiGram(Symbol.PIERRE, Symbol.CISEAUX), Symbol.PIERRE);
		map.put(new BiGram(Symbol.FEUILLE, Symbol.CISEAUX), Symbol.CISEAUX);
	}

	public boolean isGreaterThan(Symbol symbol) {
		if (this.strength > symbol.strength) {
			return true;
		}
		return false;
	}

	public static Symbol getWinner(Symbol left, Symbol right) {
		if (left == right) {
			return null;
		}
		if (map.containsKey(new BiGram(left, right))) {
			return map.get(new BiGram(left, right));
		} else if (map.containsKey(new BiGram(right, left))) {
			return map.get(new BiGram(right, left));
		}
		throw new RuntimeException("BiGram not recognized");

	}

	public static class BiGram {
		private final Symbol left;
		private final Symbol right;

		public Symbol getLeft() {
			return this.left;
		}

		public Symbol getRight() {
			return this.right;
		}

		public BiGram(Symbol left, Symbol right) {
			this.left = left;
			this.right = right;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((left == null) ? 0 : left.hashCode());
			result = prime * result + ((right == null) ? 0 : right.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BiGram other = (BiGram) obj;
			if (left != other.left)
				return false;
			if (right != other.right)
				return false;
			return true;
		}
	}
}
