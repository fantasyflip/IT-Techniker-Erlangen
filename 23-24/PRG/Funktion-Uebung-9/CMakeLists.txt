cmake_minimum_required(VERSION 3.5)

project(Funktion-Uebung-9 LANGUAGES C)

add_executable(Funktion-Uebung-9 main.c)

include(GNUInstallDirs)
install(TARGETS Funktion-Uebung-9
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
