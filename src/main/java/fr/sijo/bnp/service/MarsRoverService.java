package fr.sijo.bnp.service;

import fr.sijo.bnp.model.Instruction;
import fr.sijo.bnp.model.Rover;

public class MarsRoverService {

    public void executeCommand(Rover rover, String instruction) {

        for (char c : instruction.toCharArray()) {
            Instruction command = Instruction.getValueOf(c);
            command.getICommandService().execute(rover);
        }

    }
}
