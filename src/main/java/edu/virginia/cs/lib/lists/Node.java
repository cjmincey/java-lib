package edu.virginia.cs.lib.lists;

/**
 * A node that can be used as part of a singly linked linked list.
 * @author Jordan Mincey
 * @param <T> The type of node
 */
public class Node<T> {
    private T val;
    private Node<T> next;
    
    /**
     * Create a node with just a val and a null next node.
     * @param val The object this node is associated with
     */
    public Node(T val){
        this.val = val;
        next = null;
    }
    
    /**
     * Create a node with val and next pointers initialized.
     * @param val The object this node is associated with
     * @param next The next Node in this list
     */
    public Node(T val, Node<T> next){
        this.val = val;
        this.next = next;
    }
    
    /**
     * 
     * @return The value in this Node
     */
    public T getVal(){
        return val;
    }
    
    /**
     * 
     * @return The next Node in the list or null
     */
    public Node<T> getNext(){
        return next;
    }
    
    /**
     * 
     * @param val the new value of this Node
     */
    public void setVal(T val){
        this.val = val;
    }
    
    /**
     * 
     * @param next the new neighbor of this Node
     */
    public void setNext(Node<T> next){
        this.next = next;
    }
}
