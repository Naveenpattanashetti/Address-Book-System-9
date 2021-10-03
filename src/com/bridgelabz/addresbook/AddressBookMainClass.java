package com.bridgelabz.addresbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMainClass {
	public static AddressBook addressBook = new AddressBook();

	public static void main(String[] args) {
		System.out.println("Welcome to Address Book Program");
		AddressBookMainClass addressbook = new AddressBookMainClass();
		addressbook.addContactDetails();
	}

	public void addContactDetails() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice");
		System.out.println("1 : Add new contact    2 : Edit contact   ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter the First Name");
			String firstName = sc.next();
			System.out.println("Enter the Last Name");
			String lastName = sc.next();
			System.out.println("Enter The Address");
			String address = sc.next();
			System.out.println("Enter the city");
			String city = sc.next();
			System.out.println("Enter the state");
			String state = sc.next();
			System.out.println("Enter the zip Code");
			int zip = sc.nextInt();
			System.out.println("Enter the Phone number");
			long phone = sc.nextLong();
			List<Contacts> contactList = new ArrayList<>();
			Contacts contact = new Contacts(firstName, lastName, address, city, state, zip, phone);

			contactList.add(contact);
			addressBook.setContacts(contactList);
			displayContacts(addressBook);
			addContactDetails();
			break;
		case 2:

			System.out.println("Enter the person Name");
			String name = sc.next();
			System.out.println("Enter the Last Name");
			String editLastName = sc.next();
			System.out.println("Enter The Address");
			String editAddress = sc.next();
			System.out.println("Enter the city");
			String editCity = sc.next();
			System.out.println("Enter the state");
			String editState = sc.next();
			System.out.println("Enter the zip Code");
			int editzip = sc.nextInt();
			System.out.println("Enter the Phone number");
			long editPhone = sc.nextLong();
			editContact(name, editLastName, editAddress, editCity, editState, editzip, editPhone);
			addContactDetails();
			break;
		case 3:
			System.out.println("Enter the person Name");
			String deletename = sc.next();
			deleteContactDetails(deletename);
			addContactDetails();
			break;
		default:
			System.out.println("Please Enter correct choice");
			break;

		}
		sc.close();

	}

	public void editContact(String name, String lastname, String address, String city, String state, int zip,
			long phone) {
		List<Contacts> contactDetails = addressBook.getContacts();
		for (int i = 0; i <= contactDetails.size() - 1; i++) {

			Contacts contactperson = contactDetails.get(i);
			if (contactperson.getFirstName().equals(name)) {

				contactperson.setAddress(address);
				contactperson.setCity(city);
				contactperson.setFirstName(name);
				contactperson.setLastName(lastname);
				contactperson.setPhone(phone);
				contactperson.setState(state);
				contactperson.setZip(zip);
				contactDetails.set(i, contactperson);
				addressBook.setContacts(contactDetails);
			}
		}
		displayContacts(addressBook);
	}
	public  void deleteContactDetails(String name) {
		 List<Contacts> contactDetails=addressBook.getContacts();
		for (int i =0;i <=contactDetails.size()-1;i++) {
			 
			int value = 0;
			Contacts contactperson=contactDetails.get(i);
			if (contactperson.getFirstName().equals(name)) {
				contactDetails.remove(i); 
				contactperson.setAddress("");
				contactperson.setCity("");
				contactperson.setFirstName("");
				contactperson.setLastName("");
				contactperson.setPhone(value);
				contactperson.setState("");
				contactperson.setZip(value);
				contactDetails.set(i, contactperson);
				addressBook.setContacts(contactDetails);
			}
		}
		System.out.println("Contact deleted Successfully");
		displayContacts(addressBook);
	}
	public void displayContacts(AddressBook addressBook) {
		List<Contacts> contactDetails = addressBook.getContacts();

		for (int i = 0; i <= contactDetails.size() - 1; i++) {
			Contacts contactperson = contactDetails.get(i);
			System.out.println("Conatct Details :");
			System.out.println("FirstName :" + contactperson.getFirstName() + "      LastName :"
					+ contactperson.getLastName() + "     Address :" + contactperson.getAddress() + "      City :"
					+ contactperson.getCity() + "       State :" + contactperson.getState() + "     Zip :"
					+ contactperson.getZip() + "     Phone Number :" + contactperson.getPhone());

		}

	}
}
