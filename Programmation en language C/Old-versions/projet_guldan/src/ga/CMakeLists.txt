
set(CMAKE_INSTALL_RPATH_USE_LINK_PATH true)
set(CMAKE_INSTALL_RPATH "${CMAKE_INSTALL_PREFIX}/lib")

add_library(ga SHARED ga.c ga.h)
add_library(gaStatic STATIC ga.c ga.h)

set_target_properties (gaStatic
	PROPERTIES
		OUTPUT_NAME ga
)

configure_file(
	${CMAKE_CURRENT_SOURCE_DIR}/ga.pc.in
	${CMAKE_CURRENT_BINARY_DIR}/ga.pc
	@ONLY
)
install(
	FILES ${CMAKE_CURRENT_BINARY_DIR}/ga.pc
	DESTINATION share/pkgconfig
	COMPONENT "PkgConfig"
)

include(CMakePackageConfigHelpers)
configure_package_config_file(
	${CMAKE_CURRENT_SOURCE_DIR}/gaConfig.cmake.in
	${CMAKE_CURRENT_BINARY_DIR}/gaConfig.cmake
	INSTALL_DESTINATION cmake
)
install(
	FILES ${CMAKE_CURRENT_BINARY_DIR}/gaConfig.cmake
	DESTINATION cmake
)

install(
	TARGETS ga gaStatic ga
	LIBRARY DESTINATION lib COMPONENT "Library"
	ARCHIVE DESTINATION lib COMPONENT "Library"
	RUNTIME DESTINATION bin COMPONENT "Runtime"
)

install(
	FILES ga.h
	DESTINATION include
	COMPONENT "Header"
)

find_package(Coverage)
enable_coverage()

find_package(HtmlCoverage)
enable_html_coverage()
