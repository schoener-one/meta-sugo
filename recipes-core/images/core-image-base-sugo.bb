SUMMARY = "A console-only image that fully supports the target device \
hardware (sugo)."

LICENSE = "CLOSED"

inherit core-image
require conf/moco-version.inc
inherit extrausers

COMPATIBLE_MACHINE = "^rpi$"

KERNEL_DEVICETREE += " \
    overlays/enc28j60.dtbo \
"

# TODO Add linux-rt kernel configuration

# Root password has to be set on image build!
# If the image feature 'debug-tweaks' is set the root password
# will be deactivated anyway!
# Set unknown password as default!
ROOT_PASSWORD ?= "sugo"
EXTRA_USERS_PARAMS += " \
    usermod -P ${ROOT_PASSWORD} root \
    "

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
    sugo-service \
"

fakeroot do_image() {
    echo "SUGO_SYSTEM_VERSION:  ${SUGO_SYSTEM_VERSION}"
    echo "# sugo system version" > ${IMAGE_ROOTFS}/version
    echo "VERSION=${SUGO_SYSTEM_VERSION}" >>  ${IMAGE_ROOTFS}/version
    echo "REVISION=${SUGO_BUILD_REVISION}" >>  ${IMAGE_ROOTFS}/version
    chmod 0644 ${IMAGE_ROOTFS}/version
}

