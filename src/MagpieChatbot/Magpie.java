package MagpieChatbot;
public class Magpie
{
    public String getGreetings(){
        return "Hello!, how can I help you?";
    }
    public String getResponse(String input){
        input=input.trim().toLowerCase();
        if(input.length()==0){
            return "Say something please!";
        }
        else if(input.indexOf("no")!=-1){
            return "Why so negative?";
        }
        else if(input.indexOf("mother")!=-1 || input.indexOf("father")!=-1 ||
            input.indexOf("brother")!=-1 || input.indexOf("sister")!=-1){
                return "Tell me more about your family!";
            }
        else if(input.indexOf("friend")!=-1){
            return "Tell me more about your friend!";
        }
        else if(input.indexOf("cat")!=-1 || input.indexOf("dog")!=-1){
            return "Tell me more about your pet!";
        }
        else if(input.indexOf("gowri")!=-1){
            return "She sounds like a good teacher!";
        }
        else if(input.indexOf("prabhat")!=-1){
            return "He sounds like a good teacher!";
        }
        else if(input.indexOf("weather")!=-1){
            return "It's been quite odd right?";
        }
        else{
            return randomResponse();
        }
    }
    public String getFarewell(){
        return "Goodbye!";
    }
    public String randomResponse(){
        String responses[]={"Do you really think so?","Interesting, tell me more!",
            "Hmm","Okay!","You don't say?"};
        int randomnum=(int)(Math.random()*responses.length);
        return responses[randomnum];
    }
}
