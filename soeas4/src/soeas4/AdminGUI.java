package soeas4;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class AdminGUI implements ActionListener {
    public Statement stmt;
    public String title;
    public JFrame admin;
    public JPanel pane;
    public String sql;
    public JRadioButton rb;
    public int count;
    AdminGUI(String title,Statement stmt,String user) {
        this.title=title;
        this.stmt=stmt;
        count=0;
        admin = new JFrame("ADMIN : "+title);
    }
    void create(GridBagConstraints gbc) {
        gbc.gridy=0;  gbc.gridx=0;
        JLabel l = new JLabel("Select");
        l.setBackground(new Color(211,211,211));
        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        pane.add(l,gbc);
        try {
            sql = "select * from Professor";
            ResultSet rs = stmt.executeQuery(sql);
            ButtonGroup bg = new ButtonGroup();
            gbc.gridy=1;
            while(rs.next()) {
                gbc.gridx=count;               
                rb = new JRadioButton(rs.getString("user"));
                rb.setMnemonic(KeyEvent.VK_B);
                rb.setActionCommand(rs.getString("user"));
                rb.addActionListener(this);
                bg.add(rb);
                pane.add(rb,gbc);  
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void populateGUI() {
        pane.setLayout(new GridBagLayout());
        pane.setBackground(new Color(135,206,250));
        GridBagConstraints gbc = new GridBagConstraints();   
        gbc.fill = GridBagConstraints.HORIZONTAL;
        create(gbc);
    }
    void createAndShowGUI() {
        admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane = new JPanel();
        populateGUI();
        admin.add(pane);
        admin.setBounds(400,100,600,300);
        admin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProfessorGUI pgui = new ProfessorGUI(e.getActionCommand().toUpperCase(),stmt,e.getActionCommand());
        pgui.createAndShowGUI();
    }
}
