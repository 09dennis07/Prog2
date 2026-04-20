package de.tha.prog2.task1;

public interface Completable {
	
	public Completable complete();
	
	default public int getCompletionStatus() {
		return 0;
	}
	

}
