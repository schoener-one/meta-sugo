SUMMARY = "sugo system service"
SECTION = "base/shell"
LICENSE = "CLOSED"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "\
    file://sugo.service\
    file://sugo-service-start.sh\
"

RDEPENDS_${PN} += "sugo-system-utils"

inherit systemd

SYSTEMD_SERVICE_${PN} = "sugo.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install() {
    install -d ${D}${libexecdir}
    install -m 0755 ${WORKDIR}/sugo-service-start.sh ${D}${libexecdir}/sugo-service-start.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/sugo.service ${D}${systemd_system_unitdir}/sugo.service
}

FILES_${PN} = "\
    ${libexecdir}/sugo-service-start.sh \
    ${systemd_system_unitdir}/sugo.service \
"
REQUIRED_DISTRO_FEATURES = "systemd"
