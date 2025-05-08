import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class TaskView {
    public static void displayJson() { // retieves file path to the Database folder then creates a object with gson and file reader to later show a task details
        File folder = new File("Databases");
        File[] jsonFiles = folder.listFiles((dir, name) -> name.endsWith(".json"));

        if (jsonFiles == null || jsonFiles.length == 0) {
            System.out.println("No tasks found in the Databases folder.");
            return;
        }

        // Sort the files alphabetically
        Arrays.sort(jsonFiles);

        System.out.println("Available Tasks:");
        for (int i = 0; i < jsonFiles.length; i++) {
            System.out.println("[" + i + "] " + jsonFiles[i].getName());
        }

        // Prompt user to select a file
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the task to view: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline

        if (choice < 0 || choice >= jsonFiles.length) {
            System.out.println("Invalid choice.");
            return;
        }

        // Load the selected file
        TaskBlueprint loadedTask = loadTaskFromFile(jsonFiles[choice].getPath());

        if (loadedTask != null) {
            System.out.println("\nTask Loaded:");
            System.out.println("Title: " + loadedTask.getTitle());
            System.out.println("Description: " + loadedTask.getDescription());
            System.out.println("Completed: " + loadedTask.isCompleted());
        }
        System.out.println("\nPress Enter to continue... ");
        scanner.nextLine();

    }

    public static TaskBlueprint loadTaskFromFile(String filePath) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            TaskBlueprint task = gson.fromJson(reader, TaskBlueprint.class);
            return task;
        } catch (IOException e) {
            System.err.println("Error reading task: " + e.getMessage());
            return null;
        }

    }
}