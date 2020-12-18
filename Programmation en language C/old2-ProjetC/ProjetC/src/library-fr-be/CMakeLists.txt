cmake_minimum_required(VERSION 3.0)
project(SpellNumberFrBe C)

set(CMAKE_C_STANDARD 11)

add_executable(spell-number-fr-be library-fr-be.c library-fr-be.h)
add_library(library-fr-be SHARED library-fr-be.c library-fr-be.h)

install(
        TARGETS library-fr-be
        LIBRARY DESTINATION lib
        ARCHIVE DESTINATION lib
        RUNTIME DESTINATION bin
)

install(
        FILES library-fr-be.h
        DESTINATION include
)

enable_testing()

add_test(test-spell-number-fr-be ./spell-number-fr-be)