package org.bcit.comp2522.winter2023.midterm.bonus;

import java.util.ArrayList;
import java.util.List;

public class Advanced_03_CompositeManager {
    // Advanced Question 03 (20 points, 4 TODOs)
    // Idea: tests your ability to create and use iterators.

    // README FIRST
    // I will ONLY be reading from this package:
    //   org.bcit.comp2522.winter2023.midterm.answers
    //
    // TODO 0: Create a copy of this file in the answers package.
    // Put your answers in new classes that are labeled with the
    // question label, e.g., Advanced_03_myClass. Name them something
    // useful, other than "myClass", that is just an example.

    // TODO 1: Following the Composite Pattern directly, create a system
    // of classes that represent composed text elements.
    // - A Paragraph class has a String and a print method.
    // - A Document is composed of zero or more Paragraphs or Documents.
    // - A Document has an add, remove, and a print method.

    // TODO 2: Create a main method that demonstrates how your Composite
    // Pattern works. Create at a Document that has at least two levels
    // of nesting within it.

    /**
     * 컴포지트 패턴은 전체-부분의 관계를 갖는 객체들 사이의 관계를 정의할 때 유용하다.
     * 그리고 클라이언트는 전체와 부분을 구분하지 않고 동일한 인터페이스를 사용할 수 있다.
     */
    public static void main(String[] args) {
        File file01 = new File("기밀문서.txt", 100);
        File file02 = new File("임시파일.txt", 30);
        File file03 = new File("새파일.txt", 0);
        File file04 = new File("test.txt", 70);

        Folder folder01 = new Folder("직박구리");
        Folder folder02 = new Folder("새폴더");

        folder01.addComponent(file01);
        folder01.addComponent(file02);
        folder01.addComponent(folder02);

        folder02.addComponent(file03);
        folder02.addComponent(file04);

        System.out.println("name : " + folder01.getName());
        System.out.println("total size : " + folder01.getSize());
    }
}

abstract class Component {
    public abstract String getName();

    public abstract int getSize();
}

class File extends Component {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }
}

class Folder extends Component {
    private String name;
    private List<Component> components = new ArrayList<Component>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(Component component) {
        this.components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Component item : components) {
            size += item.getSize();
        }
        return size;
    }
}



