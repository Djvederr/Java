package TicTacToe;

public class Board {
    private Tile[][] board;
    public Board(){
        board=new Tile[3][3];
    }
     public void setTile(int r, int c, Tile t){
        board[r][c]=t;
     }

     public Tile getTile(int r, int c){
        return board[r][c];
     }


}
