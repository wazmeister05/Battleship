import javax.swing.*;
import java.awt.*;

public class Player {

    private static int hitPoints;

    public Player(){

        this.hitPoints = 10;

        EventQueue.invokeLater(() -> {
            // board type 1 == opponents board
            Board board = new Board(1);
            board.print();
            board.setLocation(500, 100);
            board.setUndecorated(true);
        });
    }


    public static void hit(){
        hitPoints--;
    }

    public void go(){

    }
}
