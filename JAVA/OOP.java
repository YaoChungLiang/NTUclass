import java.util.ArrayList; 
public class OOP{
    public static void main(String[] args){
        //Todo
        // static : shared function
        // ex: Math.random  (dont have to new)
        // singleton: like system manager or trash can or math.random
        // unified modeling L
        new A();  // default inhereit Object
        Point p1 = new Point();
        p1.x = 3;
        p1.y = 5;
        System.out.println(p1);

        int[] A = new int[3]; //too primitive
        ArrayList<Integer> B = new ArrayList<>();
        B.add(100);
        B.add(200);
        B.add(300);
        System.out.println(B);

    }
}

class A{
    void doAction(){
    
    }
}

class Point{
    double x,y;
    @Override
    public String ToString(){
        return "("+x+","+y+")";
    }
}

ex void goFly(Object o){
    if o instance of Bird{
        ((Bird) o).fly();
    }
    else if o instance of Airplane{
        ((AiirPlane) o).fly();
    }
}
