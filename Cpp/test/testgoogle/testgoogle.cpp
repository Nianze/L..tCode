#include "google.h"
#include "testgoogle.h"

using ::testing::Return;

GoogleTest::GoogleTest() {
    // Have qux return true by default
    ON_CALL(m_google,dui()).WillByDefault(Return(true));
    // Have norf return false by default
    ON_CALL(m_google,cuo()).WillByDefault(Return(false));
}

GoogleTest::~GoogleTest() {};

void GoogleTest::SetUp() {};

void GoogleTest::TearDown() {};

TEST(Array, TwoSum) {

}

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

