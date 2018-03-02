package com.example.bellatrix.interview.ricardo.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

public class LoggerTask implements Task, NoScreenShots {

	@SuppressWarnings("unused")
	private final String message;

	public LoggerTask(String message) {
		this.message = message;
	}

	@Step("Log: #message")
	public <T extends Actor> void performAs(T actor) {
		// Empty body used to log in report
	}

	public static LoggerTask log(String message) {
		return instrumented(LoggerTask.class, message);
	}
}
