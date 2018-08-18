package by.tataranovich.shop.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import by.tataranovich.shop.modelshop.Check;

import java.io.IOException;
import java.io.InvalidClassException;
import java.io.FileNotFoundException;

public class Serializator {

    public boolean serialization(List <Check> check, String fileName) {
	boolean flag = false;
	File f = new File("ChecksDay.bin");
	ObjectOutputStream ostream = null;
	try {
	    FileOutputStream fos = new FileOutputStream(f);
	    if (fos != null) {
		ostream = new ObjectOutputStream(fos);
		ostream.writeObject(check); // ������������
		flag = true;
	    }
	} catch (FileNotFoundException e) {
	    System.err.println("���� �� ����� ���� ������: " + e);
	} catch (NotSerializableException e) {
	    System.err.println("����� �� ������������ ������������: " + e);
	} catch (IOException e) {
	    System.err.println(e);
	} finally {
	    try {
		if (ostream != null) {
		    ostream.close();
		}
	    } catch (IOException e) {
		System.err.println("������ �������� ������");
	    }
	}
	return flag;
    }

    public List<Check> deserialization(String fileName) throws InvalidObjectException {
	File fr = new File(fileName);
	ObjectInputStream istream = null;
	try {
	    FileInputStream fis = new FileInputStream(fr);
	    istream = new ObjectInputStream(fis);
	    // ��������������
	 List <Check> checks = (ArrayList <Check>) istream.readObject();
	    //System.out.println(istream.readObject());
	    return checks;
	    //return new Check();
	} catch (ClassNotFoundException ce) {
	    System.err.println("����� �� ����������: " + ce);
	} catch (FileNotFoundException e) {
	    System.err.println("���� ��� �������������� �� ����������: " + e);
	} catch (InvalidClassException ioe) {
	    System.err.println("������������ ������ �������: " + ioe);
	} catch (IOException ioe) {
	    System.err.println("����� I/O ������: " + ioe);
	} finally {
	    try {
		if (istream != null) {
		    istream.close();
		}
	    } catch (IOException e) {
		System.err.println("������ �������� ������ ");
	    }
	}
	throw new InvalidObjectException("������ �� ������������");
    }
}
