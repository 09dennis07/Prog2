package de.tha.prog2.task1;

public abstract class AbstractTask implements Completable {

	private String taskName;

	public AbstractTask(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskName() {
		return taskName;
	}

	public String toString() {
		return this.getTaskName();
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o instanceof AbstractTask) {
			AbstractTask other = (AbstractTask) o;
			if (this.taskName.equals(other.getTaskName())) {
				return true;
			}
		}
		return false;
	}

}
