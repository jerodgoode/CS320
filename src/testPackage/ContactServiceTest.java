/*
 * ContactServiceTest.java
 * 
 * This file contains the test cases for ContactService class
 * These test cases validates the create, delete, and update operations.
 * 
 * Author: Jerod Goode
 * Date: May 22, 2025
 * Course: CS320 Software Test, Automation QA
 * Professor Gudivada
 * 
 */

package testPackage;									


import static org.junit.jupiter.api.Assertions.*;		//imports Junit 5 assertion methods (allows for assertThrows)
import org.junit.jupiter.api.BeforeEach;				//imports Junit 5 annotation for setup before each test
import org.junit.jupiter.api.Test;						//Junit annotation to mark each method as test cases
import contactPackage.ContactService;					//imports the class were testing

class ContactServiceTest {
	
	private ContactService contactService;
	
	//creates new CustomerService instance before each test
	@BeforeEach
	void setUp() {
		contactService = new ContactService();
	}
	
	//adds contact successfully
	@Test
	void testAddContact() {
		contactService.addContact("Sam", "Gamgee", "0808", "Hobbiton", "1234567890");
	}
	
	//should not allow two contacts with the same ID number 
	@Test
	void testAddDuplicateContactThrowsException() {
		contactService.addContact("Sam", "Gamgee", "0808", "Hobbiton", "1234567890");
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact("Peregrin", "Took", "0808", "Hobbiton", "0987654321");
		});
	}
	
	//deletes contact successfully
	@Test
	void testDeleteContact() {
		contactService.addContact("Sam", "Gamgee", "0808", "Hobbiton", "1234567890");
		contactService.deleteContact("0808");
	}
	
	//should fail if user inputs invalid ID
	@Test
	void testDeleteContactThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact("nonexistantId");
		});
	}
	
	//should fail if ID is empty
	@Test
	void testDeleteContactIfNullThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.deleteContact(null);
		});
	}
	
	//updates contact first name successfully
	@Test
	void testUpdateFirstName() {
		contactService.addContact("Sam", "Gamgee", "0808", "Hobbiton", "1234567890");
		contactService.updateFirstName("0808", "SamWise");
	}
	
	//should fail if user inputs invalid ID to update first name
	@Test
	void testUpdateFirstNameInvalidThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateFirstName("nonexistantId", "SamWise");
		});
	}
	
	//updates contact last name successfully
	@Test
	void testUpdateLastName() {
		contactService.addContact("Sam", "Gamgee", "0808", "Hobbiton", "1234567890");
		contactService.updateLastName("0808", "Gam-gee");
	}
	
	//should fail if user inputs invalid ID to update last name
	@Test
	void testUpdateLastNameInvalidThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateLastName("nonexistantId", "Gam-gee");
		});
	}
	
	//updates address successfully
	@Test
	void testUpdateAddress() {
		contactService.addContact("Sam", "Gamgee", "0808", "Hobbiton", "1234567890");
		contactService.updateAddress("0808", "Manhattan");
	}
	
	//should fail if user inputs invalid ID to update address
	@Test
	void testUpdateAddressInvalidThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updateAddress("nonexistantId", "Manhattan");
		});
	}
	
	//updates phone number successfully
	@Test
	void testUpdatePhoneNumber() {
		contactService.addContact("Sam", "Gamgee", "0808", "Hobbiton", "1234567890");
		contactService.updatePhone("0808", "1112223333");
	}
	
	//should fail if user inputs invalid ID to update phone number
	@Test
	void testUpdatePhoneNumberInvalidThrowsException() {
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.updatePhone("nonexistantId", "1112223333");
		});
	}
}
