#include "mgoogle.h"
#include "google.h"

Google::Google(MGoogle& mgoogle)
    :m_google(mgoogle) {};

bool Google::foo(bool useDui) {
    if (useDui) {
        return m_google.dui();
    } else {
        return m_google.cuo();
    }
}
