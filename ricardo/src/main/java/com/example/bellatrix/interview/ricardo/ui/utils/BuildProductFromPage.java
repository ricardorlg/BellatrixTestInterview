package com.example.bellatrix.interview.ricardo.ui.utils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.By;

import com.example.bellatrix.interview.ricardo.model.Product;
import com.example.bellatrix.interview.ricardo.utils.ParserCurrency;
import com.google.common.collect.Iterables;

import net.serenitybdd.core.pages.WebElementFacade;

public class BuildProductFromPage {

	private WebElementFacade theProductInPage;

	public BuildProductFromPage(WebElementFacade theProductInPage) {
		this.theProductInPage = theProductInPage;
	}

	private final By titleSelector = By.className("lvtitle");
	private final By priceSelector = By.className("lvprice");
	private final By priceRangeSelector = By.className("prRange");
	private final By shippingPriceSelector = By.className("lvshipping");

	public Product buildProduct() {
		return Product.withTitle(getTitle()).withShipPrice(getShippingprice()).withPrice(getPrice());
	}

	private BigDecimal getPrice() {
		WebElementFacade priceField = Iterables.getLast(theProductInPage.thenFindAll(priceSelector));
		try {
			if (priceField.containsElements(priceRangeSelector)) {
				return ParserCurrency.getInstance().parse(priceField.getText().trim().split("\\s+")[2], Locale.US);
			} else {
				return ParserCurrency.getInstance().parse(priceField.getText(), Locale.US);
			}
		} catch (ParseException e) {
			return BigDecimal.ZERO;
		}
	}

	private BigDecimal getShippingprice() {
		String shippingValue = theProductInPage.find(shippingPriceSelector).getText();
		try {
			return ParserCurrency.getInstance().parse(shippingValue, Locale.US);
		} catch (ParseException e) {
			return BigDecimal.ZERO;
		}

	}

	private String getTitle() {
		return theProductInPage.find(titleSelector).getText();
	}
}
