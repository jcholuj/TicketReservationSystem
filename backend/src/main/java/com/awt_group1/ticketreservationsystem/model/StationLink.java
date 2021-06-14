package com.awt_group1.ticketreservationsystem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class StationLink {
    private String linkId;
    private BigDecimal length;
    private BigDecimal utilizationPrice;
    private Station stationByStartNode;
    private Station stationByEndNode;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "Link_Id", nullable = false, length = 36)
    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    @Basic
    @Column(name = "Length", nullable = true, precision = 6, scale = 2)
    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    @Basic
    @Column(name = "Utilization_Price", nullable = true, precision = 19, scale = 4)
    public BigDecimal getUtilizationPrice() {
        return utilizationPrice;
    }

    public void setUtilizationPrice(BigDecimal utilizationPrice) {
        this.utilizationPrice = utilizationPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationLink that = (StationLink) o;
        return Objects.equals(linkId, that.linkId) && Objects.equals(length, that.length) && Objects.equals(utilizationPrice, that.utilizationPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkId, length, utilizationPrice);
    }

    @ManyToOne
    @JoinColumn(name = "Start_Node", referencedColumnName = "Station_Id")
    public Station getStationByStartNode() {
        return stationByStartNode;
    }

    public void setStationByStartNode(Station stationByStartNode) {
        this.stationByStartNode = stationByStartNode;
    }

    @ManyToOne
    @JoinColumn(name = "End_Node", referencedColumnName = "Station_Id")
    public Station getStationByEndNode() {
        return stationByEndNode;
    }

    public void setStationByEndNode(Station stationByEndNode) {
        this.stationByEndNode = stationByEndNode;
    }
}
