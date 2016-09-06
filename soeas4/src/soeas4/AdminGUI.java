package soeas4;

import com.sun.glass.events.KeyEvent;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class AdminGUI implements ActionListener {
    public Statement stmt;
    public String title;
    public JFrame admin;
    public JFrame adder;
    public JPanel pane;
    public JPanel datapane;
    public String sql;
    public String clas;
    public JRadioButton rb;
    public JTextField utext;
    public JCheckBox cb;
    public JPasswordField ptext;
    public JCheckBox c;
    public List<JCheckBox> cbg = new ArrayList<JCheckBox>();
    public int count;
    AdminGUI(String title,Statement stmt,String user) {
        this.title=title;
        this.stmt=stmt;
        count=0;
        admin = new JFrame("ADMIN : "+title);
    }
    void create(GridBagConstraints gbc) {
        gbc.gridy=0;  gbc.gridx=0;
        gbc.weighty=10;
        JLabel l = new JLabel("Select");
        l.setBackground(new Color(211,211,211));
        l.setOpaque(true);
        l.setForeground(Color.BLACK);
        pane.add(l,gbc);
        ButtonGroup bg = new ButtonGroup();
        try {
            sql = "select * from Professor";
            ResultSet rs = stmt.executeQuery(sql);
            gbc.gridy=1;
            gbc.weighty=0;
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
        gbc.gridx=count;
        rb = new JRadioButton("All");
        rb.setMnemonic(KeyEvent.VK_B);
        rb.setActionCommand("All");
        rb.addActionListener(this);
        bg.add(rb);
        pane.add(rb,gbc);
        gbc.gridy=2;  gbc.gridx=1;
        gbc.gridwidth=2;
        gbc.weighty=40;
        JButton adds = new JButton("Add Student");
        adds.addActionListener(this);
        adds.setActionCommand("Add Student");
        pane.add(adds,gbc);
        gbc.gridy=2;  gbc.gridx=4;
        gbc.gridwidth=2;
        JButton addp = new JButton("Add Prof.");
        addp.addActionListener(this);
        addp.setActionCommand("Add Prof.");
        pane.add(addp,gbc);
    }
    void create2(GridBagConstraints gbc) {
        gbc.gridx=1;
        gbc.gridy=0;
        JLabel ulabel = new JLabel("Set Username",SwingConstants.CENTER);
        ulabel.setMinimumSize(new Dimension(100,15));
        ulabel.setBackground(Color.WHITE);
        ulabel.setOpaque(true);
        ulabel.setForeground(Color.BLACK);
        datapane.add(ulabel,gbc);
        gbc.gridx=3;
        gbc.gridy=0;
        utext = new JTextField("",SwingConstants.CENTER);
        utext.setMinimumSize(new Dimension(100,15));
        utext.setBackground(Color.WHITE);
        utext.setOpaque(true);
        utext.setForeground(Color.BLACK);
        datapane.add(utext,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        JLabel plabel = new JLabel("Set Password",SwingConstants.CENTER);
        plabel.setMinimumSize(new Dimension(100,15));
        plabel.setBackground(Color.WHITE);
        plabel.setOpaque(true);
        plabel.setForeground(Color.BLACK);
        datapane.add(plabel,gbc);
        gbc.gridx=3;
        gbc.gridy=1;
        ptext = new JPasswordField("",SwingConstants.CENTER);
        ptext.setMinimumSize(new Dimension(100,15));
        ptext.setBackground(Color.WHITE);
        ptext.setOpaque(true);
        ptext.setForeground(Color.BLACK);
        datapane.add(ptext,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        String section[] = {"SECTION A","SECTION B","SECTION C"};  
        ButtonGroup bg = new ButtonGroup();
        for(int i=0;i<3;i++) {
            gbc.gridx=i+1;
            rb = new JRadioButton(section[i]);
            rb.setMnemonic(KeyEvent.VK_B);
            rb.setActionCommand(section[i]);
            rb.addActionListener(this);
            bg.add(rb);
            datapane.add(rb,gbc);    
        }
        gbc.gridy=3;
        gbc.gridx=0;
        JCheckBox c;
        c = new JCheckBox("SOE", false);
        cbg.add(c);
        datapane.add(c,gbc);
        gbc.gridx=1;
        c = new JCheckBox("AI", false);
        cbg.add(c);
        datapane.add(c,gbc); 
        gbc.gridx=2;
        c = new JCheckBox("CNE", false);
        cbg.add(c);
        datapane.add(c,gbc); 
        gbc.gridx=3;
        c = new JCheckBox("GVC", false);
        cbg.add(c);
        datapane.add(c,gbc); 
        gbc.gridx=4;
        c = new JCheckBox("POE", false);
        cbg.add(c);     
        datapane.add(c,gbc); 
        gbc.gridy=4;
        gbc.gridx=2;
        JButton b = new JButton("Add");
        b.setMaximumSize(new Dimension(100,30));
        b.setActionCommand("Add");
        b.addActionListener(this);
        datapane.add(b,gbc);
    }
    void create3(GridBagConstraints gbc) {
        gbc.gridx=0;
        gbc.gridy=0;
        JLabel ulabel = new JLabel("Set Username",SwingConstants.CENTER);
        ulabel.setBackground(Color.WHITE);
        ulabel.setOpaque(true);
        ulabel.setForeground(Color.BLACK);
        datapane.add(ulabel,gbc);
        gbc.gridx=1;
        gbc.gridy=0;
        utext = new JTextField("",SwingConstants.CENTER);
        utext.setBackground(Color.WHITE);
        utext.setOpaque(true);
        utext.setForeground(Color.BLACK);
        datapane.add(utext,gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        JLabel plabel = new JLabel("Set Password",SwingConstants.CENTER);
        plabel.setBackground(Color.WHITE);
        plabel.setOpaque(true);
        plabel.setForeground(Color.BLACK);
        datapane.add(plabel,gbc);
        gbc.gridx=1;
        gbc.gridy=1;
        ptext = new JPasswordField("",SwingConstants.CENTER);
        ptext.setBackground(Color.WHITE);
        ptext.setOpaque(true);
        ptext.setForeground(Color.BLACK);
        datapane.add(ptext,gbc);
        gbc.gridx=1;
        gbc.gridy=2;
        JButton b = new JButton("Add");
        b.setMaximumSize(new Dimension(100,30));
        b.setActionCommand("Add");
        b.addActionListener(this);
        datapane.add(b,gbc);
    }
    void populate2GUI() {
        datapane.setLayout(new GridBagLayout());
        datapane.setBackground(new Color(135,206,250));
        GridBagConstraints gbc = new GridBagConstraints();   
        gbc.fill = GridBagConstraints.HORIZONTAL;
        create2(gbc);
    }
    void populate3GUI() {
        datapane.setLayout(new GridBagLayout());
        datapane.setBackground(new Color(135,206,250));
        GridBagConstraints gbc = new GridBagConstraints();   
        gbc.fill = GridBagConstraints.HORIZONTAL;
        create3(gbc);
    }
    void populateGUI() {
        pane.setLayout(new GridBagLayout());
        pane.setBackground(new Color(135,206,250));
        GridBagConstraints gbc = new GridBagConstraints();   
        gbc.fill = GridBagConstraints.HORIZONTAL;
        create(gbc);
    }
    void showAddStudent() {
        datapane = new JPanel();
        populate2GUI();
        adder.add(datapane);
        adder.setBounds(400,100,600,300);
        adder.setVisible(true);
    }
    void showAddProfessor() {
        datapane = new JPanel();
        populate3GUI();
        adder.add(datapane);
        adder.setBounds(400,100,600,300);
        adder.setVisible(true);
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
        if("All".equals(e.getActionCommand())) {
            ProfessorGUI pgui = new ProfessorGUI("DEAN",stmt,"Dean");
            pgui.createAndShowGUI();
            return;
        }
        if("Add Student".equals(e.getActionCommand())) {
            adder = new JFrame("Add Student");
            showAddStudent();
            return;
        }
        if("Add Prof.".equals(e.getActionCommand())) {
            adder = new JFrame("Add Professor");
            showAddProfessor();
            return;
        }
        if("Add".equals(e.getActionCommand())) {
            if("Add Student".equals(adder.getTitle())) {
                try {
                    sql = "Insert into Student Values ('"+utext.getText()+"','"+ptext.getText()+"')";
                    stmt.executeUpdate(sql);
                    sql = "Insert into Class Values ('"+utext.getText()+"','"+clas+"');";
                    stmt.executeUpdate(sql);
                    for (JCheckBox cb : cbg) {
                        if(cb.isSelected()) {
                            sql = "Insert into Course Values ('"+utext.getText()+"','"+cb.getText()+"');";                 
                            stmt.executeUpdate(sql);
                        }
                    }                    
                    for (JCheckBox cb : cbg) {
                        if(cb.isSelected()) {
                            sql= "Insert into Studata values ('"+utext.getText()+"','"+cb.getText()+"',0,0,'"+clas+"');";
                            stmt.executeUpdate(sql);
                        }
                    }
                    JOptionPane.showMessageDialog(admin, "Updated Successfully");
                } catch (SQLException ex) {
                    Logger.getLogger(AdminGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else {
                
            }
            return;
        }
        if("SECTION A".equals(e.getActionCommand()) || "SECTION B".equals(e.getActionCommand()) || "SECTION C".equals(e.getActionCommand())) {
            clas=e.getActionCommand();      
            return;
        }
        ProfessorGUI pgui = new ProfessorGUI(e.getActionCommand().toUpperCase(),stmt,e.getActionCommand());
            pgui.createAndShowGUI();
    }
}
