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
    
        /**
     * Finds the right most node in a particular subtree or returns
     * null if the subtree is empty.
     * @param <T> The type for tree
     * @param val The node we want to start the subtree search from
     * @return The right most node in the subtree or null
     */
    public static <T> BNode<T> findRightMostNode(BNode<T> val) {
        if (val == null) {
            return null;
        } else {
            BNode<T> t = val;
            BNode<T> p = null;
            do {
                p = t;
                t = t.getRight();
            } while (t != null);
            return p;
        }
    }

    /**
     * Finds the left most node in a particular subtree or returns
     * null if the subtree is empty.
     * @param <T> The type for tree
     * @param val The node we want to start the subtree search from
     * @return The left most node in the subtree or null
     */
    public static <T> BNode<T> findLeftMostNode(BNode<T> val) {
        if (val == null) {
            return null;
        } else {
            BNode<T> t = val;
            BNode<T> p = null;
            do {
                p = t;
                t = t.getLeft();
            } while (t != null);
            return p;
        }
    }
    
    /**
     * Assert that the tree structure starting at the current node maintains
     * the binary tree property
     * @param <T> The type of the binary tree
     * @param val The node to start with
     * @throws java.lang.AssertionError when the structure is not a binary tree
     */
    public static <T extends Comparable<T>> void assertBinaryTreeProperty
            (BNode<T> val){
        if(val != null){
            if(val.getLeft() != null){
                assert(val.getLeft().getVal().compareTo(val.getVal()) <= 0);
                assertBinaryTreeProperty(val.getLeft());
            }
            if(val.getRight() != null){
                assert(val.getRight().getVal().compareTo(val.getVal()) > 0);
                assertBinaryTreeProperty(val.getRight());
            }
                
        }
    }
}
