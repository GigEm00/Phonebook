package phoneBook;

import java.util.Arrays;
import java.util.Scanner;

public class Phonebook
{
// Establish scanners for program	
	public static Scanner intInput = new Scanner(System.in);
	public static Scanner strInput = new Scanner(System.in);	
// Initialize the array of persons that will be kept in the phonebook	
	static Person[] persons = new Person[0];
// Initialize the string variable for the long test case inputs 
	// which will be parsed to be used as a method
	private static String csv = "";
// Initialize the main menu switch case int variable
	private static int choice = 0;
// Initialize the variable for the search switch case
	private static String searchTerm = "";

	
/** MAIN METHOD --  MAIN METHOD --  MAIN METHOD --  MAIN METHOD --  MAIN METHOD --  
 * _____________________________________________________________________________*/


	public static void main(String[] Args)
	{

		mainMenu();

	}

	/** MAIN METHOD --  MAIN METHOD --  MAIN METHOD --  MAIN METHOD --  MAIN METHOD --  
	 * _____________________________________________________________________________*/

	// Test case :
	// John Doe, 114 Market St, St Louis, MO, 63403, 6366435698
	// John E Doe, 324 Main St, St Charles, MO, 63303, 8475390126
	// John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375

/** MAIN MENU */
	public static void mainMenu()
	{
		do
		{

			System.out.println(
					"______________________________________________________\n" 
			+ "Welcome to your phone book.\n"
			+ "Please type a number to select an action.\n" 
			+ "Enter 6 to exit the phone book.\n\n"
			+ "\t1\tADD a person to the phone book\n" 
			+ "\t2\tDELETE a person from the phonebook\n"
			+ "\t3\tSEARCH for a person\n" 
			+ "\t4\tUPDATE or EDIT a person's information\n"
			+ "\t5\tDISPLAY the phone book in alphabetical order\n" 
			+ "\t6\tEXIT");

			/** Scan in the user's choice of number */
			choice = intInput.nextInt();

/** MAIN MENU SWITCH CASE to call the proper method */
			switch (choice)
			{
//Add person to phonebook
			case 1:

				csv = inputPerson();

				Person p1 = new Person(csv);

				Person personsTemp[] = new Person[persons.length + 1];
				for (int i = 0; i < persons.length; i++)
				{
					personsTemp[i] = persons[i];
				}

				personsTemp[personsTemp.length - 1] = p1;

				persons = personsTemp;				

				break;
// Delete person from phone book
			case 2:
				delete();
				display();
				break;
//Search phone book
			case 3:
				search();
				break;
//Update phone book
			case 4:
				update();
//Display phone book in alphabetical order
			case 5:
				display();
				break;
//EXIT to main menu
			case 6:
				break;
			}

		} while (choice != 6);

	}

	
	
	
	/** METHODS FOR THE MAIN CASES*/

	
// Case 1: method to add person
	public static String inputPerson()
	{

		// Scanner input = new Scanner(System.in);
		/** Prompt user to type out the new person info */
		System.out.println("For the person you want to add,\n"
				+ "Enter the name, address, city, state, zip, and phone separated by commas.\n"
				+ "For example: John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375\n\n");

		/** Scan in the string of info */
		csv = strInput.nextLine();
		return csv;
	}

// Case 2: method to DELETE a person
	private static void delete()
	{

		Person[] tempArray = new Person[persons.length - 1];

		System.out.println("Enter the phone number of the person record you want to DELETE"
				+ "For example (636)555-1000 would be entered as 6365551000\n\n\n");
		String phoneToDelete = strInput.nextLine();

		for (int i = 0; i < persons.length; i++)
		{
			if (Phonebook.persons[i].getPhoneNumber().equals(phoneToDelete))
			{
				int indexToDelete = i;
				System.out.println(i + "\n");
				for (i = 0; i < Phonebook.persons.length; i++)
				{
					if (i < indexToDelete)
					{
						tempArray[i] = persons[i];
					} else if (i > indexToDelete)
					{
						tempArray[i - 1] = persons[i];
					}

				}
				Phonebook.persons = tempArray;
			}

			// System.out.println(persons[i].toString());
		}
		System.out.println("The record containing " + phoneToDelete + " was deleted.\n");
		display();

	}

// Case 3: method to search for a person
	private static void search()
	{
		do
		{

			int choice = 0;
			System.out
					.println("To search, please enter numeric choide below:\nEnter 7 to exit back to the Main Menu\n\n"
							+ "\t1\tFirst Name\n" + "\t2\tLast Name\n" + "\t3\tFull Name\n" + "\t4\tPhone\n"
							+ "\t5\tCity\n" + "\t6\tState\n" + "\t7\tExit (back to Main Menu)\n\n\n");

			// Scanner input = new Scanner(System.in);
			choice = intInput.nextInt();

			switch (choice)
			{
			// First name
			case 1:

				// Scanner stringIn = new Scanner(System.in);
				System.out.println("Enter a few characters to search:\n\n\n");
				searchTerm = strInput.next();

				for (int i = 0; i < persons.length; i++)
				{
					if (persons[i].getFirstName().toLowerCase().startsWith(searchTerm))
					{
						System.out.println(persons[i].toString());
					} else
						System.out.println("No match found");
				}
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				break;
			// Last name
			case 2:
				System.out.println("Enter a few characters to search:\n\n\n");
				searchTerm = strInput.next();

				for (int i = 0; i < persons.length; i++)
				{
					if (persons[i].getLastName().toLowerCase().startsWith(searchTerm))
					{
						System.out.println(persons[i].toString());
					} else
						System.out.println("No match found");
				}
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				// Full name
			case 3:
				System.out.println("Enter a few characters to search:\n\n\n");
				searchTerm = strInput.next();

				for (int i = 0; i < persons.length; i++)
				{
					if (persons[i].getFullName().toLowerCase().startsWith(searchTerm))
					{
						System.out.println(persons[i].toString());
					} else
						System.out.println("No match found");
				}
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				break;
			// phone
			case 4:
				System.out.println("Enter a few characters to search:\n\n\n");
				searchTerm = strInput.next();

				for (int i = 0; i < persons.length; i++)
				{
					if (persons[i].getPhoneNumber().toLowerCase().startsWith(searchTerm))
					{
						System.out.println(persons[i].toString());
					} else
						System.out.println("No match found");
				}
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				break;
			// City
			case 5:
				System.out.println("Enter a few characters to search:\n\n\n");
				searchTerm = strInput.next();

				for (int i = 0; i < persons.length; i++)
				{
					if (persons[i].getAddress().getCity().toLowerCase().startsWith(searchTerm))
					{
						System.out.println(persons[i].toString());
					} else
						System.out.println("No match found");
				}
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				break;
			// State
			case 6:
				System.out.println("Enter a few characters to search:\n\n\n");
				searchTerm = strInput.next();

				for (int i = 0; i < persons.length; i++)
				{
					if (persons[i].getAddress().getState().toLowerCase().startsWith(searchTerm))
					{
						System.out.println(persons[i].toString());
					} else
						System.out.println("No match found");
				}
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				break;
			// EXIT
			case 7:
				mainMenu();
			}
		} while (choice != 7);
	}

// Case 4: UPDATE or EDIT person record */
	public static void update()
	{
		System.out.println("To update or edit a phonebook record please "
				+ "enter the phone number of the record you wish to update:\n\n");
		String phoneSearch = strInput.nextLine();

		System.out.println("Now select the number of the field you want to update" + " for the " + phoneSearch
				+ " record.\n\n\n" 
				+ "\t1\tUpdate First Name\n" 
				+ "\t2\tUpdate Last Name\n" 
				+ "\t3\tUpdate Phone\n"
				+ "\t4\tUpdate City\n" 
				+ "\t5\tUpdate State\n" 
				+ "\t6\tUpdate Zip\n"
				+ "\t7\tUpdate Street Address\n"
				+ "\t8\tExit (back to Main Menu)\n\n\n");

		// Scanner input = new Scanner(System.in);

		choice = intInput.nextInt();

		switch (choice)
		{
		// UPDATE First name
		case 1:

			// Scanner stringIn = new Scanner(System.in);
			System.out.println("Enter the new first name and press enter:\n\n\n");
			String newName = strInput.next();

			for (int i = 0; i < persons.length; i++)
			{
				if (persons[i].getPhoneNumber().equals(phoneSearch))
				{

					persons[i].setFirstName(newName);
					System.out.println("\nUpdated: \n\n");
					System.out.println(persons[i].toString());
				}
			}
			System.out.println("\n\n\n\n");
			break;
		// UPDATE Last name
		case 2:

			// Scanner stringIn = new Scanner(System.in);
			System.out.println("Enter the new last name and press enter:\n\n\n");
			newName = strInput.next();

			for (int i = 0; i < persons.length; i++)
			{
				if (persons[i].getPhoneNumber().equals(phoneSearch))
				{

					persons[i].setLastName(newName);
					System.out.println("\nUpdated: \n\n");
					System.out.println(persons[i].toString());
				}
			}
			System.out.println("\n\n\n\n");
			break;

		// UPDATE phone
		case 3:

			// Scanner stringIn = new Scanner(System.in);
			System.out.println("Enter the new phone number and press enter:\n\n\n");
			newName = strInput.next();

			for (int i = 0; i < persons.length; i++)
			{
				if (persons[i].getPhoneNumber().equals(phoneSearch))
				{

					persons[i].setPhoneNumber(newName);
					System.out.println("\nUpdated: \n\n");
					System.out.println(persons[i].toString());
				}
			}
			System.out.println("\n\n\n\n");
			break;

		// Update City
		case 4:

			// Scanner stringIn = new Scanner(System.in);
			System.out.println("Enter the new City name and press enter:\n\n\n");
			newName = strInput.next();

			for (int i = 0; i < persons.length; i++)
			{
				if (persons[i].getPhoneNumber().equals(phoneSearch))
				{

					persons[i].address.setCity(newName);
					System.out.println("\nUpdated: \n\n");
					System.out.println(persons[i].toString());
				}
			}
			System.out.println("\n\n\n\n");
			break;

		// Update State
		case 5:

			// Scanner stringIn = new Scanner(System.in);
			System.out.println("Enter the new State name and press enter:\n\n\n");
			newName = strInput.next();

			for (int i = 0; i < persons.length; i++)
			{
				if (persons[i].getPhoneNumber().equals(phoneSearch))
				{

					persons[i].address.setState(newName);
					System.out.println("\nUpdated: \n\n");
					System.out.println(persons[i].toString());
				}
			}
			System.out.println("\n\n\n\n");
			break;
		// UPDATE ZIP
		case 6:

			// Scanner stringIn = new Scanner(System.in);
			System.out.println("Enter the new ZIP and press enter:\n\n\n");
			newName = strInput.next();

			for (int i = 0; i < persons.length; i++)
			{
				if (persons[i].getPhoneNumber().equals(phoneSearch))
				{

					persons[i].address.setZip(newName);
					System.out.println("\nUpdated: \n\n");
					System.out.println(persons[i].toString());
				}
			}
			System.out.println("\n\n\n\n");
			break;
			
			// UPDATE Street Address
		case 7:

			// Scanner stringIn = new Scanner(System.in);
			System.out.println("Enter the new Street number and name and press enter:\n\n\n");
			newName = strInput.next();

			for (int i = 0; i < persons.length; i++)
			{
				if (persons[i].getPhoneNumber().equals(phoneSearch))
				{

					persons[i].address.setStreetAddress(newName);
					System.out.println("\nUpdated: \n\n");
					System.out.println(persons[i].toString());
				}
			}
			System.out.println("\n\n\n\n");
			break;

		case 8:
			mainMenu();
		}
	}

// Case 5: DISPLAY Method for option 5 */
	public static void display()
	{

		Arrays.sort(persons);
		System.out.println();
		for (int i = 0; i < persons.length; i++)
		{
			System.out.println(persons[i].toString());
		}
		System.out.println("\n\n\n\n\n\n");
//			
	}

}
