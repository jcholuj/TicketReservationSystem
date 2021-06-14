package com.awt_group1.ticketreservationsystem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Ticket {
    private String ticketId;
    private Timestamp validFrom;
    private Timestamp validUntil;
    private SalesOrder salesOrderByOrderId;
    private Connection connectionByConnectionId;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "Ticket_Id", nullable = false, length = 36)
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    @Basic
    @Column(name = "Valid_From", nullable = true)
    public Timestamp getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Timestamp validFrom) {
        this.validFrom = validFrom;
    }

    @Basic
    @Column(name = "Valid_Until", nullable = true)
    public Timestamp getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Timestamp validUntil) {
        this.validUntil = validUntil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(ticketId, ticket.ticketId) && Objects.equals(validFrom, ticket.validFrom) && Objects.equals(validUntil, ticket.validUntil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, validFrom, validUntil);
    }

    @ManyToOne
    @JoinColumn(name = "Order_Id", referencedColumnName = "Order_Id", nullable = false)
    public SalesOrder getSalesOrderByOrderId() {
        return salesOrderByOrderId;
    }

    public void setSalesOrderByOrderId(SalesOrder salesOrderByOrderId) {
        this.salesOrderByOrderId = salesOrderByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "Connection_Id", referencedColumnName = "Connection_Id", nullable = false)
    public Connection getConnectionByConnectionId() {
        return connectionByConnectionId;
    }

    public void setConnectionByConnectionId(Connection connectionByConnectionId) {
        this.connectionByConnectionId = connectionByConnectionId;
    }
}
