package FreeResponseQs;

public class ScrambledStrings
{
    /********************** Part (a) *********************/

    /**
     * Scrambles a given word.
     *
     * @param word the word to be scrambled
     * @return the scrambled word (possibly equal to word) Precondition: word is
     *     either an empty string or contains only uppercase letters.
     *     Postcondition: the string returned was created from word as follows: -
     *     the word was scrambled, beginning at the first letter and continuing
     *     from left to right - two consecutive letters consisting of "A" followed
     *     by a letter that was not "A" were swapped - letters were swapped at most
     *     once
     */
    public static String scrambleWord(String word)
    {
       String scrambledword= "";
       for(int i=0;i<word.length();i++){
           if(word.charAt(i)=='A'){
               if(i<word.length()-1 && word.charAt(i+1)!='A'){
                   scrambledword=scrambledword+word.charAt(i+1)+word.charAt(i);
                   i+=1;
               }
               else{
                   scrambledword=scrambledword+word.charAt(i);
               }

           }
           else{
               scrambledword=scrambledword+word.charAt(i);
           }
       }
       return scrambledword;
    }

    public static String[] scrambleOrRemove(String[] words){
        String[] scrambeledlist=new String[words.length];
        int pos=0;
        for(int i=0;i< words.length;i++){
            String scrambledword=scrambleWord(words[i]);
            if(!scrambledword.equals(words[i])){
                scrambeledlist[pos]=scrambledword;
                pos++;
            }

        }
        return scrambeledlist;
    }

    /********************** Test *********************/
    public static void main(String[] args)
    {
        System.out.println("\nTesting Part (a):\n");

        String[] words =
        {
            "TAN", "ABRACADABRA", "WHOA", "AARDVARK", "EGGS", "A", ""
        };

        for (String word : words)
        {
            System.out.println(word + " becomes " + scrambleWord(word));
        }
        String[] scrambledlist=scrambleOrRemove(words);
        for (String word : scrambledlist)
        {
            System.out.println(word);
        }
    }
}

