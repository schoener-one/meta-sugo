FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://60-dhcp.network;md5=9287ae403dd2443b77547e9bcb41384c"

do_install() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/60-dhcp.network ${D}${sysconfdir}/systemd/network
}

FILES_${PN} += "${sysconfdir}/systemd/network/60-dhcp.network"
