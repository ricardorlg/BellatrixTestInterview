package com.example.bellatrix.interview.ricardo.tasks;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

import com.example.bellatrix.interview.ricardo.model.EbayFilter;
import com.example.bellatrix.interview.ricardo.tasks.exceptions.NoMatchingFilterOptionIsVisible;
import com.example.bellatrix.interview.ricardo.ui.SearchResultsPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class FilterByEbayFilter implements Task {

	private final EbayFilter filter;

	public FilterByEbayFilter(EbayFilter filter) {
		this.filter = filter;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		Target filterOption = SearchResultsPage.FILTER.of(filter.getFilterKey().toUpperCase())
				.called(filter.getFilterName() + " filter");
		actor.should(eventually(seeThat(the(filterOption), isVisible())).waitingForNoLongerThan(30).milliseconds()
				.orComplainWith(NoMatchingFilterOptionIsVisible.class, getMissingFilterOptionMessage()));

		actor.attemptsTo(Click.on(filterOption.called("the " + filterOption.getName())));

	}

	private String getMissingFilterOptionMessage() {
		return String.format("Missing filter '%s'", filter);
	}

	public static FilterByEbayFilter filterByEbayFilter(EbayFilter filter) {
		return instrumented(FilterByEbayFilter.class, filter);
	}

}
