#include "google.h"
#include "mgimplement.h"
#include <iostream>

int main(int argc, char *argv[])
{
	LeetCode::MGImplement mgImplement;
    LeetCode::Google google(mgImplement);
    std::cout << "dui = " << google.foo(true) << "\n";
    std::cout << "cuo = " << google.foo(false) << "\n";
    return 0;
}