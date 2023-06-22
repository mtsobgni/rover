package fr.sijo.bnp.model;

public enum Instruction {
    LEFT('L'),
    RIGHT('R'),
    MOVE('M');

    private char value;

    Instruction(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
