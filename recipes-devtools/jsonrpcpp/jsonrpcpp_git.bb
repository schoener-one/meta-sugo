LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6309ad48fc4b61f5b113179fa90100b6"

SRC_URI = "git://github.com/badaix/jsonrpcpp.git;protocol=https"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

INSANE_SKIP_${PN}-dev += "dev-elf"

ALLOW_EMPTY_${PN} = "1"

