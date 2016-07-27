
public class Node {

    Character data;
    Node left;
    Node right;
    int frequency;

    public Node(Character data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.frequency = 1;
    }

}
