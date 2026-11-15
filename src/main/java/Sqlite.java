
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sqlite {

//    public static void main(String[] args) {
//        connect();
//        createNawTable();
//        insert("Abdullah","34447939","r");
//        insert("Abdullah","02421939","r");
//        printDate();
//        delete(3);
//        update(2,"abdullah");
//    }


    public void connect() {
        String url = "jdbc:sqlite:contacts.db";

        try (Connection con = DriverManager.getConnection(url)) {
            if (con != null) {
                System.out.println("good");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createNawTable() {
        String url = "jdbc:sqlite:contacts.db";
        String sql = """
                CREATE TABLE IF NOT EXISTS users (
                ID INTEGER PRIMARY KEY,
                NAME TEXT NOT NULL,
                PHONENUM INTEGER NOT NULL UNIQUE,
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

    public void insert(String abdullah, String number, String r) {
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

    public void delete(int idd) {
        String url = "jdbc:sqlite:contacts.db";
        String sql = "DELETE FROM users" +
                "\n WHERE ID = ?";

        try(Connection con = DriverManager.getConnection(url);
            PreparedStatement pr = con.prepareStatement(sql);
            ){
            pr.setInt(1,idd);
            pr.executeUpdate();
            System.out.println("delte is done");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void update(int id, int phoneNum){
        String url = "jdbc:sqlite:users.db";
        String sql = """
                UPDATE users
                SET PHONENUM=?
                WHERE ID= ?
                """;
        try(Connection con = DriverManager.getConnection(url);
            PreparedStatement stmt = con.prepareStatement(sql);
        ){
            stmt.setInt(1,phoneNum);
            stmt.setInt(2,id);
            stmt.executeUpdate();
            System.out.println("Phone Number Modified");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void update(int id, String name){
        String url = "jdbc:sqlite:users.db";
        String sql = """
                UPDATE users
                SET NAME=?
                WHERE ID= ?
                """;
        try(Connection con = DriverManager.getConnection(url);
            PreparedStatement stmt = con.prepareStatement(sql);
        ){
            stmt.setString(1,name);
            stmt.setInt(2,id);
            stmt.executeUpdate();
            System.out.println("Name Modified");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void update(String relation, int id){
        String url = "jdbc:sqlite:users.db";
        String sql = """
                UPDATE users
                SET RELATION=?
                WHERE ID= ?
                """;
        try(Connection con = DriverManager.getConnection(url);
            PreparedStatement stmt = con.prepareStatement(sql);
        ){
            stmt.setString(1,relation);
            stmt.setInt(2,id);
            stmt.executeUpdate();
            System.out.println("Relation Modified");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

     public void printDate() {
        String url = "jdbc:sqlite:contacts.db";
        String sql = "SELECT ID,NAME,PHONENUM,RELATION FROM users";

        try(Connection con = DriverManager.getConnection(url);
            Statement st = con.createStatement()
        ){
            ResultSet r = st.executeQuery(sql);
            while (r.next()){
                System.out.println(r.getInt(1)+"\t"+ r.getString(2)+ "\t"+r.getInt(3)+"\t" + "\t" + r.getString(4)+"\n");

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
