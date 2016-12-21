package edu.virginia.cs.lib.trees;

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
                if (t.getVal().compareTo(val) > 0) {
                    if (t.getRight() == null) {
                        t.setRight(n);
                    } else {
                        t = t.getRight();
                    }
                } else {
                    if (t.getLeft() == null) {
                        t.setLeft(n);
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
    public T find(T val) {
        if (root == null) {
            return null;
        } else {
            BNode<T> t = root;
            do {
                if (t.getVal().compareTo(val) == 0) {
                    return t.getVal();
                } else {
                    t = (t.getVal().compareTo(val) > 0)
                            ? t.getRight() : t.getLeft();
                }
            } while (t != null);
            //not in tree
            return null;
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
    public T remove(T val) {
        if (root == null) {
            return null;
        } else {
            boolean flag = true;
            BNode<T> t = root;
            BNode<T> p = null;

            do {
                //TODO add a lot more cases
                if (t.getVal().compareTo(val) == 0) {
                    if (p == null) {
                        //deleting the root
                        if (t.getLeft() == null && t.getRight() == null) {
                            root = null;
                        } else if (t.getLeft() == null) {
                            root = t.getRight();
                        } else if (t.getRight() == null) {
                            root = t.getLeft();
                        } else {
                            BNode<T> newRoot = t.getRight();
                            findRightMostNode(root.getLeft())
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
                                findRightMostNode(t.getLeft())
                                        .setRight(t.getRight());
                            } else {
                                //t is left child of p
                                p.setLeft(t.getRight());
                                findLeftMostNode(t.getRight())
                                        .setLeft(t.getLeft());
                            }
                        }
                    }
                    return t.getVal();
                } else {
                    p = t;
                    flag = t.getVal().compareTo(val) > 0;
                    t = flag ? t.getRight() : t.getLeft();
                }
            } while (t != null);
            //not in tree
            return null;
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
     * Finds the right most node in a particular subtree or returns
     * null if the subtree is empty.
     * @param <T> The type for tree
     * @param val The node we want to start the subtree search from
     * @return The right most node in the subtree or null
     */
    private static <T> BNode<T> findRightMostNode(BNode<T> val) {
        if (val == null) {
            return null;
        } else {
            BNode<T> t = val;
            BNode<T> p = null;
            do {
                p = t;
                t = (t.getRight() == null) ? t.getLeft() : t.getRight();
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
    private static <T> BNode<T> findLeftMostNode(BNode<T> val) {
        if (val == null) {
            return null;
        } else {
            BNode<T> t = val;
            BNode<T> p = null;
            do {
                p = t;
                t = (t.getLeft() == null) ? t.getRight() : t.getLeft();
            } while (t != null);
            return p;
        }
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
}
