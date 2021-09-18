SUMMARY = "A console-only image that fully supports the target device \
hardware (MoCo)."

LICENSE = "CLOSED"

inherit core-image

COMPATIBLE_MACHINE = "^rpi$"

KERNEL_DEVICETREE += " \
    overlays/enc28j60.dtbo \
"
#
# Kernel configuration
#LINUX_KERNEL_TYPE = "preempt-rt" - not used for meta-raspberry!
#PREFERRED_PROVIDER_virtual/kernel ?= "linux-raspberrypi-rt"

IMAGE_FEATURES += "splash ssh-server-openssh"
IMAGE_INSTALL_append = " \
    i2c-tools \
    rpio \
    rpi-gpio \
    python3 \
    python3-misc \
    python3-pip \
    boost \
    zeromq \
    userland \
    protobuf \
    gtest \
    protobuf \
    jsonrpcpp \
    azmq \
    moco-service \
"


