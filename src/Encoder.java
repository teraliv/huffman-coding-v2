import java.io.PrintWriter;
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


    /**
     * Constructs encoder to encode an input text.
     *
     * @param tree - Huffman Tree.
     * @param ft - Huffman Frequency table.
     */
    public Encoder(Node tree, FrequencyTable ft) {

        // check null condition
        if (tree == null || ft == null)
            throw new NullPointerException("Missing Huffman Tree or Frequency Table");

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
    public void printEncodedMessage(String message, PrintWriter writer) {

        String doubleLine = "==========================================";
        String header = String.format("%s %20s %10s", "char", "frequency", "code");
        String singleLine = "------------------------------------------";

        printAndWriteData(doubleLine, writer, true);
        printAndWriteData(header, writer, true);
        printAndWriteData(singleLine, writer, true);


        StringBuilder sb = new StringBuilder();     // string builder with encoded bit stream
        String occurrences = ft.getOccurrences();   // a string with unique character occurrences
        Character ch;
        int totalEncodedBits = 0;                   // total number of bits for encoded text.
        String outputLine;

        // print out all character occurrences
        for (int i = 0; i < occurrences.length(); i++) {
            ch = occurrences.charAt(i);

            // %s is a placeholder for the string
            // '-' makes the result left-justified
            // 15 is the width of the first string
            outputLine = String.format("%-15c %-15d %s\n", ch, ft.getFrequency(ch),  codes.get(ch));
            System.out.print(outputLine);
            writer.print(outputLine);
        }
        printAndWriteData(doubleLine, writer, true);

        printAndWriteData("\nEncoded bit stream: ", writer, true);

        // print out encoded bit stream and calculate total number of bits needed to encode input text
        for (int i = 0; i < message.length(); i++) {
            ch = message.charAt(i);                         // current character from input text
            totalEncodedBits += codes.get(ch).length();     // count bits
            sb.append(codes.get(ch));                       // append bit codes

            printAndWriteData(codes.get(ch), writer, false);
        }

        encodedText = sb.toString();

        String normal = String.format("\n\n%s %d", "Total number of bits without Huffman coding: ", message.length() * 16);
        String encoded = String.format("%s %d", "Total number of bits with Huffman coding: ", totalEncodedBits);

        printAndWriteData(normal, writer, true);
        printAndWriteData(encoded, writer, true);
    }


    /**
     * A method to get encoded bit stream.
     *
     * @return - encoded message as bit stream.
     */
    public String getEncodedText() {
        return encodedText;
    }


    // HELPER METHODS
    /**
     * A method to print and write string line.
     *
     * @param line - text line to output to the screen and write to the output file
     * @param writer - writes data into output text file.
     * @param newline - controls output with new line character or not.
     */
    private void printAndWriteData(String line, PrintWriter writer, boolean newline) {
        if (newline) {
            System.out.println(line);
            writer.println(line);
        }
        else {
            System.out.print(line);
            writer.print(line);
        }
    }

}
