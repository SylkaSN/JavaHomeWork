package com.pb.ssn.hw7;

public enum Size {

    XXS(32, "Детский размер"),
    XS(34, "Взрослый размер"),
    S(36, "Взрослый размер"),
    M(38, "Взрослый размер"),
    L(40, "Взрослый размер");

    private String description;
    private int euroSize;

    Size (int euroSize, String description) {
        this.euroSize = euroSize;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getEuroSize() {
        return euroSize;
    }
}
