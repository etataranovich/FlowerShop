package by.tataranovich.shop.modelshop;

import java.math.BigDecimal;

public enum FlowerType {
    TULIP(2, "tulip"),
    ROSE(3, "rose"),
    NARCISSE(1.5, "narcisse"),
    SUNFLOWER(5, "sunflower"),
    GERBERA(2, "gerbera"),
    CHRYSANTHEMUM(0.9, "chrysanthemum"),
    DAISY(1.3, "daisy"),
    POPPY(0.7, "poppy");

    private double price;
    private String name;

    FlowerType(double price, String name) {
	this.price = price;
	this.name = name;
    }

    public BigDecimal getPrice() {
	return BigDecimal.valueOf(price);
    }

    public String getName() {
	return name;
    }

    public static FlowerType getFlowerByName(String name) {
	switch (name) {
	case "tulip":
	    return TULIP;
	case "rose":
	    return ROSE;
	case "narcisse":
	    return NARCISSE;
	case "sunflower":
	    return SUNFLOWER;
	case "gerbera":
	    return GERBERA;
	case "chrysanthemum":
	    return CHRYSANTHEMUM;
	case "daisy":
	    return DAISY;
	case "poppy":
	    return POPPY;

	}
	return null;
    }
}