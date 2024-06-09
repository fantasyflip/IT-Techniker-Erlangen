cmake_minimum_required(VERSION 3.5)

project(C-Array-Tutorial LANGUAGES C)

add_executable(C-Array-Tutorial main.c)

include(GNUInstallDirs)
install(TARGETS C-Array-Tutorial
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
