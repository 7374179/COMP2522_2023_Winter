package org.bcit.comp2522.winter2023.midterm.bonus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Advanced_01_MySolution {
//    This JUnit test class tests a Singleton class named "Advanced_01_Server"
//    and contains three methods to check that only one instance can be created,
//    the UID is not zero, and the connected state can be set and checked.checked

    @Test
    public void testSingleton() {
        // Get two instances of the Singleton class
        Advanced_01_Server instance1 = Advanced_01_Server.getInstance();
        Advanced_01_Server instance2 = Advanced_01_Server.getInstance();

        // Ensure that they are the same instance
        assertSame(instance1, instance2);
    }

    @Test
    public void testUid() {
        // Get an instance of the Singleton class
        Advanced_01_Server instance = Advanced_01_Server.getInstance();

        // Ensure that the UID is not zero
        assertNotEquals(0, instance.getUid());
    }

    @Test
    public void testConnected() {
        // Get an instance of the Singleton class
        Advanced_01_Server instance = Advanced_01_Server.getInstance();

        // Ensure that the initial connected state is false
        assertFalse(instance.isConnected());

        // Set the connected state to true
        instance.connect();

        // Ensure that the connected state is now true
        assertTrue(instance.isConnected());

    }
}
