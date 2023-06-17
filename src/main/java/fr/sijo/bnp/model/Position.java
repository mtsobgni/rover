package fr.sijo.bnp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Position {

    private int x;
    private int y;

    public void incrementY() {
        y++;
    }

    public void decrementY() {
        y--;
    }

    public void incrementX() {
        x++;
    }

    public void decrementX() {
        x--;
    }
}
