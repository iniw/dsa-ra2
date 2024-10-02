package org.puc;

public class UnknownMorseCharacterException extends Exception {
    public UnknownMorseCharacterException(String morse) {
        super(String.format("Morse code character was not found: \"%s\"", morse));
    }
}
