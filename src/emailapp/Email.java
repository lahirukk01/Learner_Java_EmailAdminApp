package emailapp;

import java.util.Random;
import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String department;
	private String alternateEmail;
	private String companySuffix = "yahoo.com";
	private int mailboxCapacity = 500;
	
	private int defaultPasswordLength = 8;
	
	// Constructor to receive the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
//		System.out.println("Email created: " + this.firstName + " " + this.lastName);
		
		// Call a method asking for the department - return the department
		this.department = this.setDepartment();
//		System.out.println("Your department: " + this.department);
		
		// Call a method that return a random password
		this.password = this.randomPassword(this.defaultPasswordLength);
//		System.out.println("Your password: " + this.password);
		
		// Combine element to generate email
		this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" 
				+ this.department + "." + this.companySuffix;	
//		System.out.println("Your email: " + this.email);
	}
	
	// Ask for the department
	private String setDepartment() {
		System.out.println("Department codes\n1 for Sales\n2 for Development\n3 for "
				+ "Accounting\n0 for none\nEnter department code:");
		
		Scanner in = new Scanner(System.in);
		int departmentChoice = in.nextInt();
		in.close();
		
		switch (departmentChoice) {
		case 1:
			return "sales";
		case 2:
			return "dev";
		case 3:
			return "acct";
		default:
			return "";
		}
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstyvwxyz0123456789!@#$&*";
		int numberOfAllowedCharacters = allowedCharacters.length();
		char[] password = new char[length];
		
		Random r = new Random();
		
		for (int i = 0; i < length; i++) {
			int position = r.nextInt(numberOfAllowedCharacters);
			password[i] = allowedCharacters.charAt(position);
		}
		
		return new String(password);
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	// Set the alternate email
	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	public int getMailboxCapacity() {
		return mailboxCapacity;
	}

	// Set the mailbox capacity
	public void setMailboxCapacity(int mailboxCapacity) {
		this.mailboxCapacity = mailboxCapacity;
	}
	
	// Change the password
	public void changePassword(String newPassword) {
		this.password = newPassword;
	}
	
	public String showInfo() {
		return "Display Name: " + firstName + " " + lastName + "\nCompany Email: " + email + 
				"\nMailbox Capacity: " + mailboxCapacity + "mb";
	}
}
