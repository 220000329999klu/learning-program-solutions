package DecoratorPatternExample;

import java.util.Scanner;

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    public void send(String message) {
        notifier.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack Message: " + message);
    }
}

class DecoratorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your notification message: ");
        String message = scanner.nextLine();

        System.out.print("Do you want to send SMS? (yes/no): ");
        boolean sms = scanner.nextLine().trim().equalsIgnoreCase("yes");

        System.out.print("Do you want to send Slack message? (yes/no): ");
        boolean slack = scanner.nextLine().trim().equalsIgnoreCase("yes");

        Notifier notifier = new EmailNotifier();

        if (sms) {
            notifier = new SMSNotifierDecorator(notifier);
        }

        if (slack) {
            notifier = new SlackNotifierDecorator(notifier);
        }

        notifier.send(message);
        scanner.close();
    }
}
