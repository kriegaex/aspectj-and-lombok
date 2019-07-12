package me.yarosbug;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LombokNoAspectJPersonTest {
    @Test
    public void lombokApplied() {
        assertEquals("Person(name=John, age=32)", new Person("John", 32).toString());
    }

    @Test
    public void noAspectsApplied() {
        assertEquals("Hello, World!", Person.createHelloWorldString());
    }
}
