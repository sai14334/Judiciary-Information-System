/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uprooters.beans;

import com.uprooters.daoclasses.LawyerAssignedCasesDao;
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
public class Lawyer {
    private int lawyerId;
    private String Username;
    private String Password;
    private String Email;
    private String FullName;
    private String Contact;
    
    public Lawyer(){}
     public Lawyer(int lawyerId, String username, String password, String email, String fullName, String contact) {
        this.lawyerId = lawyerId;
        this.Username = username;
        this.Password = password;
        this.Email = email;
        this.FullName = fullName;
        this.Contact = contact;
    }
    /**
     * @return the lawyerId
     */
    public int getLawyerId() {
        return lawyerId;
    }

    /**
     * @param lawyerId the lawyerId to set
     */
    public void setLawyerId(int lawyerId) {
        this.lawyerId = lawyerId;
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
    
    @Override
    public String toString() {
        return "Lawyer{" +
            "lawyerId=" + lawyerId +
            ", username='" + Username + '\'' +
            ", email='" + Email + '\'' +
            ", fullName='" + FullName + '\'' +
            ", contact='" + Contact + '\'' +
            '}';
}
    public List<Cases> getLawyerAssignedCases(int lawid){
            LawyerAssignedCasesDao lad = new LawyerAssignedCasesDao();
            List<Cases> list = new ArrayList<>();
            ResultSet rs = lad.getAssignedCasesById(lawid);
            if(rs != null){
                try {
                    while(rs.next()){
                        Cases cases = new Cases();
                        cases.setCaseId(rs.getInt("CaseID"));
                        cases.setDefendantName(rs.getString("DefendantName"));
                        cases.setDefendantAddress(rs.getString("DefendantAddress"));
                        cases.setCrimeDate(rs.getDate("CrimeDate"));
                        cases.setArrestDate(rs.getDate("ArrestDate"));
                        cases.setOfficerName(rs.getString("OfficerName"));
                        cases.setLawyerName(rs.getString("LawyerName"));
                        cases.setPpName(rs.getString("PPName"));
                        cases.setCaseStatus(rs.getString("CaseStatus"));
                        cases.setHearingDate(rs.getDate("NextHearingDate")); 
                        cases.setIsJudgementPassed(rs.getBoolean("JudgementStatus"));
                        list.add(cases);
                    }
                    return list;
                } catch (SQLException ex) {
                    Logger.getLogger(Lawyer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return list;
    }

}
