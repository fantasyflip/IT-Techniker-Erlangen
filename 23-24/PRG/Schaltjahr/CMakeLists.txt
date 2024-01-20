cmake_minimum_required(VERSION 3.5)

project(Techniker_23-24_Schaltjahr LANGUAGES C)

add_executable(Techniker_23-24_Schaltjahr main.c)

include(GNUInstallDirs)
install(TARGETS Techniker_23-24_Schaltjahr
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
