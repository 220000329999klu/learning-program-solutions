package AdapterPatternExample;

import java.util.Scanner;

interface PaymentProcessor {
    void processPayment(double amount);
}

class RazorpayGateway {
    public void makeRazorpayPayment(double amount) {
        System.out.println("Paid ₹" + amount + " using Razorpay.");
    }
}

class PayPalGateway {
    public void makePayPalPayment(double amount) {
        System.out.println("Paid ₹" + amount + " using PayPal.");
    }
}

class RazorpayAdapter implements PaymentProcessor {
    private RazorpayGateway razorpay;

    public RazorpayAdapter() {
        this.razorpay = new RazorpayGateway();
    }

    public void processPayment(double amount) {
        razorpay.makeRazorpayPayment(amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway paypal;

    public PayPalAdapter() {
        this.paypal = new PayPalGateway();
    }

    public void processPayment(double amount) {
        paypal.makePayPalPayment(amount);
    }
}

class AdapterTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter payment gateway (razorpay/paypal): ");
        String gateway = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter amount to pay: ₹");
        double amount = scanner.nextDouble();

        PaymentProcessor processor;

        switch (gateway) {
            case "razorpay":
                processor = new RazorpayAdapter();
                break;
            case "paypal":
                processor = new PayPalAdapter();
                break;
            default:
                System.out.println("Unsupported payment gateway.");
                scanner.close();
                return;
        }

        processor.processPayment(amount);
        scanner.close();
    }
}
