package by.tataranovich.shop.reader;

import java.io.File;
import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import by.tataranovich.shop.exception.ProjectException;
import by.tataranovich.shop.modelshop.*;

public class DataReader {

    private static final String DEFAULT_FILENAME = "Data//input.txt";

    public static List<Order> readFile(String fileName) throws ProjectException {
	List<Order> listOrder = new ArrayList<Order>();
	File file = new File(fileName);
	if (!file.exists()) {
	    file = new File(DEFAULT_FILENAME);
	}

	try (Scanner scan = new Scanner(file);) {
	    long orderId = new Date().getTime();
	    while (scan.hasNextLine()) {
		String line = scan.nextLine();
		try (Scanner scannerLine = new Scanner(line);) { //
		    int clientId = scannerLine.nextInt();
		    int bouqetCount = scannerLine.nextInt();
		    PackageType packageType = PackageType.getPackageTypeByName(scannerLine.next()); // .toLowerCase()
		    String bouqetName = scannerLine.next();
		    Map<FlowerType, Integer> map = new HashMap<>();
		    while (scannerLine.hasNext()) {
			map.put(FlowerType.getFlowerByName(scannerLine.next()), scannerLine.nextInt());
		    }
		    Bouqet bouqet = new Bouqet(map, packageType, bouqetName, orderId);
		    Order order = new Order(bouqet, orderId, clientId, bouqetCount);
		    listOrder.add(order);
		}
	    }

	} catch (FileNotFoundException e) {
	    throw new ProjectException("File NOT found", e);

	}
	return listOrder;
    }
}













// if (bouqetCount > Order.MAX_BOUQETCOUNT) {
// try { throw new IllegalArgumentException();
// } catch (IllegalArgumentException e) {
// System.out.println("Кол-во букетов ограничено до 10 шт.в одном заказе")
// bouqetCount = Order.MAX_BOUQETCOUNT;
// }
// }

// catch (System.out.println(e.getmessage())) {
// if (bouqetCount>Order.MAX_BOUQETCOUNT) {
// throw Illegalcountexeption ("Кол-во букетов ограничено до 10 шт.в одном
// заказе");
// }
// }

// private static Exception Illegalcountexeption(String string) {
// // TODO Auto-generated method stub
// return null;
// }
