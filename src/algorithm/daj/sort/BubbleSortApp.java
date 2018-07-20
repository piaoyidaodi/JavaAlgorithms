package algorithm.daj.sort;

class ArrayBub{
    private long[] arr;
    private int nElems;

    public ArrayBub(int max){
        arr=new long[max];
        nElems=0;
    }

    public void insert(long value){
        arr[nElems]=value;
        nElems++;
    }

    public void display(){
        for(int i=0;i<nElems;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
/**
 * 外层for循环的计数器out从数组最后开始，即out等于nElems-1，每经过一次循环out-1。此时下标大于out的数据项已完成了排序。
 * 变量out在每完成一次内部循环（计数器为in）后就左移一位，此时不再处理已排序的数据。
 * 
 * 内层for循环计数器in从数组最开始计算，即in=0，每完成一次内部循环体处理后in+1，当它等于out时一次循环结束。
 * 在内层for循环体中，数组下标为in和in+1的两个数据项进行比较，并根据大小规则交换。
 */
    public void bubbleSort(){
        for(int out=nElems-1;out>1;out--){
            for(int in=0;in<out;in++){
                if(arr[in]>arr[in+1]){
                    swap(in,in+1);
                }
            }
        }
    }

    private void swap(int front, int back){
        long tmp=arr[front];
        arr[front]=arr[back];
        arr[back]=tmp;
    }
}

public class BubbleSortApp{
    public static void main(String[] args){
        long t1=System.nanoTime();
        ArrayBub arr=new ArrayBub(100);

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        arr.bubbleSort();
        arr.display();
        System.out.println((System.nanoTime()-t1)/1e6);
    }
}