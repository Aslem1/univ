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
CMAKE_SOURCE_DIR = "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug"

# Include any dependencies generated for this target.
include ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/depend.make

# Include the progress variables for this target.
include ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/progress.make

# Include the compile flags for this target's objects.
include ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/flags.make

ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/library-fr-roman.c.o: ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/flags.make
ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/library-fr-roman.c.o: ../ProjetC/src/library-fr-roman/library-fr-roman.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building C object ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/library-fr-roman.c.o"
	cd "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug/ProjetC/src/library-fr-roman" && /usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/library-fr-roman.c.dir/library-fr-roman.c.o   -c "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/src/library-fr-roman/library-fr-roman.c"

ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/library-fr-roman.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/library-fr-roman.c.dir/library-fr-roman.c.i"
	cd "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug/ProjetC/src/library-fr-roman" && /usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/src/library-fr-roman/library-fr-roman.c" > CMakeFiles/library-fr-roman.c.dir/library-fr-roman.c.i

ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/library-fr-roman.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/library-fr-roman.c.dir/library-fr-roman.c.s"
	cd "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug/ProjetC/src/library-fr-roman" && /usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/src/library-fr-roman/library-fr-roman.c" -o CMakeFiles/library-fr-roman.c.dir/library-fr-roman.c.s

# Object files for target library-fr-roman.c
library__fr__roman_c_OBJECTS = \
"CMakeFiles/library-fr-roman.c.dir/library-fr-roman.c.o"

# External object files for target library-fr-roman.c
library__fr__roman_c_EXTERNAL_OBJECTS =

ProjetC/src/library-fr-roman/liblibrary-fr-roman.c.so: ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/library-fr-roman.c.o
ProjetC/src/library-fr-roman/liblibrary-fr-roman.c.so: ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/build.make
ProjetC/src/library-fr-roman/liblibrary-fr-roman.c.so: ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking C shared library liblibrary-fr-roman.c.so"
	cd "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug/ProjetC/src/library-fr-roman" && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/library-fr-roman.c.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/build: ProjetC/src/library-fr-roman/liblibrary-fr-roman.c.so

.PHONY : ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/build

ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/clean:
	cd "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug/ProjetC/src/library-fr-roman" && $(CMAKE_COMMAND) -P CMakeFiles/library-fr-roman.c.dir/cmake_clean.cmake
.PHONY : ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/clean

ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/depend:
	cd "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug" && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/ProjetC/src/library-fr-roman" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug/ProjetC/src/library-fr-roman" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug/ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/DependInfo.cmake" --color=$(COLOR)
.PHONY : ProjetC/src/library-fr-roman/CMakeFiles/library-fr-roman.c.dir/depend

