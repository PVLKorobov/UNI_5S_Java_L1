package org.example;


/// Container class.
/// Contains a linked list and methods to insert and extract its elements
public class Container<E> {
    /// Container node class
    /// Contains reference to the next Node and generic type value
    public static class Node<E> {
        // class members
        /// Node contents
        private E contents;
        /// Following node reference
        Node<E> next;
        //

        // class methods
        /// Constructor
        /// @param _contents Value that will be stored
        public Node(E _contents) {
            contents = _contents;
            next = null;
        }

        /// Empty constructor
        public Node() {
            contents = null;
            next = null;
        }

        /// Copy constructor. Copies all following nodes
        /// @param source Node that will be copied
        public Node(Node<E> source) {
            contents = source.contents;
            if (source.next != null) {
                next = new Node<>(source.next);
            } else {
                next = null;
            }
        }

        /// Node contents getter
        /// @return Element contained within the node
        public E getContents() {
            return contents;
        }

        /// Node contents setter
        /// @param newContents Value that will be stored in the node
        public void setContents(E newContents) {
            contents = newContents;
        }
        //
    }

    /// Container iterator class
    /// Provides methods to cycle through the container object
    public static class ContainerIterator<E> {
        // class members
        /// Current node reference
        private Node<E> current;
        //

        // class methods
        /// Target node constructor.
        /// Creates iterator pointing to the given node in the container
        /// @param target Node object that iterator will point at
        private ContainerIterator(Node<E> target) {
            current = target;
        }

        /// Moves iterator to the next node.
        /// May point iterator to a null
        public void next() {
            current = current.next;
        }

        /// Tells if iterator has a node after it
        /// @return True if next reference is not null, false otherwise
        public boolean hasNext() {
            return current.next != null;
        }

        /// Current node getter
        /// @return Reference to current node. May be null
        public Node<E> getCurrent() {
            return current;
        }
    }


    // class members
    /// Container root element
    Node<E> root;
    //

    
    // class methods
    /// Constructor
    public Container() {
        root = null;
    }

    /// Array constructor.
    /// Creates a container object with the elements of given array
    /// @param inputArray an array of elements
    public Container(E[] inputArray) {
        for (E element : inputArray) {
            insertAtEnd(element);
        }
    }

    /// Copy constructor. Copies root node with all following nodes
    /// @param source a Container type object
    public Container(Container<E> source) {
        root = new Node<>(source.root);
    }

    /// Inserts item at the start of the container
    /// @param contents Value that will be inserted
    public void insertAtStart(E contents) {
        Node<E> newNode = new Node<>(contents);
        if (root != null) {
            newNode.next = root;
        }
        root = newNode;
    }

    /// Inserts item after target node
    /// @param target Node after which the value will be inserted
    /// @param contents Value that will be inserted
    public void insertAfter(Node<E> target, E contents) {
        if (target != null) {
            Node<E> newNode = new Node<>(contents);
            if (target.next != null) {
                newNode.next = target.next;
            }
            target.next = newNode;
        }
    }

    /// Inserts item at the end of the container
    /// @param contents Value that will be inserted
    public void insertAtEnd(E contents) {
        if (root == null) { root = new Node<>(contents); }
        else {
            Node<E> target = root;
            // go to the end of the list
            while (target.next != null) {
                target = target.next;
            }
            target.next = new Node<>(contents);
        }
    }

    /// Extracts the first node with target position, removing it from the list
    /// @param pos Target position
    /// @return Contents of the target node. Returns null if target doesn't exist
    public E pop(int pos) {
        if (root != null)
        {
            Node<E> target = getNodeByPosition(pos);
            if (target != null) {
                removeNode(target);
                return target.contents;
            }
        }
        return null;
    }

    /// Removes the first node with target value from the list
    /// @param targetValue Value by which node will be searched
    public void remove(E targetValue) {
        if (root != null) {
            Node<E> target = getNodeByValue(targetValue);
            if (target != null) {
                removeNode(target);
            }
        }
    }

