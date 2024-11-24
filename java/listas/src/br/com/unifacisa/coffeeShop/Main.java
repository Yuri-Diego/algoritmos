package br.com.unifacisa.coffeeShop;

public class Main {
    public static void main(String[] args) {
        OrderManagement system = new OrderManagement(15);

        // Add orders
        system.addOrder(1, "Jonhnanthan", true);
        system.addOrder(2, "Yuri", true);
        system.addOrder(3, "Neto", false);
        system.addOrder(4, "Caio", false);
        system.addOrder(5, "Marclod", false);
        system.addOrder(6, "Silas", false);
        system.addOrder(7, "Luke", true);
        system.addOrder(8, "Matheus", false);


        // View orders
        system.viewOrders();

        // Process next order
        System.out.println("\n" + system.processNextOrder());

        // Update priority
        System.out.println("\n" + system.updatePriority(3, true));

        // Remove order
        System.out.println("\n" + system.removeOrder(1));

        // View orders again
        system.viewOrders();
    }
}
