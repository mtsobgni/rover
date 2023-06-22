package fr.sijo.bnp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

    /*@org.junit.jupiter.api.Test
    public void shouldCorrectlyExecuteCommandOfRoverWithPosition_1_2() {
        //Given
        Position maxPosition = new Position(5, 5);
        Position position = new Position(1, 2);
        Rover rover = new Rover(position, Orientation.N);
        String instructions = "LMLMLMLMM";

        //WHEN
        rover.executeCommand(instructions, maxPosition);

        //THEN
        assertEquals(rover.getPosition().getX(), 1);
        assertEquals(rover.getPosition().getY(), 3);
        assertEquals(rover.getOrientation(), Orientation.N);
    }

    @org.junit.jupiter.api.Test
    public void shouldCorrectlyExecuteCommandOfRoverWithPosition_3_3_E() {
        //Given
        Position maxPosition = new Position(5, 5);
        Position position = new Position(3, 3);
        Rover rover = new Rover(position, Orientation.E);
        String instructions = "MMRMMRMRRM";

        //WHEN
        rover.executeCommand(instructions, maxPosition);

        //THEN
        assertEquals(rover.getPosition().getX(), 5);
        assertEquals(rover.getPosition().getY(), 1);
        assertEquals(rover.getOrientation(), Orientation.E);
    }*/

    @org.junit.jupiter.api.Test
    public void shouldCorrectlyRotateLeft() {
        //Given

        Position position = new Position(1, 2);
        Rover rover = new Rover(position, Orientation.N);

        //WHEN
        rover.rotateLeft();

        //THEN
        assertEquals(rover.getOrientation(), Orientation.W);
        assertEquals(rover.getPosition().getX(), 1);
        assertEquals(rover.getPosition().getY(), 2);
    }

    @org.junit.jupiter.api.Test
    public void shouldCorrectlyRotateRight() {
        //Given

        Position position = new Position(1, 2);
        Rover rover = new Rover(position, Orientation.E);

        //WHEN
        rover.rotateRight();

        //THEN
        assertEquals(rover.getOrientation(), Orientation.S);
        assertEquals(rover.getPosition().getX(), 1);
        assertEquals(rover.getPosition().getY(), 2);
    }

    @org.junit.jupiter.api.Test
    public void shouldCorrectlyMoveForward() {
        //Given

        Position position = new Position(1, 2);
        Rover rover = new Rover(position, Orientation.N);

        //WHEN
        rover.moveForward();

        //THEN
        assertEquals(rover.getOrientation(), Orientation.N);
        assertEquals(rover.getPosition().getX(), 1);
        assertEquals(rover.getPosition().getY(), 3);
    }

}
