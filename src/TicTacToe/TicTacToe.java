package TicTacToe;

public class TicTacToe {
    private Board b;
    Player p1,p2;
    Player turn;
    public TicTacToe(){
        b=new Board();
        p1=new Player(new Tile(Tile.X));
        p2=new Player(new Tile(Tile.O));
        turn=p1;
    }

    public void changeTurn(){
        if(turn==p1)
            turn=p2;
        else
            turn=p1;
    }

    public void playMove(int r,int c){
        b.setTile(r,c,turn.getTile());
    }

    private boolean checkRow(int r){

        return(b.getTile(r,0)==b.getTile(r,1)) && (b.getTile(r,0)==b.getTile(r,2)) && b.getTile(r,0)!=null;

    }

    private boolean checkCol(int c){

        return(b.getTile(0,c)==b.getTile(1,c)) && (b.getTile(0,c)==b.getTile(2,c)) && b.getTile(0,c)!=null;

    }
    public boolean isGameOver(){
        for(int i=0;i<=2;i++){
            if(checkRow(i))
                return true;
        }
        for(int i=0;i<=2;i++){
            if(checkCol(i))
                return true;
        }
        if((b.getTile(0,0)==b.getTile(1,1)) && (b.getTile(0,0)==b.getTile(2,2)) && b.getTile(0,0)!=null)
            return true;
        return (b.getTile(0, 2) == b.getTile(1, 1)) && (b.getTile(0, 2) == b.getTile(2, 0)) && b.getTile(0, 2) != null;
    }
}
