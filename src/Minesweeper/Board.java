package Minesweeper;

public class Board {
    Tile [][] board;
    public Board(int x, int  y){
        board=new Tile[x][y];
        for(int i=0;i<x;i++){
            for(int o=0;o<y;o++){
                board[i][o]=new Tile();
                //System.out.print(board[i][0].getContent());
            }
            //System.out.println();
        }
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
    public void generateBoard(int bombamt){
        int[][]bombs=new int[bombamt][2];
        for(int  i =0; i<bombamt;i++){
            int x=(int) (Math.random()*board.length-1);
            int y=(int) (Math.random()*board[0].length-1);
            System.out.println(x + "  " + y);

            bombs[i][0]=x;
            bombs[i][1]=y;

            board[x][y].setContent(-1);
        }
        for(int i=0;i<bombamt;i++){
            for(int o=0;o<2;o++){
                System.out.print(bombs[i][o]);
            }
            System.out.println();
        }
        printBoard();
        for(int i=0;i<bombs.length;i++){
            Tile[] neighbours=getNeighbours(bombs[i][0],bombs[i][1]);
            for(Tile x:neighbours){
                if(x!=null)
                    x.addContent();
            }
        }
    }

    public void printBoard(){
        for(int i=0;i< board.length;i++){
            for(int o=0;o<board[0].length;o++){
                System.out.print(board[i][0].getContent()+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Board obj=new Board(8,8);
        obj.printBoard();
        obj.generateBoard(2);
        obj.printBoard();
    }
}
