cmake_minimum_required(VERSION 3.0)
project(SpellNumberFrDate C)

set(CMAKE_C_STANDARD 11)

add_executable(spell-number-fr-date library-fr-date.c library-fr-date.h)
add_library(library-fr-date SHARED library-fr-date.c library-fr-date.h)

install(
        TARGETS library-fr-date
        LIBRARY DESTINATION lib
        ARCHIVE DESTINATION lib
        RUNTIME DESTINATION bin
)

install(
        FILES library-fr-date.h
        DESTINATION include
)