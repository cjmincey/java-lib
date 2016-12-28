package edu.virginia.cs.lib.lists;

import org.junit.Test;

/**
 *
 * @author Jordan
 */
public class StackTest {
    @Test
    public void intStack(){
        Stack<Integer> s = new Stack<>();
        assert(!s.peek().isPresent());
        s.push(Integer.MAX_VALUE);
        assert(s.peek().get() == Integer.MAX_VALUE);
        s.push(1);
        s.push(2);
        s.push(3);
        assert(s.pop().get() == 3);
        assert(s.pop().get() == 2);
        assert(s.pop().get() == 1);
        assert(s.pop().get() == Integer.MAX_VALUE);
        assert(!s.peek().isPresent());
        assert(!s.pop().isPresent());
    }
    
    @Test
    public void stringStack(){
        String[] a = {"hello", "test", "world"};
        
        Stack<String> s = new Stack<>();
        s.push(a[0]);
        s.push(a[1]);
        s.push(a[2]);
        assert(s.pop().get().equals(a[2]));
        assert(s.peek().get().equals(a[1]));
        assert(s.pop().get().equals(a[1]));
        assert(s.pop().get().equals(a[0]));
        assert(!s.pop().isPresent());
    }
}
