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
CMAKE_COMMAND = "/Users/martinehlinger/Library/Application Support/JetBrains/Toolbox/apps/CLion/ch-0/203.5981.166/CLion.app/Contents/bin/cmake/mac/bin/cmake"

# The command to remove a file.
RM = "/Users/martinehlinger/Library/Application Support/JetBrains/Toolbox/apps/CLion/ch-0/203.5981.166/CLion.app/Contents/bin/cmake/mac/bin/cmake" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = /Users/martinehlinger/CLionProjects/ProjetC/ProjetC

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug

# Include any dependencies generated for this target.
include src/library-fr-roman/CMakeFiles/library-fr-roman.dir/depend.make

# Include the progress variables for this target.
include src/library-fr-roman/CMakeFiles/library-fr-roman.dir/progress.make

# Include the compile flags for this target's objects.
include src/library-fr-roman/CMakeFiles/library-fr-roman.dir/flags.make

src/library-fr-roman/CMakeFiles/library-fr-roman.dir/library-fr-roman.c.o: src/library-fr-roman/CMakeFiles/library-fr-roman.dir/flags.make
src/library-fr-roman/CMakeFiles/library-fr-roman.dir/library-fr-roman.c.o: ../src/library-fr-roman/library-fr-roman.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object src/library-fr-roman/CMakeFiles/library-fr-roman.dir/library-fr-roman.c.o"
	cd /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/src/library-fr-roman && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/library-fr-roman.dir/library-fr-roman.c.o   -c /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/src/library-fr-roman/library-fr-roman.c

src/library-fr-roman/CMakeFiles/library-fr-roman.dir/library-fr-roman.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/library-fr-roman.dir/library-fr-roman.c.i"
	cd /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/src/library-fr-roman && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/src/library-fr-roman/library-fr-roman.c > CMakeFiles/library-fr-roman.dir/library-fr-roman.c.i

src/library-fr-roman/CMakeFiles/library-fr-roman.dir/library-fr-roman.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/library-fr-roman.dir/library-fr-roman.c.s"
	cd /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/src/library-fr-roman && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/src/library-fr-roman/library-fr-roman.c -o CMakeFiles/library-fr-roman.dir/library-fr-roman.c.s

# Object files for target library-fr-roman
library__fr__roman_OBJECTS = \
"CMakeFiles/library-fr-roman.dir/library-fr-roman.c.o"

# External object files for target library-fr-roman
library__fr__roman_EXTERNAL_OBJECTS =

src/library-fr-roman/liblibrary-fr-roman.dylib: src/library-fr-roman/CMakeFiles/library-fr-roman.dir/library-fr-roman.c.o
src/library-fr-roman/liblibrary-fr-roman.dylib: src/library-fr-roman/CMakeFiles/library-fr-roman.dir/build.make
src/library-fr-roman/liblibrary-fr-roman.dylib: src/library-fr-roman/CMakeFiles/library-fr-roman.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C shared library liblibrary-fr-roman.dylib"
	cd /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/src/library-fr-roman && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/library-fr-roman.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
src/library-fr-roman/CMakeFiles/library-fr-roman.dir/build: src/library-fr-roman/liblibrary-fr-roman.dylib

.PHONY : src/library-fr-roman/CMakeFiles/library-fr-roman.dir/build

src/library-fr-roman/CMakeFiles/library-fr-roman.dir/clean:
	cd /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/src/library-fr-roman && $(CMAKE_COMMAND) -P CMakeFiles/library-fr-roman.dir/cmake_clean.cmake
.PHONY : src/library-fr-roman/CMakeFiles/library-fr-roman.dir/clean

src/library-fr-roman/CMakeFiles/library-fr-roman.dir/depend:
	cd /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/martinehlinger/CLionProjects/ProjetC/ProjetC /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/src/library-fr-roman /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/src/library-fr-roman /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/src/library-fr-roman/CMakeFiles/library-fr-roman.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : src/library-fr-roman/CMakeFiles/library-fr-roman.dir/depend
