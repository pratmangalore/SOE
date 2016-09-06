package soeas2;

//STEP 1. Import required packages
import java.sql.*;
import java.io.*;
import java.util.*;

class Soeas2 {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/";
   static final String USER = "root";
   static final String PASS = "placements2017";
   static void addStudent(Statement stmt,Scanner scint,Scanner scstring) throws SQLException {
       System.out.println("You are now adding a student to the database::\n");
       System.out.println("Kindly enter the Name(MANDATORY), father's name,address,age,contact number(MANDOTARY) and CGPA\n\n");
       String name,fname,address,contactno;
       String sql1 = "ALTER TABLE studata AUTO_INCREMENT = 1";
       stmt.executeUpdate(sql1);
       int age=0;
       float cgpa=0;
       name = scstring.nextLine();
       while(name.isEmpty()) {
           System.out.println("Please enter your name:\n");
           name = scstring.nextLine();
       }
       fname = scstring.nextLine();
       address = scstring.nextLine();
       age = scint.nextInt();
       contactno = scstring.nextLine();
       while(contactno.isEmpty()) {
           System.out.println("Please enter your contact no.:\n");
           contactno = scstring.nextLine();
       }
       cgpa = scint.nextFloat();
       String sql = "Insert into studata values(NULL,'"+name+"','"+fname+"','"+address+"',"+age+",'"+contactno+"',"+cgpa+");";
       stmt.executeUpdate(sql);
       System.out.println("Student Added Successfully!!\n\n");
   }
   
   static void updateStudent(Statement stmt,Scanner scint,Scanner scstring) throws SQLException {
       System.out.println("Now updating student::\n");
       System.out.println("Enter the id of the student you wish to update::\n");
       int id = scint.nextInt();
       String news;
       int newi;
       float newf;
       System.out.println("Enter the field you wish to update");
       String field;
       do {
           field=scstring.nextLine();
           if(!"name".equals(field)||!"Name".equals(field)||!"NAME".equals(field)||!"FathersName".equals(field)||!"Father's Name".equals(field)||!"Address".equals(field)||!"Age".equals(field)||!"ContactNo".equals(field)||!"CGPA".equals(field)||!"cgpa".equals(field))
               break;
       }while(true);
       
       if("Name".equals(field) || "NAME".equals(field) || "name".equals(field)) {
           news = scstring.nextLine();
           String sql = "update studata set Name = '"+news+"'where ID = "+id;
           stmt.executeUpdate(sql);
       } else
       if("FathersName".equals(field) || "Father's Name".equals(field)) {
           news = scstring.nextLine();
           String sql = "update studata set FathersName = '"+news+"'where ID = "+id;
           stmt.executeUpdate(sql);
       } else
       if("Address".equals(field)) {
           news = scstring.nextLine();
           String sql = "update studata set Address = '"+news+"'where ID = "+id;
           stmt.executeUpdate(sql);
       } else
       if("Age".equals(field)) {
           newi = scint.nextInt();
           String sql = "update studata set Age = '"+newi+"'where ID = "+id;
           stmt.executeUpdate(sql);
       } else
       if("ContactNo".equals(field)) {
           news = scstring.nextLine();
           String sql = "update studata set ContactNo = '"+news+"'where ID = "+id;
           stmt.executeUpdate(sql);
       } else 
       if("CGPA".equals(field) || "cgpa".equals(field)){
           newf = scint.nextFloat();
           String sql = "update studata set CGPA = '"+newf+"'where ID = "+id;
           stmt.executeUpdate(sql);
       }
   }
   
   static void delStudent(Statement stmt,Scanner scint,Scanner scstring) throws SQLException {
       System.out.println("Enter the id of a student you wanna delete::\n");
       int id = scint.nextInt();
       String sql = "Delete from studata where ID = "+id+";";
       stmt.executeUpdate(sql);
       System.out.println("Student Deleted Successfully!!\n\n");
   }
   
   static void searchStudent(Statement stmt,Scanner scint,Scanner scstring) throws SQLException {
       System.out.println("Enter the id of a student you wanna search::\n");
       int id = scint.nextInt();
       String sql = "Select * from studata where ID = "+id+";";
       ResultSet rs = stmt.executeQuery(sql);
       while(rs.next()) {
           String Name = rs.getString("Name");
           String FName = rs.getString("FathersName");
           String Address = rs.getString("Address");
           int age = rs.getInt("Age");
           String ContactNo = rs.getString("ContactNo");
           float cgpa = rs.getFloat("CGPA");
           System.out.println("Name :: "+Name+"\nFather's Name :: "+FName+"\nAddress :: "+Address+"\nAge :: "+age+"\nContact no. :: "+ContactNo+"\nCGPA :: "+cgpa+"\n\n");
       }
   }
   
   static void display(Statement stmt,Scanner scint,Scanner scstring) throws SQLException {
       String sql = "Select * from studata ORDER BY Name,Age ASC";
       ResultSet rs = stmt.executeQuery(sql);
       while(rs.next()){
           String Name = rs.getString("Name");
           String FName = rs.getString("FathersName");
           String Address = rs.getString("Address");
           int age = rs.getInt("Age");
           String ContactNo = rs.getString("ContactNo");
           float cgpa = rs.getFloat("CGPA");
           System.out.println("Name :: "+Name+"\nFather's Name :: "+FName+"\nAddress :: "+Address+"\nAge :: "+age+"\nContact no. :: "+ContactNo+"\nCGPA :: "+cgpa+"\n\n");
       } 
   }
   
   static void startware(Statement stmt) throws SQLException {
       int flag=0;
       System.out.println("Hello! Welcome to Student Management SoftWorks. Press the key according to your choice");
       do{
            System.out.println("\n\n1.Add Student\t\t2.Update Student\t\t3.Delete Student\t\t4.Search\t\t5.Display\n\n6.Exit\n\n");
            Scanner scint = new Scanner(System.in);
            Scanner scstring = new Scanner(System.in);
            int choice = scint.nextInt();
            switch(choice) {
                case 1:
                    addStudent(stmt,scint,scstring);
                    break;
                case 2:
                    updateStudent(stmt,scint,scstring);
                    break;
                case 3:
                    delStudent(stmt,scint,scstring);
                    break;
                case 4:
                    searchStudent(stmt,scint,scstring);
                    break;
                case 5:
                    display(stmt,scint,scstring);
                    break;
                case 6:
                    flag=1;
                    break;
                default:
                    System.out.println("Please enter choice b/w 1-6");
            }
       }while(flag!=1);
   }
   
   public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
           Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           stmt = conn.createStatement();   
           String sql = "USE STUDENT;";
           stmt.executeUpdate(sql);                  
           startware(stmt);
        }catch(SQLException se){
           se.printStackTrace();
        }catch(Exception e){
           e.printStackTrace();
        }finally{
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }
        }
        System.out.println("Goodbye!");
    }
}
