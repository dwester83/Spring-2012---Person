/*
Author: Daniel Wester

Date: 04.19.12

Course: 2243-01, Spring 2012

Assignment: PGM4

Description: This program will test the Person class, it will return different strings if the names match,
if they have a birthday, and if they have the same first, middle, or last name.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestingPerson extends JFrame {
	
	JTextArea descriptionJTA;
	JLabel firstNameJL, middleNameJL, lastNameJL, ageJL, spaceJL, person1JL, person2JL;
	JTextField firstNameJTF1, middleNameJTF1, lastNameJTF1, ageJTF1, firstNameJTF2, middleNameJTF2, lastNameJTF2, ageJTF2, outputJTF;
	JButton checkJB1, checkJB2, birthdayJB1, birthdayJB2, exitJB;
	JPanel northPanel, northBottomPanel, centerPanel, southPanel, southTopCenterPanel, southTopRightPanel, southTopPanel;
	
	Person p1 = new Person();
	Person p2 = new Person();
	
	public TestingPerson() {
		
		//Description of the Program
		descriptionJTA = new JTextArea("Welcome,\nThis is a simple program to test the person class.\n It can also compare two different people.");
		descriptionJTA.setLineWrap(true);
		descriptionJTA.setEditable(false);
		descriptionJTA.setBackground(null);
		
		//Input setup
		spaceJL = new JLabel("", SwingConstants.CENTER);
		person1JL = new JLabel("Person 1", SwingConstants.CENTER);
		person2JL = new JLabel("Person 2", SwingConstants.CENTER);
		firstNameJL = new JLabel("First name: ", SwingConstants.RIGHT);
		middleNameJL = new JLabel("Middle name: ", SwingConstants.RIGHT);
		lastNameJL = new JLabel("Last name: ", SwingConstants.RIGHT);
		ageJL = new JLabel("Age: ", SwingConstants.RIGHT);
		firstNameJTF1 = new JTextField("", SwingConstants.LEFT);
		firstNameJTF1.addFocusListener(new FocusJTFHandler());
		firstNameJTF1.addActionListener(new TestingButtonHandler1());
		middleNameJTF1 = new JTextField("", SwingConstants.LEFT);
		middleNameJTF1.addFocusListener(new FocusJTFHandler());
		middleNameJTF1.addActionListener(new TestingButtonHandler1());
		lastNameJTF1 = new JTextField("", SwingConstants.LEFT);
		lastNameJTF1.addFocusListener(new FocusJTFHandler());
		lastNameJTF1.addActionListener(new TestingButtonHandler1());
		ageJTF1 = new JTextField("", SwingConstants.LEFT);
		ageJTF1.addFocusListener(new FocusJTFHandler());
		ageJTF1.addActionListener(new TestingButtonHandler1());
		firstNameJTF2 = new JTextField("", SwingConstants.LEFT);
		firstNameJTF2.addFocusListener(new FocusJTFHandler());
		firstNameJTF2.addActionListener(new TestingButtonHandler2());
		middleNameJTF2 = new JTextField("", SwingConstants.LEFT);
		middleNameJTF2.addFocusListener(new FocusJTFHandler());
		middleNameJTF2.addActionListener(new TestingButtonHandler2());
		lastNameJTF2 = new JTextField("", SwingConstants.LEFT);
		lastNameJTF2.addFocusListener(new FocusJTFHandler());
		lastNameJTF2.addActionListener(new TestingButtonHandler2());
		ageJTF2 = new JTextField("", SwingConstants.LEFT);
		ageJTF2.addFocusListener(new FocusJTFHandler());
		ageJTF2.addActionListener(new TestingButtonHandler2());
		
		//Output setup
		outputJTF = new JTextField("", SwingConstants.CENTER);
		outputJTF.setEditable(false);
		
		//Buttons setup
		checkJB1 = new JButton ("Person 1");
		checkJB1.addActionListener(new TestingButtonHandler1());
		checkJB2 = new JButton ("Person 2");
		checkJB2.addActionListener(new TestingButtonHandler2());
		birthdayJB1 = new JButton ("Birthday 1");
		birthdayJB1.addActionListener(new BirthdayButtonHandler1());
		birthdayJB1.setEnabled(false);
		birthdayJB2 = new JButton ("Birthday 2");
		birthdayJB2.addActionListener(new BirthdayButtonHandler2());	
		birthdayJB2.setEnabled(false);
		exitJB = new JButton ("Exit");
		exitJB.addActionListener(new ExitButtonHandler());
		
		//Building the GUI
		Container pane = getContentPane();
		northPanel = new JPanel(new GridLayout (2,1));
		northBottomPanel = new JPanel(new GridLayout (1,3));
		centerPanel = new JPanel(new GridLayout (4,3));
		southPanel = new JPanel(new GridLayout (2,1));
		southTopPanel = new JPanel(new GridLayout (1,3));
		southTopCenterPanel = new JPanel(new GridLayout (1,2));
		southTopRightPanel = new JPanel(new GridLayout (1,2));
		northBottomPanel.add(spaceJL);
		northBottomPanel.add(person1JL);
		northBottomPanel.add(person2JL);
		northPanel.add(descriptionJTA);
		northPanel.add(northBottomPanel);
		centerPanel.add(firstNameJL);
		centerPanel.add(firstNameJTF1);
		centerPanel.add(firstNameJTF2);
		centerPanel.add(middleNameJL);
		centerPanel.add(middleNameJTF1);
		centerPanel.add(middleNameJTF2);
		centerPanel.add(lastNameJL);
		centerPanel.add(lastNameJTF1);
		centerPanel.add(lastNameJTF2);
		centerPanel.add(ageJL);
		centerPanel.add(ageJTF1);
		centerPanel.add(ageJTF2);
		
		southTopCenterPanel.add(checkJB1);
		southTopCenterPanel.add(birthdayJB1);
		southTopRightPanel.add(checkJB2);
		southTopRightPanel.add(birthdayJB2);
		southTopPanel.add(exitJB);
		southTopPanel.add(southTopCenterPanel);
		southTopPanel.add(southTopRightPanel);
		southPanel.add(outputJTF);
		southPanel.add(southTopPanel);
		
		//Display the GUI
		setLayout(new BorderLayout());
		setSize(600,300);
		setTitle("Person Class Tester");
		add(northPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private class TestingButtonHandler1 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String firstName, middleName, lastName, output = "";
			int age;
			
			try {
				firstName = firstNameJTF1.getText();
				middleName = middleNameJTF1.getText();
				lastName = lastNameJTF1.getText();
				age = Integer.parseInt(ageJTF1.getText());
				p1.setPerson(firstName, middleName, lastName, age);
			} catch (NumberFormatException nfe) {
				outputJTF.setForeground(Color.red);
				outputJTF.setText("" + nfe.getMessage());
				birthdayJB1.setEnabled(false);
				return;
			}
			
			person1JL.setText(firstName + " " + middleName + " " + lastName);
			birthdayJB1.setEnabled(true);
			outputJTF.setForeground(Color.black);
			
			if (p1.equals(p2)) {
				outputJTF.setText("Both people have the same name.");
				return;
			}
			
			output = p1.toString();
			
			if (p2.checkFirstName(firstName) | p2.checkMiddleName(middleName) | p2.checkLastName(lastName)) {
				output = (output + " Both people share the same");
				if (p2.checkFirstName(firstName))
					output = (output + ", first");
				if (p2.checkMiddleName(middleName))
					output = (output + ", middle");
				if (p2.checkLastName(lastName))
					output = (output + ", last");
				output = (output + " name.");
				outputJTF.setText(output);
				return;
			}
			
			
			
			outputJTF.setText(output);
			
		}
	}

	private class TestingButtonHandler2 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String firstName, middleName, lastName, output = "";
			int age;
			
			try {
				firstName = firstNameJTF2.getText();
				middleName = middleNameJTF2.getText();
				lastName = lastNameJTF2.getText();
				age = Integer.parseInt(ageJTF2.getText());
				p2.setPerson(firstName, middleName, lastName, age);
			} catch (NumberFormatException nfe) {
				outputJTF.setForeground(Color.red);
				outputJTF.setText("" + nfe.getMessage());
				birthdayJB2.setEnabled(false);
				return;
			}
			
			person2JL.setText(firstName + " " + middleName + " " + lastName);
			birthdayJB2.setEnabled(true);
			outputJTF.setForeground(Color.black);
			
			if (p2.equals(p1)) {
				outputJTF.setText("Both people have the same name.");
				return;
			}
			
			output = p2.toString();
			
			if (p1.checkFirstName(firstName) | p1.checkMiddleName(middleName) | p1.checkLastName(lastName)) {
				output = (output + " Both people share the same");
				if (p1.checkFirstName(firstName))
					output = (output + ", first");
				if (p1.checkMiddleName(middleName))
					output = (output + ", middle");
				if (p1.checkLastName(lastName))
					output = (output + ", last");
				output = (output + " name.");
				outputJTF.setText(output);
				return;
			}
			
			outputJTF.setText(output);
			
		}
	}
	
	private class BirthdayButtonHandler1 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String output;
			int age;
			
			age = p1.happyBirthday();
			output = String.format("Happy Birthday! This person is now " + age + " years old.");
			outputJTF.setForeground(Color.black);
			outputJTF.setText(output);
			output = String.format("" + p1.getAge());
			ageJTF1.setText(output);
			
		}
	}
	
	private class BirthdayButtonHandler2 implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String output;
			int age;
			
			age = p2.happyBirthday();
			output = String.format("Happy Birthday! This person is now " + age + " years old.");
			outputJTF.setForeground(Color.black);
			outputJTF.setText(output);
			output = String.format("" + p2.getAge());
			ageJTF2.setText(output);
			
		}
	}
	
	private class FocusJTFHandler extends FocusAdapter {
		public void focusGained(FocusEvent fe) {
			JTextField text = (JTextField) fe.getSource();
			text.selectAll();
		} public void focusLost(FocusEvent fe) {
		
		}
	}
	
	//Exit button
	private class ExitButtonHandler implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			int temp = JOptionPane.showConfirmDialog(null,"Thank you for using this program.\n\nAre you sure you want to exit?","Person Class Test",JOptionPane.YES_NO_OPTION);
			if (temp == 0)
				System.exit(0);
		}
	}
	
	//Main
	public static void main (String [] args) {
		new TestingPerson();
	}
}