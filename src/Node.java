
public class Node {

    // A character data
    Character data;

    // Left node
    Node left;

    // Right Node
    Node right;

    // Frequency of character that occur in input text.
    int frequency;

    /**
     * Constructs new Huffman Tree Node and initializes values.
     *
     * @param data - character that the node will contain.
     */
    public Node(Character data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.frequency = 1;
    }

}
