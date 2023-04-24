package src.main.java.org.bcit.midterm.mysolution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Advanced_03_MySolution {
//    This code implements the Composite pattern to represent a hierarchical structure of employees,
//    where a Manager can have subordinates who can also be Managers or Workers.
//    The Employee class is an abstract class that defines common methods for both Managers and Workers,
//    such as add(), remove(), getSubordinates(), and getTotalSalary().
//    The Manager class extends the Employee class and maintains a list of subordinates,
//    while the Worker class is a leaf node that cannot have subordinates.

    public abstract class Employee {
        private String name;
        private int salary;

        public Employee(String name, int salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getSalary() {
            return salary;
        }

        public abstract void add(Employee employee);

        public abstract void remove(Employee employee);

        public abstract List<Employee> getSubordinates();

        public abstract int getTotalSalary();
    }

    public class Manager extends Employee {
        private List<Employee> subordinates;

        public Manager(String name, int salary) {
            super(name, salary);
            subordinates = new ArrayList<>();
        }

        public void add(Employee employee) {
            subordinates.add(employee);
        }

        public void remove(Employee employee) {
            subordinates.remove(employee);
        }

        public List<Employee> getSubordinates() {
            return subordinates;
        }

        public int getTotalSalary() {
            int totalSalary = getSalary();
            for (Employee employee : subordinates) {
                totalSalary += employee.getTotalSalary();
            }
            return totalSalary;
        }
    }

    public class Worker extends Employee {
        public Worker(String name, int salary) {
            super(name, salary);
        }

        public void add(Employee employee) {
            // Cannot add employees to a worker
        }

        public void remove(Employee employee) {
            // Cannot remove employees from a worker
        }

        public List<Employee> getSubordinates() {
            // Workers have no subordinates
            return Collections.emptyList();
        }

        public int getTotalSalary() {
            return getSalary();
        }
    }

    public static void main(String[] args) {
        Advanced_03_MySolution solution = new Advanced_03_MySolution();

        Advanced_03_MySolution.Manager manager1 = solution.new Manager("John", 50000);
        Advanced_03_MySolution.Manager manager2 = solution.new Manager("Jane", 60000);

        Advanced_03_MySolution.Worker worker1 = solution.new Worker("Bob", 20000);
        Advanced_03_MySolution.Worker worker2 = solution.new Worker("Alice", 25000);
        Advanced_03_MySolution.Worker worker3 = solution.new Worker("Charlie", 30000);

        manager1.add(worker1);
        manager1.add(worker2);
        manager2.add(worker3);

        Advanced_03_MySolution.Manager ceo = solution.new Manager("Mark", 100000);
        ceo.add(manager1);
        ceo.add(manager2);

        System.out.println("CEO total salary: " + ceo.getTotalSalary());
    }
}