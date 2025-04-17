import java.sql.*;

public class TaskDatabase {
    private static final String DB_URL = "jdbc:sqlite:tasks.db";

    public static void main(String[] args) {
        createDatabase();
        createTaskTable();
        insertTask("Finish GUI", "Pending");
        printAllTasks();
    }

    public static void createDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            if (conn != null) {
                System.out.println("Connected to SQLite and database file created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createTaskTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS tasks (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT NOT NULL,
                status TEXT NOT NULL
            );
            """;
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Task table ready.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertTask(String title, String status) {
        String sql = "INSERT INTO tasks(title, status) VALUES(?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, title);
            pstmt.setString(2, status);
            pstmt.executeUpdate();
            System.out.println("Inserted task: " + title);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void printAllTasks() {
        String sql = "SELECT * FROM tasks";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\nYour Tasks:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ". " +
                        rs.getString("title") + " - " +
                        rs.getString("status"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

