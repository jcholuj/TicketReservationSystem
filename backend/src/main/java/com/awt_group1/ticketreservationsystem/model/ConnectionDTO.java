package com.awt_group1.ticketreservationsystem.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Optional;

public class ConnectionDTO {
    private String connectionId;
    private String typeId;
    private BigDecimal duration;
    private Timestamp departureTime;
    private Timestamp arrivalTime;
    private String originId;
    private String destinationId;
    private String trainModel;

    public ConnectionDTO(Connection connection) {
        this.connectionId = connection.getConnectionId();
        this.typeId = connection.getTypeId();
        this.duration = connection.getDuration();
        this.departureTime = connection.getDepartureTime();
        this.arrivalTime = connection.getArrivalTime();
        this.originId = connection.getStationByOriginId().getStationId();
        this.destinationId = connection.getStationByDestinationId().getStationId();
        this.trainModel = connection.getTrainByTrainId().getModel();
    }

    public ConnectionDTO(Optional<Connection> connection) {
        if (connection.isPresent()) {
            this.connectionId = connection.get().getConnectionId();
            this.typeId = connection.get().getTypeId();
            this.duration = connection.get().getDuration();
            this.departureTime = connection.get().getDepartureTime();
            this.arrivalTime = connection.get().getArrivalTime();
            this.originId = connection.get().getStationByOriginId().getStationId();
            this.destinationId = connection.get().getStationByDestinationId().getStationId();
            this.trainModel = connection.get().getTrainByTrainId().getModel();
        }
    }

    public String getConnectionId() {
        return connectionId;
    }

    public void setConnectionId(String connectionId) {
        this.connectionId = connectionId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public Timestamp getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Timestamp arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getTrainModel() {
        return trainModel;
    }

    public void setTrainModel(String trainModel) {
        this.trainModel = trainModel;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }
}
