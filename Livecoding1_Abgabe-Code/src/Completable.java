package de.tha.prog2;

public interface Completable {
	
	public Completable complete();
	
	default int getCompletionStatus() {
		return 0;
	}

}
