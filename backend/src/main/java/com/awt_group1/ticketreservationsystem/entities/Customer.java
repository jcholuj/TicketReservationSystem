package com.awt_group1.ticketreservationsystem.entities;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long customerId;
//    @ElementCollection
//    private List<Role> roles;
    private String username;
    private String email;
    private String phone;
    private String password;
    private String locationID;
    private String preferredStationID;
    private String preferredPaymentSystem;
    private String lastUpdate;

    public Customer(Long customerId,
                    String username,
                    String email,
                    String phone,
                    String password,
                    String locationID,
                    String preferredStationID,
                    String preferredPaymentSystem,
                    String lastUpdate) {
        this.customerId = customerId;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.locationID = locationID;
        this.preferredStationID = preferredStationID;
        this.preferredPaymentSystem = preferredPaymentSystem;
        this.lastUpdate = lastUpdate;
    }

    public Customer() {

    }


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerID) {
        this.customerId = customerID;
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

    public String getPreferredStationID() {
        return preferredStationID;
    }

    public void setPreferredStationID(String preferredStationID) {
        this.preferredStationID = preferredStationID;
    }

    public String getPreferredPaymentSystem() {
        return preferredPaymentSystem;
    }

    public void setPreferredPaymentSystem(String preferredPaymentSystem) {
        this.preferredPaymentSystem = preferredPaymentSystem;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }


//    public List<Role> getRoles() {
//        return roles;
//    }
//    public void setRoles(List<Role> roles) {
//        this.roles = roles;
//    }
}

