package com.example.bellatrix.interview.ricardo.features.search;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.example.bellatrix.interview.ricardo.model.EbayFilter;
import com.example.bellatrix.interview.ricardo.model.OrderCriterias;
import com.example.bellatrix.interview.ricardo.questions.SearchResults;
import com.example.bellatrix.interview.ricardo.tasks.FilterByEbayFilter;
import com.example.bellatrix.interview.ricardo.tasks.LoggerTask;
import com.example.bellatrix.interview.ricardo.tasks.OpenTheApplication;
import com.example.bellatrix.interview.ricardo.tasks.OrderByCriteria;
import com.example.bellatrix.interview.ricardo.tasks.Search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;

@RunWith(SerenityRunner.class)
public class SearchByKeywordStory {

	private final String searchKeyWord = "Shoes";
	private final EbayFilter brandFilter = new EbayFilter("Brand", "Puma");
	private final EbayFilter sizeFilter = new EbayFilter("shoes size", "10");

	Actor ricardo = Actor.named("Ricardo");

	@Managed
	public WebDriver hisBrowser;

	@Steps
	OpenTheApplication openTheApplication;

	@Before
	public void annaCanBrowseTheWeb() {
		ricardo.can(BrowseTheWeb.with(hisBrowser));
		givenThat(ricardo).wasAbleTo(openTheApplication);
	}

	@Test
	public void search_results_should_show_the_search_term_in_the_results_text() {

		when(ricardo).attemptsTo(Search.forTheTerm(searchKeyWord));

		then(ricardo).should(eventually(seeThat(SearchResults.totalResultsInPage(), containsString(searchKeyWord))));

	}

	@Test
	public void filter_search_by_brand_and_size() {

		when(ricardo).attemptsTo(Search.forTheTerm(searchKeyWord));

		andThat(ricardo).attemptsTo(FilterByEbayFilter.byFilter(brandFilter), FilterByEbayFilter.byFilter(sizeFilter));

		then(ricardo).should(eventually(seeThat(SearchResults.totalResultsInPage(), containsString(searchKeyWord))),
				seeThat(SearchResults.numberOfFilterApplied(), is(2)),
				seeThat(SearchResults.isBrandFilterApplied(brandFilter)),
				seeThat(SearchResults.isBrandFilterApplied(sizeFilter)));
	}
	
	@Test
	public void order_results_by_price_ascendant() {
		when(ricardo).attemptsTo(Search.forTheTerm(searchKeyWord));

		andThat(ricardo).attemptsTo(FilterByEbayFilter.byFilter(brandFilter), FilterByEbayFilter.byFilter(sizeFilter));

		and(ricardo).attemptsTo(OrderByCriteria.byCriteria(OrderCriterias.ASCENDANT_PRICE));
		System.out.println();
	}

}