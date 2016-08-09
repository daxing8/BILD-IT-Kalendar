package kalendarProjekt;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Kalendar {
	private int year;
	private int month;
	private int dayOfWeek;
	private int date;
	private String reminder;

	// ArrayList for storing information from the user
	public static ArrayList<Kalendar> reminders = new ArrayList<>();

	// No-arguments constructor
	Kalendar() {

	}

	// Constructor created for the Kalendar class parameters
	Kalendar(int year, int month, int dayOfWeek, int date, String setReminder) {
		this.year = year;
		this.month = month;
		this.reminder = setReminder;
		this.dayOfWeek = dayOfWeek;
		this.date = date;
	}

	// Generated Getters and Setters for data fields
	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public String getReminder() {
		return reminder;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}

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

	// Method that takes 2 parameters year and month as arguments and writes a
	// graphic display of calendar
	public static void printCalendar(int year, int month) {

		// Displaying a head of calendar
		System.out.println("\t\t" + monthName(month) + "  " + year + "\n"
				+ "__________________________________________\n" + "Sun   Mon   Tue   Wed   Thu   Fri   Sat ");

		// Calling a method that prints calendar body
		calendarBody(year, month);
	}

	// Method takes 2 integers as an argument and prints calendar body on the
	// console
	public static void calendarBody(int year, int month) {

		// Creating a new GregorianCalendar object with specified parameters
		// entered, like year, month and dayOfTheWeek
		GregorianCalendar calendar = new GregorianCalendar(year, month, 1);

		// Getting a precise day of the week that the first day of the month is
		// on
		int dayOfWeek = calendar.get(GregorianCalendar.DAY_OF_WEEK);

		// Gets a number of days in a month
		int daysInMonth = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);

		// Counts the days of the week
		int daysCounter = 0;

		// Prints out empty space
		for (int i = 1; i < dayOfWeek; i++) {
			System.out.print("      ");
			daysCounter++;
		}

		// Prints the formated numbers of the days in a month
		for (int i = 1; i <= daysInMonth; i++) {
			System.out.printf("%2d  ", i);
			daysCounter++;

			// When counter reaches 7 days switch to the new line
			if (daysCounter == 7) {
				System.out.println();
				daysCounter = 0; // counter is set to 0
			} else
				System.out.print("  "); // if the counter is not 7 print empty
										// space
		}

	}

	// Method generates the name of the month that user entered
	public static String monthName(int month) {

		// Array of strings with names of the months in a year
		String[] months = { "January", "February", "March", "April", "June", "July", "August", "September", "October",
				"November", "December" };

		// Empty string variable for storing the name of the month
		String name = "";

		for (int i = 0; i < months.length; i++) {
			if ((month) == i) { // if the month is equal to index of an Array
								// store the name on that index to the variable
								// name
				name = months[i];
				break; //break the loop
			}
		}
		return name;	//return the name of the month
	}
}
