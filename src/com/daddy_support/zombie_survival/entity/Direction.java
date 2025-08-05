package com.daddy_support.zombie_survival.entity;

public enum Direction {
    E(0),
    SE(1),
    S(2),
    SW(3),
    W(4),
    NW(5),
    N(6),
    NE(7);

    private int value;

    Direction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
