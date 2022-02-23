SRC_URI += "\
    file://sugo-gpio-overlay.dts;subdir=git/arch/${ARCH}/boot/dts/overlays \
"
SRC_URI_append_raspberrypi-cm3 = "file://enc28j60-overlay.dts;subdir=git/arch/${ARCH}/boot/dts/overlays"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

KERNEL_DEVICETREE_append_raspberrypi-cm3 = "overlays/enc28j60.dtbo"

KERNEL_MODULE_AUTOLOAD += "i2c-dev"
