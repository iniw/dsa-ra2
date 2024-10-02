package org.puc;

class MorseBinaryTree {
    Node root;

    MorseBinaryTree() {
        root = new Node();
    }

    static MorseBinaryTree filled() {
        var tree = new MorseBinaryTree();

        for (char a = 'A'; a <= 'Z'; ++a)
            tree.insert(a, MorseUtils.alphanumericToMorse(a));

        for (char n = '0'; n <= '9'; ++n)
            tree.insert(n, MorseUtils.alphanumericToMorse(n));

        return tree;
    }

    void insert(char character, String morse) throws IllegalArgumentException {
        if (morse.isEmpty())
            throw new IllegalArgumentException("insert() called with empty morse code.");

        var node = root;
        for (var c : morse.toCharArray()) {
            switch (c) {
                case '.':
                    if (node.left == null)
                        node.left = new Node();
                    node = node.left;
                    break;
                case '-':
                    if (node.right == null)
                        node.right = new Node();
                    node = node.right;
                    break;
                default:
                    throw invalidMorseCharacter(c, morse);
            }
        }

        node.character = character;
    }

    String find(String... morses) throws UnknownMorseCharacterException, IllegalArgumentException {
        if (morses.length == 0)
            throw new IllegalArgumentException("find() called with no arguments.");

        var result = new StringBuilder();
        for (var morse : morses) {
            if (morse.isEmpty())
                throw new IllegalArgumentException("find() called with empty morse code.");

            result.append(find_character(morse));
        }
        return result.toString();
    }

    private char find_character(String morse) throws UnknownMorseCharacterException, IllegalArgumentException {
        assert !morse.isEmpty();

        var node = root;
        for (var c : morse.toCharArray()) {
            if (node == null)
                throw new UnknownMorseCharacterException(morse);

            switch (c) {
                case '.':
                    node = node.left;
                    break;
                case '-':
                    node = node.right;
                    break;
                default:
                    throw invalidMorseCharacter(c, morse);
            }
        }

        return node.character;
    }

    private enum NodeDirection {
        Left,
        Right,
    }

    void print() {
        printNodeRecursively(root, "", NodeDirection.Left);
    }

    private static void printNodeRecursively(Node node, String prefix, NodeDirection direction) {
        if (node == null)
            return;

        var nodePrefix = direction == NodeDirection.Left ? "├── " : "└── ";
        System.out.println(prefix + nodePrefix + node.character);

        var nextPrefix = prefix + (direction == NodeDirection.Left ? "│   " : "    ");
        printNodeRecursively(node.left, nextPrefix, NodeDirection.Left);
        printNodeRecursively(node.right, nextPrefix, NodeDirection.Right);

    }

    private static IllegalArgumentException invalidMorseCharacter(char c, String morse) {
        return new IllegalArgumentException(String.format(
                "Character \'%c\' (in string \"%s\") is not part of the morse alphabet.", c, morse));

    }

}
