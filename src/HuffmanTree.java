import java.util.List;

public class HuffmanTree {

    private Node root;
    private List<Node> forest;


    /**
     * Construct a Huffman Tree based on the forest of single Huffman Nodes.
     *
     * @param forest - a list of single Huffman Nodes.
     */
    public HuffmanTree(List<Node> forest) {
        this.forest = forest;
        buildHuffmanTree();
        root = forest.get(0);

    }


    /**
     * This method builds a Huffman Tree based on the forest of single Nodes.
     * 1. - find two minimum nodes and create a subtree with the value of the sum of these two nodes.
     * 2. - remove these two nodes from the list.
     * 3. - add a subtree to the list.
     * 4. - repeat this process while there is just one element in the list.
     */
    public void buildHuffmanTree() {

        while (forest.size() > 1) {
            int min1 = findMinimumFrequency();
            Node left = forest.get(min1);
            left.edge = 0;
            forest.remove(min1);

            int min2 = findMinimumFrequency();
            Node right = forest.get(min2);
            right.edge = 1;
            forest.remove(min2);

            Node parent = new Node(null);
            parent.left = left;
            parent.right = right;
            parent.frequency = left.frequency + right.frequency;

            forest.add(parent);
        }
    }


    // HELPER METHODS
    /**
     * A method to find the Node with the minimum Huffman Code frequency value.
     *
     * @return - returns the index of the node with the minim frequency value.
     */
    private int findMinimumFrequency() {

        int min = 0;

        for (int i = 1; i < forest.size(); i++) {
            if (forest.get(i).frequency < forest.get(min).frequency)
                min = i;
        }

        return min;
    }

    /**
     * This method returns the root element of Huffman Tree.
     *
     * @return - the root of a Huffman Tree.
     */
    public Node getRoot() {
        return root;
    }

}
