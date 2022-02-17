DESCRIPTION = "Tool to setup all Sugrow used GPIOs"
LICENSE = "CLOSED"

FILESEXTRAPATHS_prepend := "${THISDIR}/conf:"

SRC_URI = "\
    git://bitbucket.org/schoenerone/sugrow-system-utils.git;protocol=ssh;branch=master;user=git\
    file://gpio.conf\
    "
SRCREV = "${AUTOREV}"
RDEPENDS_${PN} += "bash"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${sysconfdir}/sugrow
    install -m 0644 ${WORKDIR}/gpio.conf ${D}${sysconfdir}/sugrow

    install -d ${D}${bindir}
    install -m 0755 ${S}/bin/* ${D}${bindir}
}

FILES_${PN} += "\
  ${sysconfdir}/sugrow/* \
  ${bindir}/* \
"
