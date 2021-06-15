package com.awt_group1.ticketreservationsystem.model;

import java.sql.Timestamp;
import java.util.Optional;

public class CustomerDTO {
    private String customerId;
    private Integer ordersCount;
    private Timestamp registrationDate;
    private Byte isActive;
    private Byte isAdmin;

    public CustomerDTO(Customer customer) {
        this.customerId = customer.getCustomerId();
        this.ordersCount = customer.getOrdersCount();
        this.registrationDate = customer.getRegistrationDate();
        this.isActive = customer.getIsActive();
        this.isAdmin = customer.getIsAdmin();
    }

    public CustomerDTO(Optional<Customer> customer) {
        if (customer.isPresent()) {
            this.customerId = customer.get().getCustomerId();
            this.ordersCount = customer.get().getOrdersCount();
            this.registrationDate = customer.get().getRegistrationDate();
            this.isActive = customer.get().getIsActive();
            this.isAdmin = customer.get().getIsAdmin();
        }
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(Integer ordersCount) {
        this.ordersCount = ordersCount;
    }

    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public Byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }
}
