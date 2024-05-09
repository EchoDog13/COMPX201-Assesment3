/**
 * Implementation of a stack (Last In, First Out) providing push, pop, peek, and isEmpty functionality.
 */
public class Stack {
//Starting node in stack
    Node head;
    public Stack() {
        //points head to null node
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
        } else {
            //Adds to next front of stack if it contains items
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
             // Moves head's pointer to next item, thus removing the top item from the stack
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
            return null;
        }
        //returns value of the first item in the list
        else{
            return head.value;
            }
        }

        public int length(){
            int counter = 0;
            Node curr = head;
            while (curr != null){
                curr=curr.next;
                counter++;
            }
            return counter;
        }

    /**
     * Method to check if stack contains any items
     * @return boolean, true if stack contains no items, false if stack contains items
     */
        public boolean isEmpty(){
            //if head is null, stack is empty, return true
            // else, stack contains items, return false
            return head == null;
        }

    /**
     * Method to print all items in a stack
     * Prints stack from top to bottom
     */
        public void dump(){
            Node curr = head;
            //loops till bottom of stack
            while (curr != null) {
                //prints current node
                System.out.print(curr.value + "->");
                //Moves to next node
                curr = curr.next;
            }
            System.out.println();
        }
    }

