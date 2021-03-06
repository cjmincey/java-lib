package edu.virginia.cs.lib.lists;

import java.util.Optional;

/**
 * A typical stack that only allows push, pop, and peek operations.
 * 
 * This class never throws an error for an element not being available in 
 * the stack, we instead return null.
 * 
 * @author Jordan Mincey
 * @param <T> The class this stack is associated with
 */
public class Stack<T> {
    private Node<T> head;
    
    /**
     * Create a new Stack
     */
    public Stack(){
        head = null;
    }
    
    /**
     * Push a new value onto the stack
     * @param val The value to be pushed onto the stack
     */
    public void push(T val){
        Node<T> n = new Node(val, head);
        head = n;
    }
    
    /**
     * Remove a value from the stack which is the last value
     * that was added to it.
     * @return The value just removed from the head of the stack if one exists.
     */
    public Optional<T> pop(){
        if(head != null){
            Node<T> n = head;
            head = n.getNext();
            return Optional.of(n.getVal());
        } else {
            return Optional.empty();
        }
    }
    
    /**
     * Show the value at the top of the stack but do not remove it.
     * @return The value at the top of the stack if one exists.
     */
    public Optional<T> peek(){
        return (head == null) ? Optional.empty() : Optional.of(head.getVal());
    }
}
