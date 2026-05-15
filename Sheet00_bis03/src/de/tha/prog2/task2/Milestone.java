package de.tha.prog2.task2;

import java.util.Arrays;

import de.tha.prog2.task1.Completable;

public class Milestone implements Prioritizable, Completable {

	private String milestoneName;
	private Completable[] tasks;
	private Priority priority;

	public Milestone(String milestoneName, int maxTasks, Priority priority) {
		this.milestoneName = milestoneName;
		this.priority =priority;
		tasks = new Completable[maxTasks];
	}

	public Milestone(String milestoneName, int maxTasks) {
		this(milestoneName, maxTasks, Priority.MEDIUM);
	}

	public Completable complete() {
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i] != null) {
			tasks[i].complete();
			}
		}
		return this;
	}

	public int getCompletionStatus() {
		int completionSum = 0;
		int count = 0;
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i] != null) {
			completionSum += tasks[i].getCompletionStatus();
			count++;
			}
		}
		if (count == 0) {
			return 0;
		}
		return completionSum / count;
	}

	public void addTask(Completable c) throws MaxTasksReachedException {
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i] == null) {
				tasks[i] = c;
				return;
			}
		}
		throw new MaxTasksReachedException("Maximale Tasks im Milestone bereits erreicht!");
	}
	
	public boolean equals(Object o) {
		if (o instanceof Milestone other) {
			if (this.milestoneName.equals(other.milestoneName) && this.priority == other.priority && Arrays.equals(this.tasks, other.tasks)) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String ausgabe = "";
		ausgabe += milestoneName + getPriority() +": " + getCompletionStatus() + "\n";
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i] != null) {
			ausgabe += tasks[i].toString();
			}
		}
		return ausgabe;
	}

	@Override
	public void setPriority(Priority p) {
		this.priority = p;
	}

	@Override
	public Priority getPriority() {
		return priority;
	}

}
