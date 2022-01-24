package com.ninjinkun;
 
import static org.junit.Assert.assertEquals;
 
import org.junit.Test;
 
public class MyLibTest2 {
  @Test
  public void testFibonacci() {
    try {
       Thread.sleep(2000);
    } catch(Exception e) {
    }
    assertEquals(144, MyLib.fibonacci(12));
  }
}
