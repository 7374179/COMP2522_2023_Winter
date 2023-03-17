package org.bcit.comp2522.winter2023.midterm.bonus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Advanced_01_ServerTest {

    @Test
    public void testSingletonInstance() {
        Advanced_01_Server instance1 = Advanced_01_Server.getInstance();
        Advanced_01_Server instance2 = Advanced_01_Server.getInstance();
        assertSame(instance1, instance2);
    }
//    @Test
//    public void testUidUniqueness() {
//        Advanced_01_Server instance1 = Advanced_01_Server.getInstance();
//        Advanced_01_Server instance2 = Advanced_01_Server.getInstance();
//        assertNotEquals(instance1.getUid(), instance2.getUid());
//    }

    @Test
    public void testConnect() {
        Advanced_01_Server instance = Advanced_01_Server.getInstance();
        assertFalse(instance.isConnected());
        instance.connect();
        assertTrue(instance.isConnected());
    }

    @Test
    public void testDisconnect() {
        Advanced_01_Server instance = Advanced_01_Server.getInstance();
        instance.connect();
        assertTrue(instance.isConnected());
        instance.disconnect();
        assertFalse(instance.isConnected());
    }
}