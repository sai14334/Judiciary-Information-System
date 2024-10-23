/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rguktrkvalley
 */
public class LawyerAssignedCasesDao {
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

    public ResultSet getAssignedCasesById(int lawid) {
         String query = "select CaseID, DefendantName, DefendantAddress, CrimeDate, CrimeType, CrimeLoc, ArrestDate, "
                + "StartDate, EndDate, OfficerName, LawyerName, PPName, CaseStatus,"
                + "JudgeName, CaseSummary, NextHearingDate,JudgementStatus  from CASES where LawyerID=?";
        if(conn!=null){
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, lawid);
                ResultSet rs = ps.executeQuery();
                return rs;
            } catch (SQLException ex) {
                Logger.getLogger(AssignedCasesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        return null;
        } 
    public boolean getAssignedCaseById(int lawid, int caseid){
        String query="select CaseID from ASSIGNED_CASES where LawyerID=? and CaseID=?;";
        if(conn!=null){
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, lawid);
                ps.setInt(2, caseid);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                    return true;
            } catch (SQLException ex) {
                Logger.getLogger(LawyerAssignedCasesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
        return false;
    }
    
    public boolean getUnClosedCases(int caseid){
        String query = "select CaseID from CASES where JudgementStatus='false' and CaseStatus='Pending' and CaseID=?;";
        if(conn != null){
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, caseid);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    System.out.println(" from if block in side unclosed Cases");
                    return true;
                    
                }
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(LawyerAssignedCasesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
        return false;
    }

    public boolean isExist(int caseid) {
        String query = "select CaseID from CASES where CaseID=?;";
        if(conn != null){
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, caseid);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    System.out.println(" from if block in side unclosed Cases");
                    return true;
                    
                }
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(LawyerAssignedCasesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
        return false;
    }
}
