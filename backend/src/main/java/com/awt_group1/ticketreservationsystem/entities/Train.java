package com.awt_group1.ticketreservationsystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Train {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private String trainId;
    private String model;
    private String registrationDate;
    private int seatingCapacity;
    private String seatingScheme;
    private boolean disabledAccess;
    private String extraServices;
    private int operationSpeed;
    private int operationPrice;

    public Train() { }

    public Train(
            String trainId,
            String model,
            String registrationDate,
            int seatingCapacity,
            String seatingScheme,
            boolean disabledAccess,
            String extraServices,
            int operationSpeed,
            int operationPrice) {
        this.trainId = trainId;
        this.model = model;
        this.registrationDate = registrationDate;
        this.seatingCapacity = seatingCapacity;
        this.seatingScheme = seatingScheme;
        this.disabledAccess = disabledAccess;
        this.extraServices = extraServices;
        this.operationSpeed = operationSpeed;
        this.operationPrice = operationPrice;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getSeatingScheme() {
        return seatingScheme;
    }

    public void setSeatingScheme(String seatingScheme) {
        this.seatingScheme = seatingScheme;
    }

    public boolean isDisabledAccess() {
        return disabledAccess;
    }

    public void setDisabledAccess(boolean disabledAccess) {
        this.disabledAccess = disabledAccess;
    }

    public String getExtraServices() {
        return extraServices;
    }

    public void setExtraServices(String extraServices) {
        this.extraServices = extraServices;
    }

    public int getOperationSpeed() {
        return operationSpeed;
    }

    public void setOperationSpeed(int operationSpeed) {
        this.operationSpeed = operationSpeed;
    }

    public int getOperationPrice() {
        return operationPrice;
    }

    public void setOperationPrice(int operationPrice) {
        this.operationPrice = operationPrice;
    }
}
