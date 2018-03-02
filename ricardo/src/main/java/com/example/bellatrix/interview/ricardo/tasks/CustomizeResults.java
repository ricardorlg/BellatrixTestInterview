package com.example.bellatrix.interview.ricardo.tasks;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import com.example.bellatrix.interview.ricardo.ui.SearchResultsPage;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class CustomizeResults {

	public static Task customizeResultsView() {
		return Task.where("{0} attempts to customize the results page view",
				WaitUntil.the(SearchResultsPage.VIEW_TYPE, isVisible()).forNoMoreThan(15).seconds(), 
				Click.on(SearchResultsPage.VIEW_TYPE.called("customize results view button")),
				WaitUntil.the(SearchResultsPage.CUSTOMIZE_LINK, isCurrentlyVisible()),
				Click.on(SearchResultsPage.CUSTOMIZE_LINK.called("personalize view results")), Click.on(SearchResultsPage.CONVERT_PRICES),
				Click.on(SearchResultsPage.SAVE_CHANGES));
	}

}
