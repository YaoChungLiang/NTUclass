// 4-5
#include <iostream>
#include <map>
using namespace std;

struct Contact {
    string name, city, title;
    int code;
};

class ContactFactory {
    static map<string, Contact> types;
public:
    static Contact Get(string type);
    static void Add(string type, Contact);
};

ostream& operator<<(ostream& os, const Contact& c);

int main() {
    Contact bob = ContactFactory::Get("ManagerInTaipei");
    bob.name = "Bob";
    cout << bob << endl;
    
    ContactFactory::Add("Bob", bob);
    
    Contact david = ContactFactory::Get("Bob");
    david.name = "David";
    cout << david << endl;
}

map<string, Contact> ContactFactory::types = {{
        "ManagerInTaipei",     
        Contact{"N/A", "Taipei",    "Manager",  372}
    }, {
        "EmployeeInKaohsiung", 
        Contact{"N/A", "Kaohsiung", "Employee", 975}
    }, {
        "Manager",             
        Contact{"N/A", "N/A",       "Manager",  666}
    }, {
        "InTaipei",           
        Contact{"N/A", "Taipei",    "N/A",      913}
    }
};

Contact ContactFactory::Get(string type) {
    return types.at(type);
}

void ContactFactory::Add(string type, Contact c) {
    types[type] = c;
}

ostream& operator<<(ostream& os, const Contact& c) {
    return os << c.name << ", " << c.city 
              << " (" << c.title << ") [" << c.code << "]";
}

