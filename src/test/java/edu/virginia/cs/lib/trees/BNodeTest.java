package edu.virginia.cs.lib.trees;

import org.junit.Test;

/**
 *
 * @author Jordan
 */
public class BNodeTest {
    /**
     *      50
     *     /  \
     *  -100   100
     *           \
     *           150
     */
    @Test
    public void findRightMostNodeTest(){
        BNode<Integer> tree = new BNode<>(50, 
                new BNode<>(-100), new BNode<>(100,
                        null, new BNode<>(150)));
        assert(BNode.findRightMostNode(tree).getVal() == 150);
    }
    
    /**
     *       50
     *      /  \
     *    -100  100
     *       \
     *        0
     */
    @Test
    public void findLeftMostNodeTest(){
        BNode<Integer> tree = new BNode<>(50,
                new BNode<>(-100, null, new BNode<>(0)),
                new BNode<>(100));
        assert(BNode.findLeftMostNode(tree).getVal() == -100);
    }
}
