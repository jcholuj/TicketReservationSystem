package com.awt_group1.ticketreservationsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private List<Role> roles;
    private String customerID;
    private String username;
    private String email;
    private String phone;
    private String password;
    private String locationID;
    private String prefferedStationID;
    private String prefferedPaymentSystem;
    private String lastUpdate;

    public Customer(String customerID,
                    String username,
                    String email,
                    String phone,
                    String password,
                    String locationID,
                    String prefferedStationID,
                    String prefferedPaymentSystem,
                    String lastUpdate) {
        this.customerID = customerID;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.locationID = locationID;
        this.prefferedStationID = prefferedStationID;
        this.prefferedPaymentSystem = prefferedPaymentSystem;
        this.lastUpdate = lastUpdate;
    }


    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getPrefferedStationID() {
        return prefferedStationID;
    }

    public void setPrefferedStationID(String prefferedStationID) {
        this.prefferedStationID = prefferedStationID;
    }

    public String getPrefferedPaymentSystem() {
        return prefferedPaymentSystem;
    }

    public void setPrefferedPaymentSystem(String prefferedPaymentSystem) {
        this.prefferedPaymentSystem = prefferedPaymentSystem;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

