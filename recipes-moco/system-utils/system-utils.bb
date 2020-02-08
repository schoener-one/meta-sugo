DESCRIPTION = "Tool to setup all MoCo used GPIOs"
LICENSE = "CLOSED"

SRCREV = "${AUTOREV}"
SRC_URI = "ssh://git@bitbucket.org:schoener-one/moco-system-utils.git;protocol=ssh;branch=master"
FILESEXTRAPATHS_prepend := "${THISDIR}/conf:"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}${sysconfdir}/moco
    install -m 0644 ${WORKDIR}/gpio.conf ${D}${sysconfdir}/moco
    install -m 0755 ${S}bin/moco-* ${D}${bindir}
}

FILES_${PN} += "\
  ${sysconfdir}/moco/* \
  ${bindir}/* \
"


