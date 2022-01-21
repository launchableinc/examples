#include "gtest/gtest.h"

namespace {
  class FooTest : public ::testing::Test {
    protected:
    FooTest() {
    }

    virtual ~FooTest() {
    }

    virtual void SetUp() {
    }

    virtual void TearDown() {
    }
  };


  TEST_F(FooTest, Bar) {
    EXPECT_EQ(false, false);
  }

  TEST_F(FooTest, Baz) {
    EXPECT_EQ(true, true);
    EXPECT_EQ(true, true);
  }

  TEST_F(FooTest, Foo) {
    EXPECT_EQ(true, true);
    EXPECT_EQ(true, true);
  }
}  // namespace

int main(int argc, char **argv) {
  ::testing::InitGoogleTest(&argc, argv);
  return RUN_ALL_TESTS();
}