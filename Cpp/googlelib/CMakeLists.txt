set(libmgoogle_SRCS
    mgimplement.h
    mgimplement.cpp
)

# Declare the library
add_library(libmgoogle STATIC
    ${libmgoogle_SRCS}
)

target_link_libraries(libmgoogle
    libgoogle
)

# Specify here the include directories exported
# by this library
target_include_directories(libmgoogle PUBLIC
    ${CMAKE_CURRENT_SOURCE_DIR}
)
