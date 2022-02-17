SUMMARY = "Sugrow system service"
SECTION = "base/shell"
LICENSE = "CLOSED"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "\
    file://sugrow.service\
    file://sugrow-service-start.sh\
"

RDEPENDS_${PN} += "sugrow-system-utils"

inherit systemd

SYSTEMD_SERVICE_${PN} = "sugrow.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install() {
    install -d ${D}${libexecdir}
    install -m 0755 ${WORKDIR}/sugrow-service-start.sh ${D}${libexecdir}/sugrow-service-start.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/sugrow.service ${D}${systemd_system_unitdir}/sugrow.service
}

FILES_${PN} = "\
    ${libexecdir}/sugrow-service-start.sh \
    ${systemd_system_unitdir}/sugrow.service \
"
REQUIRED_DISTRO_FEATURES = "systemd"
