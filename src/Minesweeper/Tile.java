package Minesweeper;

public class Tile {
    boolean state=false;
    int contents;
    public Tile(int contents){
        this.contents=contents;
    }
    public Tile(){

    }
    public int getSpace(){
        return contents;
    }
    public boolean getState(){
        return state;
    }

    public void setSpace(int content) {
        this.contents = content;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void addSpace(){
        if (contents!=-1){
            contents+=1;
        }
    }
    public String toString(){
        if(!state)
            return "  X";
        if(contents==-1){
            return " " + contents;
        }
        return ("  " + contents);
    }
}
