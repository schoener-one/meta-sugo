# Copyright (C) 2022 Denis Schoener <denis@schoner-one.de>

DESCRIPTION = "Waveshare SPI control library for raspberry pi High-Precision-AD-Hat."
SECTION = "libs"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=cccf1bfa6a47e21abee375000d0673bb"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI = " \
    git://github.com/waveshare/High-Pricision_AD_HAT.git;protocol=https \
    file://CMakeLists.txt;subdir=git/c \
    "
SRCREV = "e5bdc253bfb41cf97eaf9addc95296533d5ecf72"

inherit cmake

S = "${WORKDIR}/git/c"

FILES_${PN} += "${libdir}/*.so"