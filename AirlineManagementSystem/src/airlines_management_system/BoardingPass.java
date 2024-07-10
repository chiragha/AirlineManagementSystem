
package airlines_management_system;


import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener{
    
    
//    Globally declared----------
    
    JTextField tfpnr;
    JLabel tfname, tfnationality,lblsrc,lbldest, labelfname, labelfcode, labeldate;
    JButton fetchUserButton;
   
    
    
    
    public BoardingPass(){
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);
        
        
        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380, 10, 450, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(360, 50, 300, 30);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        subheading.setForeground(Color.BLACK);
        add(subheading);
        
        
        JLabel lblpnr = new JLabel("PNR Details");
        lblpnr.setBounds(60, 100, 150, 25);
        lblpnr.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpnr);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);
        
        
        
//        PNR details button--------
        
        
        fetchUserButton = new JButton("Enter");
        fetchUserButton.setBackground(Color.BLACK);
        fetchUserButton.setForeground(Color.WHITE);
        fetchUserButton.setBounds(380,100,120,25);
        fetchUserButton.addActionListener(this);
        add(fetchUserButton);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 140, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        
        JLabel lbladdress = new JLabel("SRC");
        lbladdress.setBounds(60, 220, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        lblsrc = new JLabel();
        lblsrc.setBounds(220, 220, 150, 25);
        add(lblsrc);
        
        JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(380, 220, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        lbldest = new JLabel();
        lbldest.setBounds(540, 220, 150, 25);
        add(lbldest);
        
        

//        flight name---------
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 260, 150, 25);
        add(labelfname);
        
        
        
//        flight code
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(380, 260, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(540, 260, 150, 25);
        add(labelfcode);
        
        
        
        
//        Travel date using calendar

        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 300, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        labeldate = new JLabel();
        labeldate.setBounds(220, 300, 150, 25);
        add(labeldate);
        
        
        
//        side image----------
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlines_management_system/icons/airplane.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        
        
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 0, 300, 300);
        add(lblimage);
        
        
        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);
    }
    
    
//    code for fetch data from database
    
     public void actionPerformed(ActionEvent ae){
         
         if(ae.getSource() == fetchUserButton){
         String pnr = tfpnr.getText();        
         try {
             Conn conn = new Conn();
             String query = "select * from reservation where PNR = '"+pnr+"'";
             
             ResultSet rs = conn.s.executeQuery(query);
             
             
             if(rs.next()){
                 tfname.setText(rs.getString("name"));
                 tfnationality.setText(rs.getString("nationality"));
                 labelfname.setText(rs.getString("flightname"));
                 labelfcode.setText(rs.getString("flightcode"));
                 lblsrc.setText(rs.getString("src"));
                 lbldest.setText(rs.getString("des")); 
                 labeldate.setText(rs.getString("ddate"));
                 
                
             }else{
                  JOptionPane.showMessageDialog(null, "Please enter correct PNR");
             }
           
         } catch (Exception e) {
             e.printStackTrace();
         }
         }
    }

    public static void main(String[] args) {
        new BoardingPass();
    }
}