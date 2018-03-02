package com.example.bellatrix.interview.ricardo.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ParserCurrency {
	private static ParserCurrency instance;

	private ParserCurrency() {

	}

	public static synchronized ParserCurrency getInstance() {
		if (instance == null) {
			instance = new ParserCurrency();
		}
		return instance;
	}

	public BigDecimal parse(final String amount, final Locale locale) throws ParseException {
		final NumberFormat format = NumberFormat.getNumberInstance(locale);
		if (format instanceof DecimalFormat) {
			((DecimalFormat) format).setParseBigDecimal(true);
		}
		return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]", ""));
	}
}
