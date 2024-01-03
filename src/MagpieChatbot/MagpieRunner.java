package MagpieChatbot;
import java.util.Scanner;
public class MagpieRunner
{
    public static void main(String[] args){
        runVersion4();
    }
    public static void runVersion1(){
        Magpie maggie=new Magpie();
        Scanner sc1=new Scanner(System.in);
        System.out.println(maggie.getGreetings());
        boolean run=true;
        while(run){
            String input=sc1.nextLine();
            if(input.toLowerCase().compareTo("goodbye")==0){
                System.out.println(maggie.getFarewell());
                run=false;
            }
            else{
                System.out.println(maggie.getResponse(input));
            }
        }
    }
    public static void runVersion2(){
        Magpie2 maggie=new Magpie2();
        Scanner sc1=new Scanner(System.in);
        System.out.println(maggie.getGreetings());
        boolean run=true;
        while(run){
            String input=sc1.nextLine();
            if(input.toLowerCase().compareTo("goodbye")==0){
                System.out.println(maggie.getFarewell());
                run=false;
            }
            else{
                System.out.println(maggie.getResponse(input));
            }
        }
    }
    public static void runVersion3(){
        Magpie3 maggie=new Magpie3();
        Scanner sc1=new Scanner(System.in);
        System.out.println(maggie.getGreetings());
        boolean run=true;
        while(run){
            String input=sc1.nextLine();
            if(input.toLowerCase().compareTo("goodbye")==0){
                System.out.println(maggie.getFarewell());
                run=false;
            }
            else{
                System.out.println(maggie.getResponse(input));
            }
        }
    }
    public static void runVersion4(){
        Magpie4 maggie=new Magpie4();
        Scanner sc1=new Scanner(System.in);
        System.out.println(maggie.getGreetings());
        boolean run=true;
        while(run){
            String input=sc1.nextLine();
            if(input.toLowerCase().compareTo("goodbye")==0){
                System.out.println(maggie.getFarewell());
                run=false;
            }
            else{
                System.out.println(maggie.getResponse(input));
            }
        }
    }
}
