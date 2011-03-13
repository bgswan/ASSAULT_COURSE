package com.codemanship.refactoring.assaultcourse;

public enum Rating {
	UNIVERSAL(0), FIFTEEN(15), TWELVE(12), EIGHTEEN(18);
	
	private int minAge;
	
	Rating(int minimumAge) {
	    this.minAge = minimumAge;
	}
	
	int getMinimumAge() {
	    return minAge;
	}

}
