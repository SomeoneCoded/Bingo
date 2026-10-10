package view;

import javax.swing.*;
import java.awt.*;
import model.BingoCard;

public class BingoCardPanel extends JPanel {
	private JLabel[][] numberJLabel = new JLabel[5][5];
	private JLabel cardLabel = new JLabel(new ImageIcon("image/bingoCard.png"));

	// construct the bingo card
	public BingoCardPanel() {
		setLayout(null);
		cardLabel.setLayout(null);
		addNumberLabels();

		cardLabel.setBounds(0, 0, 600, 600);
		add(cardLabel);
	}

	public JLabel getCardLabel() {
		return cardLabel;
	}

	public void setCardLabel(JLabel cardLabel) {
		this.cardLabel = cardLabel;
	}

	public JLabel[][] getNumberJLabel() {
		return numberJLabel;
	}

	public void setNumberJLabel(JLabel[][] numberJLabel) {
		this.numberJLabel = numberJLabel;
	}

	// set the numbers of each square
	private void addNumberLabels() {
		for (int row = 0; row < numberJLabel.length; row++) {
			for (int col = 0; col < numberJLabel[row].length; col++) {
				numberJLabel[row][col] = new JLabel();
				numberJLabel[row][col].setFont(new Font("Serif", Font.BOLD, 36));
				numberJLabel[row][col].setOpaque(true);
				numberJLabel[row][col].setBackground(Color.WHITE);

				if (row == 2 && col == 2) {// free space
					numberJLabel[row][col].setBackground(Color.GREEN);
					numberJLabel[row][col].setText(" X ");
					numberJLabel[row][col].setFont(new Font("Serif", Font.BOLD, 36));
				}

				numberJLabel[row][col].setBounds(85 + col * 100, 75 + row * 100, 50, 50);
				cardLabel.add(numberJLabel[row][col]);
			}
		}

	}

}
