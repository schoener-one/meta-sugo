SUMMARY = "Sugo system service"
SECTION = "base/shell"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI = "\
    file://sugo.service\
    file://sugo-service-start.sh\
"

inherit systemd features_check

SYSTEMD_SERVICE:${PN} = "sugo.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install() {
    install -d ${D}${libexecdir}
    install -m 0755 ${WORKDIR}/sugo-service-start.sh ${D}${libexecdir}/sugo-service-start.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/sugo.service ${D}${systemd_system_unitdir}/sugo.service
}

FILES:${PN} = "\
    ${libexecdir}/sugo-service-start.sh \
    ${systemd_system_unitdir}/sugo.service \
"
REQUIRED_DISTRO_FEATURES = "systemd"
