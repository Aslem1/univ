cmake_minimum_required(VERSION 3.0)
project(SpellNumber C)

set(CMAKE_C_STANDARD 11)

add_executable(spell-number library-fr-FR.c library-fr-FR.h)
add_library(library-fr-FR SHARED library-fr-FR.c library-fr-FR.h)

install(
        TARGETS library-fr-FR
        LIBRARY DESTINATION lib
        ARCHIVE DESTINATION lib
        RUNTIME DESTINATION bin
)

install(
        FILES library-fr-FR.h
        DESTINATION include
)