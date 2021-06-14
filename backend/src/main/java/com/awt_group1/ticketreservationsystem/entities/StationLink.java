package com.awt_group1.ticketreservationsystem.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StationLink {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long linkId;
    private String startNode;
    private String endNode;
    private int length;
    private double utilizationPrice;

    public StationLink() { }

    public StationLink(Long linkId, String startNode, String endNode, int length, double utilizationPrice) {
        this.linkId = linkId;
        this.startNode = startNode;
        this.endNode = endNode;
        this.length = length;
        this.utilizationPrice = utilizationPrice;
    }

    public Long getLinkId() { return this.linkId; }

    public void setLinkId(Long id) { this.linkId = id; }

    public String getStartNode() {
        return startNode;
    }

    public void setStartNode(String startNode) {
        this.startNode = startNode;
    }

    public String getEndNode() {
        return endNode;
    }

    public void setEndNode(String endNode) {
        this.endNode = endNode;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getUtilizationPrice() {
        return utilizationPrice;
    }

    public void setUtilizationPrice(double utilizationPrice) {
        this.utilizationPrice = utilizationPrice;
    }
}
