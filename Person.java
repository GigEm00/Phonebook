package phoneBook;



public class Person implements Comparable<Object>
{

	/** ATTRIBUTES for the Person class*/
	
	Address address;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	
	
	/** DEFAULT CONSTRUCTOR to add Person Object*/
	public Person()
	{
		
	}
	
	
	
	public Person(Address address, String firstName, String lastName, String phoneNumber)
	{
		super();
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}



	public Person(String csv)
	{
		String[] splitValues = csv.split(", ");

		String names = splitValues[0];
		String street = splitValues[1];
		String city = splitValues[2];
		String state = splitValues[3];
		String zip = splitValues[4];
		String phone = splitValues[5];

		// Format the phone number
		String formattedPhone = phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
		
		/** create new object for adding person */


		// Split the "names" string into an array
		String[] wholeName = names.split(" ");
		// Further parse the name set into first and last names
		String lastName = wholeName[wholeName.length-1];
		String firstName = wholeName[0];
		
		// CREATE A PERSON OBJECT
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phone;
		Address a1 = new Address(street, city, state, zip);
		
		this.address = a1;
	
		
		
		// Assign values to the object
		
		/** test print the results */
		System.out.println("You entered: \n");
		System.out.println(names + "\n" + street + "\n" + city + "\n" + state + ", " + zip + "\n" + formattedPhone + "\n");

	}


	/** Scan in the user input into a string*/
	
	public void addPerson()
	{}

	
	
	/** GETTERS AND SETTERS for Person class*/
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}


	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}


	public Address getAddress()
	{
		return address;
	}


	public void setAddress(Address address)
	{
		this.address = address;
	}


	@Override
	public String toString()
	{
		return firstName +" "+ lastName +" "+address+" "+phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
	}

	public String getFullName()
	{
		return firstName + " " +lastName;
	}

	@Override
	public int compareTo(Object o)
	{
	
		return this.getFullName().compareTo(((Person)o).getFullName());
	}
	


	
	
}



