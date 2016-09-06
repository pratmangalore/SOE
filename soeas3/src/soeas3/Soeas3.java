package soeas3;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

class Soeas3{
    static Connection conn;
    static Statement stmt;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASS = "placements2017";
    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            conn = null;
            stmt = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = (Statement) conn.createStatement();
                String sql = "USE College;";
                stmt.executeUpdate(sql);
                LoginGui mgui = new LoginGui("College Log In",stmt);
                mgui.createAndShowGUI();
            }catch(SQLException se){
                se.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        });
    } 
}