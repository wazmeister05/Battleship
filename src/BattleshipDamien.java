import java.util.Random;
import java.util.Scanner;

public class BattleshipDamien {

    private int[][] board;
    private int size;
    private int ships;

    public BattleshipDamien(int size) {
        this.size = size;
        ships = 5;
        board = new int[this.size][this.size];
        clearBoard();
        placeShips();
    }

    private void placeShips() {
        Random rand = new Random();
        for(int i = 0; i < ships; i++){
            int x = rand.nextInt(size);
            int y = rand.nextInt(size);
            board[x][y] = 1;
        }
    }

    private boolean fire(int x, int y){
        if(board[y][x] == 1){
            board[y][x] = 0;
            ships--;
            System.out.println("Hit!");
            return true;
        }
        System.out.println("Miss");
        return false;
    }

    private void clearBoard() {
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = 0;
            }
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        showBoard();
        while(!gameOver()){
            System.out.println("X Coordinate: ");
            int x = scanner.nextInt();
            System.out.println("Y Coordinate: ");
            int y = scanner.nextInt();
            fire(x,y);
            showBoard();
        }
        System.out.println("Won!");
    }

    private boolean gameOver(){
        return ships == 0;
    }

    private void showBoard() {
        System.out.println("   0|1|2|3|4|5|6|7|8|9|");
        System.out.println("   --------------------");
        for(int i = 0; i < size; i++){
            System.out.print(i + ": ");
            for(int j = 0; j < size; j++){
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }


}
