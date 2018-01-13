#ifndef INCLUDED_MOCKGOOGLE
#define INCLUDED_MOCKGOOGLE

#include "gmock/gmock.h"
#include "mgoogle.h"

namespace LeetCode {
	
class MockGoogle: public MGoogle
{
public:
    MOCK_METHOD0(dui, bool());
    MOCK_METHOD0(cuo, bool());
};

} // namespace LeetCode

#endif