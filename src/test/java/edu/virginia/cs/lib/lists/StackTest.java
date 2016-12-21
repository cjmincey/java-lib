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
        assert(s.peek() == null);
        s.push(Integer.MAX_VALUE);
        assert(s.peek() == Integer.MAX_VALUE);
        s.push(1);
        s.push(2);
        s.push(3);
        assert(s.pop() == 3);
        assert(s.pop() == 2);
        assert(s.pop() == 1);
        assert(s.pop() == Integer.MAX_VALUE);
        assert(s.peek() == null);
        assert(s.pop() == null);
    }
    
    @Test
    public void stringStack(){
        String[] a = {"hello", "test", "world"};
        
        Stack<String> s = new Stack<>();
        s.push(a[0]);
        s.push(a[1]);
        s.push(a[2]);
        assert(s.pop().equals(a[2]));
        assert(s.peek().equals(a[1]));
        assert(s.pop().equals(a[1]));
        assert(s.pop().equals(a[0]));
        assert(s.pop() == null);
    }
}
