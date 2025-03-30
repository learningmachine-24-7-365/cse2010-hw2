package cse2010.hw2;

import java.util.Comparator;
import java.util.Objects;

/*
 * © 2025 CSE2010 HW #2
 *
 * You can freely modify this class except the signatures of the public methods!!
 */
public class DLinkedList<T> {
    private final Node<T> header;
    private final Node<T> trailer;
    private int size;

    /**
     * Constructs an empty list.
     */
    public DLinkedList() {
        header = new Node<T>(null, null, null);
        trailer = new Node<T>(null, header, null);
        header.setNext(trailer);
        size = 0;
    }

    /**
     * Returns the number of nodes in the list.
     *
     * @return the number of nodes in the list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add a new node n at the front of the list.
     *
     * @param n the new node to be added
     */
    public void addFirst(Node<T> n) {
        addAfter(header, n);
    }

    /**
     * Add a new node n at the end of the list.
     *
     * @param n the new node to be added
     */
    public void addLast(Node<T> n) {
        addBefore(trailer, n);
    }

    /**
     * Remove the first node in the list.
     *
     * @return the element of the removed node, or null if the list is empty
     */
    public T removeFirst() {
        if (isEmpty())
            return null;
        return remove(header.getNext());
    }

    /**
     * Remove the last node in the list.
     *
     * @return the element of the removed node, or null if the list is empty
     */
    public T removeLast() {
        if (isEmpty())
            return null;
        return remove(trailer.getPrev());
    }

    /**
     * Add new node n before node p.
     *
     * @param p the node before which the new node n is to be added
     * @param n the new node to be added
     */
    public void addBefore(Node<T> p, Node<T> n) {
        Objects.requireNonNull(p, "cannot not be null");
        Objects.requireNonNull(n, "cannot not be null");

       /*
            Complete the code here
        */
    }

    /**
     * Add new node n after node p.
     *
     * @param p the node after which the new node n is to be added
     * @param n the new node to be added
     */
    public void addAfter(Node<T> p, Node<T> n) {
        Objects.requireNonNull(p, "cannot not be null");
        Objects.requireNonNull(n, "cannot not be null");

       /*
            Complete the code here
        */
    }

    /**
     * Remove a node p.
     *
     * @param p the node to be removed
     * @return the element of the removed node, or null if the node is null
     */
    public T remove(Node<T> p) {
        if (p == null || p == header || p == trailer)
            return null;

       /*
            Complete the code here
        */
        return null; // modify this line if necessary
    }

    /**
     * Returns the first node in the list.
     *
     * @return the first node in the list, or null if the list is empty
     */
    public Node<T> getFirstNode() {
        if (isEmpty())
            return null;
        else
            return header.getNext();
    }

    /**
     * Returns the last node in the list.
     *
     * @return the last node in the list, or null if the list is empty
     */
    public Node<T> getLastNode() {
        if (isEmpty())
            return null;
        else
            return trailer.getPrev();
    }

    /**
     * Returns next node if exists.
     *
     * @param cur current node
     * @return next node if exits, null otherwise
     */
    public Node<T> getNextNode(Node<T> cur) {
        Objects.requireNonNull(cur, "cannot not be null");

        if (cur.getNext() == trailer)
            return null;
        else
            return cur.getNext();
    }

    /**
     * Returns previous node if exists.
     *
     * @param cur current node
     * @return previous node if exits, null otherwise
     */
    public Node<T> getPrevNode(Node<T> cur) {
        Objects.requireNonNull(cur, "cannot not be null");

        if (cur.getPrev() == header)
            return null;
        else
            return cur.getPrev();
    }

    /**
     * Find a node with an element with the value of "n".
     *
     * @param n          value of the element to search
     * @param comparator comparator
     * @return the node which has an element "n", or null if not found
     */
    public Node<T> find(T n, Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator, "cannot not be null");

        if (isEmpty()) return null;

        Node<T> current = getFirstNode();
        while (current != null) {
            if (comparator.compare(current.getInfo(), n) == 0) {
                break;
            }
            current = getNextNode(current);
        }
        return current;
    }
}

