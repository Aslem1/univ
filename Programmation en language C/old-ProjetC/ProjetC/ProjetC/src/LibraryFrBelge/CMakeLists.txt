cmake_minimum_required(VERSION 3.17)
project(SpellNumber C)

set(CMAKE_C_STANDARD 11)

add_executable(spell-number library-fr-BE.c library-fr-BE.h)
add_library(library-fr-BE SHARED library-fr-BE.c library-fr-BE.h)

install(
        TARGETS library-fr-BE
        LIBRARY DESTINATION lib
        ARCHIVE DESTINATION lib
        RUNTIME DESTINATION bin
)

install(
        FILES library-fr-BE.h
        DESTINATION include
)