
public class Decoder {

    // A bit stream of encoded message
    private String bitstream;

    // A decoded message
    private String decodedText;


    // Constructs a new decoder
    public Decoder(Node tree, String bitstream) {
        this.bitstream = bitstream;
        decodedText = decodeBitStream(tree);
    }


    /**
     * A method to decode a text based on the bit stream and Huffman Tree.
     * @param tree - Huffman Tree
     * @return - returns decoded message
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
     * A mthod just to print out decoded message.
     */
    public void printDecodedText() {
        System.out.printf("%s %s\n", "Decoded String: ", decodedText);
    }

}
