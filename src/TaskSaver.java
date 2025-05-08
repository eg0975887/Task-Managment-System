import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskSaver { // this file will write user inputted information and then using gson convert it to json and save it to the database folder
    public static void saveTaskToFile(String username, TaskBlueprint task) {
        System.out.println("Saving Task");
        Gson gson = new Gson();

        File folder = new File("Databases"); // Create the folder if it doesn't exist
        if (!folder.exists()) {
            folder.mkdir();
        }

        String safeUsername = username.replaceAll("\\W+", "_");
        String safeTitle = task.getTitle().replaceAll("\\W+", "_"); // File name pattern: "Databases/username_task_title.json"
        String fileName = "Databases/" + safeUsername + "_" + safeTitle + ".json";

        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(task, writer);
            System.out.println("Saved task to " + fileName);
        } catch (IOException e) {
            System.err.println("Error saving task: " + e.getMessage());
        }
    }
}
