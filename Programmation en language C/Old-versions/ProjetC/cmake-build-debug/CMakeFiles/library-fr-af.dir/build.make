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
include CMakeFiles/library-fr-af.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/library-fr-af.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/library-fr-af.dir/flags.make

CMakeFiles/library-fr-af.dir/src/LibraryFrAfrican/library-fr-african.c.o: CMakeFiles/library-fr-af.dir/flags.make
CMakeFiles/library-fr-af.dir/src/LibraryFrAfrican/library-fr-african.c.o: ../src/LibraryFrAfrican/library-fr-african.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/library-fr-af.dir/src/LibraryFrAfrican/library-fr-african.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/library-fr-af.dir/src/LibraryFrAfrican/library-fr-african.c.o   -c "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/src/LibraryFrAfrican/library-fr-african.c"

CMakeFiles/library-fr-af.dir/src/LibraryFrAfrican/library-fr-african.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/library-fr-af.dir/src/LibraryFrAfrican/library-fr-african.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/src/LibraryFrAfrican/library-fr-african.c" > CMakeFiles/library-fr-af.dir/src/LibraryFrAfrican/library-fr-african.c.i

CMakeFiles/library-fr-af.dir/src/LibraryFrAfrican/library-fr-african.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/library-fr-af.dir/src/LibraryFrAfrican/library-fr-african.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/src/LibraryFrAfrican/library-fr-african.c" -o CMakeFiles/library-fr-af.dir/src/LibraryFrAfrican/library-fr-african.c.s

# Object files for target library-fr-af
library__fr__af_OBJECTS = \
"CMakeFiles/library-fr-af.dir/src/LibraryFrAfrican/library-fr-african.c.o"

# External object files for target library-fr-af
library__fr__af_EXTERNAL_OBJECTS =

liblibrary-fr-af.so: CMakeFiles/library-fr-af.dir/src/LibraryFrAfrican/library-fr-african.c.o
liblibrary-fr-af.so: CMakeFiles/library-fr-af.dir/build.make
liblibrary-fr-af.so: CMakeFiles/library-fr-af.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking C shared library liblibrary-fr-af.so"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/library-fr-af.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/library-fr-af.dir/build: liblibrary-fr-af.so

.PHONY : CMakeFiles/library-fr-af.dir/build

CMakeFiles/library-fr-af.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/library-fr-af.dir/cmake_clean.cmake
.PHONY : CMakeFiles/library-fr-af.dir/clean

CMakeFiles/library-fr-af.dir/depend:
	cd "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug" && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/ProjetC/cmake-build-debug/CMakeFiles/library-fr-af.dir/DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/library-fr-af.dir/depend

