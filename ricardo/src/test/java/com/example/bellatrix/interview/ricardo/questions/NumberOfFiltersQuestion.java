package com.example.bellatrix.interview.ricardo.questions;

import com.example.bellatrix.interview.ricardo.ui.SearchResultsPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("The number of filters")
public class NumberOfFiltersQuestion implements Question<Integer> {

	@Override
	public Integer answeredBy(Actor actor) {
		return SearchResultsPage.FILTERS_APPLIED.resolveAllFor(actor).size();
	}

}
