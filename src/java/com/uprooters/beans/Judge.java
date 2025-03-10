/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uprooters.beans;

import com.uprooters.daoclasses.AssignedCasesDao;
import com.uprooters.daoclasses.JudgementDao;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author rguktrkvalley
 */
public class Judge {
    
    private int judgeId;
    private String Username;
    private String Password;
    private String Email;
    private String FullName;
    private String Contact;
    
    public Judge(){}
    
    public Judge(int judgeId, String username, String password, String email, String fullName, String contact) {
        this.judgeId = judgeId;
        this.Username = username;
        this.Password = password;
        this.Email = email;
        this.FullName = fullName;
        this.Contact = contact;
    }
    /**
     * @return the judgeId
     */
    public int getJudgeId() {
        return judgeId;
    }

    /**
     * @param judgeId the judgeId to set
     */
    public void setJudgeId(int judgeId) {
        this.judgeId = judgeId;
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
        return "User{" +
            "judgeId=" + judgeId +
            ", username='" + Username + '\'' +
            ", email='" + Email + '\'' +
            ", fullName='" + FullName + '\'' +
            ", contact='" + Contact + '\'' +
            '}';
}

    public List<Cases> viewAssignedCases(int id) {
        AssignedCasesDao acd = new AssignedCasesDao();
        List<Cases> list = new ArrayList<>();
        ResultSet rs = acd.getAssignedCases(id);
        if(rs!=null){
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
                    System.out.println("from Judge Page"+cases);
                    list.add(cases);
                }
                return list;
            } catch (SQLException ex) {
                Logger.getLogger(Judge.class.getName()).log(Level.SEVERE, null, ex);
            }
        }          
        return null;
    }   

    public boolean makeJudgement(int caseid, String judgedesc, int id, Date judgedate) {
        JudgementDao jd = new JudgementDao();
       boolean status = jd.checkStatus(caseid, id);
        if(!status){
            int k = jd.enterJudgementDetails(caseid, judgedesc, id, judgedate);
                if(k>0){
                    boolean ch = jd.updateJudgementStatus(caseid, id);
                    return ch;
                }
                return false;
        }
        return true;
    }
}
