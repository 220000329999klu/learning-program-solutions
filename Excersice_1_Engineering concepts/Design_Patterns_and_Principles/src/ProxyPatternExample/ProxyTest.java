package ProxyPatternExample;

import java.util.Scanner;

interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading image from server: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

class ProxyTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter image filename to view: ");
        String filename = scanner.nextLine();

        Image image = new ProxyImage(filename);

        System.out.println("\nFirst display call:");
        image.display();

        System.out.println("\nSecond display call:");
        image.display();

        scanner.close();
    }
}
