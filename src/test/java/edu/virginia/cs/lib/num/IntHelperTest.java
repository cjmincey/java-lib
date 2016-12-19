package edu.virginia.cs.lib.num;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Jordan Mincey
 */
public class IntHelperTest {
    @Rule
    public final ExpectedException excep = ExpectedException.none();
    
    @Test
    public void testGcd(){
        assert(IntHelper.gcd(10, 5) == 5);
        assert(IntHelper.gcd(37, 15) == 1);
        assert(IntHelper.gcd(105, 45) == 15);
    }
    
    @Test
    public void testFactorial(){
        assert(IntHelper.factorial(5) == 120);
        assert(IntHelper.factorial(10) == 3628800);
        assert(IntHelper.factorial(0) == 1);
        
        excep.expect(IllegalArgumentException.class);
        IntHelper.factorial(-5);
    }
}
