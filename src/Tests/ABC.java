package Tests;

public class ABC {//class declaration

    void updateArray(int[] a1) {//int return type, no parameters
        for (int i=0; i<a1.length;i++) {
            a1[i]+=10;//increase each element by 10
            System.out.print(a1[i]+" ");//print on one line
        }
        System.out.println();//move to next line
    }

    public static void main(String[] args) {//main method
        int[] a1 = {10,20,30,40,50};//declare and intialize an array

        ABC object1 = new ABC();//create an object of the class
        object1.updateArray(a1);//update value of the array by calling the method

        //check if the array has been changed permanently
        for (int x=0; x<a1.length; x++) {//display the array
            System.out.print(a1[x]+ " ");
        }

    }

}
