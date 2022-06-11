package example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class BitwiseORTest {
    @Test
    public void calc() {
        assertThat(new BitwiseOR().calc(25,100), is(125));
        assertThat(new BitwiseOR().calc(250,100), is(254));
    }
}
