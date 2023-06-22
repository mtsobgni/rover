package fr.sijo.bnp.service;

import fr.sijo.bnp.model.Instruction;
import fr.sijo.bnp.model.Plateau;
import fr.sijo.bnp.model.Rover;

public class MarsRoverService {

    public void executeCommand(Plateau plateau, Rover rover, String instruction) {

        for (char c : instruction.toCharArray()) {
            if (Instruction.LEFT.getValue() == c) {
                rover.rotateLeft();
            } else if (Instruction.RIGHT.getValue() == c) {
                rover.rotateRight();
            } else if (Instruction.MOVE.getValue() == c) {
                rover.moveForward();
                if (!plateau.isValidPosition(rover.getPosition())) {
                    throw new RuntimeException("Invalid position,the new position of rover is outside the plateau");
                }
            } else {
                throw new RuntimeException("Invalid instruction, the instruction will be a part of this list(L, R, M)");
            }
        }

    }
}
