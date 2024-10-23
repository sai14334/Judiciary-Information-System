/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoClasses;

import Beans.PaymentDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rguktrkvalley
 */
public class LawyerPaymentDao {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.checkConnection();
    public int getLawyerId(String username) {
       if(conn!=null){
           String query = "select LawyerID from LAWYER where LawyerUsername=?;";
           try {
               PreparedStatement ps = conn.prepareStatement(query);
               ps.setString(1, username);
               ResultSet rs = ps.executeQuery();
               if(rs.next())
                   return rs.getInt("LawyerID");
           } catch (SQLException ex) {
               Logger.getLogger(LawyerAssignedCasesDao.class.getName()).log(Level.SEVERE, null, ex);
           }
       
       }
       return 0;
    }

    public boolean addPaymentDetails(int lawid, double amount, String paymentStatus) {
        String query = "insert into PAYMENT_DETAILS(LawyerID, Amount, PaymentStatus,"
                + " PaymentDate) values(?, ?, ?, CURDATE());";
        if(conn!= null){
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, lawid);
                ps.setDouble(2, amount);
                ps.setString(3, paymentStatus);
                return ps.executeUpdate()>0;
            } catch (SQLException ex) {
                Logger.getLogger(LawyerPaymentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    public List<Integer> getLawyerIdList(){
        String query = "select LawyerID from LAWYER;";
        List<Integer> list = new ArrayList<>();
        if(conn!=null){
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    list.add(rs.getInt("LawyerID"));
                }
                return list;
            } catch (SQLException ex) {
                Logger.getLogger(LawyerPaymentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public ResultSet getPaymentDetails(int id){
        String query="select PaymentID, Amount, PaymentStatus, PaymentDate from PAYMENT_DETAILS where LawyerID=?;";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(LawyerPaymentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
