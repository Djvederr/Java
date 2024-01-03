package CelebrityGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CelebrityGame {
    ArrayList<Celebrity> allcelebrities;
    Celebrity current;
    int clueno;

    int celebno;

    final int TOTALCELEBS=5;

    public CelebrityGame(String path) throws FileNotFoundException {
        this.allcelebrities=new ArrayList<Celebrity>();
        celebno=0;
        Scanner sc1=new Scanner(new File(path));//"resources\\Celebrities.csv"
        while(sc1.hasNextLine()){
            String line=sc1.nextLine();
            Scanner sc2=new Scanner(line);
            sc2.useDelimiter(",");
            String name = sc2.next();
            String clue1 = sc2.next();
            String clue2 = sc2.next();
            String clue3 =sc2.next();
            Celebrity temp=new Celebrity(name,clue1,clue2,clue3);
            allcelebrities.add(temp);
        }
        /**for(Celebrity x : allcelebrities){
         System.out.println(x);
         }**/
    }
    public void pickCelebrity(){
        clueno=1;
        celebno++;
        current=allcelebrities.get((int)(Math.random()*allcelebrities.size()));
        allcelebrities.remove(current);
    }
    public String getNextClue(){
        return current.getNextClue(clueno++);
    }

    public boolean hasMoreClues(){return clueno<=3;}
    public boolean checkAnswer(String ans){
        return current.checkName(ans);
    }

    public String getAnswer(){return current.toString();}

    public boolean gameOver(){return celebno>=TOTALCELEBS || allcelebrities.isEmpty();}


}
