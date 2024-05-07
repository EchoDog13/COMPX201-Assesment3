
/**
 * Class to create nodes which are used in the implementation of a stack
 * Each Node contains a value (string), and a pointer to the next node in the stack
 */public class Node {
     //value of the node
    String value;
    //pointer to the next node
    Node next;

    /**
     * constructor for node
     * @param x value to store in the node
     */
    public Node(String x){
        value = x;
        next = null;
    }
}
