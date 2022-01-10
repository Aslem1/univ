set(CMAKE_INSTALL_RPATH_USE_LINK_PATH true)
set(CMAKE_INSTALL_RPATH "${CMAKE_INSTALL_PREFIX}/lib")

add_library(treeRB SHARED treeBicolor.c treeBicolor.h)
add_library(treeRBStatic STATIC treeBicolor.c treeBicolor.h)

set_target_properties (treeRBStatic
	PROPERTIES
		OUTPUT_NAME treeRB
)

add_executable(main main.c)
add_dependencies(main treeRB)
target_link_libraries(main treeRB treeRBStatic)

configure_file(
	${CMAKE_CURRENT_SOURCE_DIR}/TreeRB.pc.in
	${CMAKE_CURRENT_BINARY_DIR}/TreeRB.pc
	@ONLY
)
install(
	FILES ${CMAKE_CURRENT_BINARY_DIR}/TreeRB.pc
	DESTINATION share/pkgconfig
	COMPONENT "PkgConfig"
)

include(CMakePackageConfigHelpers)
configure_package_config_file(
	${CMAKE_CURRENT_SOURCE_DIR}/TreeRBConfig.cmake.in
	${CMAKE_CURRENT_BINARY_DIR}/TreeRBConfig.cmake
	INSTALL_DESTINATION cmake
)
install(
	FILES ${CMAKE_CURRENT_BINARY_DIR}/TreeRBConfig.cmake
	DESTINATION cmake
)

install(
	TARGETS treeRB treeRBStatic main
	LIBRARY DESTINATION lib COMPONENT "Library"
	ARCHIVE DESTINATION lib COMPONENT "Library"
	RUNTIME DESTINATION bin COMPONENT "Runtime"
)

install(
	FILES treeRB.h
	DESTINATION include
	COMPONENT "Header"
)

