package DependencyInjectionExample;

import java.util.Scanner;

interface CustomerRepository {
    String findCustomerById(int id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int id) {
        // Simulated data
        return switch (id) {
            case 1 -> "Alice";
            case 2 -> "Bob";
            case 3 -> "Charlie";
            default -> null;
        };
    }
}

class CustomerService {
    private CustomerRepository repository;

    // Constructor injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void getCustomerDetails(int id) {
        String customer = repository.findCustomerById(id);
        if (customer != null) {
            System.out.println("Customer found: " + customer);
        } else {
            System.out.println("Customer not found with ID: " + id);
        }
    }
}

class DIExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        System.out.print("Enter customer ID to fetch: ");
        int id = scanner.nextInt();

        service.getCustomerDetails(id);

        scanner.close();
    }
}
