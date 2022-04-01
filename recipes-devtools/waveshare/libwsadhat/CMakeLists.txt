cmake_minimum_required(VERSION 3.11)
project(WaveshareHighPrecisionAdHat)

set(PROJECT_CONFIG_DIR "${CMAKE_SOURCE_DIR}/lib/Config")
set(PROJECT_DRIVER_DIR "${CMAKE_SOURCE_DIR}/lib/Driver")

add_compile_definitions(USELIB_RPI=USE_DEV_LIB)
add_compile_definitions(RPI)

add_library(wsadhat SHARED
    ${PROJECT_DRIVER_DIR}/ADS1263.c
    ${PROJECT_CONFIG_DIR}/DEV_Config.c
    ${PROJECT_CONFIG_DIR}/RPI_sysfs_gpio.c
    ${PROJECT_CONFIG_DIR}/dev_hardware_SPI.c
)
target_compile_options(wsadhat PRIVATE
    -Wall
    $<$<CONFIG:DEBUG>:-g>
    $<$<CONFIG:DEBUG>:-O0>
)
target_include_directories(wsadhat
    PUBLIC ${PROJECT_DRIVER_DIR}
    PRIVATE ${PROJECT_CONFIG_DIR}
)
set(LIB_HEADERS 
    ${PROJECT_DRIVER_DIR}/ADS1263.h
    ${PROJECT_CONFIG_DIR}/DEV_Config.h
    ${PROJECT_CONFIG_DIR}/Debug.h
    ${PROJECT_CONFIG_DIR}/RPI_sysfs_gpio.h
    ${PROJECT_CONFIG_DIR}/dev_hardware_SPI.h
)
set_target_properties(
    wsadhat PROPERTIES
    SOVERSION 1.0
    VERSION 1.0
    PUBLIC_HEADER "${LIB_HEADERS}"
)
install(TARGETS wsadhat
    EXPORT WaveshareHighPrecisionAdHat
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    PUBLIC_HEADER DESTINATION ${CMAKE_INSTALL_INCLUDEDIR}/wsadhat
)