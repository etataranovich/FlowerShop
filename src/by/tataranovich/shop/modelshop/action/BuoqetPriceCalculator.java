package by.tataranovich.shop.modelshop.action;

import java.math.BigDecimal;
import java.util.Map;

import by.tataranovich.shop.modelshop.Bouqet;
import by.tataranovich.shop.modelshop.FlowerType;

public class BuoqetPriceCalculator {

    public static BigDecimal calculateBuoqetPrice(Bouqet bouqet) {
	BigDecimal result = bouqet.getPackageType().getPrice();
	for (Map.Entry<FlowerType, Integer> entry : bouqet.getFlowers().entrySet()) {
	    result = result.add(entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())));
	}
	return result;
    }
}
