package collections;

import java.util.*;

class NameComparator implements Comparator<Name> {

	public int compare(Name n1, Name n2) {
		int lastCmp = n1.lastName().compareTo(n2.lastName());
		return (lastCmp != 0 ? lastCmp : n1.firstName().compareTo(n2.firstName()));
	}
}

class Name {

	private String firstName, lastName;

	public Name(String firstName, String lastName) {
		if (firstName == null || lastName == null)
			throw new IllegalArgumentException();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String firstName() {
		return firstName;
	}

	public String lastName() {
		return lastName;
	}

	public boolean equals(Object o) {
		if (!(o instanceof Name))
			return false;
		Name n = (Name) o;
		return n.firstName.equals(firstName) && n.lastName.equals(lastName);
	}

	public int hashCode() {
		return 31 * firstName.hashCode() + lastName.hashCode();
	}

	public String toString() {
		return firstName + " " + lastName;
	}

}

public class NameSort {
	public static void main(String args[]) {
		Name n[] = { new Name("Charly", "Chaplin"), new Name("Karl", "Marx"), new Name("Groucho", "Marx"),
				new Name("Karl", "Valentin") };
		List<Name> nameList = Arrays.asList(n);
		Collections.sort(nameList, new NameComparator());
		System.out.println(nameList);
	}
}