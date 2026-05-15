package test;

import org.junit.jupiter.api.Test;

import classes.AutomaticTask;
import classes.CleaningTask;
import classes.PlanningTask;
import classes.TaskManager;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {
	TaskManager taskManager = new TaskManager(2);

	AutomaticTask task1 = new AutomaticTask("Staubsaugen", "Roboter");
	AutomaticTask task2 = new AutomaticTask("Geschirr spülen", "Geschirrspüler");
	CleaningTask task3 = new CleaningTask("Küche putzen", 1, 2);
	PlanningTask task4 = new PlanningTask("Zeitplan erstellen", 1, 1);

	@Test
	void testAddTask() {
		assertAll(
				() -> assertTrue(taskManager.addTask(task1)),
				() -> assertTrue(taskManager.addTask(task3)),
				() -> assertFalse(taskManager.addTask(task4))
		);
	}

	@Test
	void testGetAutomaticTasks() {
		taskManager.addTask(task1);
		taskManager.addTask(task2);
		taskManager.addTask(task3);
		taskManager.addTask(task4);

		AutomaticTask[] result = {task1, task2};
		assertArrayEquals(result, taskManager.getAutomaticTasks());

	}
}