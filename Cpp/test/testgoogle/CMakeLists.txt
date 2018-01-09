file(GLOB SRCS *.cpp)

ADD_EXECUTABLE(testgoogle ${SRCS})

TARGET_LINK_LIBRARIES(testgoogle
    libgoogle
    libgtest
    libgmock
)

add_test(NAME testgoogle
         COMMAND testgoogle)
