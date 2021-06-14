package com.awt_group1.ticketreservationsystem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Ticket {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String ticketId;
    private String orderId;
    private Timestamp validFrom;
    private Timestamp validUntil;
    private String connectionId;

    @Id
    @Column(name = "Ticket_Id", nullable = false, length = 36)
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    @Basic
    @Column(name = "Order_Id", nullable = false, length = 36)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    @Basic
    @Column(name = "Connection_Id", nullable = false, length = 36)
    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(ticketId, ticket.ticketId) && Objects.equals(orderId, ticket.orderId) && Objects.equals(validFrom, ticket.validFrom) && Objects.equals(validUntil, ticket.validUntil) && Objects.equals(connectionId, ticket.connectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, orderId, validFrom, validUntil, connectionId);
    }
}
