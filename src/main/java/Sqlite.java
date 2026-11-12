
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sqlite {

    public static void main(String[] args) {
        connect();
    }

    private static void connect() {
        String url= "jdbc:sqlite:contacts.db";

        try(Connection con = DriverManager.getConnection(url)){
            if (con!=null){
                System.out.println("good");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
