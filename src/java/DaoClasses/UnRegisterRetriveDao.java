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
import java.sql.ResultSet;
/**
 *
 * @author rguktrkvalley
 */
public class UnRegisterRetriveDao {
    
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.checkConnection();
    public ResultSet retriveUnregisteredData(){
        
        String query = "select CaseID, DefendantName, CrimeDate, CaseStatus from CASES where PPName IS NULL and JudgeName IS NULL;";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
           
            ResultSet rs = ps.executeQuery();
        //    System.out.println("from dao class"+rs.next());
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(UnRegisterRetriveDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
}
