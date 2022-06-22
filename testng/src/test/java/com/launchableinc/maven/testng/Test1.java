package com.launchableinc.maven.testng;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Test1 {
    @Test
    public void test1() {
        assertTrue(true);
    }

    @Test
    public void test2() {
        assertTrue(true);
    }

    /**
     * This test should be excluded.
     */
    @Test
    public void test3() {
        assertTrue(false);
    }
}
