package classes;

import interfaces.Assignable;
import interfaces.Executable;

public abstract class AbstractTask implements Assignable, Executable {
	
	protected String taskName;

	protected String[] users;
	protected int userCount, minUsers, maxUsers;
	protected boolean isDone;
	
	public AbstractTask(String taskName) {
		this.taskName = taskName;
	}
	
	public AbstractTask(String taskName, int minUsers, int maxUsers) {
		this.taskName = taskName;
		this.minUsers = minUsers;
		this.maxUsers = maxUsers;
	}


	public String[] getUsers() {
		return users;
	}
	
	public boolean getIsDone() {
		return isDone;
	}
	
	public int getUserCount() {
		return userCount;
	}
	
}
