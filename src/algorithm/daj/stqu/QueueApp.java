package algorithm.daj.stqu;
 class Queue{
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public Queue(int size){
        maxSize=size;
        queArray=new long[size];
        front=0;
        rear=-1;
        nItems=0;
    }

    public void insert(long value){
        if(rear==maxSize){
            rear=-1;
        }
        queArray[++rear]=value;
        nItems++;
    }

    public long remove(){
        long tmp=queArray[front++];
        if(front==maxSize){
            front=0;
        }
        nItems--;
        return tmp;
    }

    public long peekFront(){
        return queArray[front];
    }

    public boolean isEmpty(){
        return (nItems==0);
    }

    public boolean isFull(){
        return (nItems==maxSize);
    }

    public int size(){
        return nItems;
    }
 }

 public class QueueApp{
    public static void main(String[] args){
        Queue queue=new Queue(5);

        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);

        queue.remove();
        queue.remove();
        queue.remove();

        while(!queue.isEmpty()){
            System.out.print(queue.remove()+" ");
        }
    }
 }