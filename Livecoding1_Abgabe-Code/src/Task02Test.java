package de.tha.prog2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task02Test {

    @Test
    void newComplexToDoShouldInitiallyHaveNoProgress() {
        ComplexToDo todo = new ComplexToDo("Projekt", 3);

        assertEquals("Projekt", todo.getTitle());
        assertEquals(0, todo.getCompletionStatus());
    }

    @Test
    void addToDoShouldIncreaseContainedTasks() {
        ComplexToDo complex = new ComplexToDo("Hausarbeit", 2);
        complex.addToDo(new SimpleToDo("Einleitung"));
        complex.addToDo(new SimpleToDo("Fazit"));

        String text = complex.toString();
        assertTrue(text.contains("Hausarbeit"));
        assertTrue(text.contains("Einleitung"));
        assertTrue(text.contains("Fazit"));
    }

    @Test
    void addToDoShouldThrowExceptionWhenFull() {
        ComplexToDo complex = new ComplexToDo("Projekt", 1);
        complex.addToDo(new SimpleToDo("Teil 1"));

        assertThrows(RuntimeException.class, () ->
                complex.addToDo(new SimpleToDo("Teil 2"))
        );
    }

    @Test
    void completionStatusShouldBeAverageOfSubTasks() {
        ComplexToDo complex = new ComplexToDo("Projekt", 3);
        SimpleToDo t1 = new SimpleToDo("A");
        SimpleToDo t2 = new SimpleToDo("B");

        complex.addToDo(t1);
        complex.addToDo(t2);

        assertEquals(0, complex.getCompletionStatus());

        t1.complete();
        assertEquals(50, complex.getCompletionStatus());

        t2.complete();
        assertEquals(100, complex.getCompletionStatus());
    }

    @Test
    void completeShouldCompleteAllSubTasks() {
        ComplexToDo complex = new ComplexToDo("Projekt", 2);
        SimpleToDo t1 = new SimpleToDo("A");
        SimpleToDo t2 = new SimpleToDo("B");

        complex.addToDo(t1);
        complex.addToDo(t2);

        Completable result = complex.complete();

        assertSame(complex, result);
        assertEquals(100, t1.getCompletionStatus());
        assertEquals(100, t2.getCompletionStatus());
        assertEquals(100, complex.getCompletionStatus());
    }

    @Test
    void equalsShouldCompareTitleAndOrderOfSubTasks() {
        ComplexToDo c1 = new ComplexToDo("Projekt", 2);
        ComplexToDo c2 = new ComplexToDo("Projekt", 2);

        c1.addToDo(new SimpleToDo("A"));
        c1.addToDo(new SimpleToDo("B"));

        c2.addToDo(new SimpleToDo("A"));
        c2.addToDo(new SimpleToDo("B"));

        assertEquals(c1, c2);
    }

    @Test
    void equalsShouldBeFalseForDifferentOrder() {
        ComplexToDo c1 = new ComplexToDo("Projekt", 2);
        ComplexToDo c2 = new ComplexToDo("Projekt", 2);

        c1.addToDo(new SimpleToDo("A"));
        c1.addToDo(new SimpleToDo("B"));

        c2.addToDo(new SimpleToDo("B"));
        c2.addToDo(new SimpleToDo("A"));

        assertNotEquals(c1, c2);
    }

    @Test
    void toStringShouldContainTitleProgressAndSubTasks() {
        ComplexToDo complex = new ComplexToDo("Projekt", 2);
        complex.addToDo(new SimpleToDo("Analyse"));
        complex.addToDo(new SimpleToDo("Implementierung"));

        String text = complex.toString();

        assertTrue(text.contains("Projekt"));
        assertTrue(text.contains("Analyse"));
        assertTrue(text.contains("Implementierung"));
    }
}