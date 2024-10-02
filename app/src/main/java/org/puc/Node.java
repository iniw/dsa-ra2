package org.puc;

class Node {
    public static final char PLACEHOLDER = '✕';

    char character;
    Node left;
    Node right;

    public Node() {
        character = PLACEHOLDER;
    }

    public Node(char character) {
        this.character = character;
    }
}
