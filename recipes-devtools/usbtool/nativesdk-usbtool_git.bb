SUMMARY = "This is the USB MSD boot code which should work on the Raspberry Pi model A, Compute Module, Compute Module 3, Compute Module 4 and Raspberry Pi Zero."
SECTION = "devel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"
SRCREV = "49a2a4f22eec755b8c0377b20a5ecbfee089643e"
SRC_URI = "git://github.com/raspberrypi/usbboot.git;protocol=https;branch=master"

DEPENDS:append:class-nativesdk = "nativesdk-libusb1 ${PN}-native"

S = "${WORKDIR}/git"

inherit autotools-brokensep nativesdk

do_compile_class:native() {
    oe_runmake bin2c
}

do_install_class:native() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/bin2c ${D}${bindir}/bin2c
}

do_compile_class:nativesdk() {
    sed 's/\.\/bin2c/bin2c/g' -i Makefile
    oe_runmake rpiboot
}

do_install_class:nativesdk() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/rpiboot ${D}${bindir}/rpiboot
}

FILES:${PN}:append:class-nativesdk = "${bindir}"
FILES:${PN}:append:class-native = "${bindir}"

PROVIDES:${PN}:append:class-native = "${PN}-native"

BBCLASSEXTEND = "native nativesdk"