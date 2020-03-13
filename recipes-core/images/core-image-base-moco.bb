SUMMARY = "A console-only image that fully supports the target device \
hardware (MoCo)."

LICENSE = "CLOSED"

inherit core-image

COMPATIBLE_MACHINE = "^rpi$"

#
# Kernel configuration
LINUX_KERNEL_TYPE = "preempt-rt"

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
    wiringpi \
    protobuf \
    gtest \
    protobuf \
    jsonrpcpp \
    azmq \
    moco-service \
"


