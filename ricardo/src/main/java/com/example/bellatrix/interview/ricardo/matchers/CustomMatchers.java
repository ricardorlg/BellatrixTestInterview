package com.example.bellatrix.interview.ricardo.matchers;

public class CustomMatchers {

	public static SortedMatcher areSortedByAscendantPrice() {
		return new SortedMatcher(true);
	}

	public static SortedMatcher areSortedByDescendantPrice() {
		return new SortedMatcher(false);
	}

}
