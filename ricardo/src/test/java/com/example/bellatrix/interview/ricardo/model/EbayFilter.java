package com.example.bellatrix.interview.ricardo.model;

public class EbayFilter {

	private final String filterName;
	private final String filterKey;

	public EbayFilter(String filterName, String filterKey) {
		this.filterName = filterName;
		this.filterKey = filterKey;
	}

	public String getFilterName() {
		return filterName;
	}

	public String getFilterKey() {
		return filterKey;
	}

	@Override
	public String toString() {
		return "Filter [filterName=" + filterName + ", filterKey=" + filterKey + "]";
	}

}
