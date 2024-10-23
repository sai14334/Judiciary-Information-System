/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DaoClasses;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
/**
 *
 * @author rguktrkvalley
 */
public class LoginDao {
    
    DBConnect connect = new DBConnect();
    public int checkValidity(String userType, String userName, String password) 
    {   Connection conn = connect.checkConnection();
        if(conn!=null){
            char ch=getTable(userType);
             System.out.println(userType+" Out side Block");
            PreparedStatement ps =null;
            switch(ch)
            {
                case 'L':
                {
                    try {
                        ps=conn.prepareStatement("select * from LAWYER where LawyerUsername=? and Password=?;");
                        ps.setString(1, userName);
                        ps.setString(2, password);
                        ResultSet rs= ps.executeQuery();
                        if(rs.next()){
                             System.out.println(ch+" selected Table");
                            System.out.println(rs.getString("LawyerUsername")+rs.getString("Password")+" AS Lawyer");
                            return 2;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                 case 'R':
                {
                    try {
                        ps=conn.prepareStatement("select * from REGISTRAR where Username=? and Password=?;");
                        ps.setString(1, userName);
                        ps.setString(2, password);
                        ResultSet rs= ps.executeQuery();
                        if(rs.next()){
                            System.out.println(ch+" selected Table");
                            System.out.println(rs.getString("UserName")+rs.getString("Password")+" As Registrar");
                            return 1;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                 case 'J':
                {
                    try {
                        ps=conn.prepareStatement("select * from JUDGE where Username=? and Password=?;");
                        ps.setString(1, userName);
                        ps.setString(2, password);
                        ResultSet rs= ps.executeQuery();
                        if(rs.next()){
                            System.out.println(ch+" selected Table");
                            System.out.println(rs.getString("Username")+rs.getString("Password")+" AS Judge");
                            return 3;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                 case 'S':
                {
                    try {
                        ps=conn.prepareStatement("select * from STATION where StationUsername=? and Password=?;");
                        ps.setString(1, userName);
                        ps.setString(2, password);
                        ResultSet rs= ps.executeQuery();
                        if(rs.next()){
                             System.out.println(ch+" selected Table");
                            System.out.println(rs.getString("StationUsername")+rs.getString("Password")+" As Station");
                            return 4;
                        }
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
                 default:
                     return 0;

            }
         }
        
        return 0;
    }
    
    public char getTable (String userType)
    {
        switch(userType){
            case "Lawyer":
                return 'L';
            case "Registrar":
                return 'R';
            case "Station":
                return 'S';
            case "Judge":
                return 'J';
            default:
                return 'A';
        }
    }
    
}
