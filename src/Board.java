import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame{

    public String[][] board;               // int array for the board
    private int ships = 10;                   // number of ships the user wants to play with. Capped at 5.
    public final int bgLength = 7;    // 7x7 board is big enough. Useful to have this parameter.


    // Board constructor
    public Board(int boardType){
        board = new String[bgLength][bgLength];
        for (String[] strings : board) {
            //Whatever value you want to set them to
            Arrays.fill(strings, "-");
        }

        if(boardType == 0){
            for(int i = 0; i < ships; i++){
                addShip();
                initBoard("Your ships");
            }
        }
        else{
            initBoard("Enemy map");
        }

    }


    private void initBoard(String boardType) {
        JPanel jpanel = new JPanel();

        jpanel.setLayout(new GridLayout(bgLength,bgLength,5,5));

        if(boardType.equals("Your ships")) {
            for (String[] strings : board) {
                for (String string : strings) {
                    JButton button;
                    button = new JButton(string);
                    button.setBorder(BorderFactory.createLineBorder(Color.black));
                    button.setBackground(Color.WHITE);
                    button.setFont(new Font("Verdana", Font.PLAIN, 20));
                    button.setEnabled(false);
                    button.addActionListener(actionEvent -> {
                        if(button.getText().equals("*")) {
                            button.setBackground(Color.RED);
                            shipSunk();
                        }
                    });
                    jpanel.add(button);
                }
            }
        }
        else{
            for (String[] strings : board) {
                for (String string : strings) {
                    JButton button = new JButton(string);
                    button.setFont(new Font("Verdana", Font.PLAIN, 20));
                    button.setBackground(Color.WHITE);
                    button.setForeground(Color.WHITE);
                    button.addActionListener(actionEvent -> {
                        if(button.getText().equals("*")) {
                            button.setBackground(Color.RED);
                        }
                    });

                    jpanel.add(button);
                }
            }
        }

        add(jpanel);
        setTitle(boardType);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void shipSunk() {
        if(ships > 1){
            ships--;
        }
        else{
            ships--;
            System.out.println("Game over");
        }
    }


    // add a ship
    public void addShip(){
        Random rand = new Random();
        int xCoordinate = rand.nextInt(7);
        int yCoordinate = rand.nextInt(7);
        if(shipAllowed(xCoordinate, yCoordinate)){
            board[xCoordinate][yCoordinate] = "*";
        }
    }

    // checks if a position is free.    - is free, * is occupied
    public boolean shipAllowed(int x, int y){
        return board[x][y].equals("-");
    }


    // this is just to print the game board so I can see it works.
//    public void print() {
//        System.out.println();
//        System.out.println("   |0|1|2|3|4|5|6|");
//        System.out.println("   ---------------");
//        for(int i = 0; i < bgLength; i++){
//            System.out.print(i + ": |");
//            for(int j = 0; j < bgLength; j++){
//                System.out.print(board[i][j] + "|");
//            }
//            System.out.println();
//        }
//    }

}
