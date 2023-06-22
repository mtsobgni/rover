package fr.sijo.bnp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @org.junit.jupiter.api.Test
    public void shouldCorrectlyIncrementX() {
        //Given
        Position position = new Position(4, 5);

        //WHEN
        position.incrementX();

        //THEN
        assertEquals(position.getX(), 5);
    }

    @org.junit.jupiter.api.Test
    public void shouldCorrectlyIncrementY() {
        //Given
        Position position = new Position(4, 2);

        //WHEN
        position.incrementY();

        //THEN
        assertEquals(position.getY(), 3);
    }

    @org.junit.jupiter.api.Test
    public void shouldCorrectlyDecrementX() {
        //Given
        Position position = new Position(4, 5);

        //WHEN
        position.decrementX();

        //THEN
        assertEquals(position.getX(), 3);
    }

    @org.junit.jupiter.api.Test
    public void shouldCorrectlyDecrementY() {
        //Given
        Position position = new Position(4, 5);

        //WHEN
        position.decrementY();

        //THEN
        assertEquals(position.getY(), 4);
    }
}
