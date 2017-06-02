package com.infosys.szz.model;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumberBook {

	private static PhoneNumberBook phoneNumberBook = new PhoneNumberBook();
	
	private Map<String, String> phoneNumbers = new HashMap<>();
	
	private PhoneNumberBook() {}
	
	public static PhoneNumberBook getPhoneNumberBook(){
		return phoneNumberBook;
	}
	
	public Map<String, String> getPhoneNumbers(){
		return phoneNumbers;
	}
	
	public void addPhoneNumbers(String name,String phoneNumber){
		phoneNumbers.put(name, phoneNumber);
	}
	
	public void deletePhoneNumbers(String name){
		phoneNumbers.remove(name);
	}
}
