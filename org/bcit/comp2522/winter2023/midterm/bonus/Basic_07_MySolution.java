package org.bcit.comp2522.winter2023.midterm.bonus;

public class Basic_07_MySolution {
// TODO 1: Trace the code from the next line and write down in a comment
// directly below this TODO the exact sequence of method calls that the following code initiates
// in the correct order. Include only the method calls.
    public static void main(String[] args) {
        Basic_07_MySolution test = new Basic_07_MySolution();
        test.doSomething();
    }

    private void doSomething() {
        A a = new A();
        a.foo();
        B b = new B();
        b.bar();
        C c = new C();
        c.baz();
    }

    private static class A {
        public void foo() {
            System.out.println("A.foo()");
        }
    }

    private static class B {
        public void bar() {
            System.out.println("B.bar()");
        }
    }

    private static class C {
        public void baz() {
            System.out.println("C.baz()");
        }
    }
}

// order:

// The doSomething() method creates instances of classes A, B, and C, and then calls methods
// foo() of A, bar() of B, and baz() of C, in that order. Therefore, the exact sequence of
// method calls is:
//
// a.foo()
// b.bar()
// c.baz()