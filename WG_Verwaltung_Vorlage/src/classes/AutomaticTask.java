package classes;

import exceptions.TaskException;
import interfaces.Assignable;
import interfaces.Executable;

public class AutomaticTask extends AbstractTask implements Executable, Assignable {
	
	private final String deviceName;
	private boolean isCharged;

	public AutomaticTask(String deviceName, String taskName) {
		super(taskName);
		this.deviceName = deviceName;
		isCharged = false;
	}
	
	public boolean executeTask() {
		return true;
	}
	
	public void charge() {
		isCharged = true;
	}
	
	public boolean getIsCharged() {
		return isCharged;
	}
	
}