    /// Removes all nodes with target value from the list
    /// @param targetValue Value by which nodes will be searched
    public void removeAll(E targetValue) {
        if (root != null) {
            Node<E> target = getNodeByValue(targetValue);
            while (target != null) {
                remove(targetValue);
                target = getNodeByValue(targetValue);
            }
        }
    }

    /// Returns reference to the node that is behind the target node
    /// @param target Node that will be the search target
    /// @return Reference to the Node type object. Returns null if target doesn't exist
    private Node<E> getPrevNode(Node<E> target) {
        Node<E> prev = root;
        while (prev.next != target && prev.next != null) {
            prev = prev.next;
        }
        if (prev.next == target) { return prev; }
        else { return null; }
    }

    /// Returns reference to the node that contains specified value
    /// @param targetValue Value by which node will be searched
    /// @return Reference to the Node type object. Returns null if target doesn't exist
    private Node<E> getNodeByValue(E targetValue) {
        Node<E> current = root;
        while (current.next != null) {
            if (current.contents == targetValue) { return current; }
        }
        if (current.contents == targetValue) { return current; }
        else { return null; }
    }

    /// Returns reference to the node that is stored at specified position in container
    /// @param position Target position
    /// @return Reference to the Node type object. Returns null if target doesn't exist
    private Node<E> getNodeByPosition(int position) {
        Node<E> current = root;
        int i = 0;
        while (current.next != null) {
            if (i == position) { return current; }
            i += 1;
        }
        if (i == position) { return current; }
        else { return null; }
    }

    /// Removes target node from container
    /// @param targetNode Node that will be removed
    private void removeNode(Node<E> targetNode) {
        if (targetNode != null) {
            if (targetNode == root) {
                root = root.next;
            }
            else {
                Node<E> prevNode = getPrevNode(targetNode);
                if (prevNode != null) {
                    prevNode.next = targetNode.next;
                }
            }
        }
    }

    /// Container root getter
    /// @return Reference to container root node. . Returns null if the container is empty
    public Node<E> getRoot() {
        return root;
    }

    /// Creates an iterator object pointing to the first element of the container
    /// @return Reference to ContainerIterator type object, pointing at the first element of the container.
    /// Returns null if the container is empty
    public ContainerIterator<E> getIteratorStart() {
        if (root == null) { return null; }
        else {
            return new ContainerIterator<>(root);
        }
    }

    /// Creates an iterator object pointing to the first element of the container
    /// @return Reference to ContainerIterator type object, pointing at the first element of the container.
    /// Returns null if the container is empty
    public ContainerIterator<E> getIteratorEnd() {
        if (root == null) { return null; }
        else {
            Node<E> target = root;
            // go to the end of the list
            while (target.next != null) {
                target = target.next;
            }
            return new ContainerIterator<>(target);
        }
    }

    /// Creates an iterator object pointing to the element at given position
    /// @param position Position of target node
    /// @return Reference to ContainerIterator type object, pointing at target element of the container.
    /// Returns null if the container is empty or target doesn't exist
    public ContainerIterator<E> getIteratorAt(int position) {
        if (root == null) { return null; }
        else {
            Node<E> target = getNodeByPosition(position);
            if (target == null) { return null; }
            else {
                return new ContainerIterator<>(target);
            }
        }
    }

    /// Creates an iterator object pointing to the first element with given contents value
    /// @param targetValue Value by which node will be searched
    /// @return Reference to ContainerIterator type object, pointing at the target element of the container.
    /// Returns null if the container is empty or target doesn't exist
    public ContainerIterator<E> getIteratorAt(E targetValue) {
        if (root == null) { return null; }
        else {
            Node<E> target = getNodeByValue(targetValue);
            if (target == null) { return null; }
            else {
                return new ContainerIterator<>(target);
            }
        }
    }
    //
}
