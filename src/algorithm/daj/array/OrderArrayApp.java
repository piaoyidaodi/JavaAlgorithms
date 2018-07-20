package algorithm.daj.array;

class OrderArray{
    private long[] arr;
    private int nElems;

    public OrderArray(int max){
        arr=new long[max];
        nElems=0;
    }

    public int size(){
        return nElems;
    }

    public int find(long searchKey){
        int lowerBound=0;
        int upperBound=nElems-1;
        int curIn;

        while(true){
            curIn=(lowerBound+upperBound)/2;
            if(arr[curIn]==searchKey){
                return curIn;
            }else if(lowerBound>upperBound){
                return nElems;
            }else{
                if(arr[curIn]<searchKey){
                    lowerBound=curIn+1;
                }else{
                    upperBound=curIn-1;
                }
            }
        }
    }

    public int find1(long searchKey){
        int lowerBound=0;
        int upperBound=nElems-1;
        int curIn;

        while(lowerBound<=upperBound){
            curIn=(lowerBound+upperBound)/2;
            if(arr[curIn]==searchKey){
                return curIn;
            }else if(arr[curIn]<searchKey){
                lowerBound=curIn+1;
            }else{
                upperBound=curIn-1;
            }
        }
        return nElems;
    }

    public void insert(long value){
        int j;
        for(j=0;j<nElems;j++){
            if(arr[j]>value){
                break;
            }
        }
        for(int k=nElems;k>j;k--){
            arr[k]=arr[k-1];
        }
        arr[j]=value;
        nElems++;
    }

    public boolean delete(long value){
        int j=find(value);
        if(j==nElems){
            return false;
        }else{
            for (int k=j;k<nElems;k++){
                arr[k]=arr[k+1];
            }
            nElems--;
            return true;
        }
    }

    public void display(){
        for(int j=0;j<nElems;j++){
            System.out.print(arr[j]+" ");
        }
        System.out.println();
    }
}

public class OrderArrayApp{
    public static void main(String[] args){
        int maxSize=100;
        OrderArray arr=new OrderArray(maxSize);

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

        int searchKey=55;
        if(arr.find(searchKey)!=arr.size()){
            System.out.println("Found "+searchKey);
        }else{
            System.out.println("Can't find "+searchKey);
        }

        arr.delete(00);
        arr.delete(55);
        arr.delete(99);

        arr.display();
    }
}