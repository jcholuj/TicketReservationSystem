package com.awt_group1.ticketreservationsystem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Station {
    private String stationId;
    private String stationName;
    private String stationCode;
    private Integer trackCount;
    private Integer boardingTime;
    private Byte isIntermediate;
    private String commuteOptions;
    private Collection<Connection> connectionsByStationId;
    private Collection<Connection> connectionsByStationId_0;
    private Collection<CustomerData> customerDataByStationId;
    private Location locationByLocationId;
    private Collection<StationLink> stationLinksByStationId;
    private Collection<StationLink> stationLinksByStationId_0;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "Station_Id", nullable = false, length = 36)
    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    @Basic
    @Column(name = "Station_Name", nullable = true, length = 100)
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Basic
    @Column(name = "Station_Code", nullable = true, length = 5)
    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    @Basic
    @Column(name = "Track_Count", nullable = true)
    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    @Basic
    @Column(name = "Boarding_Time", nullable = true)
    public Integer getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(Integer boardingTime) {
        this.boardingTime = boardingTime;
    }

    @Basic
    @Column(name = "Is_Intermediate", nullable = true)
    public Byte getIsIntermediate() {
        return isIntermediate;
    }

    public void setIsIntermediate(Byte isIntermediate) {
        this.isIntermediate = isIntermediate;
    }

    @Basic
    @Column(name = "Commute_Options", nullable = true, length = 20)
    public String getCommuteOptions() {
        return commuteOptions;
    }

    public void setCommuteOptions(String commuteOptions) {
        this.commuteOptions = commuteOptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return Objects.equals(stationId, station.stationId) && Objects.equals(stationName, station.stationName) && Objects.equals(stationCode, station.stationCode) && Objects.equals(trackCount, station.trackCount) && Objects.equals(boardingTime, station.boardingTime) && Objects.equals(isIntermediate, station.isIntermediate) && Objects.equals(commuteOptions, station.commuteOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationId, stationName, stationCode, trackCount, boardingTime, isIntermediate, commuteOptions);
    }

    @OneToMany(mappedBy = "stationByOriginId")
    public Collection<Connection> getConnectionsByStationId() {
        return connectionsByStationId;
    }

    public void setConnectionsByStationId(Collection<Connection> connectionsByStationId) {
        this.connectionsByStationId = connectionsByStationId;
    }

    @OneToMany(mappedBy = "stationByDestinationId")
    public Collection<Connection> getConnectionsByStationId_0() {
        return connectionsByStationId_0;
    }

    public void setConnectionsByStationId_0(Collection<Connection> connectionsByStationId_0) {
        this.connectionsByStationId_0 = connectionsByStationId_0;
    }

    @OneToMany(mappedBy = "stationByPreferredStationId")
    public Collection<CustomerData> getCustomerDataByStationId() {
        return customerDataByStationId;
    }

    public void setCustomerDataByStationId(Collection<CustomerData> customerDataByStationId) {
        this.customerDataByStationId = customerDataByStationId;
    }

    @ManyToOne
    @JoinColumn(name = "Location_Id", referencedColumnName = "Location_Id")
    public Location getLocationByLocationId() {
        return locationByLocationId;
    }

    public void setLocationByLocationId(Location locationByLocationId) {
        this.locationByLocationId = locationByLocationId;
    }

    @OneToMany(mappedBy = "stationByStartNode")
    public Collection<StationLink> getStationLinksByStationId() {
        return stationLinksByStationId;
    }

    public void setStationLinksByStationId(Collection<StationLink> stationLinksByStationId) {
        this.stationLinksByStationId = stationLinksByStationId;
    }

    @OneToMany(mappedBy = "stationByEndNode")
    public Collection<StationLink> getStationLinksByStationId_0() {
        return stationLinksByStationId_0;
    }

    public void setStationLinksByStationId_0(Collection<StationLink> stationLinksByStationId_0) {
        this.stationLinksByStationId_0 = stationLinksByStationId_0;
    }
}
