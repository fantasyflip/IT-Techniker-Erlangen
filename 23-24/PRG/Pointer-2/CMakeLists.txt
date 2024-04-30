cmake_minimum_required(VERSION 3.5)

project(Pointer-2 LANGUAGES C)

add_executable(Pointer-2 main.c)

include(GNUInstallDirs)
install(TARGETS Pointer-2
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
