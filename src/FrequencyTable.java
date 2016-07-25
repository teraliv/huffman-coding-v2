import java.util.LinkedHashMap;

public class FrequencyTable {

    // HashMap do not preserve the order of added keys, therefore LinkedHashMap is used.
    private LinkedHashMap<Character, Integer> frequency;


    /**
     * Constructs a new Huffman Frequency Table.
     */
    public FrequencyTable() {

        frequency = new LinkedHashMap<>();
    }


    /**
     * This method builds and populates Huffman Frequency Table base on the input string.
     *
     * @param string - input string to build frequency table.
     */
    public void buildFrequencyTable(String string) {

        Character ch;   // character is a key to be added to the frequency table

        // read every character from the string and add frequency to the hashmap
        for (int i = 0; i < string.length(); i++) {
            ch = string.charAt(i);

            if (frequency.containsKey(ch))
                updateFrequency(ch);
            else
                addFrequency(ch);
        }
    }


    // HELPER METHODS
    private void updateFrequency(Character key) {

        frequency.put(key, frequency.get(key) + 1);

    }

    private void addFrequency(Character key) {

        frequency.put(key, 1);

    }

    public void printFrequencyTable() {

        for (Character ch : frequency.keySet()) {
            System.out.println(ch + ": " + frequency.get(ch));
        }

    }

}
