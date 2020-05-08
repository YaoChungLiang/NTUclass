#include<iostream>

class A{
    public :
            static void f();
            static int data;  // declaration
            int y; 
    private:
            int x;
}

int main(){
    A::data; // exist 
    A a;
    a.y = 3;
}
