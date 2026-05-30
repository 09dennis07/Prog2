package de.tha.prog2.task1;

/**
 * Interface für einen Text-Validator.
 * Implementieren Sie dieses Interface mittels einer anonymen Klasse
 * in der Methode TextValidator.getValidator().
 */
public interface Validator {

    /**
     * Prüft, ob der übergebene String eine gültige E-Mail-Adresse ist.
     * Eine gültige E-Mail enthält genau ein '@'-Zeichen sowie mindestens
     * einen Punkt nach dem '@'.
     *
     * @param input der zu prüfende String
     * @return true, wenn der String eine gültige E-Mail-Adresse ist
     */
    boolean isEmail(String input);

    /**
     * Prüft, ob der übergebene String ein Palindrom ist.
     * Groß-/Kleinschreibung und Leerzeichen werden ignoriert.
     *
     * @param input der zu prüfende String
     * @return true, wenn der String (bereinigt) ein Palindrom ist
     */
    boolean isPalindrome(String input);
}
