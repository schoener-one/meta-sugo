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

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/moco-service-start.sh ${D}${bindir}

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/moco.service ${D}${systemd_system_unitdir}/moco.service
}

FILES_${PN} = "\
    ${bindir} \
    ${systemd_system_unitdir} \
"
REQUIRED_DISTRO_FEATURES = "systemd"
