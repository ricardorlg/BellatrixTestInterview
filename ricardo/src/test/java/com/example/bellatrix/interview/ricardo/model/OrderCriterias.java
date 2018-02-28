package com.example.bellatrix.interview.ricardo.model;

public enum OrderCriterias {

	
	ASCENDANT_PRICE("15"),DESCENDANT_PRICE("");
	private final String value;

	OrderCriterias(String value){
		this.value=value;
	}

	public String getValue() {
		return value;
	}

}
