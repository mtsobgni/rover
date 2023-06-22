package fr.sijo.bnp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plateau {

    private Position maxPosition;

    public boolean isValidPosition(Position roverPosition) {
        return roverPosition.getX() >= 0 && roverPosition.getX() <= maxPosition.getX() && roverPosition.getY() >= 0 && roverPosition.getY() <= maxPosition.getY();
    }
}
