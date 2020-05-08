
class Position{
    private : 
        int x;
        int y;
    public:
        Position(int x, int y):x(x),y(y) {} // damn c++ 17, when do we need 
        void Print() {
        // ....
        }

        void SetX(int x){  // this encapsulate the idea of interface
            this->x = x;  // x(x) == this-.x = x
        }
};

int main(){
    Position p(3,5); // Position p = {3,5} if x y are public
    p.Print();
    // if we want to be  p.x = 10, means it to be public

}
