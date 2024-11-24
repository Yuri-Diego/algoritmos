package br.com.unifacisa.coffeeShop;

public class OrderManagement {
    private Heap heap;

    public OrderManagement(int capacity) {
        this.heap = new Heap(capacity);
    }

    public void addOrder(int orderId, String customer, boolean vip) {
        Order order = new Order(orderId, customer, vip);
        heap.insert(order);
    }

    public String processNextOrder() {
        Order order = heap.remove();
        if (order == null) {
            return "No orders to process.";
        }
        return "Processing " + order.toString();
    }

    public void viewOrders() {
        Order[] orders = heap.viewAll();
        System.out.println("Orders in queue:");
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }

    public String updatePriority(int orderId, boolean vip) {
        try {
            heap.updatePriority(orderId, vip);
            return "Priority of order " + orderId + " updated.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }

    public String removeOrder(int orderId) {
        try {
            heap.removeById(orderId);
            return "Order " + orderId + " successfully removed.";
        } catch (RuntimeException e) {
            return e.getMessage();
        }
    }
}
