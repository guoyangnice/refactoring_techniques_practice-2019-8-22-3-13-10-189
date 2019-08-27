package com.tws.refactoring.extract_method;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OwingPrinter {
    void printOwing(String name, List<Order> orders) {
        Iterator<Order> elements = orders.iterator();
        double totalPrice = 0.0;

        // print banner
        printBanner();

        // print owings
        while (elements.hasNext()) {
            Order each = (Order) elements.next();
            totalPrice += each.getAmount();
        }

        // print details
        System.out.println("name: " + name);
        System.out.println("amount: " + totalPrice);
    }
    
    public static void main(String[] args) {
    	OwingPrinter owingPrinter = new OwingPrinter();
    	List<Order> orderList = new ArrayList<Order>();
    	orderList.add(new Order(60));
    	orderList.add(new Order(6));
    	owingPrinter.printOwing("yang", orderList);
	}
    
    public static void printBanner() {
    	System.out.println ("*****************************");
        System.out.println ("****** Customer totals ******");
        System.out.println ("*****************************");
    }
}

class Order {
    private double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
    
    
}
