package edu.virginia.cs.lib.lists;

import org.junit.Test;

/**
 *
 * @author Jordan Mincey
 */
public class DequeueTest {
    @Test
    public void addHeadTest(){
        Dequeue<Integer> d = new Dequeue<>();
        assert(d.peekHead() == null);
        assert(d.peekTail() == null);
        d.addHead(Integer.MAX_VALUE);
        d.addHead(Integer.MIN_VALUE);
        d.addHead(Integer.SIZE);
        assert(d.removeTail() == Integer.MAX_VALUE);
        assert(d.removeHead() == Integer.SIZE);
        assert(d.removeHead() == Integer.MIN_VALUE);
        assert(d.peekHead() == null);
        assert(d.peekTail() == null);
    }
    
    @Test
    public void addTailTest(){
        Dequeue<Integer> d = new Dequeue<>();
        assert(d.removeHead() == null);
        assert(d.removeTail() == null);
        d.addTail(Integer.MAX_VALUE);
        d.addTail(Integer.SIZE);
        assert(d.removeHead() == Integer.MAX_VALUE);
        assert(d.removeTail() == Integer.SIZE);
        assert(d.removeHead() == null);
        assert(d.removeTail() == null);
        d.addHead(Integer.SIZE);
        d.addTail(Integer.MAX_VALUE);
        d.addHead(Integer.MIN_VALUE);
        assert(d.removeTail() == Integer.MAX_VALUE);
        assert(d.removeHead() == Integer.MIN_VALUE);
        assert(d.peekHead() == Integer.SIZE);
        assert(d.peekTail() == Integer.SIZE);
        assert(d.removeHead() == Integer.SIZE);
        assert(d.removeTail() == null);
        assert(d.removeHead() == null);
    }
}
