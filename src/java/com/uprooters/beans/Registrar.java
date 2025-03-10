/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uprooters.beans;

import com.uprooters.daoclasses.AcknowledgmentDao;
import com.uprooters.daoclasses.AddLawyerJudgeDao;
import com.uprooters.daoclasses.UnRegisterRetriveDao;
import com.uprooters.daoclasses.AddUserDao;
import com.uprooters.daoclasses.DeleteCaseDao;
import com.uprooters.daoclasses.GetAllCasesDao;
import com.uprooters.daoclasses.LawyerPaymentDao;
import com.uprooters.daoclasses.RemoveUserDao;
import com.uprooters.daoclasses.UpdateCaseDetailsDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rguktrkvalley
 */
public class Registrar {
    private int RegistrarId;
    private String Username;
    private String Password;
    private String Email;
    private String FullName;
    private String Contact;
    public Registrar(){}
    public Registrar(int RegistrarId, String Username, String Password, String Email, String FullName, String Contact) {
        this.RegistrarId = RegistrarId;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.FullName = FullName;
        this.Contact = Contact;
    }
    /**
     * @return the RegistrarId
     */
    public int getRegistrarId() {
        return RegistrarId;
    }

    /**
     * @param RegistrarId the RegistrarId to set
     */
    public void setRegistrarId(int RegistrarId) {
        this.RegistrarId = RegistrarId;
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
    // toString method
    @Override
    public String toString() {
        return "Registrar{" +
                "RegistrarId=" + RegistrarId +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", FullName='" + FullName + '\'' +
                ", Contact='" + Contact + '\'' +
                '}';
    }
   
    public boolean addUser(String type, String username, String pass, String name, String phone, String email) {
        AddUserDao aud = new AddUserDao();
        boolean status=false;
        switch(type){
            case "L" -> {
              status = aud.addLawyer(username,pass,name,phone, email);
              return status;    
            }
            case "J" -> {
               status = aud.addJudge(username,pass,name,phone, email);
               return status;
            }
            case "R" -> {
                status = aud.addRegistrar(username,pass,name,phone, email);
                return status;
            }
            case "S" -> {
                status = aud.addStation(username,pass,name,phone, email);
                return status;
            }
            default -> {
                return status;
            }
        }
          
    }

    public boolean removeUser(String type, String username) {
         RemoveUserDao rud = new RemoveUserDao();
        boolean status=false;
        switch(type){
            case "L" -> {
              status = rud.removeLawyer(username);
              return status;    
            }
            case "J" -> {
               status = rud.removeJudge(username);
               return status;
            }
            case "R" -> {
                status = rud.removeRegistrar(username);
                return status;
            }
            case "S" -> {
                status = rud.removeStation(username);
                return status;
            }
            default -> { 
                return status;
            }
        }
    }

    public List<Cases> getUnregisteredDetails() {
       UnRegisterRetriveDao urd = new UnRegisterRetriveDao();
       ResultSet rs = urd.retriveUnregisteredData();
       List<Cases> list = new ArrayList<>();
       if(rs!=null){
        try {
            while(rs.next()){
                Cases cases = new Cases();
                cases.setCaseId(rs.getInt("CaseID"));
                cases.setCrimeDate(rs.getDate("CrimeDate"));
                cases.setDefendantName(rs.getString("DefendantName"));
                cases.setCaseStatus(rs.getString("CaseStatus"));
                list.add(cases);
            }
            System.out.println(list+"from Registrar class");
            return list;   
        } catch (SQLException ex) {
            Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        return list;
    }

    public boolean assignLawyerJudge(int caseId, int defId, int ppId, int judgeId, 
            String lawyerName, String PPName, String judgeName, Date hearingdate) {
        AddLawyerJudgeDao ajd = new AddLawyerJudgeDao();
        int num = ajd.addLawyerJudgeDetails(caseId, defId, judgeId, lawyerName, PPName, judgeName, hearingdate);
        return num>0;
    }

    public List<Cases> getAllCases() {
        List<Cases> list = new ArrayList<>();
        GetAllCasesDao gsd = new GetAllCasesDao();
        ResultSet rs = gsd.getCasesSet();
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
                    list.add(cases);
                }
                return list;
            } catch (SQLException ex) {
                Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public List<Cases> closeCasesList() {
        List<Cases> list = new ArrayList<>();
        GetAllCasesDao gsd = new GetAllCasesDao();
        ResultSet rs = gsd.readyToClose();
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
                    list.add(cases);
                }
                return list;
            } catch (SQLException ex) {
                Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    public Cases getCaseById(int id) {
       GetAllCasesDao gcd = new GetAllCasesDao();
       Cases cases = new Cases();
       ResultSet rs = gcd.getCaseById(id);
       if(rs != null){
           try{
               if(rs.next()){
                    cases.setCaseId(rs.getInt("CaseID"));
                    cases.setDefendantName(rs.getString("DefendantName"));
                    cases.setDefendantAddress(rs.getString("DefendantAddress"));
                    cases.setCrimeLoc(rs.getString("CrimeLoc"));
                    cases.setCrimeDate(rs.getDate("CrimeDate"));
                    cases.setCrimeType(rs.getString("CrimeType"));
                    cases.setArrestDate(rs.getDate("ArrestDate"));
                    cases.setOfficerName(rs.getString("OfficerName"));
                    cases.setLawyerName(rs.getString("LawyerName"));
                    cases.setPpName(rs.getString("PPName"));
                    cases.setStartDate(rs.getDate("StartDate"));
                    cases.setEndDate(rs.getDate("EndDate"));
                    cases.setJudgeName(rs.getString("JudgeName"));
                    cases.setCaseStatus(rs.getString("CaseStatus"));
                    cases.setHearingDate(rs.getDate("NextHearingDate"));
                    cases.setCaseSummary(rs.getString("CaseSummary"));
                    cases.setIsJudgementPassed(rs.getBoolean("JudgementStatus"));
               }
             return cases; 
           }catch (SQLException ex) {
                Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       return cases;
    
    }
    UpdateCaseDetailsDao udd = new UpdateCaseDetailsDao();
//    public boolean updateCaseDetails(int caseid, String caseStatus, String caseSummary, Date hearingdate, Date endDate) {
//       int k = udd.updateClosingDetails(caseid, caseStatus, caseSummary, hearingdate, endDate);
//       return k>0;
//    }

    public boolean updateCaseDetails(int caseid, String caseSummary, Date hearingdate) {
        int k = udd.updateCaseDetails(caseid, caseSummary, hearingdate);
        return k>0;
    }

    public boolean isCaseDeleted(int caseid) {
       DeleteCaseDao dcd  = new DeleteCaseDao();
       int k = dcd.deleteCase(caseid);
       return k>0;
    }
    public List<Cases> getUpcomingCaseDetails(){
       AcknowledgmentDao ad = new AcknowledgmentDao();
       ResultSet rs = ad.getAckCasesList();
       List<Cases> list = new ArrayList<>();
        if(rs != null){
           try {
               while(rs.next()){
                  Cases cases = new Cases();  
                  cases.setCaseId(rs.getInt("CaseID"));
                  cases.setHearingDate(rs.getDate("NextHearingDate"));
                  cases.setStationId(rs.getInt("StationID"));
                  list.add(cases);
               }
               return list;
           } catch (SQLException ex) {
               Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        return list;
    }
    
    public List<PaymentDetails> getPaymentDataById(int id){
            LawyerPaymentDao lpd = new LawyerPaymentDao();
            ResultSet rs =lpd.getPaymentDetails(id);
            List<PaymentDetails> list = new ArrayList<>();
            if(rs != null){
                try {
                    while(rs.next()){
                        PaymentDetails pd = new PaymentDetails();
                        pd.setLawyerId(rs.getInt("PaymentID"));
                        pd.setAmount(rs.getDouble("Amount"));
                        pd.setPaymentStatus(rs.getString("PaymentStatus"));
                        pd.setPaymentDate(rs.getDate("PaymentDate"));
                        list.add(pd);
                    }
                    return list;
                } catch (SQLException ex) {
                    Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return list;
    }

}
