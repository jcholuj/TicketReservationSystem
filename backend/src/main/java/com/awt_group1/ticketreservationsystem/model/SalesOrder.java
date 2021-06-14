package com.awt_group1.ticketreservationsystem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class SalesOrder {
    private String orderId;
    private Timestamp creationDate;
    private String paymentId;
    private Integer ticketsAmount;
    private Byte isUnregistered;
    private Byte isArchived;
    private Customer customerByCustomerId;
    private Person personByPersonId;
    private Collection<Ticket> ticketsByOrderId;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "Order_Id", nullable = false, length = 36)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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
        return Objects.equals(orderId, that.orderId) && Objects.equals(creationDate, that.creationDate) && Objects.equals(paymentId, that.paymentId) && Objects.equals(ticketsAmount, that.ticketsAmount) && Objects.equals(isUnregistered, that.isUnregistered) && Objects.equals(isArchived, that.isArchived);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, creationDate, paymentId, ticketsAmount, isUnregistered, isArchived);
    }

    @ManyToOne
    @JoinColumn(name = "Customer_Id", referencedColumnName = "Customer_Id")
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "Person_Id", referencedColumnName = "Person_Id")
    public Person getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(Person personByPersonId) {
        this.personByPersonId = personByPersonId;
    }

    @OneToMany(mappedBy = "salesOrderByOrderId")
    public Collection<Ticket> getTicketsByOrderId() {
        return ticketsByOrderId;
    }

    public void setTicketsByOrderId(Collection<Ticket> ticketsByOrderId) {
        this.ticketsByOrderId = ticketsByOrderId;
    }
}
