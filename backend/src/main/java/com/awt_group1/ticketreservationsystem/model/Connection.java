package com.awt_group1.ticketreservationsystem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Connection {
    private String connectionId;
    private String typeId;
    private BigDecimal duration;
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    private Station stationByOriginId;
    private Station stationByDestinationId;
    private Train trainByTrainId;
    private Collection<Ticket> ticketsByConnectionId;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Connection that = (Connection) o;
        return Objects.equals(connectionId, that.connectionId) && Objects.equals(typeId, that.typeId) && Objects.equals(duration, that.duration) && Objects.equals(departureTime, that.departureTime) && Objects.equals(arrivalTime, that.arrivalTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(connectionId, typeId, duration, departureTime, arrivalTime);
    }

    @ManyToOne
    @JoinColumn(name = "Origin_Id", referencedColumnName = "Station_Id")
    public Station getStationByOriginId() {
        return stationByOriginId;
    }

    public void setStationByOriginId(Station stationByOriginId) {
        this.stationByOriginId = stationByOriginId;
    }

    @ManyToOne
    @JoinColumn(name = "Destination_Id", referencedColumnName = "Station_Id")
    public Station getStationByDestinationId() {
        return stationByDestinationId;
    }

    public void setStationByDestinationId(Station stationByDestinationId) {
        this.stationByDestinationId = stationByDestinationId;
    }

    @ManyToOne
    @JoinColumn(name = "Train_Id", referencedColumnName = "Train_Id")
    public Train getTrainByTrainId() {
        return trainByTrainId;
    }

    public void setTrainByTrainId(Train trainByTrainId) {
        this.trainByTrainId = trainByTrainId;
    }

    @OneToMany(mappedBy = "connectionByConnectionId")
    public Collection<Ticket> getTicketsByConnectionId() {
        return ticketsByConnectionId;
    }

    public void setTicketsByConnectionId(Collection<Ticket> ticketsByConnectionId) {
        this.ticketsByConnectionId = ticketsByConnectionId;
    }
}
