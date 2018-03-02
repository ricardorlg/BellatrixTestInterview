package com.example.bellatrix.interview.ricardo.tasks;

import com.example.bellatrix.interview.ricardo.interactions.Refresh;
import com.example.bellatrix.interview.ricardo.ui.EbayHomePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenTheApplication implements Task {

	EbayHomePage ebayHomePage;

	@Step("{0} Opens the application")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Open.browserOn().the(ebayHomePage), 
				Refresh.theBrowserSession());
	}
}
