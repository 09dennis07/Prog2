package de.tha.prog2.task2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class DataReader implements IDataReader {

	@Override
	public ListContainer getListContainer(InputStream in) throws ClassNotFoundException, IOException {
		ObjectInputStream data = new ObjectInputStream(in);
		while (true) {
			try {
				Object o = data.readObject();
				if (o instanceof ListContainer lc) {
					return lc;
				}
			} catch (EOFException eofe) {
				return null;
			}
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		InputStream in = new FileInputStream("data/task2/data.serialized");
		
		DataReader dr = new DataReader();
		
		ListContainer lc = dr.getListContainer(in);
		
		System.out.println(lc.getIntegerList());
		System.out.println(lc.getStringList());
		
	}

}
