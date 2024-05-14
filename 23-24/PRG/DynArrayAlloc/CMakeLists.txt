cmake_minimum_required(VERSION 3.5)

project(DynArrayAlloc LANGUAGES C)

add_executable(DynArrayAlloc main.c)

include(GNUInstallDirs)
install(TARGETS DynArrayAlloc
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
