package com.awt_group1.ticketreservationsystem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Train {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String trainId;
    private String model;
    private Date registerDate;
    private Integer seatingCapacity;
    private BigDecimal operationSpeed;
    private BigDecimal operationPrice;

    @Id
    @Column(name = "Train_Id", nullable = false, length = 36)
    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    @Basic
    @Column(name = "Model", nullable = true, length = 100)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "Register_Date", nullable = true)
    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    @Basic
    @Column(name = "Seating_Capacity", nullable = true)
    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @Basic
    @Column(name = "Operation_Speed", nullable = true, precision = 2)
    public BigDecimal getOperationSpeed() {
        return operationSpeed;
    }

    public void setOperationSpeed(BigDecimal operationSpeed) {
        this.operationSpeed = operationSpeed;
    }

    @Basic
    @Column(name = "Operation_Price", nullable = true, precision = 4)
    public BigDecimal getOperationPrice() {
        return operationPrice;
    }

    public void setOperationPrice(BigDecimal operationPrice) {
        this.operationPrice = operationPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(trainId, train.trainId) && Objects.equals(model, train.model) && Objects.equals(registerDate, train.registerDate) && Objects.equals(seatingCapacity, train.seatingCapacity) && Objects.equals(operationSpeed, train.operationSpeed) && Objects.equals(operationPrice, train.operationPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainId, model, registerDate, seatingCapacity, operationSpeed, operationPrice);
    }
}
