package example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class AddTest {
    @Test
    public void calc() {
        assertThat(new Add().calc(3,4), is(7));
    }
}
