import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.*;


public class Parsing{
    
    public static void main(String[] args) {
    
        String input = args[0];
        String output=args[1];

        String[][] table = new String[12][9];//table
        table[0][0]="Shift 5";table[0][3]="Shift 4";table[0][6]="1";table[0][7]="2";table[0][8]="3";
        
        table[1][5]="Accept";table[1][1]="Shift 6";
        
        table[2][1]="Reduce 2";table[2][2]="Shift 7";table[2][4]="Reduce 2";table[2][5]="Reduce 2";
        
        table[3][1]="Reduce 4";table[3][2]="Reduce 4";table[3][4]="Reduce 4";table[3][5]="Reduce 4";
        
        table[4][0]="Shift 5";table[4][3]="Shift 4";table[4][6]="8";table[4][7]="2";table[4][8]="3";
        

        table[5][1]="Reduce 6";table[5][2]="Reduce 6";table[5][4]="Reduce 6";table[5][5]="Reduce 6";
        
        table[6][0]="Shift 5";table[6][3]="Shift 4";table[6][7]="9";table[6][8]="3";
        
        table[7][0]="Shift 5";table[7][3]="Shift 4";table[7][8]="10";
        
        table[8][1]="Shift 6";table[8][4]="Shift 11";

        table[9][1]="Reduce 1";table[9][2]="Shift 7";table[9][4]="Reduce 1";table[9][5]="Reduce 1";
        
        table[10][1]="Reduce 3";table[10][2]="Reduce 3";table[10][4]="Reduce 3";table[10][5]="Reduce 3";
        
        table[11][1]="Reduce 5";table[11][2]="Reduce 5";table[11][4]="Reduce 5";table[11][5]="Reduce 5";
        String action="";
        String Stack="0";
        
        String find="";
        int newState=0;
        
        try {
            FileWriter myWriter = new FileWriter(output);
            myWriter.write("Stack"+"\t\t\t\t"+"Input\t\t\t\t"+"Action\n");
            myWriter.flush();
            int state=0;
            while(!action.equals("Accept")){
                
                if(action.equals("")){
                
                    for(int i=0;i<input.length();i++){
                        find+=""+input.charAt(i);
                        if(find.equals("id")){
                            
                            state=returnStateofStack(Stack);  
                            action=table[state][0];
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                System.exit(0);
                            }
                            else{ 
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                
                               
                                
                            }
                        
                        }else if(find.equals("+")){
                            state=returnStateofStack(Stack);
                            action=table[state][1];
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                 
                                
                                System.exit(0);
                            }
                            else{ 
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                
                                
                            }

                        }else if(find.equals("*")){
                            state=returnStateofStack(Stack);
                            action=table[state][2];
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }
                            else{ 
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                
                            
                            }
                        }else if(find.equals("(")){
                            state=returnStateofStack(Stack);
                            action=table[state][3];
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }else{ 
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                
                            }
                        }else if(find.equals(")")){
                            state=returnStateofStack(Stack);
                            action=table[state][4];
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }
                            else{ 
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                
                            }
                        }else if(find.equals("$")){
                            state=returnStateofStack(Stack);
                            action=table[state][5];
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }
                            else{ 
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                
                            }
                        }

                    }
                    
                    find="";
                    continue;
                }else if(action.charAt(0)=='S'){//bir onceki action.
                    
                    for(int i=0;i<input.length();i++){
                        find+=""+input.charAt(i);
                        if(find.equals("id")){ 
                            state=returnStateofStack(action);
                            Stack+=""+"id"+state;
                            input=input.substring(input.indexOf("id")+2);
                            if(input.charAt(0)=='i'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][0];
                        
                            }else if(input.charAt(0)=='+'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][1];
                            }
                            else if(input.charAt(0)=='*'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][2];
                            }
                            else if(input.charAt(0)=='('){
                                newState=returnStateofStack(Stack);
                                action=table[newState][3];
                            }else if(input.charAt(0)==')'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][4];
                            }else if(input.charAt(0)=='$'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][5];
                            }
                            
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }
                            else{
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                               
                            }
                            
                            break;
                        
                        }else if(find.equals("+")){
                            state=returnStateofStack(action);
                            Stack+=""+"+"+state;
                            input=input.substring(input.indexOf("+")+1);
                            if(input.charAt(0)=='i'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][0];
                        
                            }else if(input.charAt(0)=='+'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][1];
                            }
                            else if(input.charAt(0)=='*'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][2];
                            }
                            else if(input.charAt(0)=='('){
                                newState=returnStateofStack(Stack);
                                action=table[newState][3];
                            }else if(input.charAt(0)==')'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][4];
                            }else if(input.charAt(0)=='$'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][5];
                            }
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }
                            else{
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                               
                            }
                            
                            break;
                        
                        }else if(find.equals("*")){
                            state=returnStateofStack(action);
                            Stack+=""+"*"+state;
                            input=input.substring(input.indexOf("*")+1);
                            if(input.charAt(0)=='i'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][0];
                        
                            }else if(input.charAt(0)=='+'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][1];
                            }
                            else if(input.charAt(0)=='*'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][2];
                            }
                            else if(input.charAt(0)=='('){
                                newState=returnStateofStack(Stack);
                                action=table[newState][3];
                            }else if(input.charAt(0)==')'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][4];
                            }else if(input.charAt(0)=='$'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][5];
                            }
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }
                            else{
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                               
                            }
                            
                            break;
                        
                        }else if(find.equals("(")){
                            state=returnStateofStack(action);
                            Stack+=""+"("+state;
                            input=input.substring(input.indexOf("(")+1);
                            if(input.charAt(0)=='i'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][0];
                        
                            }else if(input.charAt(0)=='+'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][1];
                            }
                            else if(input.charAt(0)=='*'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][2];
                            }
                            else if(input.charAt(0)=='('){
                                newState=returnStateofStack(Stack);
                                action=table[newState][3];
                            }else if(input.charAt(0)==')'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][4];
                            }else if(input.charAt(0)=='$'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][5];
                            }
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }
                            else{
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                               
                            }
                            
                            break;
                        
                        }else if(find.equals(")")){
                            state=returnStateofStack(action);
                            Stack+=""+")"+state;
                            input=input.substring(input.indexOf(")")+1);
                            if(input.charAt(0)=='i'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][0];
                        
                            }else if(input.charAt(0)=='+'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][1];
                            }
                            else if(input.charAt(0)=='*'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][2];
                            }
                            else if(input.charAt(0)=='('){
                                newState=returnStateofStack(Stack);
                                action=table[newState][3];
                            }else if(input.charAt(0)==')'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][4];
                            }else if(input.charAt(0)=='$'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][5];
                            }
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }
                            else{
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                               
                            }
                            
                            break;
                            
                        }else if(find.equals("$")){
                            state=returnStateofStack(action);
                            Stack+=""+"$"+state;
                            input=input.substring(input.indexOf("id")+1);
                            if(input.charAt(0)=='i'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][0];
                        
                            }else if(input.charAt(0)=='+'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][1];
                            }
                            else if(input.charAt(0)=='*'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][2];
                            }
                            else if(input.charAt(0)=='('){
                                newState=returnStateofStack(Stack);
                                action=table[newState][3];
                            }else if(input.charAt(0)==')'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][4];
                            }else if(input.charAt(0)=='$'){
                                newState=returnStateofStack(Stack);
                                action=table[newState][5];
                            }
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }
                            else{
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                               
                            }
                            
                            
                            break;
                        
                        }
                        
                    }
                    find="";
                    continue;
                }else if(action.charAt(0)=='R'){
                    int rule=returnStateofStack(action);//hangi kural oldugunu buluyor.
                    if(rule==1){//burada kontrol gerekebilir.kurallar isledi mi diye
                        Stack=rule1(Stack);
                    }else if(rule==2){
                        Stack=rule2(Stack);
                    }else if(rule==3){
                        Stack=rule3(Stack);
                    }else if(rule==4){
                        Stack=rule4(Stack);
                    }else if(rule==5){
                        Stack=rule5(Stack);
                    }else if(rule==6){
                        Stack=rule6(Stack);
                    }
                    String s="";
                    String x="";
                    int y=0;
                    
                    for(int i=Stack.length()-1;i>=0;i--){
                        if(Stack.charAt(i)=='E'){
                            y=returnStateofStack(Stack.substring(0,i)); 
                            x=table[y][6];   
                            if(x==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);  
                            }
                            Stack+=""+x;
                            break;
                        }else if(Stack.charAt(i)=='T'){
                            y=returnStateofStack(Stack.substring(0,i)); 
                            x=table[y][7];   
                            if(x==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);  
                            }
                            Stack+=""+x;
                            break;
                        }else if(Stack.charAt(i)=='F'){
                            y=returnStateofStack(Stack.substring(0,i)); 
                            x=table[y][8];   
                            
                            if(x==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);  
                            }
                            
                            Stack+=""+x;
                            
                            break;
                        }

                    }

                    state=returnStateofStack(Stack);
                    for(int i=0;i<input.length();i++){
                        find+=""+input.charAt(i);
                        if(find.equals("id")){ 
                            action=table[state][0];
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }
                            else{
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                               
                            }
                            break;
                        
                        }else if(find.equals("+")){
                            action=table[state][1];
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }
                            else{
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                               
                            }
                            break;
                        
                        }else if(find.equals("*")){
                            action=table[state][2];
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }
                            else{
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                               
                            }
                            break;
                        
                        }else if(find.equals("(")){
                            action=table[state][3];
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }
                            else{
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                               
                            }
                            break;
                        
                        }else if(find.equals(")")){
                            state=returnStateofStack(action);
                            action=table[state][4];
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }
                            else{
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                               
                            }
                            break;
                        
                        }else if(find.equals("$")){
                            action=table[state][5];
                            if(action==null){
                                action="ERROR";
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                                System.out.println("Error occurred."); 
                                
                                System.exit(0);
                            }
                            else{
                                myWriter.write(Stack+"\t\t\t\t"+input+"\t\t\t\t"+action+"\n");
                                myWriter.flush();
                               
                            }
                            break;
                        
                        }
                        
                    }
                    find="";
                    continue;                    

                
                }

            }
            System.out.println("The input has been parsed successfully.");                   

            myWriter.close();
        }catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

  


    }
    public static int returnStateofStack(String input){//For shift.(isminin degismesi lazim simdilik.)
        int index=input.length()-1;
        String value="";
        for(int i=index;i>=0;i--){
            if(input.charAt(i)>=48 && input.charAt(i)<=57){
                value=""+input.charAt(i)+""+value;

            }else{
                break;
            }
        
        }
        
        int state=Integer.parseInt(value);

        return state;
    }
    public static String rule1(String stack){
        String newStack="";
        String regex="E[0-9]*\\+[0-9]*T[0-9]*";
        newStack=stack.replaceAll(regex,"E");

        return newStack;
        
    }
    public static String rule2(String stack){
        String newStack="";
        String regex="T[0-9]*";
        newStack=stack.replaceAll(regex,"E");

        return newStack;
        
    }
    public static String rule3(String stack){
        String newStack="";
        String regex="T[0-9]*\\*[0-9]*F[0-9]*";
        newStack=stack.replaceAll(regex,"T");

        return newStack;
        
    }
    public static String rule4(String stack){
        String newStack="";
        String regex="F[0-9]*";
        newStack=stack.replaceAll(regex,"T");

        return newStack;
        
    }public static String rule5(String stack){
        String newStack="";
        String regex="\\([0-9]*E[0-9]*\\)[0-9]*";
        newStack=stack.replaceAll(regex,"F");

        return newStack;
        
    }
    public static String rule6(String stack){
        String newStack="";
        String regex="id[0-9]*";
        newStack=stack.replaceAll(regex,"F");

        return newStack;
        
    }


}
