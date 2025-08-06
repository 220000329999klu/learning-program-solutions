package p1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for product " + (i + 1));
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Category: ");
            String category = sc.nextLine();

            products[i] = new Product(id, name, category);
        }

        System.out.print("\nEnter product name to search: ");
        String searchName = sc.nextLine();

        int index1 = SearchUtility.linearSearch(products, searchName);
        System.out.println("Linear Search Result: " + (index1 != -1 ? products[index1] : "Not Found"));

        int index2 = SearchUtility.binarySearch(products, searchName);
        System.out.println("Binary Search Result: " + (index2 != -1 ? products[index2] : "Not Found"));

        sc.close();
    }
}