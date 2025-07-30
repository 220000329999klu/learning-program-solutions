package p1;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    Map<Integer, Product> products = new HashMap<>();

    public void addProduct(Product p) {
        products.put(p.productId, p);
    }

    public void updateProduct(int id, int quantity, double price) {
        if (products.containsKey(id)) {
            Product p = products.get(id);
            p.quantity = quantity;
            p.price = price;
        }
    }

    public void deleteProduct(int id) {
        products.remove(id);
    }

    public void displayProducts() {
        for (Product p : products.values()) {
            System.out.println(p);
        }
    }
}