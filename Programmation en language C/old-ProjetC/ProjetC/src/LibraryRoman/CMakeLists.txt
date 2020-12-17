cmake_minimum_required(VERSION 3.0)
project(SpellNumber C)

set(CMAKE_C_STANDARD 11)

add_executable(spell-number library-roman-numeration.c)
add_library(library-fr-roman SHARED library-fr-roman.c)

install(
        TARGETS library-fr-roman
        LIBRARY DESTINATION lib
        ARCHIVE DESTINATION lib
        RUNTIME DESTINATION bin
)

install(
        FILES library-fr-roman.c
        DESTINATION include
)
