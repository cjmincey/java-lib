package edu.virginia.cs.lib.trees;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * This is a regular binary tree that does not enforce the tree to be balanced.
 *
 * @author Jordan Mincey
 * @param <T> the type of the binary tree, must support comparable
 */
public class BinaryTree<T extends Comparable<T>> {

    BNode<T> root;

    /**
     * Create an empty Binary Tree
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Insert an element into the binary tree
     *
     * @param val the value to be inserted
     */
    public void insert(T val) {
        BNode<T> n = new BNode<>(val);
        if (root == null) {
            root = n;
        } else {
            BNode<T> t = root;
            do {
                if (val.compareTo(t.getVal()) > 0) {
                    if (t.getRight() == null) {
                        t.setRight(n);
                        break;
                    } else {
                        t = t.getRight();
                    }
                } else {
                    if (t.getLeft() == null) {
                        t.setLeft(n);
                        break;
                    } else {
                        t = t.getLeft();
                    }
                }
            } while (true);
        }
    }

    /**
     * Find a value in the Binary Tree. Note if the value is in the tree
     * multiple times, we will return the one closest to the root.
     *
     * @param val The value to find
     * @return A reference to the value if the value was found and null if it
     * was not found
     */
    public Optional<T> find(T val) {
        if (root == null) {
            return Optional.empty();
        } else {
            BNode<T> t = root;
            do {
                if (val.compareTo(t.getVal()) == 0) {
                    return Optional.of(t.getVal());
                } else {
                    t = (val.compareTo(t.getVal()) > 0)
                            ? t.getRight() : t.getLeft();
                }
            } while (t != null);
            //not in tree
            return Optional.empty();
        }
    }

    /**
     * Remove an element from the tree. Note if the value is in the tree more
     * than once, the one closest to the root will be deleted.
     *
     * @param val The value to be removed from the tree.
     * @return A reference to the value that was deleted or null if it was not
     * in the tree.
     */
    public Optional<T> remove(T val) {
        if (root == null) {
            return Optional.empty();
        } else {
            boolean flag = true;
            BNode<T> t = root;
            BNode<T> p = null;

            do {
                if (val.compareTo(t.getVal()) == 0) {
                    if (p == null) {
                        //deleting the root
                        if (t.getLeft() == null && t.getRight() == null) {
                            root = null;
                        } else if (t.getLeft() == null) {
                            root = t.getRight();
                        } else if (t.getRight() == null) {
                            root = t.getLeft();
                        } else {
                            BNode<T> newRoot = root.getRight();
                            BNode.findRightMostNode(root.getLeft())
                                    .setRight(newRoot.getLeft());
                            newRoot.setLeft(root.getLeft());
                            root = newRoot;
                        }
                    } else {
                        if (t.getLeft() == null && t.getRight() == null) {
                            p.setLeft(null);
                        } else if (t.getLeft() == null) {
                            p.setLeft(t.getRight());
                        } else if (t.getRight() == null) {
                            p.setLeft(t.getLeft());
                        } else {
                            if (flag) {
                                //t is right child of p
                                p.setRight(t.getLeft());
                                BNode.findRightMostNode(t.getLeft())
                                        .setRight(t.getRight());
                            } else {
                                //t is left child of p
                                p.setLeft(t.getRight());
                                BNode.findLeftMostNode(t.getRight())
                                        .setLeft(t.getLeft());
                            }
                        }
                    }
                    return Optional.of(t.getVal());
                } else {
                    p = t;
                    flag = val.compareTo(t.getVal()) > 0;
                    t = flag ? t.getRight() : t.getLeft();
                }
            } while (t != null);
            //not in tree
            return Optional.empty();
        }
    }
    
    /**
     * 
     * @return The depth of the tree
     */
    public int getDepth(){
        return getDepth(root);
    }
    
    /**
     * Pre Order traversal of the tree
     * @return A Stream with the elements in Pre Order order
     */
    public Stream<T> getPreOrder(){
        Stream.Builder<T> stream = Stream.builder();
        return getPreOrder(root, stream).build();
    }
    
    /**
     * An in order traversal of the binary tree
     * @return A Stream with the nodes in in-order order
     */
    public Stream<T> getInOrder(){
        Stream.Builder<T> stream = Stream.builder();
        return getInOrder(root, stream).build();
    }
    
    /**
     * A post order traversal of the binary tree
     * @return A Stream of the post ordering of the tree
     */
    public Stream<T> getPostOrder(){
        Stream.Builder<T> stream = Stream.builder();
        return getPostOrder(root, stream).build();
    }
    
    /**
     * Finds the depth of the subtree starting at a node
     * @param <T> The type of the binary tree
     * @param node the node to start the search at
     * @return the depth of the binary tree
     */
    private static <T> int getDepth(BNode<T> node){
        if(node == null)
            return 0;
        else
            return 1 + Math.max(getDepth(node.getLeft()),
                    getDepth(node.getRight()));
    }
    
    /**
     * Take in a node and return the Pre Order traversal start from that node
     * @param <T> The type of the node
     * @param node The node we are starting from
     * @param a The Stream we are using to accumulate everything
     * @return A Stream with the pre order traversal starting at
     * the node
     */
    private static <T> Stream.Builder<T> getPreOrder(BNode<T> node,
            Stream.Builder<T> stream){
        if(node == null)
            return stream;
        else {
            stream.add(node.getVal());
            return getPreOrder(node.getRight(),
                    getPreOrder(node.getLeft(), stream));
        }
    }
    
    /**
     * In order traversal of the binary tree starting at a node
     * @param <T> The type of the node
     * @param node The node to start at
     * @param a The Stream that acts as an accumulator
     * @return A Stream with the nodes in in-order order
     */
    private static <T> Stream.Builder<T> getInOrder(BNode<T> node,
            Stream.Builder<T> stream){
        if(node == null)
            return stream;
        else {
            Stream.Builder<T> left = getInOrder(node.getLeft(), stream);
            left.add(node.getVal());
            return getInOrder(node.getRight(), left);
        }
    }
    
    /**
     * A post order traversal of the binary tree
     * @param <T> The type of the node
     * @param node the node to start at
     * @param a the Stream that acts as the accumulator
     * @return An Stream of the post ordering of the subtree starting at the node
     */
    private static <T> Stream.Builder<T> getPostOrder(BNode<T> node,
            Stream.Builder<T> stream){
        if(node == null)
            return stream;
        else {
            Stream.Builder<T> newStr = getPostOrder(node.getRight(),
                    getPostOrder(node.getLeft(), stream));
            newStr.add(node.getVal());
            return newStr;
        }
    }
}
