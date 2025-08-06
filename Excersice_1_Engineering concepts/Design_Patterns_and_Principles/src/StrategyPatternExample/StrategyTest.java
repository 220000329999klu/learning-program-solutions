package StrategyPatternExample;

import java.util.Scanner;

interface PaymentStrategy {
    void pay(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal.");
    }
}

class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(double amount) {
        strategy.pay(amount);
    }
}

class StrategyTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext context = new PaymentContext();

        System.out.print("Choose payment method (creditcard/paypal): ");
        String method = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter amount: ₹");
        double amount = scanner.nextDouble();

        if (method.equals("creditcard")) {
            context.setPaymentStrategy(new CreditCardPayment());
        } else if (method.equals("paypal")) {
            context.setPaymentStrategy(new PayPalPayment());
        } else {
            System.out.println("Unsupported payment method.");
            scanner.close();
            return;
        }

        context.pay(amount);
        scanner.close();
    }
}
 