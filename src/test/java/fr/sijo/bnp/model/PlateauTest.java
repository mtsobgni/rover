package fr.sijo.bnp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlateauTest {

    @org.junit.jupiter.api.Test
    public void checkIfIsAvalidPosition() {
        //Given
        Position maxPosition = new Position(5, 5);
        Plateau plateau = new Plateau(maxPosition);

        Rover rover = new Rover();
        Position positionRover = new Position(1, 2);
        rover.setPosition(positionRover);

        //WHEN
        boolean result = plateau.isValidPosition(rover.getPosition());

        //THEN
        assertEquals(result, true);
    }
}
