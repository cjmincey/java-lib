package edu.virginia.cs.lib.lists;

import org.junit.Test;

/**
 *
 * @author Jordan Mincey
 */
public class QueueTest {
    @Test
    public void intQueue(){
        Queue<Integer> q = new Queue<>();
        assert(!q.peek().isPresent());
        assert(!q.dequeue().isPresent());
        q.enqueue(Integer.MAX_VALUE);
        assert(q.peek().get() == Integer.MAX_VALUE);
        assert(q.dequeue().get() == Integer.MAX_VALUE);
        assert(!q.dequeue().isPresent());
        q.enqueue(Integer.MAX_VALUE);
        q.enqueue(Integer.MIN_VALUE);
        assert(q.dequeue().get() == Integer.MAX_VALUE);
        assert(q.peek().get() == Integer.MIN_VALUE);
        assert(q.dequeue().get() == Integer.MIN_VALUE);
        assert(!q.peek().isPresent());
    }
    
    @Test
    public void stringQueue(){
        String[] s = {"hello", "bye", "aloha"};
        Queue<String> q = new Queue<>();
        q.enqueue(s[0]);
        q.enqueue(s[1]);
        q.enqueue(s[2]);
        assert(q.dequeue().get().equals(s[0]));
        assert(q.dequeue().get().equals(s[1]));
        assert(q.dequeue().get().equals(s[2]));
        assert(!q.dequeue().isPresent());
    }
}
