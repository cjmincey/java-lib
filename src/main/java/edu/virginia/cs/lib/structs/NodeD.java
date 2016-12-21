package edu.virginia.cs.lib.structs;

/**
 * A node that can be used as part of a doubly linked linked list.
 * @author Jordan Mincey
 * @param <T> The type of node
 */
public class NodeD<T> {
    private T val;
    private NodeD<T> next;
    private NodeD<T> prev;
    
    /**
     * Create a node with just a val and a null next node.
     * @param val The object this node is associated with
     */
    public NodeD(T val){
        this.val = val;
        next = null;
        prev = null;
    }
    
    /**
     * Create a node with val and next pointers initialized.
     * @param val The object this node is associated with
     * @param next The next Node in this list
     * @param prev the previous node in the list
     */
    public NodeD(T val, NodeD<T> next, NodeD<T> prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
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
    public NodeD<T> getNext(){
        return next;
    }
    
        /**
     * 
     * @return The previous Node in the list or null
     */
    public NodeD<T> getPrev(){
        return prev;
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
    public void setNext(NodeD<T> next){
        this.next = next;
    }
    
        /**
     * 
     * @param prev the new neighbor of this Node
     */
    public void setPrev(NodeD<T> prev){
        this.prev = prev;
    }
}
