package CelebrityGame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1=new Scanner(new File("resources\\Celebrities.csv"));
        while(sc1.hasNextLine()){
            String line=sc1.nextLine();
            Scanner sc2=new Scanner(line);
            sc2.useDelimiter(",");
            while(sc2.hasNext()){
                System.out.println(sc2.next());
            }        }
    }


}
