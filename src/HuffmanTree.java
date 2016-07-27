import java.util.List;

public class HuffmanTree {

    private Node root;
    private List<Node> forest;


    public HuffmanTree(List<Node> forest) {

        this.forest = forest;
        buildHuffmanTree();
        root = forest.get(0);

    }


    /**
     * This method builds a Huffman Tree based on the forest of single Nodes.
     */
    public void buildHuffmanTree() {

        while (forest.size() > 1) {
            int min1 = findMinimumFrequency();
            Node left = forest.get(min1);
            forest.remove(min1);

            int min2 = findMinimumFrequency();
            Node right = forest.get(min2);
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


    public Node getRoot() {
        return root;
    }

}
