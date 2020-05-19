class MorePoint<T,U>{
    private T x;
    private U name;

    public void setX(T x){
        this.x = x;
    }
    public void setName(U name){
        this.name = name;
    }
    public T getX(){
        return this.x;
    }
    public U getName(){
        return this.name;
    }
}

public class Gener{
    public static void main(String[] a){
        MorePoint<Integer, String> morePt = new MorePoint<Integer, String>();
        morePt.setX(new Integer(1));
        morePt.setName("Java generic class.");
        System.out.println(morePt.getName() + " "+ morePt.getX());    
    }
}
