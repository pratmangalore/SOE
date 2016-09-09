package soeas4;

import com.sun.glass.events.KeyEvent;
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

public class ProfessorGUI implements ActionListener{
    public Statement stmt;
    public String title;
    public JFrame professor;
    public JFrame alldata;
    public JPanel pane;
    public JPanel datapane;
    public JRadioButton rb;
    public String user;
    public int count,sboth;
    public String sql;
    public String clas;
    public String course;
    public JLabel[] u = new JLabel[10];
    public JTextField[] att = new JTextField[10];
    public JTextField[] mrk = new JTextField[10];
    public JButton[] b = new JButton[10];
    public String[] courses = new String[10];
    public String[] classes = new String[10];
    ProfessorGUI(String title,Statement stmt,String user) {
        this.title=title;
        this.stmt=stmt;
        this.user=user;
        count=0;
        sboth=0;
        professor = new JFrame(title);
    }
    void subjects(GridBagConstraints gbc) {
        sql = "Select * from Profdata where user = '"+user+"';";
        count=0;
        try {
            gbc.gridy=0;  gbc.gridx=3;
            JButton addp = new JButton("Logout");
            addp.addActionListener(this);
            addp.setActionCommand("Logout");
            pane.add(addp,gbc);
            gbc.gridy=1;  gbc.gridx=0;
            JLabel l = new JLabel("Select:");
            l.setBackground(new Color(211,211,211));
            l.setOpaque(true);
            l.setForeground(Color.BLACK);
            pane.add(l,gbc);
            ResultSet rs = stmt.executeQuery(sql);
            gbc.gridy=2;
            ButtonGroup bg = new ButtonGroup();
            while(rs.next()) {
                gbc.gridx=count;               
                rb = new JRadioButton(rs.getString("course"));
                rb.setMnemonic(KeyEvent.VK_B);
                rb.setActionCommand(rs.getString("course"));
                rb.addActionListener(this);
                bg.add(rb);
                pane.add(rb,gbc);  
                count++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void classes(GridBagConstraints gbc) {
        gbc.gridy=3;    gbc.gridx=0;
        JPanel gap = new JPanel();
        gap.setBackground(new Color(135,206,250));
        gap.setSize(400, 150);
        pane.add(gap,gbc);
        gbc.gridy=4;    gbc.gridx=0;
        JLabel l = new JLabel("Select:");
        l.setBackground(new Color(211,211,211));
        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        pane.add(l,gbc);
        String section[] = {"SECTION A","SECTION B","SECTION C"};  
        gbc.gridy=5;
        ButtonGroup bg = new ButtonGroup();
        for(int i=0;i<3;i++) {
            gbc.gridx=i;
            rb = new JRadioButton(section[i]);
            rb.setMnemonic(KeyEvent.VK_B);
            rb.setActionCommand(section[i]);
            rb.addActionListener(this);
            bg.add(rb);
            pane.add(rb,gbc);    
        }
    }
    void create(GridBagConstraints gbc) {
        subjects(gbc);
        classes(gbc);
    }
    void create2(GridBagConstraints gbc) {
        gbc.gridy=0;
        gbc.gridx=0;
        JLabel l = new JLabel("StudentID ");
        l.setBackground(new Color(211,211,211));
        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        datapane.add(l,gbc);
        gbc.gridx=1;
        l = new JLabel("Attendance");
        l.setBackground(new Color(211,211,211));
        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        datapane.add(l,gbc);
        gbc.gridx=2;
        l = new JLabel("  Marks   ");
        l.setBackground(new Color(211,211,211));
        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        datapane.add(l,gbc);       
        sql = "Select * from Studata where course = '"+course+"' and class = '"+clas+"';";
        try {
            int y=1;
            ResultSet rs = stmt.executeQuery(sql);
            count=0;
            while(rs.next())
                count++;   
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                gbc.gridy=y;
                gbc.gridx=0;
                u[y-1] = new JLabel(rs.getString("user"));
                u[y-1].setMinimumSize(new Dimension(50,20));
                u[y-1].setBackground(new Color(211,211,211));
                u[y-1].setOpaque(true);
                u[y-1].setForeground(Color.BLACK);
                u[y-1].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                datapane.add(u[y-1],gbc);
                gbc.gridx=1;
                att[y-1] = new JTextField(Integer.toString(rs.getInt("attendance")));
                att[y-1].setMinimumSize(new Dimension(50,20));
                datapane.add(att[y-1],gbc);
                gbc.gridx=2;
                mrk[y-1] = new JTextField(Integer.toString(rs.getInt("marks")));
                mrk[y-1].setMinimumSize(new Dimension(50,20));
                datapane.add(mrk[y-1],gbc);
                gbc.gridx=3;
                b[y-1] = new JButton("Update");
                b[y-1].setActionCommand(Integer.toString(y-1));
                b[y-1].addActionListener(this);
                b[y-1].setMinimumSize(new Dimension(50,20));
                datapane.add(b[y-1],gbc);
                courses[y-1]=rs.getString("course");
                classes[y-1]=rs.getString("class");
                y++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    void populateGUI() {
        pane.setLayout(new GridBagLayout());
        pane.setBackground(new Color(135,206,250));
        GridBagConstraints gbc = new GridBagConstraints();   
        gbc.fill = GridBagConstraints.HORIZONTAL;
        create(gbc);
    }
    void populateGUI2() {
        datapane.setLayout(new GridBagLayout());
        datapane.setBackground(new Color(135,206,250));
        GridBagConstraints gbc = new GridBagConstraints();   
        gbc.fill = GridBagConstraints.HORIZONTAL;
        create2(gbc);
    }
    void createAndShowGUI() {
        pane = new JPanel();
        populateGUI();
        professor.add(pane);
        professor.setBounds(450,100,500,250);
        professor.setVisible(true);
    }
    
    void showStudata() {
        alldata = new JFrame(clas+" : "+course);
        datapane = new JPanel();
        populateGUI2();
        alldata.add(datapane);
        alldata.setBounds(485,100,400,250);
        alldata.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if("Logout".equals(e.getActionCommand())) {
            professor.setVisible(false);
            MainGui mgui = new MainGui("Institute Log In",stmt);
            mgui.createAndShowGUI();
            return;
        }
        switch (e.getActionCommand()) {
            case "SECTION A":
            case "SECTION B":
            case "SECTION C":
                sboth++;
                clas = e.getActionCommand();
                if(sboth==2) {
                    sboth=0;
                    showStudata();
                }
                return;
            case "SOE":
            case "AI" :
            case "CNE":
            case "GVC":
            case "POE":
                sboth++;
                course = e.getActionCommand();
                if(sboth==2) {
                    sboth=0;
                    showStudata();
                }
                return;
            default:
                if(Integer.parseInt(att[Integer.parseInt(e.getActionCommand())].getText())<=1)
                    mrk[Integer.parseInt(e.getActionCommand())].setText("0");
                sql = "Update Studata set attendance = "+att[Integer.parseInt(e.getActionCommand())].getText()+", marks = "+mrk[Integer.parseInt(e.getActionCommand())].getText()+" where user = '"+u[Integer.parseInt(e.getActionCommand())].getText()+"' and course = '"+courses[Integer.parseInt(e.getActionCommand())]+"' and class = '"+classes[Integer.parseInt(e.getActionCommand())]+"';";
                try {
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(alldata, "Updated Successfully");
                } catch (SQLException ex) {
                    Logger.getLogger(ProfessorGUI.class.getName()).log(Level.SEVERE, null, ex);
                }             
        }
    }
}
