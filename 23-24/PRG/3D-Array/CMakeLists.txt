cmake_minimum_required(VERSION 3.5)

project(3D-Array LANGUAGES C)

add_executable(3D-Array main.c)

include(GNUInstallDirs)
install(TARGETS 3D-Array
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
