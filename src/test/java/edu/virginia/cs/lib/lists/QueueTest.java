package edu.virginia.cs.lib.lists;

import edu.virginia.cs.lib.lists.Queue;
import org.junit.Test;

/**
 *
 * @author Jordan Mincey
 */
public class QueueTest {
    @Test
    public void intQueue(){
        Queue<Integer> q = new Queue<>();
        assert(q.peek() == null);
        assert(q.dequeue() == null);
        q.enqueue(Integer.MAX_VALUE);
        assert(q.peek() == Integer.MAX_VALUE);
        assert(q.dequeue() == Integer.MAX_VALUE);
        assert(q.dequeue() == null);
        q.enqueue(Integer.MAX_VALUE);
        q.enqueue(Integer.MIN_VALUE);
        assert(q.dequeue() == Integer.MAX_VALUE);
        assert(q.peek() == Integer.MIN_VALUE);
        assert(q.dequeue() == Integer.MIN_VALUE);
        assert(q.peek() == null);
    }
    
    @Test
    public void stringQueue(){
        String[] s = {"hello", "bye", "aloha"};
        Queue<String> q = new Queue<>();
        q.enqueue(s[0]);
        q.enqueue(s[1]);
        q.enqueue(s[2]);
        assert(q.dequeue().equals(s[0]));
        assert(q.dequeue().equals(s[1]));
        assert(q.dequeue().equals(s[2]));
        assert(q.dequeue() == null);
    }
}
