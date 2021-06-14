package com.awt_group1.ticketreservationsystem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Person {
    private String personId;
    private String firstName;
    private String secondName;
    private Date birthDate;
    private String nationality;
    private String gender;
    private Byte isCustomer;
    private Collection<Customer> customersByPersonId;
    private Collection<SalesOrder> salesOrdersByPersonId;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "Person_Id", nullable = false, length = 36)
    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "First_Name", nullable = true, length = 255)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "Second_Name", nullable = true, length = 255)
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Basic
    @Column(name = "Birth_Date", nullable = true)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "Nationality", nullable = true, length = 2)
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Basic
    @Column(name = "Gender", nullable = true, length = 1)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "Is_Customer", nullable = true)
    public Byte getIsCustomer() {
        return isCustomer;
    }

    public void setIsCustomer(Byte isCustomer) {
        this.isCustomer = isCustomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(personId, person.personId) && Objects.equals(firstName, person.firstName) && Objects.equals(secondName, person.secondName) && Objects.equals(birthDate, person.birthDate) && Objects.equals(nationality, person.nationality) && Objects.equals(gender, person.gender) && Objects.equals(isCustomer, person.isCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, firstName, secondName, birthDate, nationality, gender, isCustomer);
    }

    @OneToMany(mappedBy = "personByPersonId")
    public Collection<Customer> getCustomersByPersonId() {
        return customersByPersonId;
    }

    public void setCustomersByPersonId(Collection<Customer> customersByPersonId) {
        this.customersByPersonId = customersByPersonId;
    }

    @OneToMany(mappedBy = "personByPersonId")
    public Collection<SalesOrder> getSalesOrdersByPersonId() {
        return salesOrdersByPersonId;
    }

    public void setSalesOrdersByPersonId(Collection<SalesOrder> salesOrdersByPersonId) {
        this.salesOrdersByPersonId = salesOrdersByPersonId;
    }
}
