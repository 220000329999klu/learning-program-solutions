package FactoryMethodPattern ;

import java.util.Scanner;

interface Document {
    void open();
    String getContent();
}

class WordDocument implements Document {
    private String content;
    public WordDocument(String content) {
        this.content = content;
    }
    public void open() {
        System.out.println("Opening Word Document...");
    }
    public String getContent() {
        return "[Word] " + content;
    }
}

class PdfDocument implements Document {
    private String content;
    public PdfDocument(String content) {
        this.content = content;
    }
    public void open() {
        System.out.println("Opening PDF Document...");
    }
    public String getContent() {
        return "[PDF] " + content;
    }
}

class ExcelDocument implements Document {
    private String content;
    public ExcelDocument(String content) {
        this.content = content;
    }
    public void open() {
        System.out.println("Opening Excel Document...");
    }
    public String getContent() {
        return "[Excel] " + content;
    }
}

abstract class DocumentFactory {
    abstract Document createDocument(String content);
}

class WordFactory extends DocumentFactory {
    public Document createDocument(String content) {
        return new WordDocument(content);
    }
}

class PdfFactory extends DocumentFactory {
    public Document createDocument(String content) {
        return new PdfDocument(content);
    }
}

class ExcelFactory extends DocumentFactory {
    public Document createDocument(String content) {
        return new ExcelDocument(content);
    }
}

class FactoryTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter document type (Word/PDF/Excel): ");
        String type = scanner.nextLine().trim().toLowerCase();

        System.out.print("Enter document content: ");
        String content = scanner.nextLine();

        DocumentFactory factory;

        switch (type) {
            case "word":
                factory = new WordFactory();
                break;
            case "pdf":
                factory = new PdfFactory();
                break;
            case "excel":
                factory = new ExcelFactory();
                break;
            default:
                System.out.println("Invalid document type.");
                scanner.close();
                return;
        }

        Document doc = factory.createDocument(content);
        doc.open();
        System.out.println("Document Content: " + doc.getContent());

        scanner.close();
    }
}

// Continue with Exercise 3-11 in next updates...