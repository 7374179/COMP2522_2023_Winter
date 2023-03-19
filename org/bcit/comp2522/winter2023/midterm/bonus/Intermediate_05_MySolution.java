package org.bcit.comp2522.winter2023.midterm.bonus;

import java.util.ArrayList;
import java.util.List;

public class Intermediate_05_MySolution {

    // All classes should be prefixed with Intermediate_05_MySolution_.
    // 1. There should be a class called MenuItem that contains information
    //  about a menu item, such as name, price, and description.
    // 2. There should be a class called OrderItem that contains information
    //  about an item ordered by a customer, including the menu item
    //  and the quantity ordered.
    // 3. There should be a class called Order that contains information
    //  about an entire order, including the customer who placed the order,
    //  the list of order items, and the total price.
    // 4. There should be a class called Customer that contains information
    //  about a customer, such as their name and contact information.
    // 5. There should be an interface called Orderable that defines methods
    //   for placing and viewing orders.
    // 6. There should be a class called CustomerOrderingSystem
    //   that implements the Orderable interface and allows customers
    //   to place orders and view their order history.
    // 7. There should be a class called StaffOrderingSystem
    //  that allows restaurant staff to view and manage orders,
    //  including marking orders as complete and viewing the list of orders.

    // 1. MenuItem class
    class Intermediate_05_MySolution_MenuItem {
        private String name;
        private double price;
        private String description;

        public Intermediate_05_MySolution_MenuItem(String name, double price, String description) {
            this.name = name;
            this.price = price;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public String getDescription() {
            return description;
        }
    }

    // 2. OrderItem class
    class Intermediate_05_MySolution_OrderItem {
        private Intermediate_05_MySolution_MenuItem menuItem;
        private int quantity;

        public Intermediate_05_MySolution_OrderItem(Intermediate_05_MySolution_MenuItem menuItem, int quantity) {
            this.menuItem = menuItem;
            this.quantity = quantity;
        }

        public Intermediate_05_MySolution_MenuItem getMenuItem() {
            return menuItem;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    // 3. Order class
    class Intermediate_05_MySolution_Order {
        private Intermediate_05_MySolution_Customer customer;
        private List<Intermediate_05_MySolution_OrderItem> orderItems;
        private double totalPrice;
        private boolean complete;

        public Intermediate_05_MySolution_Order(Intermediate_05_MySolution_Customer customer) {
            this.customer = customer;
            this.orderItems = new ArrayList<>();
            this.totalPrice = 0;
        }

        public Intermediate_05_MySolution_Customer getCustomer() {
            return customer;
        }

        public List<Intermediate_05_MySolution_OrderItem> getOrderItems() {
            return orderItems;
        }

        public void setComplete(boolean complete) {
            this.complete = complete;
        }

        public boolean isComplete() {
            return complete;
        }

        public void addOrderItem(Intermediate_05_MySolution_OrderItem orderItem) {
            this.orderItems.add(orderItem);
            this.totalPrice += orderItem.getMenuItem().getPrice() * orderItem.getQuantity();
        }

        public double getTotalPrice() {
            return totalPrice;
        }
    }

    // 4. Customer class
    class Intermediate_05_MySolution_Customer {
        private String name;
        private String contactInfo;

        public Intermediate_05_MySolution_Customer(String name, String contactInfo) {
            this.name = name;
            this.contactInfo = contactInfo;
        }

        public String getName() {
            return name;
        }

        public String getContactInfo() {
            return contactInfo;
        }
    }

    // 5. Orderable interface
    interface Intermediate_05_MySolution_Orderable {
        void placeOrder(Intermediate_05_MySolution_Order order);

        List<Intermediate_05_MySolution_Order> getOrderHistory(Intermediate_05_MySolution_Customer customer);
    }

    // 6. CustomerOrderingSystem class
    class Intermediate_05_MySolution_CustomerOrderingSystem implements Intermediate_05_MySolution_Orderable {
        private List<Intermediate_05_MySolution_Order> orders;

        public Intermediate_05_MySolution_CustomerOrderingSystem() {
            this.orders = new ArrayList<>();
        }

        public void placeOrder(Intermediate_05_MySolution_Order order) {
            orders.add(order);
        }

        public List<Intermediate_05_MySolution_Order> getOrderHistory(Intermediate_05_MySolution_Customer customer) {
            List<Intermediate_05_MySolution_Order> customerOrders = new ArrayList<>();
            for (Intermediate_05_MySolution_Order order : orders) {
                if (order.getCustomer().equals(customer)) {
                    customerOrders.add(order);
                }
            }
            return customerOrders;
        }
    }

    // 7. StaffOrderingSystem class
    class Intermediate_05_MySolution_StaffOrderingSystem {
        private List<Intermediate_05_MySolution_Order> orders;

        public Intermediate_05_MySolution_StaffOrderingSystem(List<Intermediate_05_MySolution_Order> orders) {
            this.orders = orders;
        }

        public void markOrderAsComplete(Intermediate_05_MySolution_Order order) {
            // Find the order in the list and mark it as complete
            for (Intermediate_05_MySolution_Order o : orders) {
                if (o.equals(order)) {
                    o.setComplete(true);
                    break;
                }
            }
        }

        public List<Intermediate_05_MySolution_Order> getOrders() {
            return orders;
        }

        public List<Intermediate_05_MySolution_Order> getPendingOrders() {
            // Create a list of orders that are not yet complete
            List<Intermediate_05_MySolution_Order> pendingOrders = new ArrayList<>();
            for (Intermediate_05_MySolution_Order order : orders) {
                if (!order.isComplete()) {
                    pendingOrders.add(order);
                }
            }
            return pendingOrders;
        }
    }
}
