cmake_minimum_required(VERSION 3.0)
project(SpellNumberFrRoman C)

set(CMAKE_C_STANDARD 11)

add_executable(spell-number-fr-roman library-fr-roman.c)
add_library(library-fr-roman.c SHARED library-fr-roman.c)

install(
        TARGETS library-fr-roman.c
        LIBRARY DESTINATION lib
        ARCHIVE DESTINATION lib
        RUNTIME DESTINATION bin
)

install(
        FILES library-fr-roman.c
        DESTINATION include
)
