import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyTable {

    /* A table with a unique character and its occurrence in the input string. */
    private HashMap<Character, Integer> frequency;

    /* A list to contain the forest of individual nodes. */
    private List<Node> forest;

    /* A string with unique character occurrences of input text. */
    private StringBuilder occurrences;


    /** Constructs a new Huffman Frequency Table. */
    public FrequencyTable() {
        forest = new ArrayList<>();
        occurrences = new StringBuilder();
        frequency = new HashMap<>();
    }


    /**
     * This method builds and populates Huffman Frequency Table base on the input string.
     *
     * @param message - input string to build frequency table.
     */
    public void buildFrequencyTable(String message) {

        if (message == null) throw new NullPointerException("Input string is missing");

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

        frequency.put(ch, frequency.get(ch) + 1);

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
        frequency.put(ch, 1);
        occurrences.append(ch);
    }


    /**
     * A helper method to print content of Huffman Frequency Table.
     */
    public void printFrequencyTable() {
        for (int i = 0; i < forest.size(); i++)
            System.out.println(forest.get(i).data + " : " + forest.get(i).frequency);
    }

    /**
     * This method returns a forest of single Huffman Nodes.
     * Be careful to use this method when the Huffman Tree is done. This method will
     * return a list with the single root node in it.
     *
     * @return - returns a list with forest of single Huffman Nodes.
     */
    public List<Node> getFrequencyTable() {
        return forest;
    }


    /**
     * This method returns a string with the unique characters that occurs in the input text.
     *
     * @return - string of unique characters.
     */
    public String getOccurrences() {
        return occurrences.toString();
    }


    /**
     * This method returns a frequency of the character that appears in the input text.
     *
     * @param ch - character we need to find its occurrence in the input text.
     * @return - returns frequency of the character.
     */
    public int getFrequency(Character ch) {
        return frequency.get(ch);
    }

}
