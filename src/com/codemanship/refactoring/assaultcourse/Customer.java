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
	private final String dateOfBirth;
	private final String name;


	public Customer(String name, Address address, String dateOfBirth) {
		this.name = name;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
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

		try {
			int age = getAge();

			// determine if customer is under legal age for rating
			switch(rating){
			case TWELVE:
				return age < 12;
			case FIFTEEN:
				return age < 15;
			case EIGHTEEN:
				return age < 18;
			default:
				return false;
			}
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;		

	}
    
    private int getAge() throws ParseException
    {
		Calendar dob = Calendar.getInstance();
		dob.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(getDateOfBirth()));
		
		Calendar today = Calendar.getInstance();
		today.setTime(new java.util.Date());  
		
		// calculate age different in years and months
		int ageYr = (today.get(Calendar.YEAR) - dob.get(Calendar.YEAR));   
		int ageMo = (today.get(Calendar.MONTH) - dob.get(Calendar.MONTH));
		
		// decrement age in years if month difference is negative
		if (ageMo < 0)   
		{   
			ageYr--;   
		}      
		return ageYr;
    }
}
