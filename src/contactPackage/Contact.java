/*
 * Contact.java
 * 
 * Contact class keeps record of customer first name, last name,
 * id number, address, and phone number.
 * 
 * Validates input through setter and getter methods and ensures input
 * stays with in the set parameters:
 * -Names and ID's are not null and less than 10 characters
 * -Address is less than 30 characters
 * -Phone numbers equal exactly 10 characters
 * 
 * Author: Jerod Goode
 * Date: May 22, 2025
 * Course: CS320 Software Test, Automation QA
 * Professor Gudivada
 * 
 */

package contactPackage;

public class Contact {
	
	//stores contact information
	private String firstName;
	private String lastName;
	private String id;
	private String address;
	private String phone;
	
	//constructor sets input details and validates the input
	public Contact (String firstName, String lastName, String id, String address, String phone) {
		if (firstName == null || firstName.length()>10)
			throw new IllegalArgumentException("Invalid First Name.");
		if (lastName == null || lastName.length()>10)
			throw new IllegalArgumentException("Invalid Last Name.");
		if (id == null || id.length()>10)
			throw new IllegalArgumentException("Invalid ID.");
		if (address == null || address.length()>30)
			throw new IllegalArgumentException("Invalid Address.");
		if (phone == null || phone.length()!=10)
			throw new IllegalArgumentException("Invalid Phone Number.");
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.address = address;
		this.phone = phone;
	}
	
	//getter methods returns information
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getId() {
		return id;
	}
	public String getAddress() {
		return address;
	}
	public String getPhoneNumber() {
		return phone;
	}
	
	//setter methods updates the fields with information. 
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length()>10)
			throw new IllegalArgumentException("Invalid First Name.");
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length()>10)
			throw new IllegalArgumentException("Invalid Last Name.");
		this.lastName = lastName;
	}
	public void setAddress(String address) {
		if (address == null || address.length()>30)
			throw new IllegalArgumentException("Invalid Address.");
		this.address = address;
	}
	public void setPhone(String phone) {
		if (phone == null || phone.length()!=10)
			throw new IllegalArgumentException("Invalid Phone Number.");
		this.phone = phone;
	}
}
