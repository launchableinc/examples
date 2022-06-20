package example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class SubTest {
    @Test
    public void calc() {
        assertThat(new Sub().calc(8,2), is(6));
        assertThat(new Sub().calc(-8,2), is(-10));
        int max = 50;
        int min = 41;
        int range = max - min + 1;
        int rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        int rand2 = (int)(Math.random());
        int isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
    }
}
