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
        //
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

    /// Copy constructor. Copies root node with all following nodes
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
    //
}
