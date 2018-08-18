package by.tataranovich.shop.serialization;

import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.List;

import by.tataranovich.shop.exception.ProjectException;
import by.tataranovich.shop.modelshop.Check;
import by.tataranovich.shop.modelshop.Order;
import by.tataranovich.shop.reader.DataReader;

public class RunnerSerialization {
    public static void main(String[] args) {

	List<Check> checks = new ArrayList<Check>();
	// создание и запись объекта
	// List<Check> checks = new ArrayList<Check>();
	// Check check = new Check();

	List<Order> orders;
	try {
	    orders = DataReader.readFile("");
	    for (Order order : orders) {
		Check check = new Check(order);
		checks.add(check);
		String file = "ChecksDay1.bin";
		Serializator sz = new Serializator();
		boolean b = sz.serialization(checks, file);
		// System.out.println(checks);
	    }
	} catch (ProjectException e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}

	String file = "ChecksDay1.bin";
	Serializator sz = new Serializator();
	// System.out.println(check);
	// boolean b = sz.serialization(Сheck, file);
	// чтение и вывод объекта
	// Check res = null;
	// List <Check> checks;
	try {
	    checks = sz.deserialization(file);
	} catch (InvalidObjectException e) {
	    // обработка
	    e.printStackTrace();
	}

	for (Check check : checks) {
	    System.out.println(check);
	}

    }
}

/*
 * package by.tataranovich.shop.serialization;
 * 
 * import java.io.IOException; import java.io.InvalidObjectException; import
 * java.util.ArrayList; import java.util.List;
 * 
 * import by.tataranovich.shop.exception.ProjectException; import
 * by.tataranovich.shop.modelshop.Check; import
 * by.tataranovich.shop.modelshop.Order; import
 * by.tataranovich.shop.reader.DataReader;
 * 
 * public class RunnerSerialization { public static void main(String[] args) {
 * 
 * List<Check> checks = new ArrayList<Check>(); // создание и запись объекта //
 * List<Check> checks = new ArrayList<Check>(); // Check check = new Check();
 * try { List<Order> orders; try { orders = DataReader.readFile(""); for (Order
 * order : orders) { Check check = new Check(order); checks.add(check); String
 * file = "ChecksDay.bin"; Serializator sz = new Serializator(); boolean b =
 * sz.serialization(checks, file);
 * 
 * // System.out.println(checks); } } catch (ProjectException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); }
 * 
 * } catch (InvalidObjectException e) { // обработка e.printStackTrace(); }
 * String file = "ChecksDay.bin"; Serializator sz = new Serializator(); //
 * System.out.println(check); // boolean b = sz.serialization(Сheck, file); //
 * чтение и вывод объекта // Check res = null; // List <Check> checks; try {
 * checks = sz.deserialization(file); } catch (InvalidObjectException e) { //
 * обработка e.printStackTrace(); }
 * 
 * for (Check check : checks) { System.out.println(check); }
 * 
 * } }
 */