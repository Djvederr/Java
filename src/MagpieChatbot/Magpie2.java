package MagpieChatbot;
public class Magpie2
{
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
        else if(findLocation(input,"weather")!=-1){
            return "It's been quite odd right?";
        }
        else{
            return randomResponse();
        }
    }
    public String getFarewell(){
        return "Goodbye!";
    }
    public int findLocation(String original,String tofind){
        int pos=original.indexOf(tofind);
        if(pos==-1){
            return -1;
        }
        if(pos!=0 && original.charAt(pos-1)==' ' ){
            if ((pos+tofind.length())==original.length()){
                return pos;
            }
            else if(original.charAt(pos+tofind.length())==' '){
                return pos;
            }
        }
        else if((pos+tofind.length())<=original.length()){
            return findLocation(original.substring(pos+tofind.length()),tofind);
        }
        return -1;
    }
    public String randomResponse(){
        String responses[]={"Do you really think so?","Interesting, tell me more!",
            "Hmm","Okay!","You don't say?"};
        int randomnum=(int)(Math.random()*responses.length);
        return responses[randomnum];
    }
}
