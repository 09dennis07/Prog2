package de.tha.prog2.task1;

public class SimpleTask extends AbstractTask {
	
	protected boolean completed;

	public SimpleTask(String taskName) {
		super(taskName);
		completed = false;
	}

	@Override
	public Completable complete() {
		completed = true;
		return this;
	}
	
	@Override
	public int getCompletionStatus() {
		if (completed) {
			return 100;
		} else {
			return 0;
		}
	}
	
	public String toString() {
		return getTaskName() + ": " + getCompletionStatus() + "%";
	}

}
