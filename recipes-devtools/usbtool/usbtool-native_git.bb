SUMMARY = "This is the USB MSD boot code which should work on the Raspberry Pi model A, Compute Module, Compute Module 3, Compute Module 4 and Raspberry Pi Zero."
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"
SRCREV = "49a2a4f22eec755b8c0377b20a5ecbfee089643e"
SRC_URI = "git://github.com/raspberrypi/usbboot.git;protocol=https;branch=master"

DEPENDS = "libusb1-native"

S = "${WORKDIR}/git"

inherit autotools-brokensep native

BUILD_CXXFLAGS += "-I${STAGING_DIR_NATIVE}/${includedir}"
BUILD_LDFLAGS += "-L${STAGING_DIR_NATIVE}/${libdir}"

do_compile() {
    export CC="${CC} ${BUILD_CXXFLAGS} ${BUILD_LDFLAGS}"  
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/rpiboot ${D}${bindir}/rpiboot
}

FILES_${PN} = "${bindir}"