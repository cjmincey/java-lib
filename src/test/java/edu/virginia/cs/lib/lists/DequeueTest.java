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
        assert(!d.peekHead().isPresent());
        assert(!d.peekTail().isPresent());
        d.addHead(Integer.MAX_VALUE);
        d.addHead(Integer.MIN_VALUE);
        d.addHead(Integer.SIZE);
        assert(d.removeTail().get() == Integer.MAX_VALUE);
        assert(d.removeHead().get() == Integer.SIZE);
        assert(d.removeHead().get() == Integer.MIN_VALUE);
        assert(!d.peekHead().isPresent());
        assert(!d.peekTail().isPresent());
    }
    
    @Test
    public void addTailTest(){
        Dequeue<Integer> d = new Dequeue<>();
        assert(!d.removeHead().isPresent());
        assert(!d.removeTail().isPresent());
        d.addTail(Integer.MAX_VALUE);
        d.addTail(Integer.SIZE);
        assert(d.removeHead().get() == Integer.MAX_VALUE);
        assert(d.removeTail().get() == Integer.SIZE);
        assert(!d.removeHead().isPresent());
        assert(!d.removeTail().isPresent());
        d.addHead(Integer.SIZE);
        d.addTail(Integer.MAX_VALUE);
        d.addHead(Integer.MIN_VALUE);
        assert(d.removeTail().get() == Integer.MAX_VALUE);
        assert(d.removeHead().get() == Integer.MIN_VALUE);
        assert(d.peekHead().get() == Integer.SIZE);
        assert(d.peekTail().get() == Integer.SIZE);
        assert(d.removeHead().get() == Integer.SIZE);
        assert(!d.removeTail().isPresent());
        assert(!d.removeHead().isPresent());
    }
}
