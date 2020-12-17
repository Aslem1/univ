cmake_minimum_required(VERSION 3.0)
project(SpellNumber C)

set(CMAKE_C_STANDARD 11)

add_executable(spell-number library-fr-african.c library-fr-african.h)
add_library(library-fr-African SHARED library-fr-african.c library-fr-african.h)

install(
        TARGETS library-fr-African
        LIBRARY DESTINATION lib
        ARCHIVE DESTINATION lib
        RUNTIME DESTINATION bin
)

install(
        FILES library-fr-african.h
        DESTINATION include
)