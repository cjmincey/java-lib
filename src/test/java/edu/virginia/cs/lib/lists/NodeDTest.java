package edu.virginia.cs.lib.lists;

import org.junit.Test;

/**
 *
 * @author Jordan
 */
public class NodeDTest {
    @Test
    public void createNode(){
        NodeD<Integer> a = new NodeD<>(Integer.MAX_VALUE);
        assert(a.getVal() == Integer.MAX_VALUE);
        assert(a.getNext() == null);
        assert(a.getPrev() == null);
    }
    
    @Test
    public void createChain(){
        NodeD<Integer> a = new NodeD<>(Integer.MIN_VALUE);
        NodeD<Integer> b = new NodeD<>(Integer.MAX_VALUE);
        a.setNext(b);
        b.setPrev(a);
        assert(a.getNext() == b);
        assert(b.getNext() == null);
        assert(b.getPrev() == a);
        assert(a.getPrev() == null);
    }
}
