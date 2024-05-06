public class Stack {

    Node head;

    public Stack() {
        head = null;
    }
    
    public void push(String s){
        Node newNode = new Node(s);

        if (head == null) {
            head = newNode;
            return;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public  String pop(){
        if (head == null){
            return null;
        }else{
            String poppedItem;
            poppedItem = head.value;
             // Get the data from the top node
            head = head.next;               // Move top to the next node
            return poppedItem; 
        }
    }

    public String peek(){
        if (head == null){
            return null;}
        else{ return head.value;
            }
        }

        public boolean isEmpty(){
            if (head == null) {
                return true;

            }else {
                return false;
            }
        }

        public void dump(){
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.value + "->");
                curr = curr.next;
    
            }
            System.out.println();
        }
    }

