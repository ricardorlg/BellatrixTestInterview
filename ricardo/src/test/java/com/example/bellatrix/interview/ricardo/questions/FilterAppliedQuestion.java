package com.example.bellatrix.interview.ricardo.questions;

import com.example.bellatrix.interview.ricardo.model.EbayFilter;
import com.example.bellatrix.interview.ricardo.ui.SearchResultsPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("The #filter should be applied")
public class FilterAppliedQuestion implements Question<Boolean> {

	private final EbayFilter filter;

	public FilterAppliedQuestion(EbayFilter filter) {
		super();
		this.filter = filter;
	}

	@Override
	public Boolean answeredBy(Actor actor) {

		return SearchResultsPage.FILTER_APPLIED_FIELD.of(filter.getFilterKey().toUpperCase())
				.called("filter by " + filter.getFilterName()).resolveFor(actor).isCurrentlyVisible();

	}

}
