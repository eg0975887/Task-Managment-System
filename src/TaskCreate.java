public class TaskCreate {
    public void insertTaskInfo(String title, String description, boolean completed) {
        System.out.println("Inserting Task");
        TaskBlueprint task = new TaskBlueprint("Finish Java Homework", "Complete by 8pm", false);
        TaskSaver.saveTaskToFile("john_doe", task);

    }
}
