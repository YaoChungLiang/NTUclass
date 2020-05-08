// 5-2
#include <iostream>
#include <string>
using namespace std;

class Screen {
    Screen() = default;
    Screen(const Screen&) = delete;
    string content;
public:
    static Screen& GetInstance();
    void Print(string content);
    void Clear();
    string Dump() const;
};

int main() {
    Screen& screen = Screen::GetInstance();
    screen.Print("Hello world!\n");    
    screen.Print("-- Before Clear -- \n");
    cout << screen.Dump() << endl;
    screen.Clear();
    screen.Print("-- After Clear -- \n");
    cout << screen.Dump() << endl;
}

Screen& Screen::GetInstance() {
    static Screen instance;  //it's like global, 
                             //so everytime you called thefunction, it will return the same object
    return instance;         //help you to clarify when to create the global variable
}

void Screen::Print(string content) {
    this->content += content;
}

void Screen::Clear() {
    content.clear();
}

string Screen::Dump() const {
    return content;
}
