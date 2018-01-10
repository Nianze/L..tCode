#include "google.h"
#include "testgoogle.h"

using ::testing::Return;

GoogleTest::GoogleTest() : nums() {
    // Have qux return true by default
    ON_CALL(m_google,dui()).WillByDefault(Return(true));
    // Have norf return false by default
    ON_CALL(m_google,cuo()).WillByDefault(Return(false));

}

GoogleTest::~GoogleTest() {};

void GoogleTest::SetUp() {};

void GoogleTest::TearDown() {};

TEST_F(GoogleTest, ByDefaultFooTrueIsTrue) {
    Google google(m_google);
    EXPECT_EQ(google.foo(true), true);
}

TEST_F(GoogleTest, ByDefaultFooFalseIsFalse) {
    Google google(m_google);
    EXPECT_EQ(google.foo(false), false);
}

TEST_F(GoogleTest, SometimesFooFalseIsTrue) {
    Google google(m_google);
    // Have cuo return true for once
    EXPECT_CALL(m_google,cuo()).WillOnce(Return(true));
    EXPECT_EQ(google.foo(false), true);
}

TEST_F(GoogleTest, TwoSum) {
//    Google google(m_google);
    nums.push_back(2);
    nums.push_back(3);
    nums.push_back(11);
    nums.push_back(15);
    int target = 9;

    std::vector<int> v = Google::twoSum(nums, target);
    EXPECT_EQ(true, v.empty());

    nums.push_back(7);
    nums.push_back(1);
    v = Google::twoSum(nums, target);
    EXPECT_EQ(2, v.size());
    EXPECT_EQ(0, v[0]);
    EXPECT_EQ(4, v[1]);
}