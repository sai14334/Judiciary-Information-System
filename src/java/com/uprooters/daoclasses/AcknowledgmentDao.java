/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uprooters.daoclasses;

import com.uprooters.beans.Cases;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author rguktrkvalley
 */
public class AcknowledgmentDao {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.checkConnection();
    public ResultSet getAckCasesList(){
        String query = "select CaseID, StationID, NextHearingDate from CASES where NextHearingDate > CURDATE() "
                + "and NextHearingDate <= DATE_ADD(CURDATE(),INTERVAL 7 DAY) and JudgementStatus <>'true';";
        if(conn != null){
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                return ps.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(AcknowledgmentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean addAckDetails(List<Cases> list) {
        
        String query = "insert into ACKNOWLEDGMENTS(StationID, AdoDesc, CaseID, NextHearingDate) values(?, ?, ?, ?);";
        if(conn!=null){
            int c = list.size();
            List<Integer> output = new ArrayList<>();
            List<Boolean> dates = getAckDates(list , c);
            PreparedStatement ps =null;
            for(int i=0;i<c;i++){
                try {
                    if(!dates.get(i)){
                    ps = conn.prepareStatement(query);
                    ps.setInt(1, list.get(i).getStationId());
                    ps.setString(2, "update inverstigation status and attend Hearing");
                    ps.setInt(3, list.get(i).getCaseId());
                    if (list.get(i).getHearingDate() != null) {
                        ps.setDate(4, new java.sql.Date(list.get(i).getHearingDate().getTime()));
                     } else {
                    ps.setNull(4, java.sql.Types.DATE);
                    }   
                    output.add(ps.executeUpdate());
                    }
                    else{
                        output.add(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AcknowledgmentDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            int size = output.size();
            for(int i=0;i<size;i++){
                if(output.get(i)<=0)
                    return false;
            }
            return true;
        }
        return false;
    }
    public List<Boolean> getAckDates(List<Cases> list ,int count){
        List<Boolean> dates = new ArrayList<>();
      //  int count = list.size();
        String query ="select * from ACKNOWLEDGMENTS where CaseID=? and StationID=? and NextHearingDate=?;";
        if(conn!=null){
            try {
               for(int i=0;i<count;i++){
                 
                   PreparedStatement ps = conn.prepareStatement(query);
                   ps.setInt(1, list.get(i).getCaseId());
                   ps.setInt(2, list.get(i).getStationId());
                   if (list.get(i).getHearingDate() != null) {
                    ps.setDate(3, new java.sql.Date(list.get(i).getHearingDate().getTime()));
                    } else {
                    ps.setNull(3, java.sql.Types.DATE);
                    } 
                   ResultSet rs = ps.executeQuery();
                    if(rs.next())
                        dates.add(Boolean.TRUE);
                    else
                        dates.add(Boolean.FALSE);
               }
             
               return dates;
            } catch (SQLException ex) {
                Logger.getLogger(AcknowledgmentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dates;
    }
}
