DESCRIPTION = "Tool to setup all Sugo used GPIOs"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

FILESEXTRAPATHS:prepend := "${THISDIR}/conf:"

do_install() {
    install -d ${D}${sysconfdir}/sugo
    install -m 0644 ${WORKDIR}/gpio.conf ${D}${sysconfdir}/sugo
}

FILES:${PN} += "\
  ${sysconfdir}/sugo/* \
"
