package com.example.bellatrix.interview.ricardo.features.search_products;

import static com.example.bellatrix.interview.ricardo.questions.SearchResults.totalResultsInPage;
import static com.example.bellatrix.interview.ricardo.tasks.Start.openTheApplication;
import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.containsString;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.example.bellatrix.interview.ricardo.tasks.Search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

@RunWith(SerenityRunner.class)
public class SearchProductsStory {

	private final String searchKeyWord = "Shoes";
	private Actor ricardo = Actor.named("Ricardo");

	@Managed
	public WebDriver hisBrowser;

	@Before
	public void ricardoCanBrowseTheWeb() {
		givenThat(ricardo).can(BrowseTheWeb.with(hisBrowser));
	}

	@Test
	public void search_results_should_show_the_search_term_in_the_results_text() {
		givenThat(ricardo).wasAbleTo(openTheApplication());

		when(ricardo).attemptsTo(Search.forTheTerm(searchKeyWord));

		then(ricardo).should(eventually(seeThat(totalResultsInPage(), containsString(searchKeyWord))));

	}



	

}