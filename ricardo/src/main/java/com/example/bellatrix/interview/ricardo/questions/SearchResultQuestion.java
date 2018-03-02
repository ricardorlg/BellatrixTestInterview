package com.example.bellatrix.interview.ricardo.questions;

import com.example.bellatrix.interview.ricardo.tasks.LoggerTask;
import com.example.bellatrix.interview.ricardo.ui.SearchResultsPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

@Subject("The total search results ")
public class SearchResultQuestion implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		String totalResults = Text.of(SearchResultsPage.TOTAL_SEARCH_RESULTS).viewedBy(actor).asString();
		actor.attemptsTo(LoggerTask.log(totalResults));
		return totalResults;
	}

}
