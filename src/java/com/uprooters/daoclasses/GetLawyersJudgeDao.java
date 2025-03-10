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
public class GetLawyersJudgeDao {
    
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.checkConnection();
    
    public ResultSet getLawyerDetails(){
        String query = "select LawyerID, FullName from LAWYER;";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(GetLawyersJudgeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return null;
    }
    
    public ResultSet getJudgeDetails(){
        String query = "select JudgeID, FullName from JUDGE;";
        
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(GetLawyersJudgeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return null;
    }
}
