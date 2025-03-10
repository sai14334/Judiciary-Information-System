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
public class EditPasswordDao {
    DBConnect dbc = new DBConnect();
    Connection conn =  dbc.checkConnection();

    public boolean checkOldPassowrd(String usertype, String username, String oldpass) {
       if(conn!=null){
        char ch = getTable(usertype);
         PreparedStatement ps =null;
            switch(ch)
            {
                case 'L':
                {
                    try {
                        ps=conn.prepareStatement("select * from LAWYER where LawyerUsername=? and Password=?;");
                        ps.setString(1, username);
                        ps.setString(2, oldpass);
                        ResultSet rs= ps.executeQuery();
                        if(rs.next())
                            return true;
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     break;
                }
                 case 'R':
                {
                    try {
                        ps=conn.prepareStatement("select * from REGISTRAR where Username=? and Password=?;");
                        ps.setString(1, username);
                        ps.setString(2, oldpass);
                        ResultSet rs= ps.executeQuery();
                        if(rs.next())
                            return true;
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     break;
                }
                 case 'J':
                {
                    try {
                        ps=conn.prepareStatement("select * from JUDGE where Username=? and Password=?;");
                        ps.setString(1, username);
                        ps.setString(2, oldpass);
                        ResultSet rs= ps.executeQuery();
                        if(rs.next())
                            return true;
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     break;
                }
                 case 'S':
                {
                    try {
                        ps=conn.prepareStatement("select * from STATION where StationUsername=? and Password=?;");
                        ps.setString(1, username);
                        ps.setString(2, oldpass);
                        ResultSet rs= ps.executeQuery();
                        if(rs.next())
                            return true;
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     break;
                }
                 default:
                     return false;

            }
       }
        return false;
    }

    public boolean updatePassword(String username, String pass, String usertype) {
        if(conn!=null){
            char ch = getTable(usertype);
            PreparedStatement ps =null;
            String newpass = encryptPassword(pass);
            switch(ch){
                case 'L':
                {
                    try {
                        ps = conn.prepareStatement("update LAWYER set Password=? where LawyerUsername=?;");
                        ps.setString(1, newpass);
                        ps.setString(2,username);
                        return ps.executeUpdate()>0;
                    } catch (SQLException ex) {
                        Logger.getLogger(EditPasswordDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     break;
                }
                case 'R':
                {
                    try {
                        ps = conn.prepareStatement("update REGISTRAR set Password=? where Username=?");
                        ps.setString(1, newpass);
                        ps.setString(2,username);
                        return ps.executeUpdate()>0;
                    } catch (SQLException ex) {
                        Logger.getLogger(EditPasswordDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     break;
                }
                case 'J':
                {
                    try {
                        ps = conn.prepareStatement("update JUDGE set Password=? where Username=?");
                        ps.setString(1, newpass);
                        ps.setString(2,username);
                        return ps.executeUpdate()>0;
                    } catch (SQLException ex) {
                        Logger.getLogger(EditPasswordDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 break;
                }
                case 'S':
                {
                    try {
                        ps = conn.prepareStatement("update STATION set Password=? where StationUsername=?");
                        ps.setString(1, newpass);
                        ps.setString(2,username);
                        return ps.executeUpdate()>0;
                    } catch (SQLException ex) {
                        Logger.getLogger(EditPasswordDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     break;
                }
            }
        }
        return false;
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
    public String encryptPassword(String password){
        // 12 is my encryption key 
        String modified = password.chars()
                                  .map(c -> c + 12)
                                  .collect(StringBuilder::new,
                                           StringBuilder::appendCodePoint,
                                           StringBuilder::append)
                                  .toString();
        return modified;
    }
}
