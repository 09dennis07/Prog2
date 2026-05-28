package de.tha.prog2;

public class SimpleToDo extends AbstractToDo{

	public SimpleToDo(String title) {
		super(title);
	}
	
	public int getCompletionStatus() {
		if (completed) {
			return 100;
		} else {
			return 0;
		}
	}
	
	public boolean equals(Object o) {
		if (o instanceof SimpleToDo other) {
			if (this.getTitle().equals(other.getTitle())&& this.getCompletionStatus()  == other.getCompletionStatus()) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		return getTitle() + " " + getCompletionStatus();
	}

}
