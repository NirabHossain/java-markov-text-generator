import java.util.*;

public class MarkovFour {
    private int num;
    private String myText;
    private Random myRandom;
    
    public MarkovFour(int x) {myRandom = new Random();num=x;}
    
    public void setRandom(int seed){myRandom = new Random(seed);}
    
    public void setTraining(String s){myText = s.trim();}
    
    public String getRandomText(int numChars){
        
        
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length()-num);
        String key=myText.substring(index,index+num);
        sb.append(key);
        for(int k=0; k < numChars-num; k++){
            ArrayList<String> follows= getFollows(key);
            //System.out.println("Key: "+key+": "+follows);
            if(key.equals("he"))System.out.println("Key: "+key+": "+follows.size());
            if(follows.size()==0)break;
            index=myRandom.nextInt(follows.size());
            String next=follows.get(index);
            sb.append(next);
            key=key.substring(1)+next;
        }
        //System.out.println(getFollows("th"));
        return sb.toString();
    }
    
    private ArrayList<String> getFollows(String key){
        ArrayList<String>follows= new ArrayList<String>();
        int pos=0;
        while(pos<myText.length()){
            int start=myText.indexOf(key,pos);
            if(start==-1)break;
            if(start+key.length()>=myText.length()-1)break;
            String next=myText.substring(start+key.length(),start+key.length()+1);
            follows.add(next);
            pos=start+key.length();
        }
        return follows;
    }
    
}
