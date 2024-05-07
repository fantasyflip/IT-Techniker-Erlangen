cmake_minimum_required(VERSION 3.5)

project(Pointer-Uebung-8 LANGUAGES C)

add_executable(Pointer-Uebung-8 main.c)

include(GNUInstallDirs)
install(TARGETS Pointer-Uebung-8
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
