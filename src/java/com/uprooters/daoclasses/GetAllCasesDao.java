/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uprooters.daoclasses;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rguktrkvalley
 */
public class GetAllCasesDao {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.checkConnection();
    
    public ResultSet getCasesSet(){
        ResultSet rs = null;
        String query = "select CaseID, DefendantName, DefendantAddress, CrimeDate, CrimeType, CrimeLoc, ArrestDate, "
                + "StartDate, EndDate, OfficerName, LawyerName, PPName, CaseStatus,"
                + "JudgeName, CaseSummary, NextHearingDate, JudgementStatus from CASES;";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(GetAllCasesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet getCaseById(int id) {
        ResultSet rs = null;
        String query = "select CaseID, DefendantName, DefendantAddress, CrimeDate, CrimeType, CrimeLoc, ArrestDate, "
                + "StartDate, EndDate, OfficerName, LawyerName, PPName, CaseStatus,"
                + "JudgeName, CaseSummary, NextHearingDate,JudgementStatus from CASES where CaseID=?;";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(GetAllCasesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    public ResultSet readyToClose(){
        ResultSet rs = null;
        String query = "select CaseID, DefendantName, DefendantAddress, CrimeDate, CrimeType, CrimeLoc, ArrestDate, "
                + "StartDate, EndDate, OfficerName, LawyerName, PPName, CaseStatus,"
                + "JudgeName, CaseSummary, NextHearingDate, JudgementStatus from CASES where JudgementStatus='true';";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(GetAllCasesDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
