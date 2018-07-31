package algorithm.daj.stqu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackS{
    private int maxSize;
    private char[] stackArr;
    private int top;

    public StackS(int size){
        maxSize=size;
        top=-1;
        stackArr=new char[maxSize];
    }

    public void push(char ch){
        stackArr[++top]=ch;
    }

    public char pop(){
        return stackArr[top--];
    }

    public char peek(){
        return stackArr[top];
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    public int size(){
        return top+1;
    }

    public char peekN(int n){
        return stackArr[n];
    }

    public void displayStack(String s){
        System.out.print(s);
        System.out.print("Stack (bottom-->top) : ");
        for(int j=0;j<size();j++){
            System.out.print(peekN(j)+" ");
        }
        System.out.println();
    }
}

class InToPost{
    private StackS stack;
    private String input;
    private String output;

    public InToPost(String in){
        input=in;
        output="";
        stack=new StackS(in.length());
    }

    public String doTrans(){
        for(int j=0;j<input.length();j++){
            char ch=input.charAt(j);
            stack.displayStack("For "+ch+" ");
            switch(ch){
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output=output+ch;
                    break;
            }
        }
        while(!stack.isEmpty()){
            stack.displayStack("While ");
            output=output+stack.pop();
        }
        stack.displayStack("End ");
        return output;
    }

    private void gotOper(char oper, int level){
        while(!stack.isEmpty()){
            char operTop=stack.pop();
            if(operTop=='('){
                stack.push(operTop);
                break;
            }else{
                int levels;
                if(operTop=='-'||operTop=='+'){
                    levels=1;
                }else{
                    levels=2;
                }
                if(levels<level){
                    stack.push(operTop);
                    break;
                }else{
                    output=output+operTop;
                }
            }
        }
        stack.push(oper);
    }

    private void gotParen(char ch){
        while(!stack.isEmpty()){
            char chx=stack.pop();
            if(chx=='('){
                break;
            }else{
                output=output+chx;
            }
        }
    }
}

public class InfixApp{
    public static void main(String[] args) throws IOException{
        while(true){
            String input=getString();
            if(input=="") break;
            InToPost trans=new InToPost(input);
            System.out.println("Postfix is "+trans.doTrans());
        }
    }

    private static String getString() throws IOException{
        BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
        return bReader.readLine();
    }
}