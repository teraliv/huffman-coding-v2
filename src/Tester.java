import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Tester {

    public static void main(String[] args) {

        String message = null;

        // checking command line arguments
        if (args.length == 0) {
            throw new IllegalArgumentException("Missing input text");
        }
        // input text should be at leas 2 characters
        else if (args[0].length() < 2) {
            System.out.println("Input text should be at leas 2 characters");
            System.exit(0);
        }
        else {
            message = concatCommandLineArguments(args);
        }


        PrintWriter writer = null;  // writer object to write output to the file

        try {
            writer = new PrintWriter(new FileOutputStream("output.txt", false));

            FrequencyTable ft = new FrequencyTable();
            ft.buildFrequencyTable(message);

            HuffmanTree tree = new HuffmanTree(ft.getFrequencyTable());
            Node root = tree.getRoot();

            Encoder encoder = new Encoder(root, ft);
            encoder.printEncodedMessage(message, writer);

            Decoder decoder = new Decoder(root, encoder.getEncodedText());
            decoder.printDecodedText(writer);


        }
        catch (FileNotFoundException e) {
            System.out.println("Error opening file " + e.getMessage());
        }
        finally {
            if (writer != null)
                writer.close();
        }
    }


    /**
     * A method to concatenate command line arguments to a string.
     *
     * @param args - command line arguments.
     * @return - concatenated string.
     */
    private static String concatCommandLineArguments(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < args.length; i++) {
            sb.append(args[i]);

            // do not append space at the end of the string
            if (i < args.length - 1)
                sb.append(' ');
        }

        return sb.toString();
    }
}
