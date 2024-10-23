/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import DaoClasses.RetriveAcknowledgmentDao;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author rguktrkvalley
 */
public class Station {
    private int stationId;
    private String Username;
    private String Password;
    private String Email;
    private String FullName;
    private String Contact;
    public Station(){}
    /**
     * @return the stationId
     */
    public int getStationId() {
        return stationId;
    }

    /**
     * @param stationId the stationId to set
     */
    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    /**
     * @return the Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * @param Username the Username to set
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * @return the Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * @param Password the Password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * @return the Email
     */
    public String getEmail() {
        return Email;
    }

    /**
     * @param Email the Email to set
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     * @return the FullName
     */
    public String getFullName() {
        return FullName;
    }

    /**
     * @param FullName the FullName to set
     */
    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    /**
     * @return the Contact
     */
    public String getContact() {
        return Contact;
    }

    /**
     * @param Contact the Contact to set
     */
    public void setContact(String Contact) {
        this.Contact = Contact;
    }

    public List<Acknowledgment> getAcknowledgments(int sid) {
       RetriveAcknowledgmentDao rad = new RetriveAcknowledgmentDao();
       ResultSet rs = rad.getAcknowledgmets(sid);
       List<Acknowledgment> list = new ArrayList<>();
       if(rs != null){
           try {
               while(rs.next()){
                   Acknowledgment ack = new Acknowledgment();
                   ack.setAkcDesc(rs.getString("AdoDesc"));
                   ack.setCaseId(rs.getInt("CaseID"));
                   ack.setStationId(rs.getInt("StationID"));
                   list.add(ack);
               }
               return list;
           } catch (SQLException ex) {
               Logger.getLogger(Station.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       return list;
    }
}
