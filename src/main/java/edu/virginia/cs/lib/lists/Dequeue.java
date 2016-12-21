package edu.virginia.cs.lib.lists;

/**
 * This class represents a regular dequeue that has operations on both
 * ends of the dequeue. The dequeue can have things added and removed
 * from its head and tail in constant time. I have also added operations
 * to look at both the head and the tail in constant time.
 * 
 * This class never throws any errors for an element not being in the 
 * dequeue, we simply return null if the dequeue is empty and the user
 * tries removing/peeking at the head or tail.
 * 
 * @author Jordan Mincey
 * @param <T> The type of the dequeue
 */
public class Dequeue<T> {
    //we need doubly linked list for constant time
    //removal of tail
    private NodeD<T> head;
    private NodeD<T> tail;
    
    /**
     * Create an empty dequeue
     */
    public Dequeue(){
        head = null;
        tail = null;
    }
    
    /**
     * Add an element to the head of the dequeue
     * @param val The value to be added to the head of the dequeue
     */
    public void addHead(T val){
        NodeD<T> n = new NodeD(val);
        if(head == null){
            //prev and next both null
            head = n;
            tail = n;
        } else {
            head.setPrev(n);
            n.setNext(head);
            head = n;
        }
    }
    
    /**
     * Remove an element from the head of the dequeue
     * @return the head of the dequeue after removing it
     */
    public T removeHead(){
        if(head == null){
            return null;
        } else {
            NodeD<T> n = head;
            if(n.getNext() == null){
                head = null;
                tail = null;
            } else {
                n.getNext().setPrev(null);
                head = n.getNext();
            }
            return n.getVal();
        }
    }
    
    /**
     * Returns the head of the dequeue without removing it
     * @return The head of the dequeue
     */
    public T peekHead(){
        return (head == null) ? null : head.getVal();
    }
    
    /**
     * Adds an element to the tail of the dequeue
     * @param val The element to be added
     */
    public void addTail(T val){
        NodeD<T> n = new NodeD<>(val);
        if(tail == null){
            //prev and next both null
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }
    }
    
    /**
     * Remove an element from the tail of the dequeue
     * @return The tail of the dequeue
     */
    public T removeTail(){
        if(tail == null){
            return null;
        } else {
            NodeD<T> n = tail;
            if(tail.getPrev() == null){
                head = null;
                tail = null;
            } else {
                tail = tail.getPrev();
                tail.setNext(null);
            }
            return n.getVal();
        }
    }
    
    /**
     * Returns the tail of the dequeue without removing it
     * @return The tail of the dequeue
     */
    public T peekTail(){
        return (tail == null) ? null : tail.getVal();
    }
}
