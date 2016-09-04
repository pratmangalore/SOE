package soeas3;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
 
public class Soeas3 {
    static Connection conn;
    static Statement stmt;
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASS = "KUmudini!@34";
    static JTable table;
    static JFrame firstframe;
    static JFrame newaccframe;
    static JFrame mainframe;
    static JFrame studentframe;
    static JButton button1; 
    static JButton update1;
    static JButton update;
    static JLabel userlabel;
    static JTextField usertf;
    static JLabel passlabel;
    static JPasswordField passtf;
    static JPanel pane;
    static JPanel panes;
    static JPanel p1;
    static JPanel p2;
    static JPanel p3;
    static JPanel p4;
    static JPanel p5;
    static JComboBox cb2;
    static int rowCount;
    static String clas="SECTION A";
    static String course="POE";
    static int row;
    static int column;
    static String[][] data = new String[10][3];
    static TableModel dataModel = new AbstractTableModel() {
        private static final long serialVersionUID = 1L;
        @Override
        public int getColumnCount() {
            return 3; 
        }
        @Override
        public int getRowCount() { 
            return rowCount;
        }
        @Override
        public Object getValueAt(int row, int col) {
            return data[row][col]; 
        }
        @Override
        public boolean isCellEditable(int row, int col) { 
            return col != 0; 
        }
        @Override
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = (String)value;
            fireTableCellUpdated(row, col);
        }
    };
    public static int getNumberOfRows() throws SQLException {
        int rows=0;
        String sql = "Select * from Student NATURAL JOIN Class where class='"+clas+"' and course='"+course+"';";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            data[rows][0]=rs.getString("id");
            data[rows][1]=Integer.toString(rs.getInt("attendance"));
            data[rows][2]=Integer.toString(rs.getInt("marks"));
            rows++;
        }
        return rows;
    }
    public static void createFirstPage(GridBagConstraints c, Container pane) {
        if (shouldFill) {
            c.fill = GridBagConstraints.HORIZONTAL;
        }
        userlabel = new JLabel("Enter Username : ",SwingConstants.CENTER);
        userlabel.setBackground(Color.WHITE);
        userlabel.setOpaque(true);
        userlabel.setForeground(Color.BLACK);
        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        c.weightx = 20;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(userlabel, c);

        usertf = new JTextField();
        usertf.setMaximumSize(new Dimension(100,30));
        c.weightx = 20;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(usertf, c);

        passlabel = new JLabel("Enter Password : ",SwingConstants.CENTER);
        passlabel.setBackground(Color.WHITE);
        passlabel.setOpaque(true);
        passlabel.setForeground(Color.BLACK);
        c.gridx = 0;
        c.gridy = 1;
        pane.add(passlabel, c);

        passtf = new JPasswordField();
        passtf.setMaximumSize(new Dimension(100,30));
        c.gridx = 1;       //aligned with button 2
        c.gridy = 1;       //third row
        pane.add(passtf, c);
       
        button1 = new JButton("Submit");
        button1.setMaximumSize(new Dimension(100,30)); 
        button1.addActionListener(new ButtonL());
        c.gridx = 0;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;      
        firstframe.getRootPane().setDefaultButton(button1);
        pane.add(button1, c);
    }
    public static void createNewAccPage(GridBagConstraints c, Container pane) {
        if (shouldFill) {
            c.fill = GridBagConstraints.HORIZONTAL;
        }
        userlabel = new JLabel("Enter New Username : ",SwingConstants.CENTER);
        userlabel.setBackground(Color.WHITE);
        userlabel.setOpaque(true);
        userlabel.setForeground(Color.BLACK);
        if (shouldWeightX) {
            c.weightx = 0.5;
        }
        c.weightx = 20;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(userlabel, c);

        usertf = new JTextField();
        usertf.setMaximumSize(new Dimension(100,30));
        c.weightx = 20;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(usertf, c);

        passlabel = new JLabel("Enter New Password(Length 6): ",SwingConstants.CENTER);
        passlabel.setBackground(Color.WHITE);
        passlabel.setOpaque(true);
        passlabel.setForeground(Color.BLACK);
        c.gridx = 0;
        c.gridy = 1;
        pane.add(passlabel, c);

        passtf = new JPasswordField();
        passtf.setMaximumSize(new Dimension(100,30));
        c.gridx = 1;       //aligned with button 2
        c.gridy = 1;       //third row
        pane.add(passtf, c);
       
        button1 = new JButton("Sign Up");
        button1.setMaximumSize(new Dimension(100,30)); 
        button1.addActionListener(new ButtonL());
        c.gridx = 0;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;      
        newaccframe.getRootPane().setDefaultButton(button1);
        pane.add(button1, c);
    }
    public static void createMainPage() {
        pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
        p1 = new JPanel();
        p1.setBackground(Color.ORANGE);
        String subjects[] = {"SOE","AI","GVC","CNN","POE"};
        String classes[] = {"Section A","Section B","Section C"};
        JComboBox cb = new JComboBox(subjects);
        cb.addActionListener(new CBAL());
        p1.add(cb);
        pane.add(p1);   
        p2 = new JPanel();
        p2.setBackground(Color.ORANGE);
        cb2 = new JComboBox(classes);
        cb2.addActionListener(new CBAL());
        p2.add(cb2);
        pane.add(p2);
        p3 = new JPanel();
        p3.setBackground(Color.ORANGE);
        update1 = new JButton("Select");
        update1.addActionListener(new ButtonL());
        p3.add(update1);
        pane.add(p3);
    }
    public static void createStudentPage() {
        panes.setLayout(new BoxLayout(panes,BoxLayout.Y_AXIS));
        
    }
    public static void addComponentsToFirstPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        pane.setLayout(new GridBagLayout());
        pane.setBackground(Color.ORANGE);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(30,60,30,60);
        createFirstPage(c,pane);       
    }
    public static void addComponentsToNewAccPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        pane.setLayout(new GridBagLayout());
        pane.setBackground(Color.ORANGE);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(30,60,30,60);
        createNewAccPage(c,pane);  
    }
    public static void addComponentsToMainPane() {
        pane.setLayout(new BoxLayout(pane,BoxLayout.PAGE_AXIS));
        createMainPage();  
    }
    public static void addComponentsToStudentPane() {
        panes.setLayout(new BoxLayout(panes,BoxLayout.PAGE_AXIS));
        createStudentPage();  
    }
    private static void createAndShowGUI(String title) {
       
        switch (title) {
            case "College Student's Database":
                firstframe = new JFrame(title);
                firstframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                addComponentsToFirstPane(firstframe.getContentPane());
                firstframe.setBounds(400,100,600,300);
                firstframe.setVisible(true);
                break;
            case "Enter login details":
                newaccframe = new JFrame(title);
                newaccframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                addComponentsToNewAccPane(newaccframe.getContentPane());
                newaccframe.setBounds(400,100,600,300);
                newaccframe.setVisible(true);
                break;
            case "College Data":
                mainframe = new JFrame(title);
                mainframe.setBounds(420,50,550,200);
                mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                pane=new JPanel();
                addComponentsToMainPane();
                mainframe.setContentPane(pane);
                mainframe.setVisible(true);
                break;
            case "Student Data":
                studentframe = new JFrame(title);
                studentframe.setBounds(420,50,550,200);
                studentframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                panes=new JPanel();
                addComponentsToStudentPane();
                studentframe.setContentPane(panes);
                studentframe.setVisible(true);
            default:
                break;
        }
       
    }
    
    private static class CBAL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
                JComboBox cb = (JComboBox)e.getSource();
                String subject = (String)cb.getSelectedItem();
                switch (subject) {
                    case "SOE":
                        course="SOE";                       
                        break;
                    case "AI":
                        course="AI"; 
                        break;
                    case "GVC":
                        course="GVC";
                        break;
                    case "CNN":
                        course="CNN";
                        break;
                    case "POE":
                        course="POE";
                    case "Section A":
                        clas="SECTION A";
                        break;
                    case "Section B":
                        clas="SECTION B";
                        break;
                    case "Section C":
                        clas="SECTION C";
                        break;
                    default:
                        clas="SECTION A";
                        course="POE";
                }
        }
    }
    
    private static boolean checkLog(String userid,String pass) throws SQLException {
        String sql = "Select * from Instructor where user = '"+userid+"'AND pass = '"+pass+"';";
        ResultSet rs = stmt.executeQuery(sql);
        int count=0;
        while(rs.next())
            count++;
        return count != 0;
    }
   
    private static class ButtonL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getActionCommand().equals("Submit")) {  
                String userid = usertf.getText();
                String pass = passtf.getText();
                if(userid.equals("") || pass.equals("") )
                    return;
                try {
                    if(checkLog(userid,pass)) {
                         createAndShowGUI("College Data");
                         firstframe.setVisible(false);
                    }
                    else {
                        createAndShowGUI("Enter login details");
                        firstframe.setVisible(false);
                    }
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
            if(e.getActionCommand().equals("Sign Up")) {
                String userid = usertf.getText();
                String pass = passtf.getText();
                if(userid.equals("") || pass.equals("") || pass.length()!=6)
                    return;
                try {
                   String sql = "Insert into Instructor Values (NULL,'"+userid+"','"+pass+"');";
                   stmt.executeUpdate(sql);  
                } catch(SQLException se) {
                    se.printStackTrace();
                }
                createAndShowGUI("College Data");
                newaccframe.setVisible(false);
            }
            if(e.getActionCommand().equals("Select")) {
                try {
                    rowCount=getNumberOfRows();
                    table = new JTable(dataModel);       
                    for(int i=0;i<3;i++){
                        TableColumn tc = table.getColumnModel().getColumn(i);
                        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                        dtcr.setHorizontalAlignment(SwingConstants.CENTER); 
                        tc.setCellRenderer(dtcr);
                    }
                    createAndShowGUI("Student Data");
                    mainframe.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Soeas3.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
            if(e.getActionCommand().equals("Update")) {
                try {
                  for(int i=0;i<rowCount;i++) {
                      String sql = "update Student set attendance='"+data[i][1]+"',marks = '"+data[i][2]+"' where (course = '"+course+"' AND id = '"+data[i][0]+"');";
                      stmt.executeUpdate(sql);
                  }
                } catch (SQLException ex) {
                    Logger.getLogger(Soeas3.class.getName()).log(Level.SEVERE, null, ex);
                }    
            }
            if(e.getActionCommand().equals("<-")) {
                studentframe.setVisible(false);
                mainframe.setVisible(true);
            }
        }
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            conn = null;
            stmt = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                String sql = "USE College;";
                stmt.executeUpdate(sql);
                createAndShowGUI("College Student's Database");
            }catch(SQLException se){
                se.printStackTrace();
            }catch(Exception e){
                e.printStackTrace();
            }
        });
    }
}