package Minesweeper;

public class Test {
    public static void main(String[] args){
        Tile [] []board=new Tile[3][3];
        for(int i=0;i<3;i++){
            for(int o=0;o<3;o++){
                board[i][o]=new Tile();
                System.out.print(board[i][0].getContent());
            }
            System.out.println();
        }
    }
}
