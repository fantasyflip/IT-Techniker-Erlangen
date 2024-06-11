cmake_minimum_required(VERSION 3.5)

project(Struktur LANGUAGES C)

add_executable(Struktur main.c)

include(GNUInstallDirs)
install(TARGETS Struktur
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
