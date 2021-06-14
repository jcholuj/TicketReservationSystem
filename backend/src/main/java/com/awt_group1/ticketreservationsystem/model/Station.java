package com.awt_group1.ticketreservationsystem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Station {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String stationId;
    private String stationName;
    private String stationCode;
    private String locationId;
    private Integer trackCount;
    private Integer boardingTime;
    private Byte isIntermediate;
    private String commuteOptions;

    @Id
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
    @Column(name = "Location_Id", nullable = true, length = 36)
    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
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
        return Objects.equals(stationId, station.stationId) && Objects.equals(stationName, station.stationName) && Objects.equals(stationCode, station.stationCode) && Objects.equals(locationId, station.locationId) && Objects.equals(trackCount, station.trackCount) && Objects.equals(boardingTime, station.boardingTime) && Objects.equals(isIntermediate, station.isIntermediate) && Objects.equals(commuteOptions, station.commuteOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationId, stationName, stationCode, locationId, trackCount, boardingTime, isIntermediate, commuteOptions);
    }
}
