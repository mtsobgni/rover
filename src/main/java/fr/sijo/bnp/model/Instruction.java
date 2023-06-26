package fr.sijo.bnp.model;

import fr.sijo.bnp.service.ICommandService;
import fr.sijo.bnp.service.MoveCommandService;
import fr.sijo.bnp.service.RotateLeftCommandService;
import fr.sijo.bnp.service.RotateRightCommandService;

import java.util.Arrays;

public enum Instruction {
    LEFT('L', new RotateLeftCommandService()),
    RIGHT('R', new RotateRightCommandService()),
    MOVE('M', new MoveCommandService());

    private char value;
    private ICommandService iCommandService;

    public void setValue(char value) {
        this.value = value;
    }

    public ICommandService getICommandService() {
        return iCommandService;
    }

    public void setICommandService(ICommandService iCommandService) {
        this.iCommandService = iCommandService;
    }

    Instruction(char value, ICommandService iCommandService) {
        this.value = value;
        this.iCommandService = iCommandService;
    }

    public char getValue() {
        return value;
    }

    public static Instruction getValueOf(char value) {
        return Arrays.stream(values()).filter(d -> d.value == value)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Instruction " + value + " is unknown."));
    }
}
