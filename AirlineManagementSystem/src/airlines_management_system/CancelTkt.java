
package airlines_management_system;


import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CancelTkt extends JFrame implements ActionListener{
    
    
//    Globally declared----------
    
    JTextField tfpnr;
    JLabel tfname, cancelnm,lblfcode,labeldate;
    JButton fetchUserButton , flight;
   
   
    
    
    public CancelTkt(){
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);
        
        Random random = new Random();
        
        //Heading
        
        JLabel heading = new JLabel("CANCELLATION");
        heading.setBounds(200, 20, 250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        
        add(heading);
        
        //side image
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlines_management_system/icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(490,100,250,250);
        add(image);
        
        
        JLabel lblpnrnum = new JLabel("PNR Number");
        lblpnrnum.setBounds(60, 80, 150, 25);
        lblpnrnum.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpnrnum);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);
        
        
        
//        fetch user details button--------
        
        
        fetchUserButton = new JButton("Show Details");
        fetchUserButton.setBackground(Color.BLACK);
        fetchUserButton.setForeground(Color.WHITE);
        fetchUserButton.setBounds(380,80,120,25);
        fetchUserButton.addActionListener(this);
        add(fetchUserButton);
        
        
        //name data-----
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        
        
        //Cancellation number
        
        
        JLabel lblcancelno = new JLabel("Cancellation number");
        lblcancelno.setBounds(60, 180, 150, 25);
        lblcancelno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblcancelno);
        
        cancelnm = new JLabel("" + random.nextInt(1000000)); // Generate random 6 digit cancellation no
        cancelnm.setBounds(220, 180, 150, 25);
        add(cancelnm);
        
        
        
        
        // flight code
        
        JLabel lblfc = new JLabel("Flight Code");
        lblfc.setBounds(60, 230, 150, 25);
        lblfc.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfc);
        
        lblfcode = new JLabel();
        lblfcode.setBounds(220, 230, 150, 25);
        add(lblfcode);
        
        
        
        //travel date
          
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 280, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        
        labeldate = new JLabel();
        labeldate.setBounds(220, 280, 150, 25);
        add(labeldate);
        
        
        

//       button --fetch all flight details------- 
        
        flight = new JButton("Cancel");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220, 330, 120, 25);
        flight.addActionListener(this);
        add(flight);
        
        
 
        setSize(800, 450);
        setLocation(350, 150);
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
                 lblfcode.setText("flightcode");
                 labeldate.setText(rs.getString("ddate"));
                
             }else{
                  JOptionPane.showMessageDialog(null, "Please enter correct PNR");
             }
           
         } catch (Exception e) {
             e.printStackTrace();
         }
        }else if(ae.getSource() == flight){
         String name = tfname.getText();   
         String pnr = tfpnr.getText(); 
         String cancelno = cancelnm.getText();
         String fcode = lblfcode.getText();
         String date = labeldate.getText();
         try {
                Conn conn = new Conn();

                String query = "insert into cancel values('"+pnr+"', '"+name+"', '"+cancelno+"', '"+fcode+"', '"+date+"')";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");
                
                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
                setVisible(false);
            
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }

    public static void main(String[] args) {
        new CancelTkt();
    }
}