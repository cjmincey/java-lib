package edu.virginia.cs.lib.trees;

/**
 * A class to hold nodes of a binary tree.
 * There is intentionally no setVal because the value of the node
 * should never change. You must remove this node and create another
 * node if you want to change a value.
 * @author Jordan Mincey
 * @param <T> The type of the node
 */
public class BNode<T> {
    private final T val;
    private BNode<T> left;
    private BNode<T> right;
    
    /**
     * Create a new node with the value
     * @param val Value to be inserted
     */
    public BNode(T val){
        this.val = val;
        left = null;
        right = null;
    }
    
    /**
     * Create a new node with the value and the left and right
     * subtrees
     * @param val The value of the node
     * @param left the left subtree
     * @param right  the right subtree
     */
    public BNode(T val, BNode<T> left, BNode<T> right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    /**
     * 
     * @return the value of the node
     */
    public T getVal(){
        return val;
    }
    
    /**
     * 
     * @return the left subtree
     */
    public BNode<T> getLeft(){
        return left;
    }
    
    /**
     * 
     * @return the right subtree
     */
    public BNode<T> getRight(){
        return right;
    }
    
    /**
     * Set the left subtree
     * @param left the left subtree to set for this node
     */
    public void setLeft(BNode<T> left){
        this.left = left;
    }
    
    /**
     * Set the right subtree
     * @param right the right subtree to set for this node
     */
    public void setRight(BNode<T> right){
        this.right = right;
    }
}
