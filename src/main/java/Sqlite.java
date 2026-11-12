
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sqlite {

    public static void main(String[] args) {
        connect();
        createNawTable();
    }

    private static void createNawTable() {
        String url = "jdbc:sqlite:contacts.db";
        String sql = """
                CREATE TABLE IF NOT EXISTS users (
                ID INTEGER PRIMARY KEY,
                NAME TEXT NOT NULL,
                PHONENUM INTEGER NOT NULL,
                RELATION TEXT NOT NULL
                );                
                
                """;

        try( Connection con = DriverManager.getConnection(url);
             Statement stmt = con.createStatement();){
            stmt.execute(sql);
            System.out.println("table created");
        }catch (Exception e){
            System.out.println(e.getMessage());
            }



    }

    private static void connect() {
        String url = "jdbc:sqlite:contacts.db";

        try (Connection con = DriverManager.getConnection(url)) {
            if (con != null) {
                System.out.println("good");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
