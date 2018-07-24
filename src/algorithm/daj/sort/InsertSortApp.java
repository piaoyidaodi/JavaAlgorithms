package algorithm.daj.sort;

class ArrayIns{
    private long[] arr;
    private int nElems;

    public ArrayIns(int max){
        arr=new long[max];
        nElems=0;
    }

    public void insert(long value) {
        arr[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void insertSort1(){
        int out,in;

        for(out=1;out<nElems;out++){
            in=0;
            long tmp=arr[out];
            while(arr[in]<tmp&&in<out){
                in++;
                continue;
            }
            if(in==out){
                continue;
            }else{
                for(int j=out;j!=in;j--){
                    arr[j]=arr[j-1];
                }
                arr[in]=tmp;
            }
        }
    }

    public void insertSort(){
        int in,out;

        for(out=1;out<nElems;out++){
            long tmp=arr[out];
            in=out;
            while(in>0&&arr[in-1]>=tmp){
                arr[in]=arr[in-1];
                in--;
            }
            arr[in]=tmp;
        }
    }
}

public class InsertSortApp{
    public static void main(String[] args){
        long t1=System.nanoTime();
        ArrayIns arr=new ArrayIns(100);

        arr.insert(99);
        arr.insert(77);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        arr.display();

        arr.insertSort1();
        arr.display();
        System.out.println((System.nanoTime()-t1)/1e6);
    }
}