package P1;

import java.util.Scanner;

class Employee {
    int employeeIdentifier;
    String employeeFullName;
    String employeeDesignation;
    double employeeMonthlySalary;

    public Employee(int employeeIdentifier, String employeeFullName, String employeeDesignation, double employeeMonthlySalary) {
        this.employeeIdentifier = employeeIdentifier;
        this.employeeFullName = employeeFullName;
        this.employeeDesignation = employeeDesignation;
        this.employeeMonthlySalary = employeeMonthlySalary;
    }

    public String toString() {
        return "Employee[ID=" + employeeIdentifier + ", Name=" + employeeFullName + ", Position=" + employeeDesignation + ", Salary=" + employeeMonthlySalary + "]";
    }
}

public class EmployeeManagement {
    static final int maximumEmployees = 100;
    static Employee[] employeeDatabase = new Employee[maximumEmployees];
    static int totalEmployees = 0;

    public static void insertEmployee(Employee newEmployeeRecord) {
        if (totalEmployees < maximumEmployees) {
            employeeDatabase[totalEmployees] = newEmployeeRecord;
            totalEmployees++;
        }
    }

    public static Employee retrieveEmployeeByName(String targetEmployeeName) {
        for (int index = 0; index < totalEmployees; index++) {
            if (employeeDatabase[index].employeeFullName.equalsIgnoreCase(targetEmployeeName)) {
                return employeeDatabase[index];
            }
        }
        return null;
    }

    public static void displayAllEmployees() {
        if (totalEmployees == 0) {
            System.out.println("No employee records found.");
        } else {
            for (int index = 0; index < totalEmployees; index++) {
                System.out.println(employeeDatabase[index]);
            }
        }
    }

    public static boolean removeEmployeeById(int targetEmployeeId) {
        for (int index = 0; index < totalEmployees; index++) {
            if (employeeDatabase[index].employeeIdentifier == targetEmployeeId) {
                for (int shiftIndex = index; shiftIndex < totalEmployees - 1; shiftIndex++) {
                    employeeDatabase[shiftIndex] = employeeDatabase[shiftIndex + 1];
                }
                employeeDatabase[totalEmployees - 1] = null;
                totalEmployees--;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] arguments) {
        Scanner inputReader = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Employee");
            System.out.println("2. Search Employee by Name");
            System.out.println("3. View All Employees");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int selectedOption = inputReader.nextInt();
            inputReader.nextLine();

            if (selectedOption == 1) {
                System.out.print("Enter ID: ");
                int id = inputReader.nextInt();
                inputReader.nextLine();
                System.out.print("Enter Name: ");
                String name = inputReader.nextLine();
                System.out.print("Enter Position: ");
                String position = inputReader.nextLine();
                System.out.print("Enter Salary: ");
                double salary = inputReader.nextDouble();
                inputReader.nextLine();

                insertEmployee(new Employee(id, name, position, salary));
                System.out.println("Employee record added.");

            } else if (selectedOption == 2) {
                System.out.print("Enter Name to search: ");
                String searchName = inputReader.nextLine();
                Employee result = retrieveEmployeeByName(searchName);
                System.out.println(result != null ? result : "Employee not found.");

            } else if (selectedOption == 3) {
                displayAllEmployees();

            } else if (selectedOption == 4) {
                System.out.print("Enter ID to delete: ");
                int deleteId = inputReader.nextInt();
                boolean deleted = removeEmployeeById(deleteId);
                System.out.println(deleted ? "Deleted successfully." : "Employee not found.");

            } else if (selectedOption == 5) {
                System.out.println("Exiting system.");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        inputReader.close();
    }
}
