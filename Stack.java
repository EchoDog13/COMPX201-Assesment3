/**
 * Implementation of a stack (Last In, First Out) providing push, pop
 */
public class Stack {
//Starting node in stack
    Node head;


    public Stack() {
        head = null;
    }

    /**
     * Method to add items to the stop of the stack
     * @param s takes string item to add to stack
     */
    public void push(String s){

        Node newNode = new Node(s);
        //Creates new node if head is null
        if (head == null) {
            head = newNode;
            //Adds to next front of stack if it contains items
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     *Method to the first item in the stack and return the value
     * @return returns a string, the value removed from the top of the stack
     */
    public  String pop(){
        //returns if stack is empty
        if (head == null){
            return null;
        }else{

            //Stores string value of popped item
            String poppedItem;
            //Gets value from item to be popped
            poppedItem = head.value;
             // Moves head's pointer to next item, removing the top item from hte list
            head = head.next;
            return poppedItem; 
        }
    }

    /**
     * Method to return the top item in the stack
     * @return  string value of the first item in the stack
     */
    public String peek(){
        //if head is null, stack is empty, so no items to return, thus return null
        if (head == null){
            return null;}
        //returns value of the first item in the list
        else{ return head.value;
            }
        }

    /**
     * Method to check if list contains items
     * @return boolean, true if list contains no items, false if list contains items
     */
        public boolean isEmpty(){
            //if head is null, list is empty, return true
            // else, list contains items, return false
            return head == null;
        }

    /**
     * Method to print all items in a stack
     * Prints stack from top to bottom
     */
        public void dump(){
            Node curr = head;
            //loops till end of list
            while (curr != null) {
                //prints current node
                System.out.print(curr.value + "->");
                //Moves to next node
                curr = curr.next;
    
            }
            System.out.println();
        }
    }

