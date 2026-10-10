package model;

import java.util.*;

// BingoCard maker
public class BingoCard {
	private int[][] grid = new int[5][5];

	public BingoCard() {
		createCard();
	}

	public int[][] getGrid() {
		return grid;
	}

	public void setGrid(int[][] grid) {
		this.grid = grid;
	}

	@Override
	public String toString() {
		return "BingoCard [grid=" + Arrays.toString(grid) + "]";
	}

	// create a bingo card
	private void createCard() {
		ArrayList<Integer> usedNumbers = new ArrayList<Integer>();
		for (int col = 0; col < 5; col++) {
			for (int row = 0; row < 5; row++) {
				if (col == 2 && row == 2)
					continue; // zeros will be seen as 'marked spaces'
				else {
					// each column can only have a specific range of numbers (1-15, 16-30, 31-45, 46-60, 61-75)
					int max = (col + 1) * 15;
					int min = max - 14;
					while (true) {
						// random number generator
						int number = (min + (int) (Math.random() * (max - min)));
						if (!usedNumbers.contains(number)) { // avoid repetitions
							grid[row][col] = number;
							usedNumbers.add(number);
							break;
						} else
							continue;
					}
				}

			}
		}
	}

	// method to check for bingo
	public boolean checkForBingo() {
		// check each row
		for (int row = 0; row < 5; row++) {
			boolean isBingo = true;
			for (int col = 0; col < 5; col++) {
				if (grid[row][col] != 0)
					isBingo = false;
			}
			if (isBingo)
				return true;
		}

		// check each column
		for (int col = 0; col < 5; col++) {
			boolean isBingo = true;
			for (int row = 0; row < 5; row++) {
				if (grid[row][col] != 0)
					isBingo = false;
			}
			if (isBingo)
				return true;
		}

		// check each left diagonal
		boolean isBingo = true;
		for (int row = 0, col = 0; row < 5; row++, col++) {
			if (grid[row][col] != 0) {
				isBingo = false;
				break;
			}
		}
		if (isBingo)
			return true;

		// check right diagonal
		isBingo = true;
		for (int row = 4, col = 0; col < 5; row--, col++) {
			if (grid[row][col] != 0) {
				isBingo = false;
				break;
			}
		}
		if (isBingo)
			return true;

		// Sometimes you may also consider patterns like 4 corners, T-shape, all shaded, etc.
		
		
		// no cases of bingo
		return false;

	}
}
