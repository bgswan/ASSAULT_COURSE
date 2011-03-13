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
			// calculate customer's age in years and months
			
			// parse customer date of birth
			Calendar calDateOfBirth = Calendar.getInstance();
			calDateOfBirth.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(getDateOfBirth()));
			
			// get current date
			Calendar calNow = Calendar.getInstance();
			calNow.setTime(new java.util.Date());  
			
			// calculate age different in years and months
			int ageYr = (calNow.get(Calendar.YEAR) - calDateOfBirth.get(Calendar.YEAR));   
			int ageMo = (calNow.get(Calendar.MONTH) - calDateOfBirth.get(Calendar.MONTH));
			
			// decrement age in years if month difference is negative
			if (ageMo < 0)   
			{   
				ageYr--;   
			}      
			int age = ageYr;

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

}
