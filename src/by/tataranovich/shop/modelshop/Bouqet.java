package by.tataranovich.shop.modelshop;

import java.io.Serializable;
import java.util.Map;

public class Bouqet implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static final int NAME_MAX_LENGTH = 20;
    public static final int NAME_MIN_LENGTH = 4;

    private Map<FlowerType, Integer> flowers;
    private PackageType packageType;
    private String name;

    public Bouqet(Map<FlowerType, Integer> flowers, PackageType packageType, String name, long orderId) {
	super();
	this.flowers = flowers;
	this.packageType = packageType;
	if (name != null && name.length() >= NAME_MIN_LENGTH && name.length() <= NAME_MAX_LENGTH) {
	    this.name = name;
	} else {
	    this.name = "Клиент#" + orderId;
	}
    }

    public Map<FlowerType, Integer> getFlowers() {
	return flowers;
    }

    public PackageType getPackageType() {
	return packageType;
    }

    public String getName() {
	return name;
    }

    public void newComponent(FlowerType flower) {
	if (this.flowers.containsKey(flower)) {
	    this.flowers.put(flower, this.flowers.get(flower) + 1);
	} else {
	    this.flowers.put(flower, 1);
	}
    }
    



}
    




// public static final int MAX_FLOWERS_NUMBER = 10;



//public BigDecimal getPrice() {
//BigDecimal result = packageType.getPrice();
//for (Map.Entry<FlowerType, Integer> entry : getFlowers().entrySet()) {
//result =
//result.add(entry.getKey().getPrice().multiply(BigDecimal.valueOf(entry.getValue())));
//}
//return result;
//}