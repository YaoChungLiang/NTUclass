// 5-1
#include <iostream>
#include <string>
using namespace std;

class Screen {
    Screen() = default;     
    Screen(const Screen&) = delete;// cancel copy-construct
    string content;
public:
    static Screen instance; 
    void Print(string content);
    void Clear();
    string Dump() const;
};

int main() {
    Screen::instance.Print("Hello world!\n");    
    Screen::instance.Print("-- Before Clear -- \n");
    cout << Screen::instance.Dump() << endl;
    Screen::instance.Clear();
    Screen::instance.Print("-- After Clear -- \n");
    cout << Screen::instance.Dump() << endl;
}

Screen Screen::instance; // 類別的靜態成員定義 
// need to define the global variable  outside, 
//but it may cause problem

void Screen::Print(string content) {
    this->content += content;
}

void Screen::Clear() {
    content.clear();
}

string Screen::Dump() const {
    return content;
}
