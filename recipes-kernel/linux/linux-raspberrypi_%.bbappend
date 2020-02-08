SRC_URI += "file://moco-gpio-overlay.dts;subdir=git/arch/${ARCH}/boot/dts/overlays"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PACKAGE_ARCH = "${MACHINE_ARCH}"

KERNEL_DEVICETREE += " overlays/moco-gpio.dtbo"
