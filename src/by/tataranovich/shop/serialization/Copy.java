package by.tataranovich.shop.serialization;
//package by.tataranovich.serialization;
//
//import java.io.IOException;
//import java.io.InvalidObjectException;
//
//import java.util.List;
//
//import by.tataranovich.model.Check;
//import by.tataranovich.model.Order;
//import by.tataranovich.parser.FileParser;
//
//public class RunnerSerialization {
//    public static void main(String[] args) {
//
//	
//	// создание и запись объекта
//	// List<Check> checks = new ArrayList<Check>();
//	// Check check = new Check();
//	try {
//	    List<Order> orders = FileParser.parseFile("");
//	    for (Order order : orders) {
//		Check check = new Check(order);
//		String file = "ChecksDay.bin";
//		Serializator sz = new Serializator();
//		boolean b = sz.serialization(check, file);
//		// checks.add(check);
//		System.out.println(check);
//	    
//	//String file = "ChecksDay.bin";
//	//Serializator sz = new Serializator();
//	// System.out.println(check);
//	//boolean b = sz.serialization(Сheck, file);
//	// чтение и вывод объекта
//	Check res = null;
//	try {
//	    res = sz.deserialization(file);
//	} catch (InvalidObjectException e) {
//	    // обработка
//	    e.printStackTrace();
//	}
//	System.out.println(res);
//	    }
//	} catch (IOException e) {
//
//	    e.printStackTrace();
//	}
//	
//    }
//}