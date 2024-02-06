cmake_minimum_required(VERSION 3.5)

project(Vier-Gewinnt LANGUAGES C)

add_executable(Vier-Gewinnt main.c)

include(GNUInstallDirs)
install(TARGETS Vier-Gewinnt
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
