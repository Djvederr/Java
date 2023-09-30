package Tests;

public class Test1 {
    public static void main(String[] args){
        String s1="Hello I like 88 dogs!";
        String s2="31235";
        System.out.println(s1.matches(".*\\blike\\b.*"));
        System.out.println(s2.matches("\\d*"));
    }
}
