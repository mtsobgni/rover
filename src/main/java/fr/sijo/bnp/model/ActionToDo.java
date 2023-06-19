package fr.sijo.bnp.model;

public enum ActionToDo {
    LEFT('L'),
    RIGHT('R'),
    MOVE('M');

    private char value;

    ActionToDo(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
