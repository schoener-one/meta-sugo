SUMMARY = "Moco system service"
SECTION = "base/shell"
LICENSE = "CLOSED"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = "\
    file://moco.service\
    file://moco-service-start.sh\
"

RDEPENDS_${PN} += "moco-system-utils"

inherit systemd

SYSTEMD_SERVICE_${PN} = "moco.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install() {
    install -d ${D}${libexecdir}
    install -m 0755 ${WORKDIR}/moco-service-start.sh ${D}${libexecdir}/moco-service-start.sh

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/moco.service ${D}${systemd_system_unitdir}/moco.service
}

FILES_${PN} = "\
    ${libexecdir}/moco-service-start.sh \
    ${systemd_system_unitdir}/moco.service \
"
REQUIRED_DISTRO_FEATURES = "systemd"
