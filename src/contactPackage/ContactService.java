/*
 * ContactService.java
 * 
 * This manages the Contact objects. It provides methods to create, update, and delete 
 * contacts by ID ensuring that each contact has a unique ID. 
 * 
 * Author: Jerod Goode
 * Date: May 22, 2025
 * Course: CS320 Software Test, Automation QA
 * Professor Gudivada
 * 
 */

package contactPackage;

import java.util.HashMap;				//imports HashMap method
import java.util.Map;					//imports the Map interface used to store contacts by ID


public class ContactService {

	private Map<String, Contact> contacts;
	
	public ContactService () {
		contacts = new HashMap<>();
		
	}
	
	//method for adding a new contact
	public void addContact (String firstName, String lastName, String id, String address, String phone) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be empty.");
		}
		if (contacts.containsKey(id)) {
			throw new IllegalArgumentException("Contact already exists. Please enter another ID.");
		} else {
			Contact newContact = new Contact(firstName, lastName, id, address, phone);
			contacts.put(id, newContact);
			System.out.println("Contact successfully added.");
		}
	}
	
	//method for deleting an existing contact
	public void deleteContact (String id) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be empty.");
		}
		if (contacts.containsKey(id)) {
			contacts.remove(id);
			System.out.println("Contact deleted");
		} else {
			throw new IllegalArgumentException("ID doesn't exist. Try another ID.");
		}
	}

	//method for updating an existing contact's first name
	public void updateFirstName (String id, String newFirstName) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be empty.");
		}
		if (contacts.containsKey(id)) {
			Contact contactToUpdate = contacts.get(id);
			contactToUpdate.setFirstName(newFirstName);
			System.out.println("First name updated");
		} else {
			throw new IllegalArgumentException("ID doesn't exist. Try another ID.");
		}
	}
	
	//method for updating an existing contact's last name
	public void updateLastName (String id, String newLastName) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be empty.");
		}
		if (contacts.containsKey(id)) {
			Contact contactToUpdate = contacts.get(id);
			contactToUpdate.setLastName(newLastName);
			System.out.println("Last name updated");
		} else {
			throw new IllegalArgumentException("ID doesn't exist. Try another ID.");
		}
	}
	
	//method for updating an existing contact's address
	public void updateAddress (String id, String address) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be empty.");
		}
		if (contacts.containsKey(id)) {
			Contact contactToUpdate = contacts.get(id);
			contactToUpdate.setAddress(address);
			System.out.println("Address updated.");
		} else {
			throw new IllegalArgumentException("ID doesn't exist. Try another ID.");
		}
	}
	
	//method for updating an existing contact's phone number
	public void updatePhone (String id, String phone) {
		if (id == null) {
			throw new IllegalArgumentException("ID cannot be empty.");
		}
		if (contacts.containsKey(id)) {
			Contact contactToUpdate = contacts.get(id);
			contactToUpdate.setPhone(phone);
			System.out.println("Phone number updated.");
		} else {
			throw new IllegalArgumentException("ID doesn't exist. Try another ID.");
		}
	}
}

