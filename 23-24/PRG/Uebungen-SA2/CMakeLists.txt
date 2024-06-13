cmake_minimum_required(VERSION 3.5)

project(Uebungen-SA2 LANGUAGES C)

add_executable(Uebungen-SA2 main.c)

include(GNUInstallDirs)
install(TARGETS Uebungen-SA2
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
