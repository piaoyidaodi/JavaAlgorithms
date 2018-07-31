package algorithm.daj.stqu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class BracketChecker{
    private String input;
    public BracketChecker(String input){
        this.input=input;
    }

    public void check(){
        int stackSize=input.length();
        StackX1 stackX1=new StackX1(stackSize);
        for(int j=0;j<stackSize;j++){
            char ch=input.charAt(j);
            switch(ch){
                case '(':
                case '[':
                case '{':
                stackX1.push(ch);
                break;

                case ')':
                case ']':
                case '}':
                if(!stackX1.isEmpty()){
                    char chx=stackX1.pop();
                    if( (ch=='}'&&chx!='{')||(ch==']'&&chx!='[')||(ch==')'&&chx!='(') ){
                        System.out.println("Error "+ch+" at "+j);
                    }
                }else{
                    System.out.println("Error "+ch+" at "+j);
                }
            }
        }
        if(!stackX1.isEmpty()){
            System.out.println("Error: missing right delimiter");
        }
    }
}

class BracketsApp{
    public static void main(String[] args) throws IOException{
        String input;

        while(true){
            input=getString();
            if(input.equals("")) break;

            BracketChecker checker=new BracketChecker(input);
            checker.check();
        }
    }

    private static String getString() throws IOException{
        BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
        return bReader.readLine();
    }
}