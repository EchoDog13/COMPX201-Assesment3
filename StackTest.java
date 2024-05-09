import org.junit.jupiter.api.*;
import java.io.*;

/**
 *
 */
class StackTest {

    //stores the output of the console output in standard out
    private final PrintStream standardOut = System.out;
    //capture the output of the information written to console
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    /**
     * Before each test is run, sets output print stream to outputStreamCaptor to capture output. This is used to test
     */
    @BeforeEach
    public void setOut() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * resets the output of the print stream
     */
    @AfterEach
    public void restoreOut() {
        System.setOut(standardOut);
    }

    /**
     * Tests that the correct item is returned when peek is run
     */
    @Test
    @DisplayName("Peek shows correct item")
    public void peekShowsCorrectItem() {

        Stack stackTest = new Stack();

        stackTest.push("Hello");
        stackTest.push("World");
        Assertions.assertEquals("World", stackTest.peek());
    }

    /**
     * Tests that empty stacks return null
     */
    @Test
    @DisplayName("Peek on empty stack should return null")
    void peekOnEmptyStack() {
        Stack stackTest = new Stack();
        Assertions.assertNull(stackTest.peek());
    }

    /**
     * Tests that an item can be added to an empty stack by pushing an item, then peeking the item
     */
    @Test
    @DisplayName("Pushing to empty stack")
    void pushToEmptyStack() {
        Stack stackTest = new Stack();
        //Adding to stack
        stackTest.push("Test");
        //Test
        Assertions.assertEquals("Test", stackTest.peek());
    }

    /**
     * Tests that items can be added to stack containing item, then peeks item to check item adds in the correct order
     */
    @Test
    @DisplayName("Push to stack containing items")
    void pushStackContainingItems() {
        Stack stackTest = new Stack();

        stackTest.push("1");
        stackTest.push("2");
        Assertions.assertEquals("2", stackTest.pop());
    }

    /**
     * Tests adding special character items to an empty stack
     */
    @Test
    @DisplayName("Push unexpected input of special characters to empty stack")
    void pushSpecialCharactersToEmptyStack(){
        Stack stackTest = new Stack();
        stackTest.push("*3Hello  &*%*   ./'");
        Assertions.assertEquals("*3Hello  &*%*   ./'", stackTest.peek());
    }

    /**
     * Tests adding special characters string to stack containing items
     */
    @Test
    @DisplayName("Push unexecpted input of special characters to stack containing item")
    void pushSpecialCharactersToStack(){
        Stack stackTest = new Stack();
        stackTest.push("Hello");
        stackTest.push("World");
        stackTest.push("*^sdfhsj^*%(*&kdhfKYGK9w8y32&*^%*)(%");
        Assertions.assertEquals("*^sdfhsj^*%(*&kdhfKYGK9w8y32&*^%*)(%", stackTest.peek());
    }

    /**
     * Tests that an empty stack returns true
     */
    @Test
    @DisplayName("Is empty on empty Stack")
    void isEmptyOnEmptyStack() {
        Stack stackTest = new Stack();

        Assertions.assertTrue(stackTest.isEmpty());
    }

    /**
     * Tests that a non-empty stack return false
     */
    @Test
    @DisplayName("Is empty stack containing an item")
    void isEmptyOnStackContainingItem() {
        Stack stackTest = new Stack();
        stackTest.push("Item");
        Assertions.assertFalse(stackTest.isEmpty());
    }

    /**
     * Tests that empty stack returns blank output
     */
    @Test
    @DisplayName("Dump empty stack")
    void dumpEmptyStack() {
        Stack stackTest = new Stack();
        stackTest.dump();
        Assertions.assertEquals("", outputStreamCaptor.toString().trim());
    }

    /**
     * Tests that the dump function correctly exports item in stack in the correct order
     */
    @Test
    @DisplayName("Dump Stack with items")
    void dumpStackWithItems() {
        Stack stackTest = new Stack();
        stackTest.push("World");
        stackTest.push("Hello");
        stackTest.dump();
        Assertions.assertEquals("Hello->World->", outputStreamCaptor.toString().trim());
    }

    /**
     * Tests that popping an empty stack returns null
     */
    @Test
    @DisplayName("Pop empty stack return null")
    void popEmptyStack() {
        Stack stackTest = new Stack();
        Assertions.assertNull(stackTest.pop());
    }

    @Test
    @DisplayName("Dump stack with special characters")
    void dumpSpecialCharactersWithEmptyItem(){
        Stack stackTest = new Stack();
        stackTest.push("Hello");
        stackTest.push("*&%(alsdhig123123(**(");
        stackTest.push("Uniform");
        stackTest.dump();
        Assertions.assertEquals("Uniform->*&%(alsdhig123123(**(->Hello->", outputStreamCaptor.toString().trim());

    }

    /**
     * Tests that when performing a pop on a stack with multiple items, the correct item is popped
     * IMPROVE THIS
     */
    @Test
    @DisplayName("Pop multiple item stack")
    void checkHeadGoesToNextItem() {
        Stack stackTest = new Stack();
        stackTest.push("A");
        stackTest.push("B");
        stackTest.push("C");

        stackTest.pop();
        Assertions.assertEquals("B", stackTest.pop());
    }

    /**
     * Pop item with special characters
     */
    @Test
    @DisplayName("Pop item containing special characters")
    void popSpecialCharacters(){
        Stack stackTest = new Stack();
        stackTest.push("Cars");
        stackTest.push("Airplanes");
        stackTest.push("O*&%O&ad.kjhg");

        Assertions.assertEquals("O*&%O&ad.kjhg", stackTest.pop());
    }


    /**
     * Tests that head points to null when an instance of a stack is initialised
     */
    @Test
    @DisplayName("Test Stack creation")
    void testStackCreation() {
        Stack stackTest = new Stack();
        Assertions.assertNull(stackTest.head);
    }

    /**
     * Tests that popping the only item in a stack returns head to being null
     */
    @Test
    @DisplayName("Pop single item makes head null")
    void popMakesHeadNull() {
        Stack stackTest = new Stack();
        stackTest.push("a");

        stackTest.pop();
        Assertions.assertNull(stackTest.head);
    }
}