import java.util.Random;

public class Board {

    public char[][] board;               // int array for the board
    public int ships;                   // number of ships the user wants to play with. Capped at 5.
    public final int bgLength = 7;    // 7x7 board is big enough. Useful to have this parameter.


    // Board constructor
    public Board(int ships){
        if(ships > 10){
            this.ships = 10;
        }
        else if(ships < 5){
            this.ships = 5;
        }
        else{
            this.ships = ships;
        }
        board = new char[bgLength][bgLength];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
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
        Random rand = new Random();
        int xCoordinate = rand.nextInt(7);
        int yCoordinate = rand.nextInt(7);
        if(shipAllowed(xCoordinate, yCoordinate)){
            board[xCoordinate][yCoordinate] = '*';
        }
    }

    // checks if a position is free.    - is free, * is occupied
    public boolean shipAllowed(int x, int y){
        if(board[x][y] == '-'){
            return true;
        }
        else{
            return false;
        }
    }

    // this is just to print the game board so I can see it works.
    public void print() {
        System.out.println();
        System.out.println("   |0|1|2|3|4|5|6|");
        System.out.println("   ---------------");
        for(int i = 0; i < bgLength; i++){
            System.out.print(i + ": |");
            for(int j = 0; j < bgLength; j++){
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }
}
