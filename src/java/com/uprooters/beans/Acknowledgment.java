/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uprooters.beans;

/**
 *
 * @author rguktrkvalley
 */
public class Acknowledgment {
        private int caseId;
        private int stationId;
        private String akcDesc;
        public Acknowledgment(){}
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
     * @return the akcDesc
     */
    public String getAkcDesc() {
        return akcDesc;
    }

    /**
     * @param akcDesc the akcDesc to set
     */
    public void setAkcDesc(String akcDesc) {
        this.akcDesc = akcDesc;
    }
}
