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
public class AddUserDao {
    
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.checkConnection();
    public boolean addLawyer(String username, String pass, String name, String phone, String email) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into LAWYER (LawyerUsername, Password, Email, FullName, Contact) values(?,?,?,?,?);");
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setString(4, name);
            ps.setString(5, phone);
            int k = ps.executeUpdate();
            if(k>0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(AddUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }

    public boolean addJudge(String username, String pass, String name, String phone, String email) {
       try {
            PreparedStatement ps = conn.prepareStatement("insert into  JUDGE(Username, Password, Email, FullName, Contact) values(?,?,?,?,?);");
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setString(4, name);
            ps.setString(5, phone);
            int k = ps.executeUpdate();
            if(k>0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(AddUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean addRegistrar(String username, String pass, String name, String phone, String email) {
         try {
            PreparedStatement ps = conn.prepareStatement("insert into REGISTRAR (Username, Password, Email, FullName, Contact) values(?,?,?,?,?);");
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setString(4, name);
            ps.setString(5, phone);
            int k = ps.executeUpdate();
            if(k>0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(AddUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean addStation(String username, String pass, String name, String phone, String email) {
        try{
            PreparedStatement ps = conn.prepareStatement("insert into STATION (StationUsername, Password, Email, Contact, FullName) values(?,?,?,?,?);");
            ps.setString(1, username);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setString(5, name);
            int k = ps.executeUpdate();
            if(k>0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(AddUserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
    

