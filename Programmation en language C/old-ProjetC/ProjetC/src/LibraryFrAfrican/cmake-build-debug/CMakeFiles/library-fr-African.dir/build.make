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
CMAKE_SOURCE_DIR = /Users/martinehlinger/CLionProjects/ProjetC/src/LibraryFrAfrican

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = /Users/martinehlinger/CLionProjects/ProjetC/src/LibraryFrAfrican/cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/library-fr-African.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/library-fr-African.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/library-fr-African.dir/flags.make

CMakeFiles/library-fr-African.dir/library-fr-african.c.o: CMakeFiles/library-fr-African.dir/flags.make
CMakeFiles/library-fr-African.dir/library-fr-african.c.o: ../library-fr-african.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=/Users/martinehlinger/CLionProjects/ProjetC/src/LibraryFrAfrican/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/library-fr-African.dir/library-fr-african.c.o"
	/Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/library-fr-African.dir/library-fr-african.c.o   -c /Users/martinehlinger/CLionProjects/ProjetC/src/LibraryFrAfrican/library-fr-african.c

CMakeFiles/library-fr-African.dir/library-fr-african.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/library-fr-African.dir/library-fr-african.c.i"
	/Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E /Users/martinehlinger/CLionProjects/ProjetC/src/LibraryFrAfrican/library-fr-african.c > CMakeFiles/library-fr-African.dir/library-fr-african.c.i

CMakeFiles/library-fr-African.dir/library-fr-african.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/library-fr-African.dir/library-fr-african.c.s"
	/Library/Developer/CommandLineTools/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S /Users/martinehlinger/CLionProjects/ProjetC/src/LibraryFrAfrican/library-fr-african.c -o CMakeFiles/library-fr-African.dir/library-fr-african.c.s

# Object files for target library-fr-African
library__fr__African_OBJECTS = \
"CMakeFiles/library-fr-African.dir/library-fr-african.c.o"

# External object files for target library-fr-African
library__fr__African_EXTERNAL_OBJECTS =

liblibrary-fr-African.dylib: CMakeFiles/library-fr-African.dir/library-fr-african.c.o
liblibrary-fr-African.dylib: CMakeFiles/library-fr-African.dir/build.make
liblibrary-fr-African.dylib: CMakeFiles/library-fr-African.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=/Users/martinehlinger/CLionProjects/ProjetC/src/LibraryFrAfrican/cmake-build-debug/CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C shared library liblibrary-fr-African.dylib"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/library-fr-African.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/library-fr-African.dir/build: liblibrary-fr-African.dylib

.PHONY : CMakeFiles/library-fr-African.dir/build

CMakeFiles/library-fr-African.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/library-fr-African.dir/cmake_clean.cmake
.PHONY : CMakeFiles/library-fr-African.dir/clean

CMakeFiles/library-fr-African.dir/depend:
	cd /Users/martinehlinger/CLionProjects/ProjetC/src/LibraryFrAfrican/cmake-build-debug && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" /Users/martinehlinger/CLionProjects/ProjetC/src/LibraryFrAfrican /Users/martinehlinger/CLionProjects/ProjetC/src/LibraryFrAfrican /Users/martinehlinger/CLionProjects/ProjetC/src/LibraryFrAfrican/cmake-build-debug /Users/martinehlinger/CLionProjects/ProjetC/src/LibraryFrAfrican/cmake-build-debug /Users/martinehlinger/CLionProjects/ProjetC/src/LibraryFrAfrican/cmake-build-debug/CMakeFiles/library-fr-African.dir/DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/library-fr-African.dir/depend

