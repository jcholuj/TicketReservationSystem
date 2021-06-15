package com.awt_group1.ticketreservationsystem.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Optional;

public class TrainDTO {
    private String trainId;
    private String model;
    private Date registerDate;
    private Integer seatingCapacity;
    private BigDecimal operationSpeed;
    private BigDecimal operationPrice;

    public TrainDTO(Train train) {
        this.trainId = train.getTrainId();
        this.model = train.getModel();
        this.registerDate = train.getRegisterDate();
        this.seatingCapacity = train.getSeatingCapacity();
        this.operationSpeed = train.getOperationSpeed();
        this.operationPrice = train.getOperationPrice();
    }

    public TrainDTO(Optional<Train> train) {
        if (train.isPresent()) {
            this.trainId = train.get().getTrainId();
            this.model = train.get().getModel();
            this.registerDate = train.get().getRegisterDate();
            this.seatingCapacity = train.get().getSeatingCapacity();
            this.operationSpeed = train.get().getOperationSpeed();
            this.operationPrice = train.get().getOperationPrice();
        }
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

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public BigDecimal getOperationSpeed() {
        return operationSpeed;
    }

    public void setOperationSpeed(BigDecimal operationSpeed) {
        this.operationSpeed = operationSpeed;
    }

    public BigDecimal getOperationPrice() {
        return operationPrice;
    }

    public void setOperationPrice(BigDecimal operationPrice) {
        this.operationPrice = operationPrice;
    }
}
