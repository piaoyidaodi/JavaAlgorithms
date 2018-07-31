package algorithm.daj.stqu;

class StackX{
    private int maxSize;
    private long[] stackArray;
    private int top;

    public StackX(int size){
        maxSize=size;
        stackArray=new long[maxSize];
        top=-1;
    }

    public void push(long value){
        stackArray[++top]=value;
    }

    public long pop(){
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

public class StackApp{
    public static void main(String[] args){
        StackX stackX=new StackX(10);
        stackX.push(20);
        stackX.push(40);
        stackX.push(60);
        stackX.push(80);

        while(!stackX.isEmpty()){
            long value=stackX.pop();
            System.out.print(value+" ");
        }
    }
    
}