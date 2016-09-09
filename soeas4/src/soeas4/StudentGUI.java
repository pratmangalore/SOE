package soeas4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class StudentGUI implements ActionListener{
    public Statement stmt;
    public String title;
    public JFrame student;
    public JPanel pane;
    public int count;
    public String sql;
    public String user;
    StudentGUI(String title,Statement stmt,String user) {
        this.title=title;
        this.stmt=stmt;
        this.user=user;
        student = new JFrame(title);
        count=0;
    }
    void subjects(GridBagConstraints gbc) {
        sql = "Select * from Course NATURAL JOIN Studata where user = '"+user+"';";
        count=0;
        gbc.gridy=1;
        gbc.gridx=0;
        JLabel ss = new JLabel(" Course Name  ");
        ss.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ss.setPreferredSize(new Dimension(70, 30));
        ss.setBackground(new Color(211,211,211));
        ss.setOpaque(true);
        ss.setForeground(Color.BLACK);
        pane.add(ss,gbc);
        count++;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                gbc.gridx=count;
                JLabel subject = new JLabel(rs.getString("course"),SwingConstants.CENTER);
                subject.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                subject.setPreferredSize(new Dimension(70, 30));
                subject.setBackground(new Color(211,211,211));
                subject.setOpaque(true);
                subject.setForeground(Color.BLACK);
                pane.add(subject,gbc);
                count++;
            }
            gbc.gridy=0;
            gbc.gridx=count;
            JButton addp = new JButton("Logout");
            addp.addActionListener(this);
            addp.setActionCommand("Logout");
            pane.add(addp,gbc);
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void attendance(GridBagConstraints gbc) {
        sql = "Select * from Course NATURAL JOIN Studata where user = '"+user+"';";
        count=0;
        gbc.gridy=2;
        gbc.gridx=0;
        JLabel ats = new JLabel("  Attendance  ");
        ats.setPreferredSize(new Dimension(70, 30));
        ats.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ats.setBackground(new Color(211,211,211));
        ats.setOpaque(true);
        ats.setForeground(Color.BLACK);
        pane.add(ats,gbc);
        count++;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                gbc.gridx=count;
                JLabel att = new JLabel(Integer.toString(rs.getInt("attendance")),SwingConstants.CENTER);
                att.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                att.setPreferredSize(new Dimension(70, 30));
                att.setBackground(new Color(211,211,211));
                att.setOpaque(true);
                att.setForeground(Color.BLACK);
                pane.add(att,gbc);
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void marks(GridBagConstraints gbc) {
        sql = "Select * from Course NATURAL JOIN Studata where user = '"+user+"';";
        count=0;
        gbc.gridy=3;
        gbc.gridx=0;
        JLabel mrs = new JLabel("Marks Obtained");
        mrs.setPreferredSize(new Dimension(100, 30));
        mrs.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mrs.setBackground(new Color(211,211,211));
        mrs.setOpaque(true);
        mrs.setForeground(Color.BLACK);
        pane.add(mrs,gbc);
        count++;
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                gbc.gridx=count;
                JLabel marks = new JLabel(Integer.toString(rs.getInt("marks")),SwingConstants.CENTER);
                marks.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                marks.setPreferredSize(new Dimension(70, 30));
                marks.setBackground(new Color(211,211,211));
                marks.setOpaque(true);
                marks.setForeground(Color.BLACK);
                pane.add(marks,gbc);
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void create(GridBagConstraints gbc) {
        subjects(gbc);
        attendance(gbc);
        marks(gbc);
    }
    void populateGUI() {
        pane.setLayout(new GridBagLayout());
        pane.setBackground(new Color(135,206,250));
        GridBagConstraints gbc = new GridBagConstraints();   
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy=0;
        gbc.gridy=4;
        create(gbc);
    }
    void createAndShowGUI() {
        student.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane = new JPanel();
        populateGUI();       
        student.add(pane);
        student.setBounds(400,100,400,150);
        student.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if("Logout".equals(e.getActionCommand())) {
            student.setVisible(false);
            MainGui mgui = new MainGui("Institute Log In",stmt);
            mgui.createAndShowGUI();
            return;
        }
        student.setVisible(false);
        MainGui login = new MainGui("Institute Log In",stmt);
        login.createAndShowGUI();
    }
}
