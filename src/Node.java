
public class Node {

    Character data;
    Node left;
    Node right;
    int frequency;
    int edge;

    public Node(Character data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.frequency = 1;
        this.edge = -1;
    }

}
