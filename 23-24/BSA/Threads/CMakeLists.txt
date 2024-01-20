cmake_minimum_required(VERSION 3.5)

project(Techniker_23-24_BSA-Threads LANGUAGES C)

add_executable(Techniker_23-24_BSA-Threads main.c)

include(GNUInstallDirs)
install(TARGETS Techniker_23-24_BSA-Threads
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
