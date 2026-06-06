package de.tha.prog2.task2;

import java.io.IOException;
import java.io.InputStream;

public interface IDataReader {
	/**
	 * Deserializes Objects from the InputStream in and returns the first Instance 
	 * of {@link ListContainer} that is found in the Stream
	 */
	ListContainer getListContainer(InputStream in) throws ClassNotFoundException, IOException;
}
