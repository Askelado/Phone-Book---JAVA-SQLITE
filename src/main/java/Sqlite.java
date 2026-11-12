
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Sqlite {

    public static void main(String[] args) {
        connect();
        createNawTable();
        insert("Abdullah","047939","r");
    }

    private static void insert(String abdullah, String number, String r) {
        String url = "jdbc:sqlite:contacts.db";
        String sql = "INSERT INTO users(NAME,PHONENUM,RELATION) VALUES(?,?,?)";

        try( Connection con =DriverManager.getConnection(url);
             PreparedStatement prst = con.prepareStatement(sql);){
            prst.setString(1,abdullah);
            prst.setString(2,number);
            prst.setString(3,r);
            prst.executeUpdate();
            System.out.println("inserted");
        }catch (Exception e){
        System.out.println(e);
        }
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
