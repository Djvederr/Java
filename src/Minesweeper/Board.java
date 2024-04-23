package Minesweeper;
import java.util.Scanner;
public class Board {
    Tile [][] board;
    boolean gameOver = false;


    boolean win=false;
    int bombamt;

    public Board(int x1, int  y1, int bombamt){
        board=new Tile[x1][y1];
        for(int i=0;i<x1;i++){
            for(int j=0;j<y1;j++){
                board[i][j]=new Tile();
                //System.out.print(board[i][0].getTile());
            }
            //System.out.println();

        }
        //System.out.println(board[0][0] + " " +board[0][1]);
        this.bombamt=bombamt;

    }

    //Create a function to find neighbours for the generateBoard function to find the values of non-bomb squares
    public Tile[] getNeighbours(int xLoc,int yLoc){
        Tile[] tiles=new Tile[9];
        int count=0;
        for(int x=-1;x<=1;x++)
        {
            if((xLoc+x)<0)
                continue;
            if((xLoc+x)>board.length-1)
                continue;
            for(int y=-1;y<=1;y++){
                if((yLoc+y)<0)
                    continue;
                if((yLoc+y)>board[0].length-1)
                    continue;
                //System.out.println(xLoc+x + "  " + (yLoc+y));
                tiles[count]=board[xLoc+x][yLoc+y];
                count++;
            }
        }
        return tiles;
    }
    public void generateBoard(int startX,int startY){
        int[][]bombs=new int[bombamt][2];
        for(int  i =0; i<bombamt ; i++){
            boolean z=false;
            int x = 0,y = 0;
            while(!z) {
                x = (int) (Math.random() * board.length - 1);
                y = (int) (Math.random() * board[0].length - 1);
                boolean bombpick=true;
                for(int[] bomb:bombs){
                    if (x==bomb[0] && y==bomb[1] || checkStartLoc(x,y,startX,startY)) {
                        bombpick=false;
                        break;
                    }
                }
                if(bombpick){
                    z=true;
                }

            }
            //System.out.println(x + "  " + y);

            bombs[i][0]=x;
            bombs[i][1]=y;

            board[x][y].setSpace(-1);
        }
        //for(int i=0;i<bombamt;i++){
        //    for(int o=0;o<2;o++){
        //        System.out.print(bombs[i][o]);
        //    }
        //    System.out.println();
        //}
        //testBoard();
        for(int i=0;i<bombs.length;i++){
            Tile[] neighbours=getNeighbours(bombs[i][0],bombs[i][1]);
            for(Tile x:neighbours){
                if(x!=null)
                    x.addSpace();
            }
        }
        openVoid(startX,startY);
    }
    public boolean checkStartLoc(int bombX,int bombY,int startX,int startY){
        if(bombX==startX && bombY==startY)
            return true;
        Tile[] tiles=getNeighbours(startX,startY);
        for(Tile t: tiles){
            if(t!=null) {
                int[] loc = getXYFromTile(t);
                if (loc[0] == bombX && loc[1] == bombY) {
                    return true;
                }
            }
        }
        return false;
    }



    public void testBoard(){
        for(int i=0;i< board.length;i++){
            for(int o=0;o<board[0].length;o++){
                if(board[i][o].getSpace() != -1)
                    System.out.print("  " + board[i][o].getSpace()  );
                else
                    System.out.print(" " + board[i][o].getSpace());
            }
            System.out.println();
        }
    }
    public boolean selectCell(int x, int y){
        if (board[x][y].getState()){
            return false;
        }
        openTile(x,y);
        return true;
    }

    public boolean gameWin(){
        int sum=0;
        for(Tile[] row:board){
            for(Tile t:row){
                if(t.getState())
                    sum++;
            }
        }
        return sum==((board.length*board[0].length)-bombamt);
    }


    public void openTile(int x,int y){
        Tile t=board[x][y];
        t.setState(true);

        if(t.getSpace()==-1){
            gameOver=true;
        }
        else {
            if(t.getSpace()==0){
                openVoid(x,y);
            }
            if(gameWin()){
                gameOver=true;
                win=true;
            }
        }


    }

    public void openVoid(int x,int y){
        Tile[] neighbours=getNeighbours(x,y);
        for(Tile t: neighbours){
            if(t==null)
                continue;
            if(t.getSpace()!=-1 && !t.getState()){
                t.setState(true);
                if(t.getSpace()==0) {
                    int[] XLocYLoc = getXYFromTile(t);
                    openVoid(XLocYLoc[0], XLocYLoc[1]);
                }
            }

        }
    }

    public int[] getXYFromTile(Tile t){
        for(int row=0;row< board.length;row++){
            for(int col=0;col<board[0].length;col++){
                if(board[row][col]==t){
                    return new int[]{row,col};
                }
            }
        }
        return new int[]{0};
    }



}
