package by.tataranovich.shop.runner;


import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.tataranovich.shop.exception.ProjectException;
import by.tataranovich.shop.modelshop.Check;
import by.tataranovich.shop.modelshop.Order;
import by.tataranovich.shop.reader.DataReader;
import by.tataranovich.shop.writer.DataWriter;

public class MainRun {
    static Logger logger = LogManager.getLogger();

    public static void main(String[] args)  {

	logger.log(Level.INFO, "Принимаем заказы");

	List<Order> orders;
	try {
	    orders = DataReader.readFile("Data//input.txt");
	    for (Order order : orders) {
		Check check = new Check(order);
		System.out.println(check);
		long forFilename = new Date().getTime();
		
		    //DataWriter.writeInFile("ChecksPDF//"+ forFilename + "Check.pdf", order);
		
	    }
	} catch (ProjectException e) {
	    logger.log(Level.FATAL, e.getMessage());
	}
    }
}


















// } catch (ProjectException e) {
// logger.log(Level.FATAL, "File NOT found");
// }

// } catch (DocumentException e) {
// throw new ProjectException("Document", e);
// // e.printStackTrace();
// // logger.log(Level.FATAL, "File NOT found");
// }
// logger.info("Evrika");

/*
 * int orderId = 1; Map<FlowerType, Integer> map = new HashMap<FlowerType,
 * Integer>(); map.put(FlowerType.NARCISSE, 5); map.put(FlowerType.POPPY, 5);
 * 
 * Bouqet bouqet =new Bouqet(map, PackageType.REGULAR, "hhhhhhh", orderId);
 * Order order = new Order(bouqet, orderId, 2, 3);
 * 
 * Check check = new Check(order); System.out.println(check.toString());
 */

// public class MainRun {
// static Logger logger = LogManager.getLogger();
//
// public static void main(String[] args) throws DocumentException {
// logger.log(Level.INFO, "Принимаем заказы");
// /*
// * int orderId = 1; Map<FlowerType, Integer> map = new HashMap<FlowerType,
// * Integer>(); map.put(FlowerType.NARCISSE, 5); map.put(FlowerType.POPPY, 5);
// *
// * Bouqet bouqet =new Bouqet(map, PackageType.REGULAR, "hhhhhhh", orderId);
// * Order order = new Order(bouqet, orderId, 2, 3);
// *
// * Check check = new Check(order); System.out.println(check.toString());
// */
// try {
// List<Order> orders = DataReader.readFile("");
//
// for (Order order : orders) {
// Check check = new Check(order);
// System.out.println(check);
// DataWriter.writeInFile("Check1.pdf", order);
// }
// } catch (IOException e) {
//
// // e.printStackTrace();
// // logger.error("negative scene: ", e);
// logger.log(Level.FATAL, "fatal error");
// }
// logger.info("Evrika");
// }
//
// }
