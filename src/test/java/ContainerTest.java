import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.example.Container;
import org.example.Container.Node;

/// Container unit-test class.
/// Provides test methods for the Container class
public class ContainerTest  {
    // class members
    /// Test container
    private Container<Integer> testContainer;
    //

    // class methods
    /// Constructor
    public ContainerTest() {
        testContainer = null;
    }

    /// Clears test container reference before each test
    @BeforeEach
    public void clearContainer() {
        testContainer = null;
    }

    /// Element array insertion from end test.
    /// Inserts an array of elements and then asserts the array with container contents
    @Test
    public void insertElementsArrayTest() {
        Integer[] testArray = {10, 11, 21, 31, 41};
        testContainer = new Container<>(testArray);

        Node<Integer> cursor = testContainer.getRoot();
        Assertions.assertNotEquals(null, cursor);
        for (int element : testArray) {
            Assertions.assertEquals(element, cursor.getContents());
        }
    }

    /// Insertion at start test.
    /// Inserts an element at the start of filled container and asserts first
    /// container element with the one added
    @Test
    public void insertAtStartTest() {
        // TODO
    }

    /// Insertion at end test.
    /// Inserts an element at the end of filled container and asserts last
    /// container element with the one that should be added
    @Test
    public void insertAtEndTest() {
        // TODO
    }

    /// Insertion after specific element test.
    /// Inserts an element after an element with specific value
    /// and asserts it with the one that should be added
    @Test
    public void insertAfterTest() {
        // TODO
    }

    /// Element popping test.
    /// Pops an element at specific position from the container
    /// and asserts that it is no longer present in the container
    @Test
    public void popTest() {
        // TODO
    }

    /// Element removal test.
    /// Removes a unique element from the container
    /// and asserts that it is no longer present in the container
    @Test
    public void removeTest() {
        // TODO
    }

    /// Repeating elements removal test.
    /// Removes all elements with specific value from the container
    /// and asserts that none of them are present in the container anymore
    @Test
    public void removeAllTest() {
        // TODO
    }

    /// Get previous node test.
    /// Adds two elements to the container. Calls previous node getter
    /// for the last element and asserts that the result node matches the first one
    @Test
    public void getPrevNodeTest() {
        // TODO
    }

    /// Get node by position test.
    /// Gets a node by getter by position method
    /// and asserts its value with the value of the node in the container
    @Test
    public void getNodeByPositionTest() {
        // TODO
    }
    //
}