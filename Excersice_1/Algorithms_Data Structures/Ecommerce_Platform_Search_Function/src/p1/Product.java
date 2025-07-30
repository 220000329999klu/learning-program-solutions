package p1;
public class Product {
	
	
    int id;
    String name;
    String category;

    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product[ID=" + id + ", Name=" + name + ", Category=" + category + "]";
    }
}