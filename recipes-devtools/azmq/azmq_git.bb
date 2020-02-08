LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE-BOOST_1_0;md5=e4224ccaecb14d942c71d31bef20d78c"

FILESEXTRAPATHS_prepend := "${THISDIR}/patch:"
SRC_URI = "git://github.com/zeromq/azmq.git;protocol=https \
    file://0001-azmq-boost-version.patch"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = "boost zeromq"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = "-DAZMQ_NO_TESTS=1"

ALLOW_EMPTY_${PN} = "1"
