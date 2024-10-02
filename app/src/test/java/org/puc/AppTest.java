package org.puc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    static final MorseBinaryTree filledTree = MorseBinaryTree.filled();
    static final MorseBinaryTree emptyTree = new MorseBinaryTree();

    @Test
    void findSOS() {
        assertDoesNotThrow(() -> assertEquals(filledTree.find("...", "---", "..."), "SOS"));
        assertDoesNotThrow(() -> assertEquals(filledTree.find(".-", "-...", "-.-."), "ABC"));
    }

    @Test
    void unknownMorseCharacter() {
        // Empty tree cant find any character
        assertThrows(UnknownMorseCharacterException.class, () -> emptyTree.find("...", "---", "..."));
        assertThrows(UnknownMorseCharacterException.class, () -> emptyTree.find(".-", "-...", "-.."));
    }

    @Test
    void illegalInsert() {
        // Empty morse code
        assertThrows(IllegalArgumentException.class, () -> filledTree.insert('c', ""));
        // Invalid morse code
        assertThrows(IllegalArgumentException.class, () -> filledTree.insert('c', "C"));
    }

    @Test
    void illegalFind() {
        // Nothing to find
        assertThrows(IllegalArgumentException.class, () -> filledTree.find());
        // Empty string
        assertThrows(IllegalArgumentException.class, () -> filledTree.find(""));
        // Invalid morse code
        assertThrows(IllegalArgumentException.class, () -> filledTree.find("b"));
    }
}
