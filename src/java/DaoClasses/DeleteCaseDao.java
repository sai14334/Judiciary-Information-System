/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rguktrkvalley
 */
public class DeleteCaseDao {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.checkConnection();
    public int deleteCase(int caseid) {
        String query = "delete from CASES where CaseID=?;";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, caseid);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DeleteCaseDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
