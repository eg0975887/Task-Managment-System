import java.io.File;

public class TaskFileManager {
    public static File[] listJsonFiles(String folderPath) {
        File folder = new File(folderPath);

        if (!folder.exists() || !folder.isDirectory()) {
            System.err.println("Folder does not exist: " + folderPath);
            return new File[0];
        }

        // Filter to only .json files
        return folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
    }
}
