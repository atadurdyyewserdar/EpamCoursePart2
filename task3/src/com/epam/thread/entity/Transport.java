package com.epam.thread.entity;

import java.util.Objects;

public class Transport implements Runnable {
    private TransportType transportType;
    private int weight;
    private int size;

    public Transport(TransportType transportType, int weight, int size) {
        this.transportType = transportType;
        this.weight = weight;
        this.size = size;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return new StringBuilder("Transport{transportType=")
                .append(transportType)
                .append(", weight=")
                .append(weight)
                .append(", size=")
                .append(size)
                .append("}")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return weight == transport.weight &&
                size == transport.size &&
                transportType == transport.transportType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transportType, weight, size);
    }

    @Override
    public void run() {
        Ferry.put(this);
    }
}
