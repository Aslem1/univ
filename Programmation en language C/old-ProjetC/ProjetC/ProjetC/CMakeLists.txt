cmake_minimum_required(VERSION 3.0)
project(SpellNumber C)

set(CMAKE_C_STANDARD 11)


find_library(library-fr-FR liblibrary-fr-FR lib)


install(
        FILES affichage.h
        DESTINATION include
)

add_executable(affichage Affichage.c affichage.h)
add_library(affichage Affichage.c affichage.h)
target_include_directories(ProjetC PUBLIC .)