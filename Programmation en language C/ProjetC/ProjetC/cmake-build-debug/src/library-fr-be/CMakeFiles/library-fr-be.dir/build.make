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
include src/library-fr-be/CMakeFiles/library-fr-be.dir/depend.make

# Include the progress variables for this target.
include src/library-fr-be/CMakeFiles/library-fr-be.dir/progress.make

# Include the compile flags for this target's objects.
include src/library-fr-be/CMakeFiles/library-fr-be.dir/flags.make

src/library-fr-be/CMakeFiles/library-fr-be.dir/library-fr-be.c.o: src/library-fr-be/CMakeFiles/library-fr-be.dir/flags.make
src/library-fr-be/CMakeFiles/library-fr-be.dir/library-fr-be.c.o: ../src/library-fr-be/library-fr-be.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object src/library-fr-be/CMakeFiles/library-fr-be.dir/library-fr-be.c.o"
	cd /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/src/library-fr-be && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/library-fr-be.dir/library-fr-be.c.o   -c /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/src/library-fr-be/library-fr-be.c

src/library-fr-be/CMakeFiles/library-fr-be.dir/library-fr-be.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/library-fr-be.dir/library-fr-be.c.i"
	cd /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/src/library-fr-be && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/src/library-fr-be/library-fr-be.c > CMakeFiles/library-fr-be.dir/library-fr-be.c.i

src/library-fr-be/CMakeFiles/library-fr-be.dir/library-fr-be.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/library-fr-be.dir/library-fr-be.c.s"
	cd /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/src/library-fr-be && /Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/src/library-fr-be/library-fr-be.c -o CMakeFiles/library-fr-be.dir/library-fr-be.c.s

# Object files for target library-fr-be
library__fr__be_OBJECTS = \
"CMakeFiles/library-fr-be.dir/library-fr-be.c.o"

# External object files for target library-fr-be
library__fr__be_EXTERNAL_OBJECTS =

src/library-fr-be/liblibrary-fr-be.dylib: src/library-fr-be/CMakeFiles/library-fr-be.dir/library-fr-be.c.o
src/library-fr-be/liblibrary-fr-be.dylib: src/library-fr-be/CMakeFiles/library-fr-be.dir/build.make
src/library-fr-be/liblibrary-fr-be.dylib: src/library-fr-be/CMakeFiles/library-fr-be.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C shared library liblibrary-fr-be.dylib"
	cd /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/src/library-fr-be && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/library-fr-be.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
src/library-fr-be/CMakeFiles/library-fr-be.dir/build: src/library-fr-be/liblibrary-fr-be.dylib

.PHONY : src/library-fr-be/CMakeFiles/library-fr-be.dir/build

src/library-fr-be/CMakeFiles/library-fr-be.dir/clean:
	cd /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/src/library-fr-be && $(CMAKE_COMMAND) -P CMakeFiles/library-fr-be.dir/cmake_clean.cmake
.PHONY : src/library-fr-be/CMakeFiles/library-fr-be.dir/clean

src/library-fr-be/CMakeFiles/library-fr-be.dir/depend:
	cd /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/martinehlinger/CLionProjects/ProjetC/ProjetC /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/src/library-fr-be /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/src/library-fr-be /Users/martinehlinger/CLionProjects/ProjetC/ProjetC/cmake-build-debug/src/library-fr-be/CMakeFiles/library-fr-be.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : src/library-fr-be/CMakeFiles/library-fr-be.dir/depend

