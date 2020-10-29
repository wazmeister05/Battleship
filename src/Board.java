import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.Random;
import java.util.function.DoubleToIntFunction;

public class Board {

    public char[][] board;               // int array for the board
    public int ships;                   // number of ships the user wants to play with. Capped at 5.
    public final int BOARD_SIZE = 7;    // 7x7 board is big enough. Useful to have this parameter.


    // Board constructor
    public Board(int ships){
        if(ships > 5){
            this.ships = 5;
        }
        else if(ships < 1){
            this.ships = 1;
        }
        else{
            this.ships = ships;
        }
        board = new char[BOARD_SIZE][BOARD_SIZE];
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[row].length; col++)
            {
                board[row][col] = '-'; //Whatever value you want to set them to
            }
        }
        print();
        for(int i = 0; i < ships; i++){
            addShip();
        }
    }


    // add a ship
    public void addShip(){
        int added = 0;
        Random rand = new Random();
        int xCoordinate = rand.nextInt(7);
        int yCoordinate = rand.nextInt(7);
        int direction = rand.nextInt(2);

        while(added != 1) {
            if (shipAllowed(xCoordinate, yCoordinate, direction, 1)) {
                if(direction == 0){
                    board[xCoordinate][yCoordinate] = '*';
                    yCoordinate++;
                    board[xCoordinate][yCoordinate] = '*';
                    yCoordinate++;
                    board[xCoordinate][yCoordinate] = '*';
                }
                else{
                    board[xCoordinate][yCoordinate] = '*';
                    xCoordinate++;
                    board[xCoordinate][yCoordinate] = '*';
                    xCoordinate++;
                    board[xCoordinate][yCoordinate] = '*';
                }
                added++;
            }
        }
    }

    // checks if a position is free.    - is free, * is occupied
    // direction is passed in here. 1 = horizontal, 0 = vertical
    public boolean shipAllowed(int x, int y, int direction, int shipSegment){
        if(shipSegment > 3){
            return false;
        }
        if(x >= 6 || y >= 6){
            return false;
        }
        if(board[x][y] == '-'){
            if(direction == 0){
                // the ship is to be placed vertically
                shipAllowed(x, y + 1, direction, shipSegment + 1);
                return true;
            }
            else{
                // position it horizontally
                shipAllowed(x + 1, y, direction, shipSegment + 1);
                return true;
            }
        }
        else{
            return false;
        }
    }


    public void print() {
        System.out.println();
        System.out.println("   |0|1|2|3|4|5|6|");
        System.out.println("   ---------------");
        for(int i = 0; i < BOARD_SIZE; i++){
            System.out.print(i + ": |");
            for(int j = 0; j < BOARD_SIZE; j++){
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }
}
