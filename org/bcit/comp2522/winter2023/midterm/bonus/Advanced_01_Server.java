package org.bcit.comp2522.winter2023.midterm.bonus;

import java.util.Random;

public class Advanced_01_Server {

    // Declare a private static variable to hold the single instance of the class.
    private static Advanced_01_Server instance;

    // Declare a final variable to hold a unique identifier for the server instance.
    private final int uid;

    // Declare a private boolean variable to represent the server's connection status.
    private boolean connected;

    // Private constructor to prevent external instantiation of the class.
    private Advanced_01_Server() {
        // Create a new Random object to generate a unique identifier.
        Random random = new Random();
        // Generate a random integer and assign it to the uid variable.
        this.uid = random.nextInt();
        // Set the connected variable to false by default.
        this.connected = false;
    }

    // Set the connected variable to false by default.
    public static Advanced_01_Server getInstance() {
        // If the instance variable is null, create a new instance of the class.
        if (instance == null) {
            instance = new Advanced_01_Server();
        }
        // Return the instance variable.
        return instance;
    }

    // Public method to get the unique identifier of the server instance.
    public int getUid() {
        return uid;
    }

    // Public method to check if the server is connected.
    public boolean isConnected() {
        return connected;
    }

    // Public method to connect the server.
    public void connect() {
        connected = true;
    }

    // Public method to disconnect the server.
    public void disconnect() {
        connected = false;
    }
}