package fr.sijo.bnp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rover {

    private Position position;
    private Orientation orientation;

    public void rotateLeft() {
        // Rotate the rover 90 degrees to the left
        // Update the heading accordingly
        if (orientation == Orientation.N) {
            orientation = Orientation.W;
        } else if (orientation == Orientation.W) {
            orientation = Orientation.S;
        } else if (orientation == Orientation.S) {
            orientation = Orientation.E;
        } else if (orientation == Orientation.E) {
            orientation = Orientation.N;
        }
    }

    public void rotateRight() {
        // Rotate the rover 90 degrees to the right
        // Update the heading accordingly
        if (orientation == Orientation.N) {
            orientation = Orientation.E;
        } else if (orientation == Orientation.W) {
            orientation = Orientation.N;
        } else if (orientation == Orientation.S) {
            orientation = Orientation.W;
        } else if (orientation == Orientation.E) {
            orientation = Orientation.S;
        }
    }

    public void moveForward() {
        // Move the rover forward one grid point based on its current heading
        // Update the position (x, y) accordingly
        if (orientation == Orientation.N) {
            position.incrementY();
        } else if (orientation == Orientation.E) {
            position.incrementX();
        } else if (orientation == Orientation.S) {
            position.decrementY();
        } else if (orientation == Orientation.W) {
            position.decrementX();
        }
    }

    @Override
    public String toString() {
        return position.getX() +" "+ position.getY() + " "+ orientation;
    }
}
