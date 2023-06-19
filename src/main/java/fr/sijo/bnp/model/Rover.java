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

    public void executeCommand(String instructions, Position maxPosition) {
        for (char c : instructions.toCharArray()) {
            if (RotateAndMove.CHAR_L.getValue() == c) {
                rotateLeft();
            } else if (RotateAndMove.CHAR_R.getValue() == c) {
                rotateRight();
            } else if (RotateAndMove.CHAR_M.getValue() == c) {
                moveForward();
                if (!isValidPosition(maxPosition, getPosition())) {
                    throw new RuntimeException("Invalid position,the new position of rover is outside the plateau");
                }
            } else {
                throw new RuntimeException("Invalid instruction, the instruction will be a part of this list(L, R, M)");
            }
        }
    }

    private boolean isValidPosition(Position posoMax, Position poso) {
        return poso.getX() >= 0 && poso.getX() <= posoMax.getX() && poso.getY() >= 0 && poso.getY() <= posoMax.getY();
    }

    @Override
    public String toString() {
        return position.getX() +" "+ position.getY() + " "+ orientation;
    }
}
