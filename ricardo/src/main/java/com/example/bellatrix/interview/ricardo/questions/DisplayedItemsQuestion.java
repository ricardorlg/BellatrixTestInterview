package com.example.bellatrix.interview.ricardo.questions;

import java.util.ArrayList;
import java.util.List;

import com.example.bellatrix.interview.ricardo.model.Product;
import com.example.bellatrix.interview.ricardo.tasks.LoggerTask;
import com.example.bellatrix.interview.ricardo.ui.SearchResultsPage;
import com.example.bellatrix.interview.ricardo.ui.utils.BuildProductFromPage;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class DisplayedItemsQuestion implements Question<List<Product>> {
	private List<Product> products = new ArrayList<>();
	private int limit;

	public DisplayedItemsQuestion(int limit) {
		this.limit = limit;
	}

	@Override
	public List<Product> answeredBy(Actor actor) {

		List<WebElementFacade> productsInPage = SearchResultsPage.PRODUCTS_LIST.resolveAllFor(actor).subList(0, limit);
		productsInPage.forEach(t -> buildProductFromElement(t));
		actor.attemptsTo(LoggerTask.log(getProductLogMessage()));
		return products;
	}

	private void buildProductFromElement(WebElementFacade productInPage) {
		BuildProductFromPage builder = new BuildProductFromPage(productInPage);
		products.add(builder.buildProduct());

	}

	private String getProductLogMessage() {
		StringBuilder builder = new StringBuilder("**First " + limit + " Products**\n");
		for (int i = 0; i < products.size(); i++) {
			builder.append((i + 1) + ". " + products.get(i).toString() + "\n");
		}
		products.forEach(product -> {

		});
		return builder.toString();
	}

}
