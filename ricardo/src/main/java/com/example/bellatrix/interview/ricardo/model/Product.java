package com.example.bellatrix.interview.ricardo.model;

import java.math.BigDecimal;

public class Product implements Cloneable {
	private final String title;
	private final BigDecimal price;
	private final BigDecimal shippingPrice;

	public Product(String title, BigDecimal price, BigDecimal shippingPrice) {
		this.title = title;
		this.price = price;
		this.shippingPrice = shippingPrice;
	}

	public String getTitle() {
		return title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getShippingPrice() {
		return shippingPrice;
	}

	public BigDecimal getFinalPrice() {
		return price.add(shippingPrice);
	}

	@Override
	public String toString() {
		return "Product [title=" + title + ", price=" + price + ", shippingPrice=" + shippingPrice + "TotalPrice="+getFinalPrice()+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((shippingPrice == null) ? 0 : shippingPrice.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (shippingPrice == null) {
			if (other.shippingPrice != null)
				return false;
		} else if (!shippingPrice.equals(other.shippingPrice))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public Product clone() {
		Product clone = null;
		try {
			clone = (Product) super.clone();

		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e); // won't happen
		}

		return clone;

	}

	public static ProductBuilder withTitle(String title) {
		return new ProductBuilder(title);
	}

	public interface WithShippingPrice {
		ProductBuilder withShipPrice(BigDecimal shippingPrice);
	}

	public static class ProductBuilder implements WithShippingPrice {

		private String title;
		private BigDecimal shippingPrice = BigDecimal.ZERO;

		public ProductBuilder(String title) {
			this.title = title;
		}

		public Product withPrice(BigDecimal price) {
			return new Product(title, price, shippingPrice);
		}

		@Override
		public ProductBuilder withShipPrice(BigDecimal shippingPrice) {
			this.shippingPrice = shippingPrice;
			return this;
		}

	}
}
