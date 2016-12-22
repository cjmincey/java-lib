package edu.virginia.cs.lib.trees;

import java.util.ArrayList;
import org.junit.Test;

/**
 *
 * @author Jordan
 */
public class BinaryTreeTest {
    /**
     *        0
     *      /   \
     *    -5     5
     *   /      / \
     *  -10    3   10
     *        /
     *       2
     */ 
    @Test
    public void depthTest(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        assert(tree.getDepth() == 0);
        tree.insert(0);
        assert(tree.getDepth() == 1);
        tree.insert(-5);
        tree.insert(5);
        tree.insert(-10);
        tree.insert(3);
        assert(tree.getDepth() == 3);
        tree.insert(10);
        assert(tree.getDepth() == 3);
        tree.insert(2);
        assert(tree.getDepth() == 4);
    }
    
    /**
     *            0
     *         /     \
     *     -100       100
     *        \       /  \
     *        -50    50   150
     *          \     \     \
     *          -75   80     500
     */ 
    @Test
    public void insertTest(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(0);
        tree.insert(-100);
        tree.insert(100);
        tree.insert(-50);
        tree.insert(50);
        tree.insert(150);
        tree.insert(-75);
        tree.insert(80);
        tree.insert(500);
        
        ArrayList<Integer> a = tree.getPreOrder();
        assert(a.size() == 9);
        assert(a.get(0) == 0);
        assert(a.get(1) == -100);
        assert(a.get(2) == -50);
        assert(a.get(3) == -75);
        assert(a.get(4) == 100);
        assert(a.get(5) == 50);
        assert(a.get(6) == 80);
        assert(a.get(7) == 150);
        assert(a.get(8) == 500);
    }
    
    //TODO fix the remove functionality
    /**
     *        0                 50
     *       / \               /  \
     *     -50 50      =>    -50  100
     *     /  /  \           / \
     *  -100 10   100     -100  10
     */
 /*   @Test
    public void removeRootTest(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(0);
        tree.insert(-50);
        tree.insert(50);
        tree.insert(-100);
        tree.insert(100);
        tree.insert(10);
        
        tree.remove(0);
        ArrayList<Integer> a = tree.getInOrder();
        for(int n : a)
            System.out.println(n);
        assert(a.size() == 5);
        assert(a.get(0) == 50);
        assert(a.get(1) == -50);
        assert(a.get(2) == -100);
        assert(a.get(3) == 10);
        assert(a.get(4) == 100);
    }*/
}
