package example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ExpTest {
    @Test
    public void calc() {
        assertThat(5, is(7));
    }
}
