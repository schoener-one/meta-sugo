SUMMARY = "A console-only image that fully supports the target device \
hardware (Sugo)."
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR};md5=c79ff39f19dfec6d293b95dea7b07891"

inherit core-image extrausers
require conf/sugo-version.inc

COMPATIBLE_MACHINE = "^rpi$"
# Preempt-rt patch not supported any more in kirkstone release!
# PREFERRED_PROVIDER_virtual/kernel ?= "linux-raspberrypi-rt"

# Root password has to be set on image build!
# If the image feature 'debug-tweaks' is set the root password
# will be deactivated anyway!
# Set unknown password as default!
ROOT_PASSWORD ?= "sugo"
# SERVICE_USER_PASSWORD ?= "sugo"
# SERVICE_USER ?= "sugo"
EXTRA_USERS_PARAMS += " \
    usermod -p '$(openssl passwd '${ROOT_PASSWORD}')' root; \
"
# groupadd '${SERVICE_USER}'; 
# useradd -p '${SERVICE_USER_PASSWORD}' -g '${SERVICE_USER}'; 

IMAGE_FEATURES += "splash ssh-server-openssh"
IMAGE_INSTALL:append = " \
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
    googletest \
    protobuf \
    jsonrpcpp \
    azmq \
    rt-tests \
    libgpiod \
    libgpiod-tools \
    ${@bb.utils.contains('SUGO_BUILD_SYSTEM_SERVICE', '1', 'sugo-service', '' ,d)} \
    mongoose \
"

fakeroot do_image() {
    echo "SUGO_SYSTEM_VERSION:  ${SUGO_SYSTEM_VERSION}"
    echo "# Sugo system version" > ${IMAGE_ROOTFS}/version
    echo "VERSION=${SUGO_SYSTEM_VERSION}" >>  ${IMAGE_ROOTFS}/version
    echo "REVISION=${SUGO_BUILD_REVISION}" >>  ${IMAGE_ROOTFS}/version
    chmod 0644 ${IMAGE_ROOTFS}/version
}

