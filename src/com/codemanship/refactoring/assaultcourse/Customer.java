package com.codemanship.refactoring.assaultcourse;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Customer {
	
	private List<Video> rentals = new ArrayList<Video>();
	private Address address;
	private final Date dateOfBirth;
	private final String name;


	public Customer(String name, Address address, String dateOfBirth) {
		this.name = name;
		this.address = address;
		try {
		    this.dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dateOfBirth);
		}
		catch(ParseException e) {
		    throw new IllegalArgumentException("Not a valid date: " + dateOfBirth);
		}		
	}

	public String getDateOfBirth() {
		return dateOfBirth.toString();
	}
	
	public List<Video> getRentedVideos() {
		return rentals;
	}

	public void addRental(Video video) {
		rentals.add(video);
	}

	public String getSummary() {
		return name + ", " + address.getHouse() + " " + address.getStreet() + ", " 
				+ address.getCity() + ", " + address.getPostcode();
	}
	
	public boolean isUnderAge(Rating rating) {
		return getAge() < rating.getMinimumAge();
	}
    
    private int getAge()
    {
		Calendar dob = Calendar.getInstance();
		dob.setTime(this.dateOfBirth);
		
		Calendar today = Calendar.getInstance();
		today.setTime(new java.util.Date());  
		
		int age = (today.get(Calendar.YEAR) - dob.get(Calendar.YEAR));   
		
		if (dob.get(Calendar.MONTH) > today.get(Calendar.MONTH))   
		{   
			age--;   
		}      
		return age;
    }
}
