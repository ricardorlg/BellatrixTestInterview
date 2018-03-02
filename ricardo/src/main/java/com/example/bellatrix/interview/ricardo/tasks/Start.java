package com.example.bellatrix.interview.ricardo.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.example.bellatrix.interview.ricardo.interactions.Refresh;
import com.example.bellatrix.interview.ricardo.ui.EbayHomePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class Start implements Task {

	private EbayHomePage applicationHomePage;

	
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Open.browserOn().the(applicationHomePage),
				Refresh.theBrowserSession());
	}

	public static Start openTheApplication() {
		return instrumented(Start.class);
	}
}
