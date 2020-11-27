
include_directories(${CMAKE_SOURCE_DIR}/include)

#executable
add_executable(sudoku sudoku.c)

#dependencies
add_dependencies(sudoku ga)
target_link_libraries(sudoku ga)
#find_library(LIBYAML_LIB yaml)
target_link_libraries(sudoku yaml)



target_link_libraries(sudoku m)

