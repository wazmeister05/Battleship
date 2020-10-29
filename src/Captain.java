import javax.swing.*;
import java.awt.*;

public class Captain {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            // board type 1 == board you shoot
            Board opponent = new Board(1);
            //opponent.print();
            opponent.setLocation(500,100);
            opponent.setVisible(true);

            // board type 0 == your board
            Board yourBoard = new Board(0);
            //yourBoard.print();
            yourBoard.setLocation(100,100);
            yourBoard.setVisible(true);


        });
    }

}
