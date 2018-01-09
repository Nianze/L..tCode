#include "gmock/gmock.h"
#include "mgoogle.h"

class MockGoogle: public MGoogle
{
public:
    MOCK_METHOD0(dui, bool());
    MOCK_METHOD0(cuo, bool());
};
