package br.com.unifacisa.coffeeShop;

public class Order {
    private int orderId;
    private String customer;
    private int priority;

    public Order(int orderId, String customer, boolean vip) {
        this.orderId = orderId;
        this.customer = customer;
        this.priority = vip ? -1 : 0; // VIPs have higher priority (lower value)
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomer() {
        return customer;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(boolean vip) {
        this.priority = vip ? -1 : 0;
    }

    @Override
    public String toString() {
        return "Order " + orderId + ": Customer " + customer + ", Priority " + priority;
    }
}
