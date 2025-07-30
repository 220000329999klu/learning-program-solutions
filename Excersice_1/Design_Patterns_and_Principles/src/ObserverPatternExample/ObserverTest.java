package ObserverPatternExample;

import java.util.*;

interface Observer {
    void update(String stockName, double price);
}

interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public void setStock(String name, double price) {
        this.stockName = name;
        this.price = price;
        notifyObservers();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, price);
        }
    }
}

class MobileApp implements Observer {
    public void update(String stockName, double price) {
        System.out.println("Mobile App - Stock: " + stockName + " updated to ₹" + price);
    }
}

class WebApp implements Observer {
    public void update(String stockName, double price) {
        System.out.println("Web App - Stock: " + stockName + " updated to ₹" + price);
    }
}

class ObserverTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        market.registerObserver(mobile);
        market.registerObserver(web);

        System.out.print("Enter stock name: ");
        String stock = scanner.nextLine();

        System.out.print("Enter stock price: ₹");
        double price = scanner.nextDouble();

        market.setStock(stock, price);
        scanner.close();
    }
}