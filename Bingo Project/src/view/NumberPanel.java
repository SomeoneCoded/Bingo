package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.*;

import controller.BingoGameController;

import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberPanel extends JPanel{
	// THIS IS THE BINGER NUMBER, ITS UPDATED EVERY TIME THE BUTTON IS CLICKED
	private JButton nextNumberButton = new JButton("0");
	private JLabel instructionLabel = new JLabel("Click the button to pick the next number:");

	public NumberPanel() {
		nextNumberButton.setText("0");
		setBackground(Color.RED);
		
		add(instructionLabel);
		add(nextNumberButton);
		
		
	}

	public JButton getNextNumberButton() {
		return nextNumberButton;
	}

	public void setNextNumberButton(JButton nextNumberButton) {
		this.nextNumberButton = nextNumberButton;
	}

	public JLabel getInstructionLabel() {
		return instructionLabel;
	}

	public void setInstructionLabel(JLabel instruction) {
		this.instructionLabel = instruction;
	}
	
	
	
}