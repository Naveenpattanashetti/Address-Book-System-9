package com.bridgelabz.addresbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookMainClass {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBookMainClass addressbook=new AddressBookMainClass();
		System.out.println("Welcome to Address Book Program");
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
		AddressBook addressBook = new AddressBook();
		contactList.add(contact);
		addressBook.setContacts(contactList);
		addressbook.displayContacts(addressBook);
		sc.close();

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
