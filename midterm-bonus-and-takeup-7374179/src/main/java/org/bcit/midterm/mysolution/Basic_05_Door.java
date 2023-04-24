package src.main.java.org.bcit.midterm.mysolution;

public class Basic_05_Door {
    // Basic Question 05 (5 points, 4 TODOs)
    // Idea: tests your ability to create and use meaningful exceptions.

    // README FIRST
    // I will ONLY be reading from this package:
    //   org.bcit.comp2522.winter2023.midterm.answers
    //
    // TODO 0: Create a copy of this file in the answers package.
    // Put your answers in new classes that are labeled with the
    // question label, e.g., Basic_05_myClass. Name them something useful,
    // other than "myClass", that is just an example.

    boolean locked;
    boolean open;

    public Basic_05_Door() {
        this.locked = false; // starts unlocked
        this.open = false; // starts closed
    }

    public void open() throws Basic_05_LockedException {
        // TODO 1: Create a new exception called Basic_05_LockedException
        // and throw it if this is called while locked == true
        // otherwise, set open = true
        if (locked) {
            throw new Basic_05_LockedException("It is locked.");
        }
        open = true;
    }

    public void close() throws Basic_05_LockedException {
        // TODO 2: Use your new exception called Basic_05_LockedException
        // and throw it if this is called while locked == true
        // otherwise, set open = false
        if (locked) {
            throw new Basic_05_LockedException("It is locked.");
        }
        open = false;
    }

    public void unlock() {
        this.locked = false;
    }

    public void lock() throws Basic_05_OpenException {
        // TODO 3: Create a new exception called Basic_05_OpenException
        // and throw it if this is called while open == true
        // otherwise, set lock = true
        if (open) {
            throw new Basic_05_OpenException("It is opened.");
        }
        locked = true;
    }

    public void closeAndLock() {
        // TODO 4: Once you create and use your exceptions, surround each
        // with the appropriate try/catch block and handle any exceptions.
        try {
            this.close();
        } catch (Basic_05_LockedException e) {
            throw new RuntimeException(e);
        }
        try {
            this.lock();
        } catch (Basic_05_OpenException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // Note that you may need to wrap the below in try/catch blocks
        Basic_05_Door door = new Basic_05_Door();
        try {
            door.lock(); // should be OK
        } catch (Basic_05_OpenException e) {
            throw new RuntimeException(e);
        }
        try {
            door.open(); // should throw an exception since it is closed
        } catch (Basic_05_LockedException e) {
            throw new RuntimeException(e);
        }

        door.unlock(); // should be OK

        try {
            door.open(); // should be OK
        } catch (Basic_05_LockedException e) {
            throw new RuntimeException(e);
        }
        try {
            door.lock(); // should throw an exception since it is open
        } catch (Basic_05_OpenException e) {
            throw new RuntimeException(e);
        }
        door.closeAndLock(); // should be OK
    }

}
