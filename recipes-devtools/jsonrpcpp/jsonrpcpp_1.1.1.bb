LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=25931fa56ec9d8ac839e16402267c527"

SRC_URI = "git://github.com/badaix/jsonrpcpp.git;protocol=https;tag=v1.1.1"

S = "${WORKDIR}/git"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

INSANE_SKIP_${PN}-dev += "dev-elf"
FILES_${PN}-dev += "${libdir}/libjsonrpcpp.so"
#FILES_${PN} += "${libdir}/libjsonrpcpp.so"
ALLOW_EMPTY_${PN} = "1"

