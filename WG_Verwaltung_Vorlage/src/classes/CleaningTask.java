package classes;

import exceptions.*;
import interfaces.*;

public class CleaningTask extends AbstractTask implements Assignable, Executable {
	
	public CleaningTask(String taskName, int minUsers, int maxUsers) {
		super(taskName, minUsers, maxUsers);
	}
	
	public boolean executeTask() {
		return true;
	}
	
	public boolean assignUser(String taksName) {
		return true;
	}
	
}
