cmake_minimum_required(VERSION 3.0)
project(ProjetC VERSION 0.0.1 DESCRIPTION "Transform number into letter")
set(CMAKE_INSTALL_RPATH_USE_LINK_PATH true)
set(CMAKE_MODULE_PATH "${PROJECT_SOURCE_DIR}/cmake" ${CMAKE_MODULE_PATH}) #Add the cmake folder so the FindSphinx module is found

add_subdirectory(src/library-fr-fr) #Directories#
#add_subdirectory(src/library-fr-african)
add_subdirectory(src/library-fr-date)
add_subdirectory(src/library-fr-be)
#add_subdirectory(src/library-fr-roman)

include_directories(${CMAKE_SOURCE_DIR} utils)

add_executable(main main.h main.c)
target_link_libraries(main utils)