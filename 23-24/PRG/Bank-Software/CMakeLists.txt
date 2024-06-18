cmake_minimum_required(VERSION 3.5)

project(Bank-Software LANGUAGES C)

add_executable(Bank-Software main.c)

include(GNUInstallDirs)
install(TARGETS Bank-Software
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
