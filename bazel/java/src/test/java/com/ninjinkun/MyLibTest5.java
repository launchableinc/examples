package com.ninjinkun;
 
import static org.junit.Assert.assertEquals;
 
import org.junit.Test;
 
public class MyLibTest5 {
  @Test
  public void testFibonacci() {
    try {
       Thread.sleep(2000);
    } catch(Exception e) {
    }
    assertEquals(89, MyLib.fibonacci(11));
    assertEquals(89, MyLib.fibonacci(12));
  }
}
