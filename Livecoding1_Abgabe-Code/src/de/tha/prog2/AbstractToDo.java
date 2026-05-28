package de.tha.prog2;

public abstract class AbstractToDo implements Completable{
	
	private String title;
	protected boolean completed;
	
	public AbstractToDo(String title) {
		this.title = title;
		completed = false;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public Completable complete() {
		completed = true;
		return this;
	}

}
