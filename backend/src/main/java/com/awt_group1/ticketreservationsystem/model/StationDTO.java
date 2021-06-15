package com.awt_group1.ticketreservationsystem.model;

import java.util.Optional;

public class StationDTO {
    private String stationId;
    private String stationName;
    private String stationCode;
    private Integer trackCount;
    private Integer boardingTime;
    private Byte isIntermediate;
    private String commuteOptions;

    public StationDTO() { }

    public StationDTO(Station station) {
        this.stationId = station.getStationId();
        this.stationName = station.getStationName();
        this.stationCode = station.getStationCode();
        this.trackCount = station.getTrackCount();
        this.boardingTime = station.getBoardingTime();
        this.isIntermediate = station.getIsIntermediate();
        this.commuteOptions = station.getCommuteOptions();
    }

    public StationDTO(Optional<Station> station) {
        if (station.isPresent()) {
            this.stationId = station.get().getStationId();
            this.stationName = station.get().getStationName();
            this.stationCode = station.get().getStationCode();
            this.trackCount = station.get().getTrackCount();
            this.boardingTime = station.get().getBoardingTime();
            this.isIntermediate = station.get().getIsIntermediate();
            this.commuteOptions = station.get().getCommuteOptions();
        }
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public Integer getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(Integer trackCount) {
        this.trackCount = trackCount;
    }

    public Integer getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(Integer boardingTime) {
        this.boardingTime = boardingTime;
    }

    public Byte getIsIntermediate() {
        return isIntermediate;
    }

    public void setIsIntermediate(Byte isIntermediate) {
        this.isIntermediate = isIntermediate;
    }

    public String getCommuteOptions() {
        return commuteOptions;
    }

    public void setCommuteOptions(String commuteOptions) {
        this.commuteOptions = commuteOptions;
    }
}
