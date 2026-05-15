package de.tha.prog2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task03Test {

    @Test
    void addShouldStoreTodosInApp() {
        ToDoApp app = new ToDoApp("Meine App");
        SimpleToDo todo = new SimpleToDo("Lernen");

        app.add(todo);

        String text = app.toString();
        assertTrue(text.contains("Lernen"));
    }

    @Test
    void deleteAllCompletedShouldRemoveCompletedTodos() {
        ToDoApp app = new ToDoApp("Meine App");

        SimpleToDo open = new SimpleToDo("Offen");
        SimpleToDo done = new SimpleToDo("Erledigt");
        done.complete();

        app.add(open);
        app.add(done);

        app.deleteAllCompleted();

        String text = app.toString();
        assertTrue(text.contains("Offen"));
        assertFalse(text.contains("Erledigt"));
    }

    @Test
    void deleteAllCompletedShouldKeepOpenTodos() {
        ToDoApp app = new ToDoApp("Meine App");

        SimpleToDo t1 = new SimpleToDo("A");
        SimpleToDo t2 = new SimpleToDo("B");

        app.add(t1);
        app.add(t2);

        app.deleteAllCompleted();

        String text = app.toString();
        assertTrue(text.contains("A"));
        assertTrue(text.contains("B"));
    }

    @Test
    void deleteAllCompletedShouldAlsoRemoveCompletedComplexTodos() {
        ToDoApp app = new ToDoApp("Meine App");

        ComplexToDo complex = new ComplexToDo("Projekt", 2);
        complex.addToDo(new SimpleToDo("Teil 1"));
        complex.addToDo(new SimpleToDo("Teil 2"));
        complex.complete();

        app.add(complex);
        app.deleteAllCompleted();

        String text = app.toString();
        assertFalse(text.contains("Projekt"));
    }
}