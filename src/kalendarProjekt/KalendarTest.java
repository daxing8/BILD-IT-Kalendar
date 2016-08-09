package kalendarProjekt;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class KalendarTest {

	public static void main(String[] args) throws IOException {

		try {
			Scanner input = new Scanner(System.in);

			System.out.println("Enter the year: ");
			int year = input.nextInt();

			System.out.println("Enter a month of the year in format(0 - January, 1 - February... 11 - December): ");
			int month = input.nextInt();

			wrongInput(year, month);
			Kalendar.printCalendar(year, month);
			Reminder.displayMessage(year, month);

			input.close();

		} catch (InputMismatchException e) {
			System.out.println("Wrong input! Please enter the specified format!");
		}

	}

	public static void wrongInput(int num1, int num2) {
		if (num1 < 0 && num2 < 0) {
			throw new InputMismatchException();
		}
	}
}
