SUMMARY = "Linux library to implement a embedded HTTP server"
SECTION = "libs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e177cce9e6b9dcdd6b666adec6a4a1e2"

SRC_URI = "git://github.com/cesanta/mongoose.git;protocol=https"
SRCREV = "0a265e79a67d7bfcdca27f2ccb98ccb474677ec6"

S = "${WORKDIR}/git"

EXTRA_OEMAKE_append = " PREFIX=/usr SSL="

do_compile() {
    oe_runmake -e linux-libs
}

do_install() {
    install -d ${D}${libdir}
    oe_runmake -e install DESTDIR=${D}
}