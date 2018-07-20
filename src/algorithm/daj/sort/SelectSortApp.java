package algorithm.daj.sort;

class ArraySel {
    private long[] arr;
    private int nElems;

    public ArraySel(int max) {
        arr = new long[max];
        nElems = 0;
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

    public void selectSort() {
        int out, in;
        long tmp;
        for (out = 0; out < nElems; out++) {
            for (in = out + 1; in < nElems; in++) {
                if(arr[out]>arr[in]){
                    tmp=arr[out];
                    arr[out]=arr[in];
                    arr[in]=tmp;
                }
            }
        }
    }
}

public class SelectSortApp{
    public static void main(String[] args){
        long t1=System.nanoTime();
        ArraySel arr=new ArraySel(100);

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

        arr.selectSort();
        arr.display();
        System.out.println((System.nanoTime()-t1)/1e6);
    }
}