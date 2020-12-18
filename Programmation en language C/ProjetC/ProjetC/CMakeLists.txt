cmake_minimum_required(VERSION 3.0)
project(ProjetC VERSION 0.0.1 DESCRIPTION "Transform number into letter")
set(CMAKE_INSTALL_RPATH_USE_LINK_PATH true)

add_subdirectory(src/library-fr-fr) #nom des dossiers#
add_subdirectory(src/library-fr-african)
add_subdirectory(src/library-fr-date)
add_subdirectory(src/library-fr-be)
add_subdirectory(src/library-fr-roman)

add_executable(spell-number main.h main.c)

include_directories(${CMAKE_SOURCE_DIR} /library-fr-fr)
target_link_libraries(spell-number library-fr-fr)

include_directories(${CMAKE_SOURCE_DIR} /library-fr-african)
target_link_libraries(spell-number library-fr-african)

include_directories(${CMAKE_SOURCE_DIR} /library-fr-date)
target_link_libraries(spell-number library-fr-date)

include_directories(${CMAKE_SOURCE_DIR} /library-fr-be)
target_link_libraries(spell-number library-fr-be)

include_directories(${CMAKE_SOURCE_DIR} /library-fr-roman)
target_link_libraries(spell-number library-fr-roman)

enable_testing()