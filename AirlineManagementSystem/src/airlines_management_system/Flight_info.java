
package airlines_management_system;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Flight_info extends JFrame{
    
    public Flight_info(){
        
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);
        
        JTable table = new JTable();
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from flight_detail");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,0,800,500);
        add(jsp);
        
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Flight_info();
    }
}
