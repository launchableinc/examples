package example;

 import org.junit.Test;

 import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

 public class FlakyTest {
    @Test
    public void flaky1() {
        int max = 50;
        int min = 41;
        int range = max - min + 1;
        int rand = (int)(Math.random() * (range-3)) + min;
        if (rand < min || rand  > max)  {
          fail("random number is not between range, flaky test failed");
        }
     
       long timestamp = System.currentTimeMillis() / 1000;
       if (timestamp < 50) {
        fail("current time seconds is greater than 50.");
       }
    }
    @Test
    public void flaky2() {
       long timestamp = System.currentTimeMillis() / 1000;
       if (timestamp < 56) {
        fail("current time seconds is greater than 50.");
       }
    }
  @Test
    public void flaky3() {
       long timestamp = System.currentTimeMillis() / 1000;
       if (timestamp < 51) {
        fail("current time seconds is greater than 50.");
       }
    }
  @Test
    public void flaky4() {
       long timestamp = System.currentTimeMillis() / 1000;
      System.out.print(timestamp);
       if (timestamp < 50) {
        fail("current time seconds is greater than 50.");
       }
    }
   @Test
    public void flaky6() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp < 50) {
        fail("current time seconds is greater than 50.");
       }
    }
   @Test
    public void flaky7() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp < 52) {
        fail("current time seconds is greater than 50.");
       }
    }
   @Test
    public void flaky8() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp < 53) {
        fail("current time seconds is greater than 50.");
       }
    }
   @Test
    public void flaky9() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp % 2 == 1) {
        fail("current time seconds is odd.");
       }
    }
    @Test
    public void flaky10() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp < 52) {
        fail("current time seconds is greater than 50.");
       }
    }
   @Test
    public void flaky11() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp < 53) {
        fail("current time seconds is greater than 50.");
       }
    }
   @Test
    public void flaky12() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp % 2 == 1) {
        fail("current time seconds is odd.");
       }
    }
    @Test
    public void flaky13() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp < 52) {
        fail("current time seconds is greater than 50.");
       }
    }
   @Test
    public void flaky14() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp < 53) {
        fail("current time seconds is greater than 50.");
       }
    }
   @Test
    public void flaky15() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp % 2 == 1) {
        fail("current time seconds is odd.");
       }
    }
    @Test
    public void flaky16() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp < 52) {
        fail("current time seconds is greater than 50.");
       }
    }
   @Test
    public void flaky17() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp < 53) {
        fail("current time seconds is greater than 50.");
       }
    }
   @Test
    public void flaky18() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp % 2 == 1) {
        fail("current time seconds is odd.");
       }
    }
   @Test
    public void flaky19() {
       long timestamp = System.currentTimeMillis() / 1000;
       if (timestamp % 2 == 1) {
        fail("current time seconds is odd.");
       }
    }
   @Test
    public void flaky20() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp % 2 == 1) {
        fail("current time seconds is odd.");
       }
    }
  @Test
    public void flaky21() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp < 52) {
        fail("current time seconds is greater than 50.");
       }
    }
  @Test
    public void flaky22() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp < 52) {
        fail("current time seconds is greater than 50.");
       }
    }
  @Test
    public void flaky23() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp < 53) {
        fail("current time seconds is greater than 50.");
       }
    }
  @Test
    public void flaky24() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp < 55) {
        fail("current time seconds is greater than 50.");
       }
    }
  @Test
    public void flaky25() {
       long timestamp = System.currentTimeMillis() / 1000;
     System.out.print(timestamp);
       if (timestamp < 54) {
        fail("current time seconds is greater than 50.");
       }
    }
}
