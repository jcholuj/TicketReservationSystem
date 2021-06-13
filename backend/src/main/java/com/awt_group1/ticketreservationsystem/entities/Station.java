package com.awt_group1.ticketreservationsystem.entities;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Station {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    private String stationId;
    private String name;
    private String code;
    private String locationId;
    private int trackCount;
    private int boardingTime;
    private boolean isIntermediate;
    private String commuteOptions;

    public Station() { }

    public Station(
            String stationId,
            String name,
            String code,
            String locationId,
            int trackCount,
            int boardingTime,
            boolean isIntermediate,
            String commuteOptions) {
        this.stationId = stationId;
        this.name = name;
        this.code = code;
        this.locationId = locationId;
        this.trackCount = trackCount;
        this.boardingTime = boardingTime;
        this.isIntermediate = isIntermediate;
        this.commuteOptions = commuteOptions;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public int getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(int trackCount) {
        this.trackCount = trackCount;
    }

    public int getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(int boardingTime) {
        this.boardingTime = boardingTime;
    }

    public boolean isIntermediate() {
        return isIntermediate;
    }

    public void setIntermediate(boolean intermediate) {
        isIntermediate = intermediate;
    }

    public String getCommuteOptions() {
        return commuteOptions;
    }

    public void setCommuteOptions(String commuteOptions) {
        this.commuteOptions = commuteOptions;
    }
}
