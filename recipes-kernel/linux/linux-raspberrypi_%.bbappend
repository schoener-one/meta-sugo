SRC_URI += "\
    file://sugo-gpio-overlay.dts;subdir=git/arch/${ARCH}/boot/dts/overlays \
"
SRC_URI:append:raspberrypi-cm3 = "file://enc28j60-overlay.dts;subdir=git/arch/${ARCH}/boot/dts/overlays"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

KERNEL_DEVICETREE:append:raspberrypi-cm3 = "overlays/enc28j60.dtbo"

KERNEL_MODULE_AUTOLOAD += "i2c-dev"
