package phoneBook;

public class Address
{
	/**ATTRIBUTES for Address class*/
	private String streetAddress;
	private String city;
	private String state;
	private String zip;

	/** DEFAULT CONSTRUCTOR to create Address object*/
	public Address()
	{
		
	}
		
	
	public Address(String streetAddress, String city, String state, String zip)
	{
		super();
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}











	/** GETTERS AND SETTERS for address attributes*/
	public String getStreetAddress()
	{
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress)
	{
		this.streetAddress = streetAddress;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getState() 
	{
		return state;
	}
	
	public void setState(String state) 
	{
		this.state = state;
	}
	
	public String getZip()
	{
		return zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
	}









	@Override
	public String toString()
	{
		return streetAddress + " " + city + " " + state + " " + zip;
	}
	
}
