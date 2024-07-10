
package airlines_management_system;


import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class Book_flight extends JFrame implements ActionListener{
    
    
//    Globally declared----------
    
    JTextField tfaadhar;
    JLabel tfname, tfnationality,tfaddress,labelgender, labelfname, labelfcode;
    JButton fetchUserButton , flight,bookflight ;
    Choice source, destination;
    JDateChooser dcdate;
    
    
    public Book_flight(){
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);
        
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(450, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLACK);
        add(heading);
        
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 80, 150, 25);
        add(tfaadhar);
        
        
        
//        fetch user details button--------
        
        
        fetchUserButton = new JButton("Fetch User");
        fetchUserButton.setBackground(Color.BLACK);
        fetchUserButton.setForeground(Color.WHITE);
        fetchUserButton.setBounds(380,80,120,25);
        fetchUserButton.addActionListener(this);
        add(fetchUserButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
        
         JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        
        labelgender = new JLabel("Gender");
        labelgender.setBounds(220, 280, 150, 25);
        add(labelgender);
        
        
        
//        fetch source and destination details
        
         JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(220,330,120,25);
//      source.add("chiragha");
        add(source);
        
        
         JLabel lbldest = new JLabel("Destination");
         lbldest.setBounds(60, 380, 150, 25);
         lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
         add(lbldest);
        
        
        destination = new Choice();
        destination.setBounds(220,380,150,25);
        add(destination);
        
        try {
            Conn c = new Conn();
            String query = "select * from flight_detail";
           ResultSet rs = c.s.executeQuery(query);
           
           while(rs.next()){
               source.add(rs.getString("source"));
               destination.add(rs.getString("destination"));
           }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
//       button --fetch all flight details------- 
        
        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380, 380, 120, 25);
        flight.addActionListener(this);
        add(flight);
        
        
//        flight name---------
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 430, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 430, 150, 25);
        add(labelfname);
        
        
        
//        flight code
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220, 480, 150, 25);
        add(labelfcode);
        
        
        
        
//        Travel date using calendar

        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(220, 530, 150, 25);
        add(dcdate);
        
        
        
//        side image----------
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlines_management_system/icons/travel.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        
        
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);
        
        
        
//        final button-------


        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(220,580,150,25);
        bookflight.addActionListener(this);
        add(bookflight);
        
        
        
        setSize(1100,700);
        setLocation(200,50);
        setVisible(true);
    }
    
    
//    code for fetch data from database
    
     public void actionPerformed(ActionEvent ae){
         
         if(ae.getSource() == fetchUserButton){
         String aadhar = tfaadhar.getText();        
         try {
             Conn conn = new Conn();
             String query = "select * from passenger where aadhar = '"+aadhar+"'";
             
             ResultSet rs = conn.s.executeQuery(query);
             
             
             if(rs.next()){
                 tfname.setText(rs.getString("name"));
                 tfnationality.setText("nationality");
                 tfaddress.setText(rs.getString("address"));
                 labelgender.setText(rs.getString("gender"));
             }else{
                  JOptionPane.showMessageDialog(null, "Please enter correct aadhar");
             }
           
         } catch (Exception e) {
             e.printStackTrace();
         }
        }else if(ae.getSource() == flight){
         String src = source.getSelectedItem();   
         String dest = destination.getSelectedItem(); 
         try {
             Conn conn = new Conn();
             String query = "select * from flight_detail where source = '"+src+"' and destination = '"+dest+"'";
             
             ResultSet rs = conn.s.executeQuery(query);
             
             
             if(rs.next()){
                 labelfname.setText(rs.getString("f_name"));
                 labelfcode.setText(rs.getString("f_code"));
             }else{
                  JOptionPane.showMessageDialog(null, "No Flights Found");
             }
           
          } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Random random = new Random();
            
            String aadhar = tfaadhar.getText();
            String name = tfname.getText(); 
            String nationality = tfnationality.getText();
            String flightname = labelfname.getText(); 
            String flightcode = labelfcode.getText();
            String src = source.getSelectedItem(); 
            String des = destination.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            
            try {
                Conn conn = new Conn();

                String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+aadhar+"', '"+name+"', '"+nationality+"', '"+flightname+"', '"+flightcode+"', '"+src+"', '"+des+"', '"+ddate+"')";

                conn.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");

                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Book_flight();
    }
}