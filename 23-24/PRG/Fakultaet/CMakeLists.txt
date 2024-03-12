cmake_minimum_required(VERSION 3.5)

project(Fakultaet LANGUAGES C)

add_executable(Fakultaet main.c)

include(GNUInstallDirs)
install(TARGETS Fakultaet
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
