package example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class SubTest {
    @Test
    public void calc() {
        assertThat(new Sub().calc(8,2), is(6));
    }
}
