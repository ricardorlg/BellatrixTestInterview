package com.example.bellatrix.interview.ricardo.questions;

import java.util.List;

import com.example.bellatrix.interview.ricardo.model.EbayFilter;
import com.example.bellatrix.interview.ricardo.model.Product;

import net.serenitybdd.screenplay.Question;

public class SearchResults {

	public static Question<String> totalResultsInPage() {
		return new SearchResultQuestion();
	}

	public static Question<Integer> numberOfFilterApplied() {
		return new NumberOfFiltersQuestion();
	}

	public static Question<Boolean> isEbayFilterApplied(EbayFilter filter) {
		return new FilterAppliedQuestion(filter);
	}

	public static Question<List<Product>> displayedProductsByLimit(int limit) {
		return new DisplayedItemsQuestion(limit);
	}

}
