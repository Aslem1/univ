cmake_minimum_required(VERSION 3.0)
project(SpellNumberFrAfrican C)

set(CMAKE_C_STANDARD 11)

add_executable(spell-number-fr-african library-fr-african.c library-fr-african.h)
add_library(library-fr-african SHARED library-fr-african.c library-fr-african.h)

install(
        TARGETS library-fr-african
        LIBRARY DESTINATION lib
        ARCHIVE DESTINATION lib
        RUNTIME DESTINATION bin
)

install(
        FILES library-fr-african.h
        DESTINATION include
)

enable_testing()

add_test(test-spell-number-fr-african ./spell-number-fr-african)