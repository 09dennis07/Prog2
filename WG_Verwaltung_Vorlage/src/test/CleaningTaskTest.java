package test;

import org.junit.jupiter.api.Test;

import classes.CleaningTask;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CleaningTaskTest {
	CleaningTask task = new CleaningTask("Küche putzen", 1, 2);
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

	@Test
	void executeTask_success() {
		task.assignUser(user1);
		task.executeTask();

		assertTrue(task.getIsDone());
	}

	@Test
	void executeTask_tooFewUsers() {
		assertAll(
				() -> assertFalse(task.executeTask(), "executeTask should return false if too few users"),
				() -> assertFalse(task.getIsDone(), "Task should not be marked as done if too few users")
		);
	}
}