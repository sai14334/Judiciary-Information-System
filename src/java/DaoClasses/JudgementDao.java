/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoClasses;

import java.util.Date;
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
public class JudgementDao {
    
    DBConnect dbc = new  DBConnect();
    Connection conn = dbc.checkConnection();
    public int enterJudgementDetails(int caseid, String judgedesc, int id, Date judgedate) {
        
   
            if(conn!=null){
            String query = "insert into JUDGEMENT (CaseID, JudgeID, JudgementDesc, Date) Values(?,?,?,?);";
                try {
                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.setInt(1, caseid);
                    ps.setInt(2, id);
                    ps.setString(3, judgedesc);
                    if (judgedate != null) {
                    ps.setDate(4, new java.sql.Date(judgedate.getTime()));
                } else {
                    ps.setNull(4, java.sql.Types.DATE);
                }
                   System.out.println("Excecuted Update");
                System.out.println("Executing Query: " + ps.toString()); // Logs the query with values
                System.out.println("CaseID: " + caseid);
                System.out.println("JudgeID: " + id);
                System.out.println("Judgement Description: " + judgedesc);
                System.out.println("Judgement Date: " + judgedate);
                    return ps.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(JudgementDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return 0;
    }
    public boolean updateJudgementStatus(int caseID, int judgeID){
        String query = "update CASES set JudgementStatus='true' where CaseID=? and JudgeID=?;";
        if(conn!=null){
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, caseID);
                ps.setInt(2, judgeID);
                return ps.executeUpdate()>0;
            } catch (SQLException ex) {
                Logger.getLogger(JudgementDao.class.getName()).log(Level.SEVERE, null, ex);
            }       
        }
        return false;
    }
    public boolean checkStatus(int caseid, int judgeid){
        String query = "select JudgeID, CaseID from JUDGEMENT where CaseID=? and JudgeID=?;";
        if(conn!=null){
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                 ps.setInt(1, caseid);
                ps.setInt(2, judgeid);
                ResultSet rs = ps.executeQuery();
                 //System.out.println(rs.getBoolean("JudgementStatus")+" status of Judgemet");
                if(rs.next())  
                    return true;
                return false;
            } catch (SQLException ex) {
                Logger.getLogger(JudgementDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public Date closeCase(int caseid){
        String query = "select Date from JUDGEMENT where CaseID=?;";
        if(conn!=null){
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, caseid);
                ResultSet rs = ps.executeQuery();
                if(rs.next())
                    return rs.getDate("Date");
            } catch (SQLException ex) {
                Logger.getLogger(JudgementDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    public Date getHearingDate(int caseid){
        String query = "select NextHearingDate from CASES where CaseID=?;";
        Date heDate = null;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, caseid);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                heDate = rs.getDate("NextHearingDate");
            return heDate;
        } catch (SQLException ex) {
            Logger.getLogger(AddLawyerJudgeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return heDate;
    }
    
}
