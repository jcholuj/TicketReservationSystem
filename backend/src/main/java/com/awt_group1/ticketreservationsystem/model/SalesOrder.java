package com.awt_group1.ticketreservationsystem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class SalesOrder {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String orderId;
    private String customerId;
    private String personId;
    private Timestamp creationDate;
    private String paymentId;
    private Integer ticketsAmount;
    private Byte isUnregistered;
    private Byte isArchived;

    @Id
    @Column(name = "Order_Id", nullable = false, length = 36)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "Customer_Id", nullable = true, length = 36)
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "Person_Id", nullable = true, length = 36)
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "Creation_Date", nullable = true)
    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Basic
    @Column(name = "Payment_Id", nullable = true, length = 36)
    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    @Basic
    @Column(name = "Tickets_Amount", nullable = true)
    public Integer getTicketsAmount() {
        return ticketsAmount;
    }

    public void setTicketsAmount(Integer ticketsAmount) {
        this.ticketsAmount = ticketsAmount;
    }

    @Basic
    @Column(name = "Is_Unregistered", nullable = true)
    public Byte getIsUnregistered() {
        return isUnregistered;
    }

    public void setIsUnregistered(Byte isUnregistered) {
        this.isUnregistered = isUnregistered;
    }

    @Basic
    @Column(name = "Is_Archived", nullable = true)
    public Byte getIsArchived() {
        return isArchived;
    }

    public void setIsArchived(Byte isArchived) {
        this.isArchived = isArchived;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesOrder that = (SalesOrder) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(customerId, that.customerId) && Objects.equals(personId, that.personId) && Objects.equals(creationDate, that.creationDate) && Objects.equals(paymentId, that.paymentId) && Objects.equals(ticketsAmount, that.ticketsAmount) && Objects.equals(isUnregistered, that.isUnregistered) && Objects.equals(isArchived, that.isArchived);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, personId, creationDate, paymentId, ticketsAmount, isUnregistered, isArchived);
    }
}
