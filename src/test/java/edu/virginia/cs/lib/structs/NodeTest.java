package edu.virginia.cs.lib.structs;

import org.junit.Test;

/**
 *
 * @author Jordan
 */
public class NodeTest {
    @Test
    public void createNode(){
        Node<Integer> a = new Node<>(Integer.MAX_VALUE);
        assert(a.getVal() == Integer.MAX_VALUE);
        assert(a.getNext() == null);
    }
    
    @Test
    public void createChain(){
        Node<Integer> a = new Node<>(Integer.MIN_VALUE);
        Node<Integer> b = new Node<>(Integer.MAX_VALUE);
        a.setNext(b);
        assert(a.getNext() == b);
        assert(b.getNext() == null);
    }
}
