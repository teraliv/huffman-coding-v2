
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
     * There are two types of nodes:
     * 1 - A node with character data means the node is the leaf.
     * 2 - A node with null data means a parent node.
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
