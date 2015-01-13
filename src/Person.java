/*
 * Author: Daniel Wester
 *
 * Date: 04/16/2012
 *
 * Course: Comp 2243-01, Spring 2012
 *
 * Assignment: PGM4
 *
 * Description: This class will define a person with a first, middle, last name, and age.
 * It will also allow a person to have a birthday. In addition it will check for invalid input.
 */

/**
 * Represents a person with a first, middle, last name, and age.
 *
 * @author Daniel Wester
 * @version 04/16/2012
 */

public class Person {
	
	private String firstName, fName, middleName, mName, lastName, lName;
	private int age, a;
	
	/**
	 * Default constructor initializes all variables to 0 or "".
	 */
	public Person() {
       this.firstName = "";
       this.middleName = "";
       this.lastName = "";
       this.age = 0;
    }
	
	/**
	 * Constructor initializes instance variables to parameter values.
	 * @param fName String represents the first name of the person
	 * @param mName String represents the middle name of the person
	 * @param lName String represents the last name of the person
	 * @param a int represents the age of the person
	 */
	public void setPerson(String fName, String mName, String lName, int a) {
		this.setFirstName(fName);
		this.setMiddleName(mName);
		this.setLastName(lName);
		this.setAge(a);
    }
	
	/**
	 * Sets the persons first name.
	 * @param fName String represents the first name of the person input
	 */
	public void setFirstName(String fName) {
		this.firstName = fName;
    }
	
	/**
	 * Sets the persons middle name.
	 * @param mName String represents the middle name of the person input
	 */
	public void setMiddleName(String mName) {
		this.middleName = mName;
    }
	
	/**
	 * Sets the persons last name.
	 * @param lName String represents the last name of the person input
	 */
	public void setLastName(String lName) {
		this.lastName = lName;
    }
	
	/**
	 * Sets the persons age.
	 * @param a int represents the age of the person input
	 * @throws NumberFormatException when a value equal to or less then zero is given
	 */
	public void setAge(int a) {
		if (a <= 0) {
			throw new NumberFormatException(a + " is an invaild age, please enter a number greater than 0.");
		} else
			this.age = a;
    }
	
	/**
	 * Checks the persons first name to a different persons first name.
	 * @param otherName String represents the other persons first name
	 * @return boolean if the persons first name is the same
	 */
	public boolean checkFirstName (String otherName) {
		return (otherName.equals(this.firstName));
	}

	/**
	 * Checks the persons middle name to a different persons middle name.
	 * @param otherName String represents the other persons middle name
	 * @return boolean if the persons middle name is the same
	 */
	public boolean checkMiddleName (String otherName) {
		return (otherName.equals(this.middleName));
	}

	/**
	 * Checks the persons last name to a different persons last name.
	 * @param otherName String represents the other persons last name
	 * @return boolean if the persons last name is the same
	 */
	public boolean checkLastName (String otherName) {
		return (otherName.equals(this.lastName));
	}

	/**
	 * Checks the persons first, middle, and last name are equal to a different persons first, middle, last name.
	 * @param person Object represents the other persons full name
	 * @return boolean if the persons full name is the same
	 */
	public boolean equals (Object person) {
		if (person instanceof Person) {
			Person otherPerson = (Person) person;
			return (otherPerson.getFirstName().equals(this.firstName) && 
			otherPerson.getMiddleName().equals(this.middleName) &&
			otherPerson.getLastName().equals(this.lastName));
		} else return false;
	}

	
	/**
	 * Increase the persons age by one.
	 * @return int returned the age increased by one.
	 */
	public int happyBirthday() {
		age++;
		return age;
	}
	
	/**
	 * Returns the first name of the person.
	 * @return String the persons first name
	 */
	public String getFirstName() {
		return firstName;
    }
	
	/**
	 * Returns the middle name of the person.
	 * @return String the persons middle name
	 */
	public String getMiddleName() {
		return middleName;
    }
	
	/**
	 * Returns the last name of the person.
	 * @return String the persons last name
	 */
	public String getLastName() {
		return lastName;
    }
	
	/**
	 * Returns the age of the person.
	 * @return int the persons age
	 */	
	public int getAge() {
		return age;
    }
	
	/**
	 * Provides a String represntion of the first, middle, last name, and age.
	 * @return String the persons first, middle, last name, and age
	 */
	public String toString() {
		return (firstName + " " + middleName + " " + lastName + " is " + age + " years old.");
	}

}
