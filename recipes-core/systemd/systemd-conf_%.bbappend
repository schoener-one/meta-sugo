FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://60-dhcp.network;md5=9287ae403dd2443b77547e9bcb41384c"

do_install() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/60-dhcp.network ${D}${sysconfdir}/systemd/network
    
    # Avoid user interaction by firstboot!
    ln -s /usr/share/zoneinfo/UTC ${D}/${sysconfdir}/localtime
    install -d ${D}/${sysconfdir}
    echo "LANG=en_GB.utf8" > ${D}/${sysconfdir}/locale.conf
}

FILES_${PN} += "\
    ${sysconfdir}/systemd/network/60-dhcp.network\
    ${sysconfdir}/locale.conf\
    ${sysconfdir}/localtime\
"
