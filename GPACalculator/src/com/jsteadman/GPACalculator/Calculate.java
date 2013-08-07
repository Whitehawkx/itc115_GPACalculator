package com.jsteadman.GPACalculator;

import java.util.ArrayList;

public class Calculate {

	private ArrayList<Grade> gradeList;

	public Calculate() {
		// constructor to initialize the gradeList array
		gradeList = new ArrayList<Grade>();
	}

	// grade listener
	public void add(Grade g) {
		// add all the grades to the array
		gradeList.add(g);
	}

	// GPA listener
	public double getGPA() {
		double totalGPA = 0;
		double grade = 0;
		double credits = 0;
		double gradePoints = 0;
		double sumCredits = 0;

		// calculations for every grade entered
		for (Grade g : gradeList) {
			grade = g.getGrade();
			credits = g.getCredits();
			gradePoints += grade * credits;
			sumCredits += credits;
		}

		// calculate the users overall GPA
		totalGPA = gradePoints / sumCredits;

		return totalGPA;

	}

	public int getArraySize() {
		int arraySize = gradeList.size();
		return arraySize;
	}

}
