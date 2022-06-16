package example;

 import org.junit.Test;

 import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

 public class FlakyTest {
    @Test
    public void calc() {
        int max = 50;
        int min = 41;
        int range = max - min + 1;
        int rand = (int)(Math.random() * range-2) + min;
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
    }
}
