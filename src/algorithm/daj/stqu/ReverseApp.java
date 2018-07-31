package algorithm.daj.stqu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class StackX1{
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackX1(int size){
        maxSize=size;
        stackArray=new char[maxSize];
        top=-1;
    }

    public void push(char value){
        stackArray[++top]=value;
    }

    public char pop(){
        return stackArray[top--];
    }

    public long peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    public boolean isFull(){
        return (top==maxSize-1);
    }
}

class Reverser{
    private String input;
    private String output;

    public Reverser(String in){
        input=in;
    }
    public String doRev(){
        int stackSize=input.length();
        StackX1 stackX=new StackX1(stackSize);

        for(int j=0;j<stackSize;j++){
            char ch=input.charAt(j);
            stackX.push(ch);
        }
        output="";
        while(!stackX.isEmpty()){
            char ch=stackX.pop();
            output=output+ch;
        }
        return output;
    }
}

public class ReverseApp{
    public static void main(String[] args) throws IOException{
        String input ,output;
        while(true){
            input=getString();
            if(input.equals("")){
                break;
            }

            Reverser reverser=new Reverser(input);
            output=reverser.doRev();
            System.out.println(output);
        }
    }

    private static String getString() throws IOException{
        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader bReader=new BufferedReader(reader);
        String s=bReader.readLine();
        return s;
    }
}