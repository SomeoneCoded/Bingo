package view;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BingoGameFrame extends JFrame {
	private NumberPanel numberPanel = new NumberPanel();
	private BingoCardPanel cardPanel;

	public BingoGameFrame() {
		// setting up the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(600, 700); // setting size
		setTitle("Bingo Championships");

		numberPanel.setBounds(0, 0, 600, 100);
		add(numberPanel);

		cardPanel = new BingoCardPanel(); // generate a card
		cardPanel.setBounds(0, 100, 600, 600);
		add(cardPanel);

		setVisible(true); // allows it to be visible
	}

	public NumberPanel getNumberPanel() {
		return numberPanel;
	}

	public void setNumberPanel(NumberPanel numberPanel) {
		this.numberPanel = numberPanel;
	}

	public BingoCardPanel getCardPanel() {
		return cardPanel;
	}

	public void setCardPanel(BingoCardPanel cardPanel) {
		this.cardPanel = cardPanel;
	}

}