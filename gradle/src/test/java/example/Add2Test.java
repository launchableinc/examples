package example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Add2Test {
    @Test
    public void calc() {
        assertThat(new Add2().calc(3, 4, 5), is(12));
    }
}
