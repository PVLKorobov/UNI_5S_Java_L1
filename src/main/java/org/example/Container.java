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
}
