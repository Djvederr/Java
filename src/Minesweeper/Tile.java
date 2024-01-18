package Minesweeper;

public class Tile {
    boolean state=false;
    int content;
    public Tile(int content){
        this.content=content;
    }
    public Tile(){

    }
    public int getContent(){
        return content;
    }
    public boolean getState(){
        return state;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public void addContent(){
        if (content!=-1){
            content+=1;
        }
    }
}
