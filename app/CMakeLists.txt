cmake_minimum_required(VERSION 3.4.1)
project(gpio_utils)
SET(CMAKE_BUILD_TYPE Debug)
#set(CMAKE_BUILD_TYPE Debug)
#message(STATUS "Build Type: ${CMAKE_BUILD_TYPE}")
# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
        # 设置生成.so 的文件名
        gpio-utils

        # Sets the library as a shared library.
        #设置库的类型  一种静态文件  STATIC .a   一种动态文件  SHARED .so
        SHARED

        # Provides a relative path to your source file(s).
        # 需要编译的c/c++ 文件
        src/main/cpp/gpio_utils.cpp)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.
find_library(
        log-lib
        log)
target_link_libraries(
        gpio-utils
        ${log-lib}
)