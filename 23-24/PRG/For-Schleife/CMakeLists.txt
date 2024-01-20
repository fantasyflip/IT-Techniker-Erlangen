cmake_minimum_required(VERSION 3.5)

project(Techniker_23-24_For-Schleife LANGUAGES C)

add_executable(Techniker_23-24_For-Schleife main.c)

include(GNUInstallDirs)
install(TARGETS Techniker_23-24_For-Schleife
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
