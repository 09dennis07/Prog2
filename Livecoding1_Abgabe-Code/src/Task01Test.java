package de.tha.prog2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task01Test {

    @Test
    void completeShouldSetStatusTo100() {
        SimpleToDo todo = new SimpleToDo("Lernen");

        Completable result = todo.complete();

        assertSame(todo, result);
        assertEquals(100, todo.getCompletionStatus());
    }

    @Test
    void equalObjectsShouldBeRecognized() {
        SimpleToDo t1 = new SimpleToDo("Sport");
        SimpleToDo t2 = new SimpleToDo("Sport");

        assertEquals(t1, t2);

        t1.complete();
        assertNotEquals(t1, t2);

        t2.complete();
        assertEquals(t1, t2);
    }

    @Test
    void toStringShouldContainTitleAndProgress() {
        SimpleToDo todo = new SimpleToDo("Kochen");

        String textBefore = todo.toString();
        assertTrue(textBefore.contains("Kochen"));
        assertTrue(textBefore.contains("0"));

        todo.complete();

        String textAfter = todo.toString();
        assertTrue(textAfter.contains("Kochen"));
        assertTrue(textAfter.contains("100"));
    }
}