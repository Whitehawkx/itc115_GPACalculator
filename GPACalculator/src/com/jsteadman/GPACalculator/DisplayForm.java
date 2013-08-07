package com.jsteadman.GPACalculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DisplayForm {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblClass;
	private JTextField txtClass;
	private JLabel lblCredits;
	private JTextField txtCredits;
	private JLabel lblGrade;
	private JTextField txtGrade;
	private JButton btnAddClass;
	private JButton btnGetGPA;
	private JLabel lblGPA;
	private JButton btnExit;

	private Calculate GPACalculator;

	public DisplayForm() {
		createFrame();
		GPACalculator = new Calculate();
	}

	private void createFrame() {
		frame = new JFrame();
		frame.setSize(600, 600);
		createPanel();
		frame.add(panel);
		frame.setVisible(true);
	}

	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(6, 2, 5, 5));

		// create all the labels and fields
		lblClass = new JLabel("Enter the class");
		txtClass = new JTextField();
		lblCredits = new JLabel("Enter number of Credits");
		txtCredits = new JTextField();
		lblGrade = new JLabel("Enter your grade point");
		txtGrade = new JTextField();
		btnAddClass = new JButton("Add Class");
		btnAddClass.addActionListener(new AddClass());
		btnGetGPA = new JButton("Calculate GPA");
		btnGetGPA.addActionListener(new GetGPA());
		lblGPA = new JLabel();
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ExitEvent());

		// add labels and fields to panel
		panel.add(lblClass);
		panel.add(txtClass);
		panel.add(lblCredits);
		panel.add(txtCredits);
		panel.add(lblGrade);
		panel.add(txtGrade);
		panel.add(btnAddClass);
		panel.add(btnGetGPA);
		panel.add(lblGPA);
		panel.add(btnExit);

	}

	/*
	 * These take care of the actions that each button will perform
	 */

	private class ExitEvent implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// exit the program
			System.exit(0);
		}

	}

	private class AddClass implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// set every class/grade/credit
			Grade g = new Grade();
			g.setClassName(txtClass.getText());
			g.setCredits(Double.parseDouble(txtCredits.getText()));
			g.setGrade(Double.parseDouble(txtGrade.getText()));
			GPACalculator.add(g);
			// after each grade is entered, reset the fields to be blank
			txtClass.setText("");
			txtCredits.setText("");
			txtGrade.setText("");
		}

	}

	private class GetGPA implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			double GPA = 0;
			int array = 0;

			// prevent crashing if credits or grade are null
			if (txtCredits.getText() != ("") && txtGrade.getText() != ("")) {
				// return the users overall GPA from the Calculate class
				GPA = GPACalculator.getGPA();
			}

			array = GPACalculator.getArraySize();
			// display the size of the array which should be the
			// number of classes this is being calculated for and
			// display the total GPA to two decimal places
			lblGPA.setText("For " + array + " classes, your GPA is "
					+ (new DecimalFormat("##.##").format(GPA)));
		}

	}
}
