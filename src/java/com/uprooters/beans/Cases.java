/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uprooters.beans;

import java.util.Date;

/**
 *
 * @author rguktrkvalley
 */

public class Cases {
    private int caseId;
    private String defendantName;
    private String defendantAddress;
    private String crimeType;
    private String crimeLoc;
    private Date crimeDate;
    private Date arrestDate;
    private String lawyerName;
    private String officerName;
    private Date startDate;
    private String caseStatus;
    private String judgeName;
    private String  ppName;
    private Date endDate;
    private Date hearingDate;
    private String caseSummary;
    private boolean isJudgementPassed;
    private int stationId;
    
    public Cases(){}
    public Cases(int id, String name, Date date, String status){
        this.caseId=id;
        this.defendantName=name;
        this.caseStatus=status;
        this.crimeDate=date;
    }
    
    public Cases(int caseId, String defendantName, String defendantAddress, String crimeType, String crimeLoc, 
                     Date crimeDate, Date arrestDate, String lawyerName, String officerName, Date startDate, 
                     String caseStatus, String judgeName, String ppName, Date endDate, Date hearingDate) {
    this.caseId = caseId;
    this.defendantName = defendantName;
    this.defendantAddress = defendantAddress;
    this.crimeType = crimeType;
    this.crimeLoc = crimeLoc;
    this.crimeDate = crimeDate;
    this.arrestDate = arrestDate;
    this.lawyerName = lawyerName;
    this.officerName = officerName;
    this.startDate = startDate;
    this.caseStatus= caseStatus;
    this.judgeName = judgeName;
    this.ppName = ppName;
    this.endDate = endDate;
    this.hearingDate = hearingDate;
}

    
    /**
     * @return the defendantName
     */
    public String getDefendantName() {
        return defendantName;
    }

    /**
     * @param defendantName the defendantName to set
     */
    public void setDefendantName(String defendantName) {
        this.defendantName = defendantName;
    }

    /**
     * @return the defendantAddress
     */
    public String getDefendantAddress() {
        return defendantAddress;
    }

    /**
     * @param defendantAddress the defendantAddress to set
     */
    public void setDefendantAddress(String defendantAddress) {
        this.defendantAddress = defendantAddress;
    }

    /**
     * @return the crimeType
     */
    public String getCrimeType() {
        return crimeType;
    }

    /**
     * @param crimeType the crimeType to set
     */
    public void setCrimeType(String crimeType) {
        this.crimeType = crimeType;
    }

    /**
     * @return the crimeLoc
     */
    public String getCrimeLoc() {
        return crimeLoc;
    }

    /**
     * @param crimeLoc the crimeLoc to set
     */
    public void setCrimeLoc(String crimeLoc) {
        this.crimeLoc = crimeLoc;
    }

    /**
     * @return the crimeDate
     */
    public Date getCrimeDate() {
        return crimeDate;
    }

    /**
     * @param crimeDate the crimeDate to set
     */
    public void setCrimeDate(Date crimeDate) {
        this.crimeDate = crimeDate;
    }

    /**
     * @return the arrestDate
     */
    public Date getArrestDate() {
        return arrestDate;
    }

    /**
     * @param arrestDate the arrestDate to set
     */
    public void setArrestDate(Date arrestDate) {
        this.arrestDate = arrestDate;
    }

    /**
     * @return the lawyerName
     */
    public String getLawyerName() {
        return lawyerName;
    }

    /**
     * @param lawyerName the lawyerName to set
     */
    public void setLawyerName(String lawyerName) {
        this.lawyerName = lawyerName;
    }

    /**
     * @return the officerName
     */
    public String getOfficerName() {
        return officerName;
    }

    /**
     * @param officerName the officerName to set
     */
    public void setOfficerName(String officerName) {
        this.officerName = officerName;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the caseStatus
     */
    public String getCaseStatus() {
        return caseStatus;
    }

    /**
     * @param caseStatus the caseStatus to set
     */
    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    /**
     * @return the judgeName
     */
    public String getJudgeName() {
        return judgeName;
    }

    /**
     * @param judgeName the judgeName to set
     */
    public void setJudgeName(String judgeName) {
        this.judgeName = judgeName;
    }

    /**
     * @return the ppName
     */
    public String getPpName() {
        return ppName;
    }

    /**
     * @param ppName the ppName to set
     */
    public void setPpName(String ppName) {
        this.ppName = ppName;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the hearingDate
     */
    public Date getHearingDate() {
        return hearingDate;
    }

    /**
     * @param hearingDate the hearingDate to set
     */
    public void setHearingDate(Date hearingDate) {
        this.hearingDate = hearingDate;
    }

    /**
     * @return the caseId
     */
    public int getCaseId() {
        return caseId;
    }

    /**
     * @param caseId the caseId to set
     */
    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }
    @Override
public String toString() {
    return "Case {" +
           "caseId=" + caseId +
           ", defendantName='" + defendantName + '\'' +
           ", defendantAddress='" + defendantAddress + '\'' +
           ", crimeType='" + crimeType + '\'' +
           ", crimeLoc='" + crimeLoc + '\'' +
           ", crimeDate=" + crimeDate +
           ", arrestDate=" + arrestDate +
           ", lawyerName='" + lawyerName + '\'' +
           ", officerName='" + officerName + '\'' +
           ", startDate=" + startDate +
           ", caseStatus=" + caseStatus +
           ", judgeName='" + judgeName + '\'' +
           ", ppName='" + ppName + '\'' +
           ", endDate=" + endDate +
           ", hearingDate=" + hearingDate +
           '}';
}

    /**
     * @return the caseSummary
     */
    public String getCaseSummary() {
        return caseSummary;
    }

    /**
     * @param caseSummary the caseSummary to set
     */
    public void setCaseSummary(String caseSummary) {
        this.caseSummary = caseSummary;
    }

    /**
     * @return the isJudgementPassed
     */
    public boolean isIsJudgementPassed() {
        return isJudgementPassed;
    }

    /**
     * @param isJudgementPassed the isJudgementPassed to set
     */
    public void setIsJudgementPassed(boolean isJudgementPassed) {
        this.isJudgementPassed = isJudgementPassed;
    }

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

}
