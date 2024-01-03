package MagpieChatbot;

public class Magpie4 {
    public String getGreetings(){
        return "Hello!, how can I help you?";
    }
    public String getResponse(String input){
        input=input.trim().toLowerCase();
        if(input.length()==0){
            return "Say something please!";
        }
        else if(findLocation(input,"no")!=-1){
            return "Why so negative?";
        }
        else if(findLocation(input,"mother")!=-1 || findLocation(input,"father")!=-1 ||
                findLocation(input,"brother")!=-1 || findLocation(input,"sister")!=-1){
            return "Tell me more about your family!";
        }
        else if(findLocation(input,"friend")!=-1){
            return "Tell me more about your friend!";
        }
        else if(findLocation(input,"cat")!=-1 || findLocation(input,"dog")!=-1){
            return "Tell me more about your pet!";
        }
        else if(findLocation(input,"gowri")!=-1){
            return "She sounds like a good teacher!";
        }
        else if(findLocation(input,"prabhat")!=-1){
            return "He sounds like a good teacher!";
        }
        else if(findLocation(input,"weather")!=-1) {
            return "It's been quite odd right?";
        }
        else if(input.matches("i\\s\\w*\\syou")){
            return "Why do you "+findNextWord(input,"i")+" me?";
        }
        else if(input.matches("you\\s\\w*\\sme")){
            return "Why do you think I "+findNextWord(input,"you")+" you?";
        }
        else if(findLocation(input,"i like")!=-1){
            return "Why do you like " + findNextWord(input,"i like")+"?";
        }
        else if(findLocation(input,"i want")!=-1){
            return "would you really be happy if you had " + findNextWord(input,"i want")+"?";
        }
        else{
            return randomResponse();
        }
    }
    public String getFarewell(){
        return "Goodbye!";
    }


    public int findLocation(String original,String tofind) {
        if (original.matches(".*\\b" + tofind + "\\b.*")) {
            int startpos=0;
            int index = original.indexOf(tofind,startpos);
            if (index==0 || index+tofind.length()==original.length()){
                return index;
            }
            else {
                while (true) {
                    index = original.indexOf(tofind, startpos);

                    if (index==0 || index+tofind.length()==original.length()){
                        return index;
                    }
                    String sub = original.substring(index - 1, index + tofind.length() + 1);

                    if (sub.matches("\\s" + tofind + "\\s")) {

                        return index;
                    }
                    startpos = index + tofind.length() + 1;
                }
            }
        } else {
            return -1;
        }
    }
    public String findNextWord(String original,String tofind){
        int loc=findLocation(original,tofind);
        int wordloc=loc+tofind.length()+1;
        String nextword="";
        while( wordloc<original.length() && original.charAt(wordloc)!=' '){
            nextword=nextword+original.charAt(wordloc);
            wordloc++;
        }
        return nextword;
    }
    public String randomResponse(){
        String responses[]={"Do you really think so?","Interesting, tell me more!",
                "Hmm","Okay!","You don't say?"};
        int randomnum=(int)(Math.random()*responses.length);
        return responses[randomnum];
    }
}

