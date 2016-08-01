package com.palvair;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Chiffoumi extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel label;

	JComboBox<Symbol> box;

	Player autoPlayer = new Player();

	Player manualPlayer = new Player();

	JTextField autoScoreValue;

	JTextField manualScoreValue;

	public Chiffoumi() {
		super();
		init();
	}

	private void init() {

		JPanel manualPanel = new JPanel();
		box = new JComboBox<>(Symbol.values());
		manualPanel.add(box);
		JLabel manualScoreLabel = new JLabel("score :");
		manualScoreValue = new JTextField();
		manualScoreValue.setPreferredSize(new Dimension(100, 20));
		manualPanel.add(manualScoreLabel);
		manualPanel.add(manualScoreValue);

		JPanel autoPanel = new JPanel();
		label = new JLabel("en attente...");
		autoPanel.add(label);
		JLabel autoScoreLabel = new JLabel("score :");
		autoScoreValue = new JTextField();
		autoScoreValue.setPreferredSize(new Dimension(100, 20));
		autoPanel.add(autoScoreLabel);
		autoPanel.add(autoScoreValue);

		JPanel buttons = new JPanel();
		JButton newPart = new JButton("Nouvelle partie");
		newPart.addActionListener(new StartListener());
		JButton play = new JButton("Jouer");
		play.addActionListener(new PlayListener());
		buttons.add(newPart);
		buttons.add(play);

		Container container = this.getContentPane();
		container.add(manualPanel, BorderLayout.WEST);
		container.add(autoPanel, BorderLayout.EAST);
		container.add(buttons, BorderLayout.SOUTH);

		this.setSize(600, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Chiffoumi();

	}

	public Symbol getManualSymbol() {
		manualPlayer.setSymbol((Symbol) box.getSelectedItem());
		return (Symbol) box.getSelectedItem();
	}

	public Symbol getAutoSymbol() {
		autoPlayer.setSymbol(Symbol.valueOf(label.getText()));
		return Symbol.valueOf(label.getText());
	}

	public static Symbol getRandomSymbol() {
		Symbol[] symbols = Symbol.values();
		int randomSimple = new Random().nextInt(symbols.length);
		return symbols[randomSimple];
	}

	public void getWinner(Symbol left, Symbol right) {
		Symbol symbol = Symbol.getWinner(left, right);
		// pas de gagnants
		if (symbol == null) {

		} else {
			if (symbol.equals(manualPlayer.getSymbol())) {
				manualPlayer.win();
			} else {
				autoPlayer.win();
			}
			autoScoreValue.setText(String.valueOf(autoPlayer.getScore()));
			manualScoreValue.setText(String.valueOf(manualPlayer.getScore()));
		}

	}

	class StartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			autoPlayer.init();
			manualPlayer.init();
			autoScoreValue.setText(String.valueOf(autoPlayer.getScore()));
			manualScoreValue.setText(String.valueOf(manualPlayer.getScore()));

		}

	}

	class PlayListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText(getRandomSymbol().name());
			getWinner(getManualSymbol(), getAutoSymbol());
		}

	}

}
