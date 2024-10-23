/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import java.util.Date;

/**
 *
 * @author rguktrkvalley
 */
public class PaymentDetails {
        private int lawyerId;
        private double amount;
        private String paymentStatus;
        private Date paymentDate;
       
        public PaymentDetails(){} 

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
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * @return the paymentStatus
     */
    public String getPaymentStatus() {
        return paymentStatus;
    }

    /**
     * @param paymentStatus the paymentStatus to set
     */
    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    /**
     * @return the paymentDate
     */
    public Date getPaymentDate() {
        return paymentDate;
    }

    /**
     * @param paymentDate the paymentDate to set
     */
    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
