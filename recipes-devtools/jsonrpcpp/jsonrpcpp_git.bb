LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a4db87b14307e5b30ca767492370854a"

SRC_URI = "git://github.com/badaix/jsonrpcpp.git;protocol=https;branch=master"
SRCREV = "0111fabda63c25ab7308ce2d7914d55f7387ed9e"

S = "${WORKDIR}/git"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE:append = " -DBUILD_TESTS=OFF -DBUILD_EXAMPLE=OFF"

INSANE_SKIP:${PN}-dev += "dev-elf"

ALLOW_EMPTY:${PN} = "1"

