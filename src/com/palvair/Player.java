package com.palvair;

public class Player {

	private int score;
	
	private Symbol symbol;
	
	public void init() {
		this.score = 0;
	}
	
	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}
	
	public Symbol getSymbol() {
		return this.symbol;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void win() {
		score++;
	}
}
