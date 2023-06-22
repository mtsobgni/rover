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
        orientation = orientation.turnLeft();
    }

    public void rotateRight() {
        orientation = orientation.turnRight();
    }

    public void moveForward() {
        switch (this.orientation) {
            case N:
                position.incrementY();
                break;
            case S:
                position.decrementY();
                break;
            case E:
                position.incrementX();
                break;
            case W:
                position.decrementX();
                break;
        }
    }

    @Override
    public String toString() {
        return position.getX() +" "+ position.getY() + " "+ orientation;
    }
}
