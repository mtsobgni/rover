package fr.sijo.bnp.model;

public enum RotateAndMove {
    CHAR_L('L'),
    CHAR_R('R'),
    CHAR_M('M');

    private char value;

    RotateAndMove(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
