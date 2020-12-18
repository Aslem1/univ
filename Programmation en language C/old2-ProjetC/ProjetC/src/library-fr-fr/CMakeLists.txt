cmake_minimum_required(VERSION 3.0)
project(SpellNumberFrFr C)

set(CMAKE_C_STANDARD 11)

add_executable(spell-number-fr-fr library-fr-fr.c library-fr-fr.h)
add_library(library-fr-fr SHARED library-fr-fr.c library-fr-fr.h)

install(
        TARGETS library-fr-fr
        LIBRARY DESTINATION lib
        ARCHIVE DESTINATION lib
        RUNTIME DESTINATION bin
)

install(
        FILES library-fr-fr.h
        DESTINATION include
)

enable_testing()

add_test(test-spell-number-fr-fr ./spell-number-fr-fr)