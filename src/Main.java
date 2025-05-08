import java.io.File;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);  // Create Scanner object
    static String databaseFolderPath = "Databases";
    public static void main(String[] args)
    {
        File folder = new File("Databases"); // create the database folder if it doesn't exist e.g. if program is run on new computer
        if (!folder.exists()) {
            folder.mkdir();  // Creates the folder if it doesn't exist
        }

        System.out.println("\nHello, this is your Task Management System!");
        UserInputMethod(); // runtime method for UI

        scanner.close();
    }

    public static void UserInputMethod() { // the logic for the UI
        int userChoice = 0;
        System.out.println("What would you like to do?");

        System.out.println("Note: 'To choose type the number of the task you would like to select.'");
        System.out.println("1. View Task\n2. Create Task\n3. Edit Task\n4. Delete Task\n5. End Program");
        try { // collect user input and catch errors if inputted incorrectly
            userChoice = scanner.nextInt();
//            System.out.println(userChoice);
        }
        catch (Exception e) {
            System.out.println("Please enter a valid number.");
        }

        switch (userChoice) { // switch statement to call different methods if inputted by user correctly otherwise recall 'UserInputMethod'
            case 1:
                System.out.println("View Task");
                TaskView.displayJson();
                UserInputMethod();
                break;
            case 2: // Take the Title and Description from the user
                System.out.println("Create Task");
                TaskCreate.taskUserInput();
                UserInputMethod();
                break;
            case 3:
                System.out.println("Edit Task");
                UserInputMethod();
                break;
            case 4: // generate a list of files from Database
                System.out.println("Delete Task");
                TaskDelete.deleteTaskFile();
                UserInputMethod();
                break;
            case 5:
                System.out.println("End Program");
                break;
            default:
                System.out.println("Please enter one of the available options above.");
                UserInputMethod();
                break;
        }
    }

}