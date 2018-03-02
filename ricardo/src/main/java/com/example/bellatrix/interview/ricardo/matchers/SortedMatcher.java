package com.example.bellatrix.interview.ricardo.matchers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.example.bellatrix.interview.ricardo.model.Product;

public class SortedMatcher extends TypeSafeMatcher<List<Product>> {
	private boolean ascendingOrder;

	public SortedMatcher(boolean ascendingOrder) {
		this.ascendingOrder = ascendingOrder;
	}

	@Override
	protected boolean matchesSafely(List<Product> actualProducts) {

		List<Product> expectedProducts = actualProducts.stream().map(product -> product.clone())
				.collect(Collectors.toList());
		Comparator<Product> productComparator = (p1, p2) -> p1.getFinalPrice().compareTo(p2.getFinalPrice());
		expectedProducts.sort(ascendingOrder ? productComparator : productComparator.reversed());
		return actualProducts.equals(expectedProducts);
	}

	@Override
	public void describeTo(Description description) {
		String orderDescription = ascendingOrder ? "ascending order" : "descending order";
		description.appendText("sorted by " + orderDescription);
	}

}
