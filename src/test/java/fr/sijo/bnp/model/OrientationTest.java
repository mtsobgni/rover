package fr.sijo.bnp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrientationTest {

    @org.junit.jupiter.api.Test
    public void shouldCorrectlyTurnLeft() {
        //Given
        Orientation orientation = Orientation.N;

        //WHEN
        Orientation result = orientation.turnLeft();

        //THEN
        assertEquals(result, Orientation.W);
    }

    @org.junit.jupiter.api.Test
    public void shouldCorrectlyTurnRight() {
        //Given
        Orientation orientation = Orientation.E;

        //WHEN
        Orientation result = orientation.turnRight();

        //THEN
        assertEquals(result, Orientation.S);
    }
}
