
public class Tester {

    public static void main(String[] args) {

        String message = "My test works totally fine";
        FrequencyTable ft = new FrequencyTable();

        ft.buildFrequencyTable(message);
        //ft.printFrequencyTable();

        HuffmanTree tree = new HuffmanTree(ft.getFrequencyTable());
        Encoder encoder = new Encoder(tree.getRoot(), ft);
        encoder.printEncodedMessage(message);

    }

}
