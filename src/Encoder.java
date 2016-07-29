import java.util.HashMap;

public class Encoder {

    // A string representing bits required to encode a unique character.
    private StringBuilder bits;

    // A collection of encoded characters
    private HashMap<Character, String> codes;

    // A frequency table
    private FrequencyTable ft;

    // An encoded text.
    private String encodedText;


    public Encoder(Node tree, FrequencyTable ft) {
        bits = new StringBuilder();
        codes = new HashMap<>();
        this.ft = ft;
        buildHuffmanCodes(tree);
    }


    /**
     * A recursive method to build Huffman Codes for all occurrences of unique characters.
     * @param tree - the root of Huffman Tree.
     */
    private void buildHuffmanCodes(Node tree) {

        // traverse left node
        if (tree.left != null) {
            bits.append('0');
            buildHuffmanCodes(tree.left);
            bits.deleteCharAt(bits.length() - 1);
        }

        // check data
        if (tree.data != null) {
            String bitcode = bits.toString();
            codes.put(tree.data, bitcode);
        }

        // traverse right node
        if (tree.right != null) {
            bits.append('1');
            buildHuffmanCodes(tree.right);
            bits.deleteCharAt(bits.length() - 1);
        }

    }


    /**
     * A method print a table of all unique characters that occur in input text and print out encoded bits stream.
     * @param message - input text.
     */
    public void printEncodedMessage(String message) {
        System.out.println("==========================================");
        System.out.printf("%s %20s %10s\n", "char", "frequency", "code");
        System.out.println("------------------------------------------");

        StringBuilder sb = new StringBuilder();     // string builder with encoded bit stream
        String occurrences = ft.getOccurrences();   // a string with unique character occurrences
        Character ch;
        int totalEncodedBits = 0;                   // total number of bits for encoded text.

        // print out all character occurrences
        for (int i = 0; i < occurrences.length(); i++) {
            ch = occurrences.charAt(i);

            // %s is a placeholder for the string
            // '-' makes the result left-justified
            // 15 is the width of the first string
            System.out.printf("%-15c %-15d %s\n", ch, ft.getFrequency(ch),  codes.get(ch));
        }
        System.out.println("==========================================");


        System.out.println("\nEncoded bit stream: ");

        // print out encoded bit stream and calculate total number of bits needed to encode input text
        for (int i = 0; i < message.length(); i++) {
            ch = message.charAt(i);                         // current character from input text
            totalEncodedBits += codes.get(ch).length();     // count bits
            sb.append(codes.get(ch));                       // append bit codes
            System.out.print(codes.get(ch));
        }

        encodedText = sb.toString();

        System.out.printf("\n\n%s %d", "Total number of bits without Huffman coding: ", message.length() * 16);
        System.out.printf("\n%s %d\n", "Total number of bits with Huffman coding: ", totalEncodedBits);

    }


    /**
     * A method to get encoded bit stream.
     *
     * @return - encoded message as bit stream.
     */
    public String getEncodedText() {
        return encodedText;
    }

}
