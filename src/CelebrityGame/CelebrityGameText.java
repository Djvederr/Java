package CelebrityGame;


import java.io.FileNotFoundException;
import java.util.Scanner;
public class CelebrityGameText {
    CelebrityGame game;

    public CelebrityGameText() throws FileNotFoundException{
        game = new CelebrityGame("resources\\Celebrities.csv");
    }
    public static void main(String[] args) throws FileNotFoundException  {
        CelebrityGameText c=new CelebrityGameText();
        c.playGameRandom();
    }
    public void playGameRandom(){
        Scanner sc1=new Scanner(System.in);
        while(!game.gameOver()){
            game.pickCelebrity();
            System.out.println("Guess the celebrities!\nYour first clue is:");
            boolean done=false;
            while(!done && game.hasMoreClues()){
                System.out.println(game.getNextClue());
                String input=sc1.nextLine();
                if(game.checkAnswer(input)){
                    System.out.println("Correct!\n****************************************");
                    done=true;
                }
                else if(game.hasMoreClues()){
                    System.out.println("Incorrect! \nNext clue is:");
                }

            }
            if(!done){
                System.out.println("You couldn't guess correctly!\n"+ game.getAnswer() + "\n****************************************");
            }
        }
    }
}
