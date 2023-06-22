package fr.sijo.bnp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoverWithInstructions {

    private Rover rover;
    private String instruction;

    private Plateau plateau;
}
