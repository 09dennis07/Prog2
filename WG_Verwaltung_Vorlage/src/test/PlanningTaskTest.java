package test;

import org.junit.jupiter.api.Test;

import classes.PlanningTask;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlanningTaskTest {
	PlanningTask task = new PlanningTask("Zeitplan erstellen", 1, 2);
	String user1 = "Anna", user2 = "Bob", user3 = "Daniel";

	@Test
	void assignUser_successAndTooManyUsers() {
		assertAll(
				() -> assertTrue(task.assignUser(user1)),
				() -> assertArrayEquals(new String[]{user1}, Arrays.copyOf(task.getUsers(), task.getUserCount())),
				() -> assertTrue(task.assignUser(user2)),
				() -> assertArrayEquals(new String[]{user1, user2}, Arrays.copyOf(task.getUsers(), task.getUserCount())),

				() -> assertFalse(task.assignUser(user3)),
				() -> assertArrayEquals(new String[]{user1, user2}, Arrays.copyOf(task.getUsers(), task.getUserCount()))
		);
	}


	@Test
	void assignUser_invalidInput() {
		assertAll(
				() -> assertThrows(IllegalArgumentException.class, () -> task.assignUser(null)),
				() -> assertThrows(IllegalArgumentException.class, () -> task.assignUser(""))
		);
	}
}