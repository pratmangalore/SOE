package soeas4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class StudentGUI {
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
        gbc.gridy=0;
        gbc.gridx=0;
        JLabel ss = new JLabel("Subject");
        ss.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ss.setBackground(Color.white);
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
                subject.setMinimumSize(new Dimension(70, 30));
                subject.setBackground(Color.white);
                subject.setOpaque(true);
                subject.setForeground(Color.BLACK);
                pane.add(subject,gbc);
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void attendance(GridBagConstraints gbc) {
        sql = "Select * from Course NATURAL JOIN Studata where user = '"+user+"';";
        count=0;
        gbc.gridy=1;
        gbc.gridx=0;
        JLabel ats = new JLabel("Atndce");
        ats.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        ats.setBackground(Color.white);
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
                att.setMinimumSize(new Dimension(70, 30));
                att.setBackground(Color.white);
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
        gbc.gridy=2;
        gbc.gridx=0;
        JLabel mrs = new JLabel("Marks");
        mrs.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        mrs.setBackground(Color.white);
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
                marks.setMinimumSize(new Dimension(70, 30));
                marks.setBackground(Color.white);
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
        pane.setBackground(Color.orange);
        GridBagConstraints gbc = new GridBagConstraints();   
        gbc.fill = GridBagConstraints.HORIZONTAL;
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
}
