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
public class AssignedCasesDao {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.checkConnection();
    public int getJudgeId(String username) {
       if(conn!=null){
           String query = "select JudgeID from JUDGE where Username=?;";
           try {
               PreparedStatement ps = conn.prepareStatement(query);
               ps.setString(1, username);
               ResultSet rs = ps.executeQuery();
               if(rs.next()){
                   int jid = rs.getInt("JudgeID");
                   System.out.println(jid+" Judge ID from Dao Calss");
                   return jid;
               }
               return 0;
           } catch (SQLException ex) {
               Logger.getLogger(AssignedCasesDao.class.getName()).log(Level.SEVERE, null, ex);
           }
       
       }
       return 0;
    }

    public ResultSet getAssignedCases(int id) {
        String query = "select CaseID, DefendantName, DefendantAddress, CrimeDate, CrimeType, CrimeLoc, ArrestDate, "
                + "StartDate, EndDate, OfficerName, LawyerName, PPName, CaseStatus,"
                + "JudgeName, CaseSummary, NextHearingDate,JudgementStatus  from CASES where JudgeID=?";
        if(conn!=null){
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                return rs;
            } catch (SQLException ex) {
                Logger.getLogger(AssignedCasesDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        return null;
    }
    
}
