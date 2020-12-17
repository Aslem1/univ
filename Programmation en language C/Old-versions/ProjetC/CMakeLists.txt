cmake_minimum_required(VERSION 3.0)
project(ProjetC C)

set(CMAKE_C_STANDARD 11)

find_library(library-fr-FR liblibrary-fr-FR lib)

install(
        FILES affichage.h
        DESTINATION include
)

add_executable(affichage Affichage.c affichage.h)
add_library(library-fr-FR Affichage.c)