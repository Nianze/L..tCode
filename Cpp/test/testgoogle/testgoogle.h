#ifndef INCLUDED_TESTGOOGLE
#define INCLUDED_TESTGOOGLE

#include "gtest/gtest.h"
#include "mockgoogle.h"

namespace LeetCode {

// The fixture for testing class Foo.
class GoogleTest : public ::testing::Test {

protected:

    // Do set-up work for each test here.
    GoogleTest();

    // Do clean-up work that doesn't throw exceptions here.
    virtual ~GoogleTest();

    // If the constructor and destructor are not enough for setting up
    // and cleaning up each test, define the following methods:

    // Code here will be called immediately after the constructor (right
    // before each test).
    virtual void SetUp();

    // Code here will be called immediately after each test (right
    // before the destructor).
    virtual void TearDown();

    // The mock bar library shaed by all tests
    MockGoogle m_google;

    // For general purpose
    std::vector<int> nums;
};

} // namespace LeetCode

#endif