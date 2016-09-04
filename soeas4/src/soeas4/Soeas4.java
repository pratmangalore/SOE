package soeas4;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

class Soeas4{
    static Connection conn;
    static Statement stmt;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASS = "KUmudini!@34";
    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            conn = null;
            stmt = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = (Statement) conn.createStatement();
                String sql = "USE Institute;";
                stmt.executeUpdate(sql);
                MainGui mgui = new MainGui("Institute Log In",stmt);
                mgui.createAndShowGUI();
            }catch(SQLException se){
                se.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        });
    } 
}