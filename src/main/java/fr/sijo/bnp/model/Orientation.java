package fr.sijo.bnp.model;

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

    public Orientation turnRight() {
        switch (this) {
            case N:
                return E;
            case S:
                return W;
            case E:
                return S;
            case W:
                return N;
            default:
                throw new IllegalStateException("Unknown direction");
        }
    }

    public Orientation turnLeft() {
        switch (this) {
            case N:
                return W;
            case S:
                return E;
            case E:
                return N;
            case W:
                return S;
            default:
                throw new IllegalStateException("Unknown direction");
        }
    }

}
