
class Point{
    int x,y;
    void Point(int x, int y){
        x = x ;
        y = y ;
    }
}

public class PointDemo{
    public static void main(String[] args){
        Point p1 = new Point();
        p1.x = 1;
        p1.y = 2;

        Point p2 = new Point();
        p2.x = 3;
        p2.y = 4;

        System.out.printf("(%d , %d)\n", p1.x, p1.y);
        System.out.printf("(%d , %d)\n", p2.x, p2.y);

    }
}
