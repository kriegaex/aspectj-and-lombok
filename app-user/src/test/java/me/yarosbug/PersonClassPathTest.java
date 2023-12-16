package me.yarosbug;

import org.junit.Test;

import static org.junit.Assert.*;

public class PersonClassPathTest {
    private static final String CLASS_PATH = System.getProperty("java.class.path").replace('\\', '/');

    @Test
    public void lombokApplied() {
        assertEquals("Person(name=John, age=32)", new Person("John", 32).toString());
    }

    @Test
    public void aspectsApplied() {
        assertEquals("Hello from Aspect!", Person.createHelloWorldString());
    }

    @Test
    public void wovenDependencyIsOnClassPath() {
        // Direct dependency on woven application is on CP
        assertTrue(CLASS_PATH.contains("/main-app-aspectj/"));
    }
    @Test
    public void unwovenDependencyIsNotOnClassPath() {
        // Transitive dependency on unwoven application is *not* CP (scope 'provided')
        assertFalse(CLASS_PATH.contains("/main-app/"));
    }
}
