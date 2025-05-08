public class TaskCreate {
    public static void taskUserInput() {
        Main.scanner.nextLine(); // consume the leftover newline

        System.out.print("Enter Username: ");
        String username = Main.scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = Main.scanner.nextLine();

        System.out.print("Enter Description: ");
        String description = Main.scanner.nextLine();

        System.out.println("Saved Task → Title: " + title + ", Description: " + description);

        System.out.println("\nAll tasks entered.");
        TaskCreate.insertTaskInfo(title, description, false, username);
    }

    public static void insertTaskInfo(String title, String description, boolean completed, String username) {
        System.out.println("Inserting Task");
//        TaskBlueprint task = new TaskBlueprint("Finish Java Homework", "Complete by 8pm", false);
        TaskBlueprint task = new TaskBlueprint(title, description, false);
        TaskSaver.saveTaskToFile(username, task);

    }
}
