package org.bcit.comp2522.winter2023.midterm.bonus;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class Basic_06_DoorTest_answer {

    @org.junit.jupiter.api.Test
    void unlock1() {
        Basic_05_Door door = new Basic_05_Door();
        assertFalse(door.locked);
    }
    @org.junit.jupiter.api.Test
    void unlock2() {
        Basic_05_Door door = new Basic_05_Door();
        try {
            door.lock();
        } catch (Basic_05_OpenException e) {
            throw new RuntimeException(e);
        }
        assertTrue(door.locked);
    }

    @org.junit.jupiter.api.Test
    void lock1() {
        Basic_05_Door door = new Basic_05_Door();
        try {
            door.open();
        } catch (Basic_05_LockedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(door.open);
    }
    @org.junit.jupiter.api.Test
    void lock2() throws Basic_05_LockedException {
        Basic_05_Door door = new Basic_05_Door();
        door.close();
        assertFalse(door.open);
    }
}


//    public void unlock() {
//        this.locked = false;
//    }
//
//    public void lock() throws Basic_05_OpenException {
//        // TODO 3: Create a new exception called Basic_05_OpenException
//        // and throw it if this is called while open == true
//        // otherwise, set lock = true
//        if (open) {
//            throw new Basic_05_OpenException("It is opened.");
//        }
//        locked = true;
//    }