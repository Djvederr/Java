package FreeResponseQs;

public class SelfDivisor
{

    /**
     * @param number the number to be tested Precondition: number > 0
     * @return true if every decimal digit of number is a divisor of number; false
     *     otherwise
     */
    public static boolean isSelfDivisor(int number)
    {
        int original=number;
        while(number>=1){
            int lastdigit=number%10;
            if(lastdigit!=0){
                if(original%lastdigit!=0){
                    return false;
                }
            }
            else{
                return false;
            }
            number/=10;
        }
        return true;
    }

    /****************/

    public static void main(String[] args)
    {
        System.out.println("128: " + isSelfDivisor(128));
        System.out.println("15: " + isSelfDivisor(15));
        System.out.println("21: " + isSelfDivisor(21));
        System.out.println("102: " + isSelfDivisor(102));
    }
}

 