package CommandPatternExample;

import java.util.Scanner;

interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("Light turned ON");
    }
    public void turnOff() {
        System.out.println("Light turned OFF");
    }
}

class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }
    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton() {
        command.execute();
    }
}

class CommandTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Light light = new Light();
        RemoteControl remote = new RemoteControl();

        System.out.print("Turn light on or off? (on/off): ");
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("on")) {
            remote.setCommand(new LightOnCommand(light));
        } else if (input.equals("off")) {
            remote.setCommand(new LightOffCommand(light));
        } else {
            System.out.println("Invalid command");
            scanner.close();
            return;
        }

        remote.pressButton();
        scanner.close();
    }
}
