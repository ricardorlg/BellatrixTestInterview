package com.example.bellatrix.interview.ricardo.model;

public class Product {
	private final String title;
	private final double price;
	private final double shippingPrice;

	public Product(String title, double price, double shippingPrice) {
		this.title = title;
		this.price = price;
		this.shippingPrice = shippingPrice;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}

	public double getShippingPrice() {
		return shippingPrice;
	}

	@Override
	public String toString() {
		return "Product [title=" + title + ", price=" + price + ", shippingPrice=" + shippingPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(shippingPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (Double.doubleToLongBits(shippingPrice) != Double.doubleToLongBits(other.shippingPrice))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	public static ProductBuilder withTitle(String title) {
		return new ProductBuilder(title);
	}

	public interface WithShippingPrice {
		ProductBuilder withShipPrice(double shippingPrice);
	}

	public static class ProductBuilder implements WithShippingPrice {

		private String title;
		private double shippingPrice = 0;

		public ProductBuilder(String title) {
			this.title = title;
		}

		public Product withDescription(double price) {
			return new Product(title, price, shippingPrice);
		}

		@Override
		public ProductBuilder withShipPrice(double shippingPrice) {
			this.shippingPrice = shippingPrice;
			return this;
		}

	}
}
