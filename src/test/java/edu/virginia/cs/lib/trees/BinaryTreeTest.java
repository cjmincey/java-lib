package edu.virginia.cs.lib.trees;

import java.util.ArrayList;
import java.util.stream.Collectors;
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
    
    @Test
    public void sizeTest(){
        BinaryTree<String> tree = new BinaryTree<>();
        assert(tree.getSize() == 0);
        tree.insert("hello");
        assert(tree.getSize() == 1);
        tree.insert("bye");
        assert(tree.getSize() == 2);
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
        
        ArrayList<Integer> a = tree.getPreOrder()
                .collect(Collectors.toCollection(ArrayList::new));
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
    
    /**
     *        0                 50
     *       / \               /  \
     *     -50 50      =>    -50  100
     *     /  /  \           / \
     *  -100 10   100     -100  10
     */
    @Test
    public void removeRootTest(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(0);
        tree.insert(-50);
        tree.insert(50);
        tree.insert(-100);
        tree.insert(100);
        tree.insert(10);
        
        tree.remove(0);
        tree.assertCorrectBinaryTree();
    }
    
    @Test
    public void removeNodeTest(){
        BinaryTree<Double> tree = new BinaryTree<>();
        tree.insert(0.0);
        tree.insert(-25.0);
        tree.insert(25.0);
        tree.insert(-100.0);
        tree.insert(100.0);
        
        tree.remove(25.0);
        tree.assertCorrectBinaryTree();
    }
}
