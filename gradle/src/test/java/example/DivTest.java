package example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Ignore;


public class DivTest {
    @Ignore		
    @Test
    public void div1() {
        assertThat(new Div().calc(10,2), is(5));
        assertThat(new Div().calc(20,4), is(5));
        assertThat(new Div().calc(100,20), is(5));
        assertThat(new Div().calc(5,1), is(5));
        assertThat(new Div().calc(-5,-1), is(5));
        assertThat(new Div().calc(25,5), is(5));
    }
    @Ignore		
    @Test
    public void div2() {
        assertThat(new Div().calc(10,2), is(5));
        assertThat(new Div().calc(20,4), is(5));
        assertThat(new Div().calc(100,20), is(5));
        assertThat(new Div().calc(5,1), is(5));
        assertThat(new Div().calc(-5,-1), is(5));
        assertThat(new Div().calc(25,5), is(5));
    }
    @Test
    public void div3() {
        assertThat(new Div().calc(100,20), is(5));
        assertThat(new Div().calc(5,1), is(5));
        assertThat(new Div().calc(-5,-1), is(5));
        assertThat(new Div().calc(25,5), is(5));
    }
     @Test
    public void div4() {
        assertThat(new Div().calc(100,20), is(5));
        assertThat(new Div().calc(5,1), is(5));
        assertThat(new Div().calc(-5,-1), is(5));
        assertThat(new Div().calc(25,5), is(5));
    }
     @Test
    public void div5() {
        assertThat(new Div().calc(100,20), is(5));
        assertThat(new Div().calc(5,1), is(5));
        assertThat(new Div().calc(-5,-1), is(5));
        assertThat(new Div().calc(25,5), is(5));
    }
}
