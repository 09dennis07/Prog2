package de.tha.prog2;

import java.util.Arrays;

public class ComplexToDo extends AbstractToDo {

	private AbstractToDo[] toDos;
	private int maxSize;
	private int size;

	public ComplexToDo(String title, int maxSize) {
		super(title);
		toDos = new AbstractToDo[maxSize];
	}

	public void addToDo(AbstractToDo todo) {
		if (size == 0 || size != maxSize) {
			toDos[size] = todo;
			size++;
		} else {
			throw new MaxCapacityExeption("ToDo-Liste ist bereits voll!");
		}
	}

	public Completable complete() {
		if (size != 0) {
			for (int i = 0; i < toDos.length; i++) {
				toDos[i].completed = completed;
		}
		}
		return this;
	}

	public int getCompletionStatus() {
		int sum = 0;
		int anzahl = 0;
		if (size != 0) {
			for (int i = 0; i < toDos.length; i++) {
				if (toDos[i].completed) {
					sum += 100;
					anzahl++;
				} else {
					sum += 0;
					anzahl++;
				}
			}
			if (anzahl != 0) {
				return (sum / anzahl);
			}
		} 
		return 0;
	}

	@Override
	public String toString() {
		String ausgabe = getTitle() + getCompletionStatus() + "\n";
		if (size != 0) {
			for (int i = 0; i < toDos.length; i++) {
				ausgabe += toDos[i].getTitle() + "\n";
			}
		}
		return ausgabe;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof ComplexToDo other) {
			if (this.getTitle().equals(other.getTitle()) && this.toString().equals(other.toString())) {
				return true;
			}
		}
		return false;
	}

}
