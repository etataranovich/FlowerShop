package by.tataranovich.shop.modelshop;

import java.math.BigDecimal;

public enum PackageType {

    REGULAR(2, "regular"),
    BASKET(7, "basket");

    private double price;
    private String name;

    private PackageType(double price, String name) {
	this.price = price;
	this.name = name;
    }

    public BigDecimal getPrice() {
	return BigDecimal.valueOf(price);
    }

    public String getName() {
	return name;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public static PackageType getPackageTypeByName(String name) {
	switch (name) {
	case "regular":
	    return REGULAR;
	case "basket":
	    return BASKET;
	}
	return null;
    }
}
