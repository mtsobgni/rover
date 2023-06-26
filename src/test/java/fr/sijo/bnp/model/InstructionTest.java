package fr.sijo.bnp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionTest {

    @org.junit.jupiter.api.Test
    public void shouldCorrectlyTurnLeft() {

        //WHEN
        Instruction result = Instruction.getValueOf('L');

        //THEN
        assertEquals(result, Instruction.LEFT);
    }
}
