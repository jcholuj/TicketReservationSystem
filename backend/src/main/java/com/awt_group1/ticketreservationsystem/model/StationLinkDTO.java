package com.awt_group1.ticketreservationsystem.model;

import java.math.BigDecimal;
import java.util.Optional;

public class StationLinkDTO {
    private String linkId;
    private BigDecimal length;
    private BigDecimal utilizationPrice;
    private String startNodeId;
    private String endNodeId;

    public StationLinkDTO(StationLink stationLink) {
        this.linkId = stationLink.getLinkId();
        this.length = stationLink.getLength();
        this.utilizationPrice = stationLink.getUtilizationPrice();
        this.startNodeId = stationLink.getStationByStartNode().getStationId();
        this.endNodeId = stationLink.getStationByEndNode().getStationId();
    }

    public StationLinkDTO(Optional<StationLink> stationLink) {
        if (stationLink.isPresent()) {
            this.linkId = stationLink.get().getLinkId();
            this.length = stationLink.get().getLength();
            this.utilizationPrice = stationLink.get().getUtilizationPrice();
            this.startNodeId = stationLink.get().getStationByStartNode().getStationId();
            this.endNodeId = stationLink.get().getStationByEndNode().getStationId();
        }
    }

    public String getEndNodeId() {
        return endNodeId;
    }

    public void setEndNodeId(String endNodeId) {
        this.endNodeId = endNodeId;
    }

    public String getStartNodeId() {
        return startNodeId;
    }

    public void setStartNodeId(String startNodeId) {
        this.startNodeId = startNodeId;
    }

    public BigDecimal getUtilizationPrice() {
        return utilizationPrice;
    }

    public void setUtilizationPrice(BigDecimal utilizationPrice) {
        this.utilizationPrice = utilizationPrice;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }
}
