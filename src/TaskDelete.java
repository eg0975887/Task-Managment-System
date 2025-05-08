import java.io.File;

public class TaskDelete {
    public static void deleteTaskFile() {
        File[] taskFiles = TaskFileManager.listJsonFiles(Main.databaseFolderPath); //list from Databases folder
        if (taskFiles.length == 0) { // if true, there are zero files recorded
            System.out.println("No task files found.");

        } else {
            System.out.println("\nAvailable task files:");
        }
        for (int i = 0; i < taskFiles.length; i++) { // print a list of files
            System.out.println((i + 1) + ". " + taskFiles[i].getName());
        }

        if (taskFiles.length >= 1) {
            System.out.print("Enter the number of the task to delete: ");
            try {
                int choice = Main.scanner.nextInt();

                if (choice >= 1 && choice <= taskFiles.length) { //true if user # between 1 and the length of files list
                    File selectedFile = taskFiles[choice - 1];
                    boolean deleted = selectedFile.delete();

                    if (deleted) {
                        System.out.println("Deleted: " + selectedFile.getName());
                    } else {
                        System.out.println("Failed to delete: " + selectedFile.getName());
                    }
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static String buildFilePath(String username, String title) { // improve safety of user input by removing file dangerous names
        String safeTitle = title.replaceAll("\\W+", "_");
        return "Databases/" + username + "_" + safeTitle + ".json";
    }

}
