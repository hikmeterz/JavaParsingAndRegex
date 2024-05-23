import javax.sql.StatementEventListener;

import java.util.regex.*;
public class regex{
    public static void main(String[] args){
        String text="T11*id112Fid3(1E12)12F12";
        //String regex="E[0-9]*\\+[0-9]*T[0-9]*";
        //String regex="T[0-9]*\\*[0-9]*F[0-9]*";
        
        //String regex="F[0-9]*";
        
        //String regex="\\([0-9]*E[0-9]*\\)[0-9]*";
        String regex="id[0-9]*";
        
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        // Check all occurrences
        int index=0;
        int[] indexes= new int[1000];
        String[] replace = new String[1000];
        /*while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end());
            System.out.println(" Found: " + matcher.group());
        }*/
        while (matcher.find()) {
            indexes[index]= matcher.start();
            indexes[index+1] =matcher.end();           
            index+=2;
            
        }
        
        String s=text.replaceAll(regex,"F");
        
        


        for(int i=0;i<index;i++){
            System.out.println(indexes[i]);
        }

        
        

        
        System.out.println(s);
    }


}