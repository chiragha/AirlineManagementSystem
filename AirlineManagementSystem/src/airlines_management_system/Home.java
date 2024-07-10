
package airlines_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener {
    public Home(){
        
       
        setLayout(null); 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlines_management_system/icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0 ,0, 1600, 800);
        add(image);
        
        
        
        JLabel heading = new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(500, 40, 1000, 40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 36));
        image.add(heading);
        
        
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails = new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight = new JMenuItem("Book Flight");
        bookFlight.addActionListener(this);
        details.add(bookFlight);
        
        JMenuItem JourneyDetails = new JMenuItem("Journey Details");
        JourneyDetails.addActionListener(this);
        details.add(JourneyDetails);
        
        
        
        JMenuItem ticketCancellation = new JMenuItem("Cancel Ticket");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
        
        
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingPass = new JMenuItem("Boarding Pass");
        boardingPass.addActionListener(this);
        ticket.add(boardingPass);
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String text = ae.getActionCommand();
            
        if(text.equals("Add Customer Details")){
            new Add_customer();
        }else if (text.equals("Flight Details")){
            new Flight_info();
        }else if (text.equals("Book Flight")){
            new Book_flight();
        }else if (text.equals("Journey Details")){
            new JourneyDetails();
        }else if (text.equals("Cancel Ticket")){
            new CancelTkt();
        }else if (text.equals("Boarding Pass")){
            new BoardingPass();
        }
    }

    
     public static void main(String[] args) {
        new Home();
    }   
    
}
