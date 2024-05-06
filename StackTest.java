import org.junit.jupiter.api.*;
import  java.io.*;

class StackTest {

   private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream () ;
    @BeforeEach
    public void setOut (){
        System.setOut (new PrintStream (outputStreamCaptor));
    }

    @AfterEach
    public void restoreOut () {
        System.setOut(standardOut);}


//Peek Tests
    @Test
    @DisplayName("Peek shows correct item")
    public void peekShowsCorrectItem() {
        Stack stackTest = new Stack();

        stackTest.push("Hello");
        stackTest.push("World");
        Assertions.assertEquals("World", stackTest.peek());
    }

    @Test
     @DisplayName("Peek on empty stack should return null")
     void peekOnEmptyStack(){
        Stack stackTest = new Stack();
        Assertions.assertNull(stackTest.peek());
    }
//Pushing tests
    @Test
     @DisplayName("Pushing to empty stack")
     void pushToEmptyStack(){
        Stack stackTest = new Stack();
        //Adding to stack
        stackTest.push("Test");
        //Test
        Assertions.assertEquals("Test", stackTest.peek());
    }

   @Test
     @DisplayName("Push to stack containing values")
     void pushStackContainingItems(){
       Stack stackTest = new Stack();

       stackTest.push("1");
       stackTest.push("2");
    Assertions.assertEquals("2", stackTest.pop());


   }
   //isEmpty Tests
   @Test
    @DisplayName("Is empty on empty Stack")
     void isEmptyOnEmptyStack(){
        Stack stackTest = new Stack();

        Assertions.assertTrue(stackTest.isEmpty());
     }

     @Test
     @DisplayName("Is empty stack containing an item")
     void isEmptyOnStackContainingItem(){
         Stack stackTest = new Stack();
         stackTest.push("Item");
         Assertions.assertFalse(stackTest.isEmpty());
     }

     //Dump Tests

    @Test
    @DisplayName("Dump empty stack")
    void dumpEmptyStack() {
      Stack stackTest = new Stack();
        stackTest.dump();

        Assertions.assertEquals("", outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Dump Stack with item")
    void dumpStackWithItem(){
        Stack stackTest = new Stack();
        stackTest.push("Hello");
        stackTest.dump();
        Assertions.assertEquals("Hello->", outputStreamCaptor.toString().trim());
    }

//Test multiple when relying on dependencies


     //Pop tests

     @Test
     @DisplayName("Pop empty stack return null")
     void popEmptyStack(){
         Stack stackTest = new Stack();
            Assertions.assertNull(stackTest.pop());
     }

     @Test
     @DisplayName("Pop stack item")
     void popStackItem(){
         Stack stackTest = new Stack();
        stackTest.push("A");
        stackTest.push("B");

        Assertions.assertEquals("B", stackTest.pop());
     }
//Does the stack start as empty
@Test
    @DisplayName("Test Stack creation")
    void testStackCreation(){
        Stack stackTest = new Stack();
        Assertions.assertNull(stackTest.head);
}

}