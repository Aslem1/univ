# CMAKE generated file: DO NOT EDIT!
# Generated by "Unix Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

# The shell in which to execute make rules.
SHELL = /bin/sh

# The CMake executable.
CMAKE_COMMAND = /home/agathe/cmake-3.17.5/bin/cmake

# The command to remove a file.
RM = /home/agathe/cmake-3.17.5/bin/cmake -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/cmake-build-debug"

# Include any dependencies generated for this target.
include src/library-fr-date/CMakeFiles/library-fr-date.dir/depend.make

# Include the progress variables for this target.
include src/library-fr-date/CMakeFiles/library-fr-date.dir/progress.make

# Include the compile flags for this target's objects.
include src/library-fr-date/CMakeFiles/library-fr-date.dir/flags.make

src/library-fr-date/CMakeFiles/library-fr-date.dir/library-fr-date.c.o: src/library-fr-date/CMakeFiles/library-fr-date.dir/flags.make
src/library-fr-date/CMakeFiles/library-fr-date.dir/library-fr-date.c.o: ../src/library-fr-date/library-fr-date.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building C object src/library-fr-date/CMakeFiles/library-fr-date.dir/library-fr-date.c.o"
	cd "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/cmake-build-debug/src/library-fr-date" && /usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/library-fr-date.dir/library-fr-date.c.o   -c "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/src/library-fr-date/library-fr-date.c"

src/library-fr-date/CMakeFiles/library-fr-date.dir/library-fr-date.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/library-fr-date.dir/library-fr-date.c.i"
	cd "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/cmake-build-debug/src/library-fr-date" && /usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/src/library-fr-date/library-fr-date.c" > CMakeFiles/library-fr-date.dir/library-fr-date.c.i

src/library-fr-date/CMakeFiles/library-fr-date.dir/library-fr-date.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/library-fr-date.dir/library-fr-date.c.s"
	cd "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/cmake-build-debug/src/library-fr-date" && /usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/src/library-fr-date/library-fr-date.c" -o CMakeFiles/library-fr-date.dir/library-fr-date.c.s

# Object files for target library-fr-date
library__fr__date_OBJECTS = \
"CMakeFiles/library-fr-date.dir/library-fr-date.c.o"

# External object files for target library-fr-date
library__fr__date_EXTERNAL_OBJECTS =

src/library-fr-date/liblibrary-fr-date.so: src/library-fr-date/CMakeFiles/library-fr-date.dir/library-fr-date.c.o
src/library-fr-date/liblibrary-fr-date.so: src/library-fr-date/CMakeFiles/library-fr-date.dir/build.make
src/library-fr-date/liblibrary-fr-date.so: src/library-fr-date/CMakeFiles/library-fr-date.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking C shared library liblibrary-fr-date.so"
	cd "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/cmake-build-debug/src/library-fr-date" && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/library-fr-date.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
src/library-fr-date/CMakeFiles/library-fr-date.dir/build: src/library-fr-date/liblibrary-fr-date.so

.PHONY : src/library-fr-date/CMakeFiles/library-fr-date.dir/build

src/library-fr-date/CMakeFiles/library-fr-date.dir/clean:
	cd "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/cmake-build-debug/src/library-fr-date" && $(CMAKE_COMMAND) -P CMakeFiles/library-fr-date.dir/cmake_clean.cmake
.PHONY : src/library-fr-date/CMakeFiles/library-fr-date.dir/clean

src/library-fr-date/CMakeFiles/library-fr-date.dir/depend:
	cd "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/cmake-build-debug" && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/src/library-fr-date" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/cmake-build-debug" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/cmake-build-debug/src/library-fr-date" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/cmake-build-debug/src/library-fr-date/CMakeFiles/library-fr-date.dir/DependInfo.cmake" --color=$(COLOR)
.PHONY : src/library-fr-date/CMakeFiles/library-fr-date.dir/depend

