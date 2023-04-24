package src.main.java.org.bcit.midterm.mysolution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Advanced_01_ServerTest {

    @Test
    public void testSingletonInstance() {
    // testSingletonInstance(): This method tests whether the server class is
    // implemented as a singleton. It creates two instances of the class and ensures
    // that they refer to the same object using the assertSame() method.
    // This is a good test to ensure that the server class behaves correctly as a singleton.
        Advanced_01_Server instance1 = Advanced_01_Server.getInstance();
        Advanced_01_Server instance2 = Advanced_01_Server.getInstance();
        assertSame(instance1, instance2);
    }
    @Test
    public void testUidUniqueness() {
    // testUidUniqueness(): This method tests whether the server class generates
    // unique UIDs for each instance. It creates two instances of the class and
    // ensures that their UIDs are not the same using the assertNotSame() method.
    // This is a good test to ensure that the server class generates unique
    // identifiers correctly.
        Advanced_01_Server instance1 = Advanced_01_Server.getInstance();
        Advanced_01_Server instance2 = Advanced_01_Server.getInstance();
        assertNotSame(instance1.getUid(), instance2.getUid());
    }

    @Test
    public void testConnect() {
    // testConnect(): This method tests whether the server class can connect to
    // a remote server. It creates an instance of the class, checks that it is not
    // connected, and then calls the connect() method. Finally, it checks that
    // the server is connected using the assertTrue() method. This is a good test
    // to ensure that the server class can establish a connection with a remote server.
        Advanced_01_Server instance = Advanced_01_Server.getInstance();
        assertFalse(instance.isConnected());
        instance.connect();
        assertTrue(instance.isConnected());
    }

    @Test
    public void testDisconnect() {
    // testDisconnect(): This method tests whether the server class can disconnect
    // from a remote server. It creates an instance of the class, connects to the server,
    // checks that it is connected, and then calls the disconnect() method.
    // Finally, it checks that the server is disconnected using the assertFalse() method.
    // This is a good test to ensure that the server class can cleanly disconnect from
    // a remote server.
        Advanced_01_Server instance = Advanced_01_Server.getInstance();
        instance.connect();
        assertTrue(instance.isConnected());
        instance.disconnect();
        assertFalse(instance.isConnected());
    }
}