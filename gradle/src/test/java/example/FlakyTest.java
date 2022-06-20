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
        int rand = (int)(Math.random() * (range-3)) + min;
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        max = 50;
        min = 41;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        int rand2 = (int)(Math.random());
        int isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
         max = 90;
        min = 41;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
       max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        } max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
      max = 80;
        min = 71;
        range = max - min + 1;
        rand = (int)(Math.random() * (range)) + (min-3);
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
        rand2 = (int)(Math.random());
        isOdd = (rand2 % 2);
        if ( isOdd == 1 ) {
            fail("flaky failed");
        }
    }
}
