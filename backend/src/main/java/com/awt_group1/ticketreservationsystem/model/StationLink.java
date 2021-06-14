package com.awt_group1.ticketreservationsystem.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class StationLink {
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String linkId;
    private String startNode;
    private String endNode;
    private BigDecimal length;
    private BigDecimal utilizationPrice;

    @Id
    @Column(name = "Link_Id", nullable = false, length = 36)
    public String getLinkId() {
        return linkId;
    }

    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    @Basic
    @Column(name = "Start_Node", nullable = true, length = 36)
    public String getStartNode() {
        return startNode;
    }

    public void setStartNode(String startNode) {
        this.startNode = startNode;
    }

    @Basic
    @Column(name = "End_Node", nullable = true, length = 36)
    public String getEndNode() {
        return endNode;
    }

    public void setEndNode(String endNode) {
        this.endNode = endNode;
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
        return Objects.equals(linkId, that.linkId) && Objects.equals(startNode, that.startNode) && Objects.equals(endNode, that.endNode) && Objects.equals(length, that.length) && Objects.equals(utilizationPrice, that.utilizationPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkId, startNode, endNode, length, utilizationPrice);
    }
}
