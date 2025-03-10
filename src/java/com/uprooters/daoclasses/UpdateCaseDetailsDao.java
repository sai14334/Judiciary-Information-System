/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uprooters.daoclasses;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author rguktrkvalley
 */
public class UpdateCaseDetailsDao {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.checkConnection();
    
//    public int updateClosingDetails(int caseid, String caseStatus, String caseSummary, Date hearingdate, Date endDate) {
//        String query = "update CASES set CaseStatus=?, CaseSummary=?, NextHearingDate=?, EndDate=? where CaseID=?";
//        try {
//            PreparedStatement ps = conn.prepareStatement(query);
//            ps.setString(1, caseStatus);
//            ps.setString(2, caseSummary);
//             if (hearingdate != null) {
//                ps.setDate(3, new java.sql.Date(hearingdate.getTime()));
//            } else {
//                ps.setNull(3, java.sql.Types.DATE);
//            }
//              if (endDate != null) {
//                ps.setDate(4, new java.sql.Date(endDate.getTime()));
//            } else {
//                ps.setNull(4, java.sql.Types.DATE);
//            }
//            ps.setInt(5, caseid);
//            return ps.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(UpdateCaseDetailsDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return 0;
//    }

    public int updateCaseDetails(int caseid, String caseSummary, Date hearingdate) {
        String query = "update CASES set  CaseSummary=?, NextHearingDate=? where CaseID=? and JudgementStatus<> 'true'";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
           // ps.setString(1, caseStatus);
            ps.setString(1, caseSummary);
             if (hearingdate != null) {
                ps.setDate(2, new java.sql.Date(hearingdate.getTime()));
            } else {
                ps.setNull(2, java.sql.Types.DATE);
            }
            ps.setInt(3, caseid);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UpdateCaseDetailsDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public boolean isCaseClosed(int caseid, String status, Date date){
        String query = "update CASES set CaseStatus=?, EndDate=?, CaseSummary=? where CaseID=?;";
        String caseSummary = getJudgementDesc(caseid);
        if(conn!=null){
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, status);
                if (date != null) {
                ps.setDate(2, new java.sql.Date(date.getTime()));
                } else {
                ps.setNull(2, java.sql.Types.DATE);
                }
                ps.setString(3, caseSummary);
                ps.setInt(4, caseid);
                return ps.executeUpdate()>0;
            } catch (SQLException ex) {
                Logger.getLogger(UpdateCaseDetailsDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public String getJudgementDesc(int caseid){
            String query = "select JudgementDesc from JUDGEMENT where CaseID=?;";
            if(conn!=null){
                try {
                    PreparedStatement ps = conn.prepareStatement(query);
                    ps.setInt(1, caseid);
                    ResultSet rs = ps.executeQuery();
                    if(rs.next())
                        return rs.getString("JudgementDesc");
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateCaseDetailsDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return "Judgement Details Not available";
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
