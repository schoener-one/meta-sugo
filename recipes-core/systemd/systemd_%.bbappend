PACKAGECONFIG:append = "networkd resolved timesyncd"

do_install:append() {
    # systemd-networkd 
    ln -sf ../systemd-networkd.service ${D}${systemd_unitdir}/system/dbus-org.freedesktop.network1.service
    ln -sf ../systemd-networkd.service ${D}${systemd_unitdir}/system/multi-user.target.wants/systemd-networkd.service
    ln -sf ../systemd-networkd.socket ${D}${systemd_unitdir}/system/sockets.target.wants/systemd-networkd.socket
    #ln -sf ../systemd-networkd-wait-online.service ${D}${systemd_unitdir}/system/network-online.target.wants/systemd-networkd-wait-online.service

    # systemd-resolved
    ln -sf ../systemd-resolved.service ${D}${systemd_unitdir}/system/dbus-org.freedesktop.resolve1.service
    ln -sf ../systemd-resolved.service ${D}${systemd_unitdir}/system/multi-user.target.wants/systemd-resolved.service

    # systemd-timesyncd
    ln -sf ../systemd-timesyncd.service ${D}${systemd_unitdir}/system/dbus-org.freedesktop.timesync1.service
    ln -sf ../systemd-timesyncd.service ${D}${systemd_unitdir}/system/sysinit.target.wants/systemd-timesyncd.service
}