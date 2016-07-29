import java.io.PrintWriter;

public class Decoder {

    // A bit stream of encoded text
    private String bitstream;

    // A decoded text
    private String decodedText;


    /**
     * Constructs a ned Huffmand Code decoder. Decoder decodes the bit stream into original message.
     *
     * @param tree - Huffman Tree.
     * @param bitstream - bit codes of encoded text.
     */
    public Decoder(Node tree, String bitstream) {

        // check null condition
        if (tree == null || bitstream == null)
            throw new NullPointerException("Missing Huffman Tree or bit stream");

        this.bitstream = bitstream;
        decodedText = decodeBitStream(tree);
    }


    /**
     * A method to decode a text based on the bit stream and Huffman Tree.
     * @param tree - Huffman Tree.
     * @return - returns decoded message.
     */
    private String decodeBitStream(Node tree) {

        StringBuilder decodedText = new StringBuilder();
        Node node = tree;

        for (int i = 0; i < bitstream.length(); i++) {

            // traverse left
            if (bitstream.charAt(i) == '0' && node.left != null) {
                node = node.left;   // go to the next left node

                // check if current Huffman Node contain data
                if (node.data != null) {
                    decodedText.append(node.data);
                    node = tree;
                }
            }
            // traverse right
            else if (bitstream.charAt(i) == '1' && node.right != null) {
                node = node.right;  // go to the next right node

                // check if current Huffman Node contain data
                if (node.data != null) {
                    decodedText.append(node.data);
                    node = tree;
                }
            }
        }

        return decodedText.toString();
    }


    /**
     * A method just to print out decoded message.
     *
     * @param writer - writes data into output text file.
     */
    public void printDecodedText(PrintWriter writer) {

        if (writer == null)
            throw new NullPointerException("Missing writer object");

        String output = String.format("\n%s %s\n", "Decoded String: ", decodedText);

        System.out.println(output);
        writer.println(output);
    }

}
