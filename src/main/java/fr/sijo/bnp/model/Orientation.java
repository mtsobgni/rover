package fr.sijo.bnp.model;

import java.util.Arrays;

public enum Orientation {
    N("NORTH"),
    E("EAST"),
    S("SOUTH"),
    W("WEST");

    private String label;

    Orientation(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public Orientation getOrientationValue(String label) {
        return Arrays.stream(values())
                .filter(orientation -> orientation.getLabel().equals(label))
                .findFirst()
                .orElse(null);
    }

}
