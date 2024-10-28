import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.example.Container;
import org.example.Container.ContainerIterator;

/// Container unit-test class.
/// Provides test methods for the Container class
public class ContainerTest  {
    // class members
    /// Test container
    private Container<Integer> testContainer;
    /// Array of test elements
    private static final Integer[] testArray = {10, 11, 21, 31, 41, 11};
    //

    // class methods
    /// Constructor
    public ContainerTest() {
        testContainer = null;
    }

    /// Clears test container reference before each test
    @BeforeEach
    public void clearContainer() {
        testContainer = new Container<>(testArray);
    }

    /// Element array insertion from end test.
    /// Inserts an array of elements and then asserts the array with container contents
    @Test
    public void insertElementsArrayTest() {
        ContainerIterator<Integer> iterator = testContainer.getIteratorStart();
        Assertions.assertNotNull(iterator); // iterator shouldn't be null here
        for (int element : testArray) {
            Assertions.assertEquals(element, iterator.getCurrent().getContents());
            iterator.next();
        }
        // container should only contain the given array so the iterator should be pointing to null
        Assertions.assertNull(iterator.getCurrent());
    }

    /// Insertion at start test.
    /// Inserts an element at the start of filled container and asserts first
    /// container element with the one added
    @Test
    public void insertAtStartTest() {
        testContainer.insertAtStart(9);
        Assertions.assertEquals(9, testContainer.getRoot().getContents());
    }

    /// Insertion at end test.
    /// Inserts an element at the end of filled container and asserts last
    /// container element with the one that should be added
    @Test
    public void insertAtEndTest() {
        testContainer.insertAtStart(9);
        Assertions.assertEquals(9, testContainer.getIteratorEnd().getCurrent().getContents());
    }

    /// Insertion after specific element test.
    /// Inserts an element after an element with specific value
    /// and asserts it with the one that should be added
    @Test
    public void insertAfterTest() {
        Integer targetValue = 21;
        Integer newValue = 9;

        testContainer.insertAfter(targetValue, newValue);
        Assertions.assertTrue(testContainer.includes(newValue));
    }

    /// Element popping test.
    /// Pops an element at specific position from the container
    /// and asserts that it is no longer present in the container
    @Test
    public void popTest() {
        int targetValue = 31;
        int poppedValue = testContainer.pop(3); // passed target value node position in the container
        Assertions.assertFalse(testContainer.includes(targetValue));
        Assertions.assertEquals(targetValue, poppedValue);
    }

    /// Element removal test.
    /// Removes a unique element from the container
    /// and asserts that it is no longer present in the container
    @Test
    public void removeTest() {
        int targetValue = 41;
        testContainer.remove(targetValue);
        Assertions.assertFalse(testContainer.includes(targetValue));
    }

    /// Repeating elements removal test.
    /// Removes all elements with specific value from the container
    /// and asserts that none of them are present in the container anymore
    @Test
    public void removeAllTest() {
        int targetValue = 1;
        testContainer.removeAll(targetValue);
        Assertions.assertFalse(testContainer.includes(targetValue));
    }
    //
}