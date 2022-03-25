FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://eth.network;md5=9287ae403dd2443b77547e9bcb41384c"

do_install() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/eth.network ${D}${sysconfdir}/systemd/network
    
    # Avoid user interaction by firstboot!
    ln -s /usr/share/zoneinfo/UTC ${D}/${sysconfdir}/localtime
    install -d ${D}/${sysconfdir}
    echo "LANG=en_GB.utf8" > ${D}/${sysconfdir}/locale.conf
}

FILES_${PN} += "\
    ${sysconfdir}/systemd/network/eth.network\
    ${sysconfdir}/locale.conf\
    ${sysconfdir}/localtime\
"
