package com.example.bellatrix.interview.ricardo.questions;

import com.example.bellatrix.interview.ricardo.model.EbayFilter;

import net.serenitybdd.screenplay.Question;

public class SearchResults {

	public static Question<String> totalResultsInPage(){
		return new SearchResultQuestion();
	}
	
	public static Question<Integer> numberOfFilterApplied(){
		return new NumberOfFiltersQuestion();
	}

	public static Question<Boolean> isBrandFilterApplied(EbayFilter filter) {
		// TODO Auto-generated method stub
		return new FilterAppliedQuestion(filter);
	}
}
