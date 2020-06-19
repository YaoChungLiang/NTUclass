import java.util.*;
public class CompareSortAlgos{
    public static void main(String[] args){
        Random random = new Random();
        int[] array;
        int[] sz = {1000,2000,4000,8000, 16000,32000, 64000};
        double St, arrayTime, bubbleTime, insertTime, selectTime ;
        System.out.println("Simulating Arrays.sort: .........done");
        System.out.println("Simulating Insertion sort: .........done");
        System.out.println("Simulating Selection sort: .........done");
        System.out.println("Simulating Bubble sort: .........done");
        System.out.println("Benchmark(time units : ms)");
        System.out.printf("%5s%14s%17s%16s%12s\n","Size","Bubble sort","Selection sort","Insertion sort","Arrays.sort");
        for(int i = 0;i< sz.length;i++){
            array = random.ints(sz[i],10,sz[i]).toArray();

            St = System.currentTimeMillis();
            Arrays.sort(array);
            arrayTime = System.currentTimeMillis() - St;

            St = System.currentTimeMillis();
            BubbleSort(array);
            bubbleTime = System.currentTimeMillis() - St;

            St = System.currentTimeMillis();
            SelectSort(array);
            selectTime = System.currentTimeMillis() - St;

            St = System.currentTimeMillis();
            InsertSort(array);
            insertTime = System.currentTimeMillis() - St;

            System.out.printf("%5d%14.3f%17.3f%16.3f%12.3f\n",sz[i], bubbleTime,  selectTime, insertTime, arrayTime);

        }
        
    }
    static void BubbleSort(int[] arr){
        int len = arr.length;
        int tmp;
        for(int i = 0; i < len;i++){
            for(int j = 0; j< i-1;j++){
                if(arr[j] > arr[j+1]){
                    tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
    static void SelectSort(int[] arr){
        int len = arr.length;
        int minId, tmp;
        for(int i=0;i < len;i++){
            minId = i;
            for(int j = i+1;j<len;j++){
                if(arr[j]<arr[minId]){
                    minId = j;
                }
            }
            if(minId != i){
                tmp = arr[i];
                arr[i] = arr[minId];
                arr[minId] = tmp;
            }
        }    
    }

    static void InsertSort(int[] arr){
        int len = arr.length;
        int key, j;
        for(int i = 0; i< len;i++){
            key = arr[i];
            j = i -1;
            while(j>0 && arr[j]< key){
                arr[j+1] = arr[j];
                j -= 1;
            }
            arr[j+1] = key;
        }
    }

}
