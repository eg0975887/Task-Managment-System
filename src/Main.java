import java.io.File;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);  // Create Scanner object
    public static void main(String[] args)
    {
        File folder = new File("Databases"); // create the database folder if it doesn't exist e.g. if program is run on new computer
        if (!folder.exists()) {
            folder.mkdir();  // Creates the folder if it doesn't exist
        }

        UserInputMethod("runtime"); // runtime method for UI

        scanner.close();
    }

    public static void UserInputMethod(String systemCall) {
        int userChoice = 0;

        if (systemCall.equals("runtime")) { // this if statement collects the UserInputMethod parameter to see if this is teh first time the method is called
            System.out.println("Hello, this is your Task Management System!");
            System.out.println("How would you like to start.");
        }
        else {
            System.out.println("what would you like to do?.");
        }

        System.out.println("Note: 'To choose type the number of the task you would like to select.'");
        System.out.println("1. View Task\n2. Create Task\n3. Edit Task\n4. Delete Task");
        try { // collect user input and catch errors if inputted incorrectly
            userChoice = scanner.nextInt();
            System.out.println(userChoice);
        }
        catch (Exception e) {
            System.out.println("Please enter a valid number.");
        }

        switch (userChoice) { // switch statement to call different methods if inputted by user correctly otherwise recall 'UserInputMethod'
            case 1:
                System.out.println("View Task");
                break;
            case 2:
                System.out.println("Create Task");
                TaskBlueprint task = new TaskBlueprint("Create Task", "Complete by 8pm", false);
                TaskSaver.saveTaskToFile("john_doe", task);
                break;
            case 3:
                System.out.println("Edit Task");
                break;
            case 4:
                System.out.println("Delete Task");
                break;
            case 5:
                System.out.println("End Program");
                break;
            default:
                System.out.println("Please enter one of the available options above.");
                UserInputMethod(systemCall);
                break;
        }



    }


}