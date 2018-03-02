package com.example.bellatrix.interview.ricardo.features.sort_results;

import static com.example.bellatrix.interview.ricardo.matchers.CustomMatchers.areSortedByAscendantPrice;
import static com.example.bellatrix.interview.ricardo.matchers.CustomMatchers.areSortedByDescendantPrice;
import static com.example.bellatrix.interview.ricardo.questions.SearchResults.displayedProductsByLimit;
import static com.example.bellatrix.interview.ricardo.tasks.CustomizeResults.customizeResultsView;
import static com.example.bellatrix.interview.ricardo.tasks.FilterByEbayFilter.filterByEbayFilter;
import static com.example.bellatrix.interview.ricardo.tasks.OrderByCriteria.orderResultsBy;
import static com.example.bellatrix.interview.ricardo.tasks.Start.openTheApplication;
import static net.serenitybdd.screenplay.GivenWhenThen.and;
import static net.serenitybdd.screenplay.GivenWhenThen.andThat;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.example.bellatrix.interview.ricardo.model.EbayFilter;
import com.example.bellatrix.interview.ricardo.model.OrderCriterias;
import com.example.bellatrix.interview.ricardo.tasks.Search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
@RunWith(SerenityRunner.class)

public class SortResultsStory {

	private final String searchKeyWord = "Shoes";
	private final EbayFilter brandFilter = new EbayFilter("Brand", "Puma");
	private final EbayFilter sizeFilter = new EbayFilter("shoes size", "10");
	private final int RESULTS_LIMIT = 5;
	private Actor ricardo = Actor.named("Ricardo");

	@Managed
	public WebDriver hisBrowser;

	@Before
	public void ricardoCanBrowseTheWeb() {
		givenThat(ricardo).can(BrowseTheWeb.with(hisBrowser));
		andThat(ricardo).wasAbleTo(openTheApplication());

	}

	@Test
	public void order_results_by_ascendant_price() {
		when(ricardo).attemptsTo(Search.forTheTerm(searchKeyWord));
		and(ricardo).has(
				customizeResultsView(), 
				orderResultsBy(OrderCriterias.ASCENDANT_PRICE));
		then(ricardo).should(
				seeThat("The displayed Products",displayedProductsByLimit(RESULTS_LIMIT), areSortedByAscendantPrice()));

	}

	@Test
	public void order_results_by_descendant_price() {
		when(ricardo).attemptsTo(Search.forTheTerm(searchKeyWord));
		and(ricardo).has(
				customizeResultsView(), 
				orderResultsBy(OrderCriterias.DESCENDANT_PRICE));
		then(ricardo).should(
				seeThat(displayedProductsByLimit(RESULTS_LIMIT), areSortedByDescendantPrice()));
	}
	@Test
	public void order_filter_results() {
		when(ricardo).attemptsTo(Search.forTheTerm(searchKeyWord));
		and(ricardo).has(
				customizeResultsView(), 
				filterByEbayFilter(brandFilter),
				filterByEbayFilter(sizeFilter),
				orderResultsBy(OrderCriterias.DESCENDANT_PRICE));
		then(ricardo).should(
				seeThat(displayedProductsByLimit(RESULTS_LIMIT), areSortedByDescendantPrice()));
	}
}
