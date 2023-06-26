package fr.sijo.bnp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverTest {

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
