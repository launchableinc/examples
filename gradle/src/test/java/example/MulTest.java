package example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MulTest {
    @Test
    public void calc() {
        assertThat(new Mul().calc(8,2), is(16));
        assertThat(new Mul().calc(8,3), is(24));
        assertThat(new Mul().calc(8,4), is(32));
        assertThat(new Mul().calc(8,3), is(24));
        assertThat(new Mul().calc(2,2), is(4));
        assertThat(new Mul().calc(8,2), is(16));
        assertThat(new Mul().calc(11,5), is(55));
        assertThat(new Mul().calc(0,5), is(0));
        assertThat(new Mul().calc(4,8), is(32));
        assertThat(new Mul().calc(9,8), is(72));
    }
}
