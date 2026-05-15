package test;

import org.junit.jupiter.api.Test;

import classes.AutomaticTask;

import static org.junit.jupiter.api.Assertions.*;

class AutomaticTaskTest {
	AutomaticTask task = new AutomaticTask("Staubsaugen", "Roboter");

	@Test
	void executeWithoutChargeThrowsException() {
		assertAll(
				() -> assertFalse(task.executeTask()),
				() -> assertFalse(task.getIsDone())
		);
	}

	@Test
	void executeAfterChargingWorks() {
		task.charge();
		task.executeTask();

		assertAll(
				() -> assertTrue(task.getIsDone()),
				() -> assertFalse(task.getIsCharged())
		);


	}

	@Test
	void executeTwiceRequiresRecharge() {
		task.charge();
		task.executeTask();

		assertAll(
				() -> assertTrue(task.getIsDone()),
				() -> assertFalse(task.executeTask()),
				() -> assertFalse(task.getIsCharged())
		);
	}

	@Test
	void chargeSetsStateCorrectly() {
		task.charge();
		assertTrue(task.getIsCharged());
	}
}