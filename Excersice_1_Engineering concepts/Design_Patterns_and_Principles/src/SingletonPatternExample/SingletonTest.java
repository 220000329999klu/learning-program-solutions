package SingletonPatternExample;

class SingletonTest {
    public static void main(String[] args) {
        LoggerService serviceA = new LoggerService();
        LoggerService serviceB = new LoggerService();

        serviceA.performOperation("Data Sync");
        serviceB.performOperation("Cache Update");

        Logger logger = Logger.getInstance();
        System.out.println("\n--- Log History ---");
        for (String log : logger.getLogs()) {
            System.out.println(log);
        }
    }
}
