SRC_URI += "\
    file://moco-gpio-overlay.dts;subdir=git/arch/${ARCH}/boot/dts/overlays \
    file://enc28j60-overlay.dts;subdir=git/arch/${ARCH}/boot/dts/overlays \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGE_ARCH = "${MACHINE_ARCH}"

KERNEL_DEVICETREE += " \
    overlays/moco-gpio.dtbo \
    overlays/enc28j60.dtbo \
"
KERNEL_MODULE_AUTOLOAD += "i2c-dev"
KERNEL_MODULE_PROBECONF += "i2c-dev"
