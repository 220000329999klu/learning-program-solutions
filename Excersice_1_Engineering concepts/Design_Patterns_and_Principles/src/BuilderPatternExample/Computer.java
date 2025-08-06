package BuilderPatternExample;

class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private boolean graphicsCard;
    private boolean wifiEnabled;

    // Step 4: Private constructor that takes Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.wifiEnabled = builder.wifiEnabled;
    }

    // Step 3: Static nested Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private boolean graphicsCard;
        private boolean wifiEnabled;

        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(boolean graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setWifiEnabled(boolean wifiEnabled) {
            this.wifiEnabled = wifiEnabled;
            return this;
        }

        // Step 3: build method returning a Computer
        public Computer build() {
            return new Computer(this);
        }
    }

    public void showSpecs() {
        System.out.println("Computer Specs:");
        System.out.println("CPU: " + CPU);
        System.out.println("RAM: " + RAM);
        System.out.println("Storage: " + storage);
        System.out.println("Graphics Card: " + (graphicsCard ? "Yes" : "No"));
        System.out.println("WiFi Enabled: " + (wifiEnabled ? "Yes" : "No"));
    }
}