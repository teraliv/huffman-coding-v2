import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Tester {

    public static void main(String[] args) {

        String message = null;

        // check if there is an input text in command line arguments
        if (args.length == 0) {
            System.out.println("Missing input message");
            System.exit(0);
        }
        else {
            message = args[0];  // read input text from command line arguments
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

}
