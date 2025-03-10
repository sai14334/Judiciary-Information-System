/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uprooters.daoclasses;

import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rguktrkvalley
 */
public class PastCaseListDao {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.checkConnection();
    public List<Integer> getPastCases(int lid){
        List<Integer> list = new ArrayList<>();
        String query = "select CaseID from CASES where JudgementStatus='true' and CaseStatus='Closed' and LawyerID <>?;";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, lid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Past Cases");
                list.add(rs.getInt("CaseID"));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PastCaseListDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
