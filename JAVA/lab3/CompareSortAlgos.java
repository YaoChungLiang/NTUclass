import java.util.*;
public class CompareSortAlgos{
    public static void main(String[] args){
        Random random = new Random();
        int[] array;
        int[] sz = {1000,2000,4000,8000, 16000,32000, 64000};
        long St, Time;
        for(int i = 0;i< sz.length;i++){
            array = random.ints(sz[i],10,sz[i]).toArray();
            St = System.currentTimeMillis();
            BubbleSort(array);
            Time = System.currentTimeMillis() - St;
            System.out.println("bubble");
            System.out.println(Time);

            St = System.currentTimeMillis();
            SelectSort(array);
            Time = System.currentTimeMillis() - St;
            System.out.println("select");
            System.out.println(Time);

            St = System.currentTimeMillis();
            InsertSort(array);
            Time = System.currentTimeMillis() - St;
            System.out.println("insert");
            System.out.println(Time);
            
            St = System.currentTimeMillis();
            Arrays.sort(array);
            Time = System.currentTimeMillis() - St;
            System.out.println("ArraySortAPI");
            System.out.println(Time);
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
