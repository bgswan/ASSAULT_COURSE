package com.codemanship.refactoring.assaultcourse;

public class Video {

	private final String title;
	private final Rating rating;


	public Video(String title, Rating rating) {
		this.title = title;
		this.rating = rating;
	}
	
	public Rating getRating() {
		return rating;
	}

	public String getTitle() {
		return title;
	}

	public void rentFor(Customer customer) throws CustomerUnderageException {
		if(customer.isUnderAge(rating))
			throw new CustomerUnderageException();
		customer.addRental(this);
	}

}
