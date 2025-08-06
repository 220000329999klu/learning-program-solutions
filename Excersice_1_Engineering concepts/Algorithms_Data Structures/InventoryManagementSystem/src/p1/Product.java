package p1;

import java.util.HashMap;
import java.util.Map;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}

class Inventory {
    Map<Integer, Product> products = new HashMap<>();

    void addProduct(Product p) {
        products.put(p.productId, p);
    }

    void updateProduct(int id, int quantity, double price) {
        if (products.containsKey(id)) {
            Product p = products.get(id);
            p.quantity = quantity;
            p.price = price;
        }
    }

    void deleteProduct(int id) {
        products.remove(id);
    }
}