/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uprooters.daoclasses;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author rguktrkvalley
 */
public class RemoveUserDao {
    DBConnect dbc = new DBConnect();
    Connection conn = dbc.checkConnection();
    public boolean removeLawyer(String username) {
        try{
            System.out.println(username +" to delete");
            PreparedStatement ps = conn.prepareStatement("delete from LAWYER where LawyerUsername=?;");
            ps.setString(1, username);
            System.out.println("Before Deleting");
          int k = ps.executeUpdate();
          System.out.println(k +" deleted Status");
          if(k>0)
              return true;
        }catch(Exception e){}
        return false;
    }
    public boolean removeJudge(String username) {
         try{
            PreparedStatement ps = conn.prepareStatement("delete from JUDGE where Username=?;");
            ps.setString(1, username);
          int k = ps.executeUpdate();
          if(k>0)
              return true;
        }catch(Exception e){}
        return false;
    }

    public boolean removeRegistrar(String username) {
         try{
            PreparedStatement ps = conn.prepareStatement("delete from REGISTRAR where Username=?;");
            ps.setString(1, username);
          int k = ps.executeUpdate();
          if(k>0)
              return true;
        }catch(Exception e){}
        return false;
    }

    public boolean removeStation(String username) {
         try{
            PreparedStatement ps = conn.prepareStatement("delete from STATION where StationUsername=?;");
            ps.setString(1, username);
          int k = ps.executeUpdate();
          if(k>0)
              return true;
        }catch(Exception e){}
        return false;
    }
    
}
