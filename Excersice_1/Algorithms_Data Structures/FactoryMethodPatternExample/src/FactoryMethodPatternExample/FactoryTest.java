package FactoryMethodPatternExample;

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
    public abstract Document createDocument(String content);
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

class DocumentFactoryProvider {
    public static DocumentFactory getFactory(String type) {
        return switch (type.toLowerCase()) {
            case "word" -> new WordFactory();
            case "pdf" -> new PdfFactory();
            case "excel" -> new ExcelFactory();
            default -> throw new IllegalArgumentException("Unsupported document type: " + type);
        };
    }
}

class FactoryTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter document type (Word/PDF/Excel): ");
        String type = scanner.nextLine();

        System.out.println("Enter document content: ");
        String content = scanner.nextLine();

        try {
            DocumentFactory factory = DocumentFactoryProvider.getFactory(type);
            Document document = factory.createDocument(content);
            document.open();
            System.out.println("Document Content: " + document.getContent());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}