package com.example.bellatrix.interview.ricardo.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.example.bellatrix.interview.ricardo.model.EbayFilter;
import com.example.bellatrix.interview.ricardo.ui.SearchResultsPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

public class FilterByEbayFilter implements Task {

	private final EbayFilter filter;

	public FilterByEbayFilter(EbayFilter filter) {
		this.filter = filter;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click
				.on(SearchResultsPage.FILTER.of(filter.getFilterKey().toUpperCase()).called("filter by " + filter.getFilterName())));

	}

	public static FilterByEbayFilter byFilter(EbayFilter filter) {
		return instrumented(FilterByEbayFilter.class, filter);
	}

}
