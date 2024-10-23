/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoClasses;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rguktrkvalley
 */
public class RetriveAcknowledgmentDao {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.checkConnection();
    public ResultSet getAcknowledgmets(int stationid) {
        String query = "select CaseID, StationID, AdoDesc from ACKNOWLEDGMENTS where StationID=?;";
        if(conn!=null){
            try {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, stationid);
                return ps.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(RetriveAcknowledgmentDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
