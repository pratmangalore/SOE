package soeas3;

import java.sql.*;
import com.sun.glass.events.KeyEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginGui implements ActionListener{
    public Statement stmt;
    public String title;
    public JFrame login;
    public JPanel pane;
    public JRadioButton rb;
    public JTextField utext;
    public JPasswordField ptext;
    public String sql;
    int mode = 1;
    LoginGui(String title,Statement stmt) {
        this.stmt = stmt;
        this.title = title;
        login = new JFrame(title);
    }
    void UserName(GridBagConstraints gbc) {
        gbc.gridx=0;
        gbc.gridy=1;
        JLabel ulabel = new JLabel("Enter Username",SwingConstants.CENTER);
        ulabel.setPreferredSize(new Dimension(120,15));
        ulabel.setBackground(Color.WHITE);
        ulabel.setOpaque(true);
        ulabel.setForeground(Color.BLACK);
        pane.add(ulabel,gbc);
        gbc.gridx=2;
        gbc.gridy=1;
        utext = new JTextField("",SwingConstants.CENTER);
        utext.setPreferredSize(new Dimension(100,20));
        utext.setBackground(Color.WHITE);
        utext.setOpaque(true);
        utext.setForeground(Color.BLACK);
        pane.add(utext,gbc);
    }
    void PassWord(GridBagConstraints gbc) {
        gbc.gridx=0;
        gbc.gridy=2;
        JLabel plabel = new JLabel("Enter Password",SwingConstants.CENTER);
        plabel.setPreferredSize(new Dimension(120,15));
        plabel.setBackground(Color.WHITE);
        plabel.setOpaque(true);
        plabel.setForeground(Color.BLACK);
        pane.add(plabel,gbc);
        gbc.gridx=2;
        gbc.gridy=2;
        ptext = new JPasswordField("",SwingConstants.CENTER);
        ptext.setPreferredSize(new Dimension(100,20));
        ptext.setBackground(Color.WHITE);
        ptext.setOpaque(true);
        ptext.setForeground(Color.BLACK);
        pane.add(ptext,gbc);
    }
    void LogIn(GridBagConstraints gbc) {
        gbc.gridx=1;
        gbc.gridy=3;
        JButton b = new JButton("Log In");
        b.setMaximumSize(new Dimension(100,30));
        b.setActionCommand("LogIn");
        b.addActionListener(this);
        pane.add(b,gbc);
        login.getRootPane().setDefaultButton(b);
    }
    void create(GridBagConstraints gbc) {
        UserName(gbc);
        PassWord(gbc);
        LogIn(gbc);
    }
    void populateGUI() {
        pane.setLayout(new GridBagLayout());
        pane.setBackground(new Color(135,206,250));
        GridBagConstraints gbc = new GridBagConstraints();   
        gbc.fill = GridBagConstraints.HORIZONTAL;
        create(gbc);
    }
    void createAndShowGUI() {
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane = new JPanel();
        populateGUI();
        login.add(pane);
        login.setBounds(400,100,400,100);
        //login.pack();
        login.setVisible(true);
    }
    
    boolean checkLog(String sql) throws SQLException {
        ResultSet rs = stmt.executeQuery(sql);
        int count=0;
        while(rs.next())
            count++;
        return count != 0;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "LogIn":
                String user = utext.getText();
                String pass = ptext.getText();
                sql = "Select * from Instructor where ";
                String sql2=sql+"user = '"+user+"' AND pass = '"+pass+"';";
                try {
                    if(checkLog(sql2)) {                      
                        ProfessorGUI pgui = new ProfessorGUI(user.toUpperCase(),stmt,user);
                        login.setVisible(false);
                        pgui.createAndShowGUI();  
                        break; 
                    }
                    else {
                        JOptionPane.showMessageDialog(login, "Invalid Username or Password");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LoginGui.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
}

