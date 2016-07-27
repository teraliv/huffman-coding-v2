
public class Tester {

    public static void main(String[] args) {
        FrequencyTable ft = new FrequencyTable();

        ft.buildFrequencyTable("My test works totaly fine");
        ft.printFrequencyTable();

        HuffmanTree tree = new HuffmanTree(ft.getFrequencyTable());
        ft.printFrequencyTable();


    }

}
