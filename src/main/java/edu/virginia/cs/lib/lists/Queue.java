package edu.virginia.cs.lib.lists;

/**
 * This class represents a regular queue where something is added to the
 * tail of the queue and removed from the head of the queue. There are
 * only three operations supported since we only want to support
 * this limited ability.
 * 
 * This class never throws exceptions when trying to remove from an empty
 * queue, it simply returns null.
 * 
 * @author Jordan Mincey
 * @param <T> The type of the queue.
 */
public class Queue<T> {
    //keep both head and tail pointers so inserts
    //and retrievals are fast
    private Node<T> head;
    private Node<T> tail;
    
    /**
     * Create an empty queue.
     */
    public Queue(){
        head = null;
        tail = null;
    }
    
    /**
     * Add a value to the end of the queue.
     * @param val the value to be added to the queue
     */
    public void enqueue(T val){
        Node<T> n = new Node<>(val);
        if(head == null){
            head = n;
            tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }
    
    /**
     * Remove the head of the queue and return it.
     * @return a value from the front of the queue
     */
    public T dequeue(){
        if(head != null){
            Node<T> n = head;
            head = n.getNext();
            
            if(head == null){
                tail = null;
            }
            
            return n.getVal();
        } else {
            return null;
        }
    }
    
    /**
     * Do not remove the head of the queue but return it.
     * @return The head of the queue.
     */
    public T peek(){
        return (head == null) ? null : head.getVal();
    }
}
