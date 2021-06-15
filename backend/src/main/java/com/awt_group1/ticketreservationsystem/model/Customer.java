package com.awt_group1.ticketreservationsystem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Customer {
    private String customerId;
    private Integer ordersCount;
    private Timestamp registrationDate;
    private Byte isActive;
    private Byte isAdmin;
    private Person personByPersonId;
    private Collection<SalesOrder> salesOrdersByCustomerId;

    public Customer(CustomerDTO customerDTO) {
        this.customerId = customerDTO.getCustomerId();
        this.ordersCount = customerDTO.getOrdersCount();
        this.registrationDate = customerDTO.getRegistrationDate();
        this.isActive = customerDTO.getIsActive();
        this.isAdmin = customerDTO.getIsAdmin();
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "Customer_Id", nullable = false, length = 36)
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "Orders_Count", nullable = true)
    public Integer getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(Integer ordersCount) {
        this.ordersCount = ordersCount;
    }

    @Basic
    @Column(name = "Registration_Date", nullable = true)
    public Timestamp getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Timestamp registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Basic
    @Column(name = "Is_Active", nullable = true)
    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "Is_Admin", nullable = true)
    public Byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) && Objects.equals(ordersCount, customer.ordersCount) && Objects.equals(registrationDate, customer.registrationDate) && Objects.equals(isActive, customer.isActive) && Objects.equals(isAdmin, customer.isAdmin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, ordersCount, registrationDate, isActive, isAdmin);
    }

    @ManyToOne
    @JoinColumn(name = "Person_Id", referencedColumnName = "Person_Id", nullable = false)
    public Person getPersonByPersonId() {
        return personByPersonId;
    }

    public void setPersonByPersonId(Person personByPersonId) {
        this.personByPersonId = personByPersonId;
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<SalesOrder> getSalesOrdersByCustomerId() {
        return salesOrdersByCustomerId;
    }

    public void setSalesOrdersByCustomerId(Collection<SalesOrder> salesOrdersByCustomerId) {
        this.salesOrdersByCustomerId = salesOrdersByCustomerId;
    }
}
