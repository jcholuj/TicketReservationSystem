package com.awt_group1.ticketreservationsystem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Connection {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String connectionId;
    private String typeId;
    private String originId;
    private String destinationId;
    private BigDecimal duration;
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    private String trainId;

    @Id
    @Column(name = "Connection_Id", nullable = false, length = 36)
    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    @Basic
    @Column(name = "Type_Id", nullable = true, length = 36)
    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "Origin_Id", nullable = true, length = 36)
    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    @Basic
    @Column(name = "Destination_Id", nullable = true, length = 36)
    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    @Basic
    @Column(name = "Duration", nullable = true, precision = 4, scale = 2)
    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "Departure_Time", nullable = true)
    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    @Basic
    @Column(name = "Arrival_Time", nullable = true)
    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Basic
    @Column(name = "Train_Id", nullable = true, length = 36)
    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return Objects.equals(connectionId, that.connectionId) && Objects.equals(typeId, that.typeId) && Objects.equals(originId, that.originId) && Objects.equals(destinationId, that.destinationId) && Objects.equals(duration, that.duration) && Objects.equals(departureTime, that.departureTime) && Objects.equals(arrivalTime, that.arrivalTime) && Objects.equals(trainId, that.trainId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectionId, typeId, originId, destinationId, duration, departureTime, arrivalTime, trainId);
    }
}
