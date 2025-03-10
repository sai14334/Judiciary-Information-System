/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uprooters.daoclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author rguktrkvalley
 */
// LawyerID, LawyerName, PPName, JudgeID, JudgeName, CaseID
public class AddLawyerJudgeDao {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.checkConnection();

    public int addLawyerJudgeDetails(int caseId, int defId, int judgeId, 
            String lawyerName, String PPName, String judgeName, Date hearingdate) {
        String query = "update CASES set LawyerID=?, LawyerName=?, PPName=?, JudgeID=?, "
                + "JudgeName=?, NextHearingDate=? where caseID=?";
        String sql = "insert into ASSIGNED_CASES (CaseID, LawyerID, LawyerName) values (?, ?, ?);";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            PreparedStatement ps2 = conn.prepareStatement(sql);
            ps2.setInt(1, caseId);
            ps2.setInt(2, defId);
            ps2.setString(3, lawyerName);
            ps.setInt(1, defId);
            ps.setString(2, lawyerName);
            ps.setString(3,PPName);
            ps.setInt(4,judgeId);
            ps.setString(5, judgeName);
            if (hearingdate != null) {
                ps.setDate(6, new java.sql.Date(hearingdate.getTime()));
            } else {
                ps.setNull(6, java.sql.Types.DATE);
            }
            ps.setInt(7, caseId);
            int a = ps2.executeUpdate();
            int k = ps.executeUpdate();
            return k;
        } catch (SQLException ex) {
            Logger.getLogger(AddLawyerJudgeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public Date getStartDate(int caseid){
        String query = "select StartDate from CASES where CaseID=?;";
        Date stDate = null;
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, caseid);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
                stDate = rs.getDate("StartDate");
            return stDate;
        } catch (SQLException ex) {
            Logger.getLogger(AddLawyerJudgeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stDate;
    }
    
}
