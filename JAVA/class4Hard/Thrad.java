import java.lang.*;
public class Thrad{
    public static void main(String[] args){
        Runnable task = ()->{

            new MyThread().start();
            new MyThread().start();
        };
    }
}

class MyThread extends Thread{
    public void run(){
        for(int i=0; i<1000;i++){
            System.out.println(Thread.currentThread().getName());
        }
    }
    /*
    new Thread(task).start();
    new MyThread().start();
    new MyThread().start();
    */
}
