import java.util.ArrayList;
import java.util.List;

public class FrequencyTable {

    // HashMap do not preserve the order of added keys, therefore LinkedHashMap is used.
    //private LinkedHashMap<Character, Integer> frequency;

    private List<Node> forest;  // A list to contain the forest of individual nodes.


    /** Constructs a new Huffman Frequency Table. */
    public FrequencyTable() {

        forest = new ArrayList<>();
    }



    /**
     * This method builds and populates Huffman Frequency Table base on the input string.
     *
     * @param message - input string to build frequency table.
     */
    public void buildFrequencyTable(String message) {

        Character ch;

        for (int i = 0; i < message.length(); i++) {

            ch = message.charAt(i); // current character

            if (containsCharacter(ch))
                updateFrequency(ch);
            else
                addFrequency(ch);
        }
    }


    public void buldHuffmanTree() {

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
    private boolean containsCharacter(Character ch) {

        for (int i = 0; i < forest.size(); i ++) {

            if (forest.get(i).data == ch)
                return true;
        }

        return false;
    }


    private void updateFrequency(Character ch) {

        for (int i = 0; i < forest.size(); i++) {

            if (forest.get(i).data == ch) {
                forest.get(i).frequency++;
                return;
            }
        }

    }


    private void addFrequency(Character ch) {

        Node node = new Node(ch);
        forest.add(node);
    }


    /**
     * A method to find the Node with the minimum Huffman Code frequency value.
     *
     * @return - returns the index of the node with the minim frequency value.
     */
    public int findMinimumFrequency() {

        int min = 0;

        for (int i = 1; i < forest.size(); i++) {
            if (forest.get(i).frequency < forest.get(min).frequency)
                min = i;
        }

        return min;
    }


    public void printFrequencyTable() {

        for (int i = 0; i < forest.size(); i++) {
            System.out.println(forest.get(i).data + " : " + forest.get(i).frequency);
        }

    }

}
