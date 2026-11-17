
import java.sql.Connection;
import java.sql.DriverManager;     // Manages database drivers and establishes the connection
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Sqlite {

    // Establishes a connection to the SQLite database
    public void connect() {
        // JDBC connection string specifying the SQLite driver and database file name
        String url = "jdbc:sqlite:contacts.db";

        // 'try-with-resources' block: opens the connection and automatically closes it when done
        try (Connection con = DriverManager.getConnection(url)) {
            if (con != null) {
                System.out.println("database created");
            }
        } catch (Exception e) {
            // throw an exception
            throw new RuntimeException(e);
        }
    }

    // Creates the 'users' table in the database if it hasn't been created yet
    public void createNawTable() {
        String url = "jdbc:sqlite:contacts.db";

        // PRIMARY KEY: auto-incrementing unique identifier | NOT NULL: field cannot be empty | UNIQUE: no duplicate numbers allowed
        String sql = """
                CREATE TABLE IF NOT EXISTS users (
                ID INTEGER PRIMARY KEY,
                NAME TEXT NOT NULL,
                PHONENUM INTEGER NOT NULL UNIQUE,
                RELATION TEXT NOT NULL
                );                
                """;

        // Opens connection and creates a Statement object to run the static SQL command
        try (Connection con = DriverManager.getConnection(url);
             Statement stmt = con.createStatement()) {
            stmt.execute(sql); // Executes the SQL command (used for CREATE, DROP, etc.)
            System.out.println("table created");
        } catch (Exception e) {
            // Prints the error description if table creation fails
            System.out.println(e.getMessage());
        }
    }

    // Inserts a new contact row into the 'users' table
    public void insert(String abdullah, String number, String r) {
        String url = "jdbc:sqlite:contacts.db";

        // Parameterized SQL query: '?' act as safe placeholders for values (prevents SQL Injection)
        String sql = "INSERT INTO users(NAME,PHONENUM,RELATION) VALUES(?,?,?)";

        // PreparedStatement precompiles the SQL query so values can be safely injected into '?'
        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement prst = con.prepareStatement(sql)) {

            // Replaces each '?' placeholder by its 1-based position index
            prst.setString(1, abdullah); // 1st '?' -> NAME
            prst.setString(2, number);   // 2nd '?' -> PHONENUM
            prst.setString(3, r);        // 3rd '?' -> RELATION

            prst.executeUpdate();        // Runs queries that modify data (INSERT, UPDATE, DELETE)
            System.out.println("inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Deletes a specific contact row matching the given ID
    public void delete(int idd) {
        String url = "jdbc:sqlite:contacts.db";
        String sql = "DELETE FROM users\n WHERE ID = ?"; // Deletes only the row where ID matches '?'

        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setInt(1, idd);    // Binds the integer ID to the 1st '?'
            pr.executeUpdate();   // Executes the deletion
            System.out.println("delte is done");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Updates a contact's phone number based on their ID (Method Overloading: int, int)
    public void update(int id, int phoneNum) {
        String url = "jdbc:sqlite:contacts.db";
        String sql = """
                UPDATE users
                SET PHONENUM=?
                WHERE ID= ?;
                """;
        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, phoneNum); // Replaces 1st '?' (new PHONENUM)
            stmt.setInt(2, id);       // Replaces 2nd '?' (target ID in WHERE clause)
            stmt.executeUpdate();     // Commits the update to the database
            System.out.println("Phone Number Modified");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Updates a contact's name based on their ID (Method Overloading: int, String)
    public void update(int id, String name) {
        String url = "jdbc:sqlite:contacts.db";
        String sql = """
                UPDATE users
                SET NAME=?
                WHERE ID= ?;
                """;
        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, name);  // Replaces 1st '?' (new NAME)
            stmt.setInt(2, id);       // Replaces 2nd '?' (target ID)
            stmt.executeUpdate();
            System.out.println("Name Modified");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Updates a contact's relation based on their ID (Method Overloading: String, int)
    public void update(String relation, int id) {
        String url = "jdbc:sqlite:contacts.db";
        String sql = """
                UPDATE users
                SET RELATION=?
                WHERE ID= ?;
                """;
        try (Connection con = DriverManager.getConnection(url);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, relation); // Replaces 1st '?' (new RELATION)
            stmt.setInt(2, id);          // Replaces 2nd '?' (target ID)
            stmt.executeUpdate();
            System.out.println("Relation Modified");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Fetches and prints all rows from the 'users' table
    public void printDate() {
        String url = "jdbc:sqlite:contacts.db";
        String sql = "SELECT ID,NAME,PHONENUM,RELATION FROM users"; // Query to read all 4 columns

        try (Connection con = DriverManager.getConnection(url);
             Statement st = con.createStatement()) {

            // executeQuery() runs a SELECT statement and stores the returned table in ResultSet
            ResultSet r = st.executeQuery(sql);

            // r.next() moves the cursor to the next row; returns false when no more rows exist
            while (r.next()) {
                // Extracts data from the current row using 1-based column positions:
                // 1 -> ID, 2 -> NAME, 3 -> PHONENUM, 4 -> RELATION
                System.out.println(r.getInt(1) + "\t" + r.getString(2) + "\t" + r.getInt(3) + "\t\t" + r.getString(4) + "\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

