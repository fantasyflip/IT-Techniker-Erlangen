cmake_minimum_required(VERSION 3.5)

project(Techniker_23-24_PRG_SA1 LANGUAGES C)

add_executable(Techniker_23-24_PRG_SA1 main.c)

include(GNUInstallDirs)
install(TARGETS Techniker_23-24_PRG_SA1
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
