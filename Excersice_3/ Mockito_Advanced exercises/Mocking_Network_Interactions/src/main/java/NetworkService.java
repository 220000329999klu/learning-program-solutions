import java.io.FileWriter;
import java.io.IOException;

public class NetworkService {
    private final NetworkClient networkClient;
    private final FileWriter fileWriter;

    // Constructor-based Dependency Injection
    public NetworkService(NetworkClient networkClient, FileWriter fileWriter) {
        this.networkClient = networkClient;
        this.fileWriter = fileWriter;
    }

    // Method to download data from network and save to file
    public String downloadAndSave() throws IOException {
        String data = networkClient.fetchData();  // Fetch data from the network
        fileWriter.write(data);                   // Write data to file
        return "Saved: " + data;                  // Return confirmation
    }
}