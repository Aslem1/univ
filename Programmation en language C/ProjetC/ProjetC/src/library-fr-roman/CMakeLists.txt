cmake_minimum_required(VERSION 3.0)
project(SpellNumberFrRoman C)

set(CMAKE_C_STANDARD 11)

add_executable(spell-number-fr-roman library-fr-roman.c library-fr-roman.h)
add_library(library-fr-roman SHARED library-fr-roman.c library-fr-roman.h)

install(
        TARGETS library-fr-roman
        LIBRARY DESTINATION lib
        ARCHIVE DESTINATION lib
        RUNTIME DESTINATION bin
)

install(
        FILES library-fr-roman.h
        DESTINATION include
)

enable_testing()

add_test(test-spell-number-fr-roman ./spell-number-fr-roman)