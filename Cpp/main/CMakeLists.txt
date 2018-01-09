set(Main_SRCS
    main.cpp
)

add_executable(leetCode
    ${Main_SRCS}
)

# Specify here the libraries this program depends on
target_link_libraries(leetCode
    libgoogle
    libmgoogle
)

install(TARGETS leetCode DESTINATION bin)
