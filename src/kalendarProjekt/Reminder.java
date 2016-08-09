package kalendarProjekt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

class Reminder {

	// Data fields for use in class
	private int year;
	private int month;
	private String reminder;

	// ArrayList for storing information from the user
	public static ArrayList<Kalendar> reminders = new ArrayList<>();

	// Created a file object for use in other methods
	public static File file = new File("information_reminders.txt");

	// No-args Constructor
	Reminder() {

	}

	// Constructor created for Reminder class parameters
	Reminder(int year, int month, String reminder) {
		this.year = year;
		this.month = month;
		this.reminder = reminder;
	}

	// Generated Getters and Setters
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getReminder() {
		return reminder;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}

	//Method that displays the reminder message to user and gives him the options menu
	public static void displayMessage(int year, int month) throws IOException {

		Scanner input = new Scanner(System.in);
		
		
		try {
			//if the file does't exist, create the file
			if (!file.exists()) {
				file.createNewFile();
			}
			
			//Catch the possible exception if file doesn't exist
		} catch (FileNotFoundException e) {
			System.out.println("File doesn't exist!");
		}

		// User's options written on the console
		System.out.println("\n\n		Options Menu");
		System.out.println("[1] Set reminder for a day in the month. ");
		System.out.println("[2] See another month of the year. ");
		System.out.println("[3] Exit \n");
		
		readFromFile(); // Read from the file if there is a reminder saved in it
		
		System.out.println("Enter the number of your chosen option: ");
		// User's option
		int option = input.nextInt();

		// First option - Set reminder
		if (option == 1) {
			System.out.println("Enter day or date in the month that you want to create reminder for: ");
			
			// Enter date for reminder 
			int dayOfWeek = input.nextInt();
			
			 //Copy date for display purpose and pass it to the getDayOfWeek(date) argument
			
			int date = dayOfWeek;

			System.out.println("Set reminder for: ");

			//Invoking the method for setting the reminder for certain date
			getDayOfWeek(year, month, dayOfWeek, date);

			//Prompt the user to enter reminder 
			String setReminder = input.nextLine(); 
			setReminder = input.nextLine(); 

			//Call constructor to store information to the ArrayList 
			Kalendar reminderCalendar = new Kalendar(year, month, date, date, setReminder);
			
			//Store informations into ArrayList passing by constructor 
			reminders.add(reminderCalendar);

			writeToFile(); // Write informations to the file
			displayMessage(month, year); // Call display calendar-menu
											// method

			//Second Option - Look at another month 
		} else if (option == 2) {
			System.out.println("Enter a month (0 - January, 1 - February... 11 - December): ");
			month = input.nextInt(); // Insert a month
			System.out.println("Enter year: ");
			year = input.nextInt(); // Insert a year
			Kalendar.printCalendar(year, month);// Call printCalendar() method and
												// pass arguments
			displayMessage(month, year); // Display menu

			// Third Option - Exit the program 
		} else if (option == 3) {
			System.out.println("<< Exit >>");
			System.exit(0);
		}
		input.close();
	}

	public static void writeToFile() {
				
		try {
			
			// Create an PrintWriter object to write some data to the file 
			PrintWriter writer = new PrintWriter(file);
			for (Kalendar list : reminders) {
				writer.println("*********************************");
				
				// Write year, month and date/day to the file 
				writer.println(list.getYear() + "-" + list.getMonth() + "-" + list.getDayOfWeek());
				
				// Write user's message/reminder/note 
				writer.println(list.getReminder());
				writer.println("*********************************");
			}
			writer.close(); // close the writer
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void readFromFile() {
		
		try {
			
			// Create a Scanner object to read data from the file 
			Scanner readScan = new Scanner(file);
			
			// Check if file contains some data 
			if (readScan.hasNext()) {
				System.out.println("\nYour saved reminder: ");
			}
			while (readScan.hasNext()) {
				
				// Read everything from the file in one single string
				String str = readScan.nextLine();
				System.out.println(str);
			}
			readScan.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void getDayOfWeek(int year, int month, int dayOfWeek, int date) {

		// Call GregorianCalendar's constructor with specified year, month and
		// day of the week 
		GregorianCalendar calendar = new GregorianCalendar(year, month, dayOfWeek);

		// Initialize an array of days in the week */
		String[] dayOfWeekArray = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

		// Initialize an array of months */
		String[] monthsArray = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		year = calendar.get(GregorianCalendar.YEAR); // Get actual year using
														// GregorianCalendar
														// class
		month = calendar.get(GregorianCalendar.MONTH); // Get actual month using
														// GregorianCalendar
														// class
		System.out.println(year + " " + monthsArray[month] + " " + date + ". - "
				+ dayOfWeekArray[calendar.get(GregorianCalendar.DAY_OF_WEEK) - 1]);
		;

	}
}
