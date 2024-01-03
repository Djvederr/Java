package CelebrityGame;

public class Celebrity {
    String name,clue1,clue2,clue3;
    public Celebrity(String name,String clue1,String clue2,String clue3){
        this.name=name;
        this.clue1=clue1;
        this.clue2=clue2;
        this.clue3=clue3;
    }

    public String getNextClue(int x) {
        return x==1?clue1:x==2?clue2:clue3;
    }

    public boolean checkName(String nameInput){
        if(name.toLowerCase().compareTo(nameInput.toLowerCase())==0){
            return true;
        }
        return false;
    }



    public String toString(){
        return "The name of the celebrity is: " + name ;
    }
}
