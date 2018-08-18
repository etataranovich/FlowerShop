package by.tataranovich.shop.modelshop.action;

import java.math.BigDecimal;


import by.tataranovich.shop.modelshop.Order;

public class TotalPriceCalculator {

    public  static BigDecimal calculateTotalPrice(Order order) {
	return BuoqetPriceCalculator.calculateBuoqetPrice(order.getBouqet()).multiply(BigDecimal.valueOf(order.getBouqetCount()));
    }
}

























//private BigDecimal getTotalPrice() {
//	return order.getBouqet().getPrice().multiply(BigDecimal.valueOf(order.getBouqetCount()));
//}
