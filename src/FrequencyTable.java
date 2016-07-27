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



    // HELPER METHODS

    /**
     * A method to check if the Huffman Frequency Table contains particular character.
     *
     * @param ch - character to check if it exist in the list.
     * @return - returns true if character exists, otherwise false.
     */
    private boolean containsCharacter(Character ch) {

        for (int i = 0; i < forest.size(); i ++) {

            if (forest.get(i).data == ch)
                return true;
        }

        return false;
    }


    /**
     * A method to update frequency by 1 for particular character in Huffman Frequency Table.
     *
     * @param ch - the character to update frequency.
     */
    private void updateFrequency(Character ch) {

        for (int i = 0; i < forest.size(); i++) {

            if (forest.get(i).data == ch) {
                forest.get(i).frequency++;
                return;
            }
        }

    }


    /**
     * A method to add new character to the Huffman Frequency Table and set its frequency to 1.
     *
     * @param ch - new character to add to Huffman Frequency Table.
     */
    private void addFrequency(Character ch) {

        Node node = new Node(ch);
        forest.add(node);
    }


    /**
     * A helper method to print content of Huffman Frequency Table.
     */
    public void printFrequencyTable() {

        for (int i = 0; i < forest.size(); i++) {
            System.out.println(forest.get(i).data + " : " + forest.get(i).frequency);
        }

    }


    public List<Node> getFrequencyTable() {
        return forest;
    }

}
