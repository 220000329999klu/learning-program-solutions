package BuilderPatternExample;

import java.util.Scanner;

public class BuilderTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter CPU: ");
        String cpu = scanner.nextLine();

        System.out.print("Enter RAM: ");
        String ram = scanner.nextLine();

        System.out.print("Enter Storage: ");
        String storage = scanner.nextLine();

        System.out.print("Do you want a Graphics Card? (yes/no): ");
        boolean graphicsCard = scanner.nextLine().trim().equalsIgnoreCase("yes");

        System.out.print("WiFi Enabled? (yes/no): ");
        boolean wifi = scanner.nextLine().trim().equalsIgnoreCase("yes");

        Computer customPC = new Computer.Builder()
                .setCPU(cpu)
                .setRAM(ram)
                .setStorage(storage)
                .setGraphicsCard(graphicsCard)
                .setWifiEnabled(wifi)
                .build();

        System.out.println("\nYour Custom PC Configuration:");
        customPC.showSpecs();

        scanner.close();
    }
}