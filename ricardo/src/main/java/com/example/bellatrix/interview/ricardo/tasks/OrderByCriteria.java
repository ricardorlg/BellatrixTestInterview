package com.example.bellatrix.interview.ricardo.tasks;

import com.example.bellatrix.interview.ricardo.model.OrderCriterias;
import com.example.bellatrix.interview.ricardo.ui.SearchResultsPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class OrderByCriteria implements Task {

	private OrderCriterias criteria;

	public OrderByCriteria(OrderCriterias criteria) {
		this.criteria = criteria;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(SearchResultsPage.SORT_FIELD));
		String orderName = SearchResultsPage.SORTED_OPTION.of(criteria.getValue()).resolveFor(actor).getText();
		actor.attemptsTo(Click.on(SearchResultsPage.SORTED_OPTION.of(criteria.getValue()).called(orderName)));

	}

	public static OrderByCriteria orderResultsBy(OrderCriterias criteria) {
		return new OrderByCriteria(criteria);
	}

}
