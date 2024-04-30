cmake_minimum_required(VERSION 3.5)

project(Pointer-1 LANGUAGES C)

add_executable(Pointer-1 main.c)

include(GNUInstallDirs)
install(TARGETS Pointer-1
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
