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
CMAKE_SOURCE_DIR = "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec/cmake-build-debug"

# Include any dependencies generated for this target.
include CMakeFiles/projetExec.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/projetExec.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/projetExec.dir/flags.make

CMakeFiles/projetExec.dir/main.c.o: CMakeFiles/projetExec.dir/flags.make
CMakeFiles/projetExec.dir/main.c.o: ../main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/projetExec.dir/main.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/projetExec.dir/main.c.o   -c "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec/main.c"

CMakeFiles/projetExec.dir/main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/projetExec.dir/main.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec/main.c" > CMakeFiles/projetExec.dir/main.c.i

CMakeFiles/projetExec.dir/main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/projetExec.dir/main.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec/main.c" -o CMakeFiles/projetExec.dir/main.c.s

CMakeFiles/projetExec.dir/conversion.c.o: CMakeFiles/projetExec.dir/flags.make
CMakeFiles/projetExec.dir/conversion.c.o: ../conversion.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Building C object CMakeFiles/projetExec.dir/conversion.c.o"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -o CMakeFiles/projetExec.dir/conversion.c.o   -c "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec/conversion.c"

CMakeFiles/projetExec.dir/conversion.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/projetExec.dir/conversion.c.i"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec/conversion.c" > CMakeFiles/projetExec.dir/conversion.c.i

CMakeFiles/projetExec.dir/conversion.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/projetExec.dir/conversion.c.s"
	/usr/bin/cc $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -S "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec/conversion.c" -o CMakeFiles/projetExec.dir/conversion.c.s

# Object files for target projetExec
projetExec_OBJECTS = \
"CMakeFiles/projetExec.dir/main.c.o" \
"CMakeFiles/projetExec.dir/conversion.c.o"

# External object files for target projetExec
projetExec_EXTERNAL_OBJECTS =

projetExec: CMakeFiles/projetExec.dir/main.c.o
projetExec: CMakeFiles/projetExec.dir/conversion.c.o
projetExec: CMakeFiles/projetExec.dir/build.make
projetExec: CMakeFiles/projetExec.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec/cmake-build-debug/CMakeFiles" --progress-num=$(CMAKE_PROGRESS_3) "Linking C executable projetExec"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles/projetExec.dir/link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/projetExec.dir/build: projetExec

.PHONY : CMakeFiles/projetExec.dir/build

CMakeFiles/projetExec.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles/projetExec.dir/cmake_clean.cmake
.PHONY : CMakeFiles/projetExec.dir/clean

CMakeFiles/projetExec.dir/depend:
	cd "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec/cmake-build-debug" && $(CMAKE_COMMAND) -E cmake_depends "Unix Makefiles" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec/cmake-build-debug" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec/cmake-build-debug" "/mnt/c/Users/agath/Desktop/Cours info/workspace/univ/Programmation en language C/projetExec/cmake-build-debug/CMakeFiles/projetExec.dir/DependInfo.cmake" --color=$(COLOR)
.PHONY : CMakeFiles/projetExec.dir/depend

