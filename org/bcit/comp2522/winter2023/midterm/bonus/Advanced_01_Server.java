package org.bcit.comp2522.winter2023.midterm.bonus;

import java.util.Random;

public class Advanced_01_Server {

    private static Advanced_01_Server instance;
    private final int uid;
    private boolean connected;

    private Advanced_01_Server() {
        Random random = new Random();
        this.uid = random.nextInt();
        this.connected = false;
    }

    public static Advanced_01_Server getInstance() {
        if (instance == null) {
            instance = new Advanced_01_Server();
        }
        return instance;
    }

    public int getUid() {
        return uid;
    }

    public boolean isConnected() {
        return connected;
    }

    public void connect() {
        connected = true;
    }

    public void disconnect() {
        connected = false;
    }

}