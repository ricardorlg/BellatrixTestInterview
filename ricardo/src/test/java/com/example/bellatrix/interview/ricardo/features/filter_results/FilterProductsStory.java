package com.example.bellatrix.interview.ricardo.features.filter_results;

import static com.example.bellatrix.interview.ricardo.questions.SearchResults.isEbayFilterApplied;
import static com.example.bellatrix.interview.ricardo.questions.SearchResults.numberOfFilterApplied;
import static com.example.bellatrix.interview.ricardo.questions.SearchResults.totalResultsInPage;
import static com.example.bellatrix.interview.ricardo.tasks.FilterByEbayFilter.filterByEbayFilter;
import static com.example.bellatrix.interview.ricardo.tasks.Start.openTheApplication;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.and;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.example.bellatrix.interview.ricardo.model.EbayFilter;
import com.example.bellatrix.interview.ricardo.tasks.Search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

@RunWith(SerenityRunner.class)
public class FilterProductsStory {

	private final String searchKeyWord = "Shoes";
	private final EbayFilter brandFilter = new EbayFilter("Brand", "Puma");
	private final EbayFilter sizeFilter = new EbayFilter("shoes size", "10");
	private Actor ricardo = Actor.named("Ricardo");

	@Managed
	public WebDriver hisBrowser;

	@Before
	public void ricardoCanBrowseTheWeb() {
		givenThat(ricardo).can(BrowseTheWeb.with(hisBrowser));
		
	}
	
	@Test
	public void filter_results_by_brand() {
		givenThat(ricardo).wasAbleTo(openTheApplication());
		when(ricardo).attemptsTo(Search.forTheTerm(searchKeyWord));
		and(ricardo).attemptsTo(
				filterByEbayFilter(brandFilter));
		then(ricardo).should(eventually(
				seeThat(totalResultsInPage(), containsString(searchKeyWord))),
				seeThat(numberOfFilterApplied(), is(1)), 
				seeThat(isEbayFilterApplied(brandFilter)));
	}
	@Test
	public void filter_results_by_size() {
		givenThat(ricardo).wasAbleTo(openTheApplication());
		when(ricardo).attemptsTo(Search.forTheTerm(searchKeyWord));
		and(ricardo).attemptsTo( 
				filterByEbayFilter(sizeFilter));
		then(ricardo).should(eventually(
				seeThat(totalResultsInPage(), containsString(searchKeyWord))),
				seeThat(numberOfFilterApplied(), is(1)),
				seeThat(isEbayFilterApplied(sizeFilter)));
	}
	@Test
	public void filter_results_by_brand_and_size() {
		givenThat(ricardo).wasAbleTo(openTheApplication());
		when(ricardo).attemptsTo(Search.forTheTerm(searchKeyWord));
		and(ricardo).attemptsTo(
				filterByEbayFilter(brandFilter), 
				filterByEbayFilter(sizeFilter));
		then(ricardo).should(eventually(
				seeThat(totalResultsInPage(), containsString(searchKeyWord))),
				seeThat(numberOfFilterApplied(), is(2)), 
				seeThat(isEbayFilterApplied(brandFilter)),
				seeThat(isEbayFilterApplied(sizeFilter)));
	}
}
