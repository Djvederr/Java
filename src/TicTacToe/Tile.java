package TicTacToe;

public class Tile {
    private short  value;
    static final short X=1;
    static final short O=0;
    public Tile(short value){
        this.value=value;
    }

    public short getValue(){
        return value;
    }


}
