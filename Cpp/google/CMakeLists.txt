set(libgoogle_SRCS
    google.h
    google.cpp
    mgoogle.h
)

# Declare the library
add_library(libgoogle STATIC
    ${libgoogle_SRCS}
)

# Specify here the include directories exported
# by this library
target_include_directories(libgoogle PUBLIC
    ${CMAKE_CURRENT_SOURCE_DIR}
)
