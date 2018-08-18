package by.tataranovich.shop.modelshop;

import java.io.Serializable;
import java.util.Map;

import by.tataranovich.shop.modelshop.action.BuoqetPriceCalculator;
import by.tataranovich.shop.modelshop.action.TotalPriceCalculator;

public class Check implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final String RAW_FORMAT = "%1$-20s%2$10s%3$10s\n";
    private static final String TOTAL_FORMAT = "%1$-30s%2$10s\n";

    private Order order;

    public Check(Order order) {
	super();
	this.order = order;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("****************************************");
	sb.append(System.lineSeparator());
	sb.append("Заказ: ").append(order.getId()).append(System.lineSeparator());
	sb.append("Клиент: ").append(order.getClientId()).append(System.lineSeparator());
	sb.append("Название: ").append(order.getBouqet().getName()).append(System.lineSeparator());
	sb.append(System.lineSeparator());
	sb.append("----------------------------------------");
	sb.append(System.lineSeparator());
	sb.append(System.lineSeparator());
	sb.append(String.format(RAW_FORMAT, String.format("Base (%s)", order.getBouqet().getPackageType().getName()), 1,
		String.format(" %.2f \u20AC", order.getBouqet().getPackageType().getPrice())));
	for (Map.Entry<FlowerType, Integer> entry : order.getBouqet().getFlowers().entrySet()) {
	    sb.append(String.format(RAW_FORMAT,
		    entry.getKey().getName(), 
		    entry.getValue(),
		    String.format(" %.2f \u20AC", entry.getKey().getPrice()))
		    );
	}
	sb.append(String.format(TOTAL_FORMAT,"Всего:", String.format(" %.2f \u20AC",BuoqetPriceCalculator.calculateBuoqetPrice(order.getBouqet()))));
	sb.append(String.format(TOTAL_FORMAT,"Кол-во:", order.getBouqetCount()));
	sb.append(System.lineSeparator());
	sb.append("----------------------------------------");
	sb.append(System.lineSeparator());
	sb.append(String.format(TOTAL_FORMAT,"Общая сумма:", String.format(" %.2f \u20AC",TotalPriceCalculator.calculateTotalPrice(order))));
	sb.append(System.lineSeparator());
	sb.append("****************************************");
	return sb.toString();
    }   
    
}












//private BigDecimal getTotalPrice() {
//	return order.getBouqet().getPrice().multiply(BigDecimal.valueOf(order.getBouqetCount()));
//}
