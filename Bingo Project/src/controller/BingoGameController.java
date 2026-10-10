package controller;

import java.util.*;

import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.BingoCard;
import view.*;

public class BingoGameController implements ActionListener {
	private Stack<Integer> numberList = new Stack<Integer>();
	private BingoGameFrame gameFrame = new BingoGameFrame();
	private BingoCard card = new BingoCard();

	public BingoGameController() {
		// generate card numbers to add to the stack
		for (int i = 1; i <= 75; i++)
			numberList.add(i);

		// shuffle the stack
		Collections.shuffle(numberList);

		// connect the button to the controller
		gameFrame.getNumberPanel().getNextNumberButton().addActionListener(this);
		addCardNumbers();
	}

	// ActionListener for number button in number panel
	@Override
	public void actionPerformed(ActionEvent event) {
		if (numberList.size() > 0) { // if there are still more numbers to call
			int current = numberList.pop(); // get the current number
			gameFrame.getNumberPanel().getNextNumberButton().setText(Integer.toString(current)); // display current number onto button
			checkBoard(current); // check the board to see if the number exists
		} else {
			// no more numbers to call
			JOptionPane.showMessageDialog(gameFrame, "Game Over");
		}

	}

	// method to add numbers to the JLabels of the card panel
	private void addCardNumbers() {
		for (int row = 0; row < card.getGrid().length; row++) {
			for (int col = 0; col < card.getGrid()[row].length; col++) {
				if (row == 2 && col == 2)
					continue;
				else
					gameFrame.getCardPanel().getNumberJLabel()[row][col]
							.setText(Integer.toString(card.getGrid()[row][col]));
			}
		}
	}

	// method to check if the board has this number
	private void checkBoard(int number) {
		for (int row = 0; row < card.getGrid().length; row++) {
			for (int col = 0; col < card.getGrid()[row].length; col++) {
				if (number == card.getGrid()[row][col]) {
					// stamp the space
					gameFrame.getCardPanel().getNumberJLabel()[row][col].setBackground(Color.GREEN);
					// mark the space as stamped
					card.getGrid()[row][col] = 0;
					if (card.checkForBingo()) {
						JOptionPane.showMessageDialog(gameFrame, "BINGO!");
					}
				}
			}
		}
	}
}
