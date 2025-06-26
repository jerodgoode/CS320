/*
 * ContactTest.java
 * 
 * This file contains the test cases for Contact class
 * These test cases validates the user input for creating a new contact.
 * 
 * Author: Jerod Goode
 * Date: May 22, 2025
 * Course: CS320 Software Test, Automation QA
 * Professor Gudivada
 * 
 */

package testPackage;

import org.junit.jupiter.api.Test;						//Junit 5 annotation to mark each method as test cases
import static org.junit.jupiter.api.Assertions.*;		//imports Junit 5 assertion methods (allows for assertThrows, assertTrue)
import contactPackage.Contact;							//imports the class were testing

class ContactTest {

	//successfully add a new contact 
	@Test
	void testContactClass () {
		Contact contact = new Contact("Frodo", "Baggins", "0707", "Bag End, The Shire", "1234567890");
		
		assertTrue(contact.getFirstName().equals("Frodo"));
		assertTrue(contact.getLastName().equals("Baggins"));
		assertTrue(contact.getId().equals("0707"));
		assertTrue(contact.getAddress().equals("Bag End, The Shire"));
		assertTrue(contact.getPhoneNumber().equals("1234567890"));
	}
	
	//fails if first name is longer than 10 characters
	@Test
	void testContactFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("FrodoBaggins", "Baggins", "0707", "Bag End, The Shire", "1234567890");
		});
	}
	
	//fails if last name is longer than 10 characters
	@Test
	void testContactLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Frodo", "FrodoBaggins", "0707", "Bag End, The Shire", "1234567890");
		});
	}
	
	//fails if first name is entered blank 
	@Test
	void testContactFirstNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Baggins", "0707", "Bag End, The Shire", "1234567890");
		});
	}

	//fails if last name is entered blank
	@Test
	void testContactLastNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Frodo", null, "0707", "Bag End, The Shire", "1234567890");
		});
	}

	//fails if ID is longer than 10 characters
	@Test
	void testContactIdTooLong () {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Frodo", "Baggins", "0707070707070707", "Bag End, The Shire", "1234567890");
		});
	}
	
	//fails if ID is entered blank
	@Test
	void testContactIdIsNull () {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Frodo", "Baggins", null, "Bag End, The Shire", "1234567890");
		});
	}
	
	//fails if address is longer than 30 characters=
	@Test
	void testContactAddressTooLong () {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Frodo", "Baggins", "0707", "Bag End, The Shire, Middle Earth", "1234567890");
		});
	}
	
	//fails if addressed is entered blank
	@Test		
	void testContactAddressIsNull () {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Frodo", "Baggins", "0707", null, "1234567890");
		});
	}
	
	//fails if phone number does not exactly match 10 characters
	@Test
	void testContactPhoneNumberTooLong () {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Frodo", "Baggins", "0707", "Bag End, The Shire", "12345678901221");
		});
	}
	
	//fails if phone number is entered in blank
	@Test		
	void testContactPhoneNumberIsNull () {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("Frodo", "Baggins", "0707", "Bag End, The Shire", null);
		});
	}
}