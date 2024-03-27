package Minesweeper;

import java.util.Scanner;

public class MinesweeperText {
    Board board;
    int [] gameLevel;
    public MinesweeperText(int x1, int y1,int bombamt){
        board=new Board(x1,y1,bombamt);
        int[] temp={x1,y1,bombamt};
        this.gameLevel=temp;
    }
    public static void main(String[] args){
        MinesweeperText game=new MinesweeperText(8,8,6);
        //board.generateBoard();
        game.playGame();


    }
    public void playGame(){
        //board.printBoard();
        //board.testBoard();
        printBeforeBoard();
        int[] choice = getRowCol();
        board.generateBoard(choice[0],choice[1]);
        board.testBoard();
        //board.testBoard();
        while(!board.gameOver) {
            printBoard();
            choice = getRowCol();
            while (!board.selectCell(choice[0], choice[1])) {
                choice = getRowCol();
            }
            printBoard();
        }
        if(board.win)
            System.out.println("YOU WON!");
        else
            System.out.println("YOU LOST!");
        board.testBoard();
    }
    public void printBeforeBoard(){
        for(int i=1;i<=gameLevel[0];i++){
            for(int j=1;j<=gameLevel[1];j++){
                System.out.print(" X");
            }
            System.out.println();
        }
    }

    public int[] getRowCol(){
        System.out.println("Enter a row between 1 and "+gameLevel[0]);
        Scanner sc1=new Scanner(System.in);
        int x=sc1.nextInt()-1;
        while(x>board.board.length || x<0){
            System.out.println("Error! \nEnter a new row between 1 and "+gameLevel[0]);
            x=sc1.nextInt()-1;
        }
        System.out.println("Enter a column between 1 and "+gameLevel[1]);
        int y=sc1.nextInt()-1;
        while(y>board.board[0].length || y<0){
            System.out.println("Error! \nEnter a new column between 1 and "+gameLevel[1]);
            y=sc1.nextInt()-1;
        }
        return new int[]{x,y};
    }

    public void printBoard(){
        for(int i=0;i< board.board.length;i++){
            for(int o=0;o<board.board[0].length;o++){
                System.out.print(board.board[i][o]);
            }
            System.out.println();
        }
        for(int j=0;j<board.board[0].length;j++){
            System.out.print("---");
        }
        System.out.println();
    }
}
