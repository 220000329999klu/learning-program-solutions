package SingletonPatternExample;


class LoggerService {
    public void performOperation(String operationName) {
        Logger logger = Logger.getInstance();
        logger.log("Performing operation: " + operationName);
        // Simulate some logic
        try {
            Thread.sleep((int)(Math.random() * 500));
        } catch (InterruptedException e) {
            logger.log("Operation interrupted: " + e.getMessage());
        }
        logger.log("Operation completed: " + operationName);
    }
}